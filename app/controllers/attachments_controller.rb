class AttachmentsController < ApplicationController
  layout 'dashboard'

  def index
    @attachment = Attachment.new params.permit(:resource_type, :resource_id)
    res = Object.const_get(@attachment.resource_type).find @attachment.resource_id
    authorize res, :edit?
    @attachments = Attachment.where(params.permit(:resource_type, :resource_id)).order(sort_order: :asc)
  end

  def new
    @attachment = Attachment.new params.permit(:resource_type, :resource_id)
    res = Object.const_get(@attachment.resource_type).find @attachment.resource_id
    authorize res, :edit?
    @attachment.sort_order = 0
  end

  def create
    @attachment = Attachment.new params.require(:attachment).permit(:resource_type, :resource_id, :sort_order)

    res = Object.const_get(@attachment.resource_type).find @attachment.resource_id
    authorize res, :edit?

    @attachment.user = current_user
    @attachment.read! params.require(:attachment).fetch(:file)
    puts '#'*80, @attachment.inspect
    if @attachment.save
      redirect_to attachments_path(params.require(:attachment).permit(:resource_type, :resource_id))
    else
      render 'new'
    end
  end

  def destroy
    @attachment = Attachment.find params[:id]
    res = Object.const_get(@attachment.resource_type).find @attachment.resource_id
    authorize res, :edit?
    @attachment.destroy
    redirect_to attachments_path(resource_type:@attachment.resource_type, resource_id:@attachment.resource_id)
  end
end
