class LeaveWordsController < ApplicationController
  def new
    @leave_word = LeaveWord.new
  end

  def create
    @leave_word = LeaveWord.new(params.require(:leave_word).permit(:body, :email, :phone, :username))
    @leave_word.lang = I18n.locale

    if @leave_word.save
      flash[:notice] = ''
      redirect_to root_path
    else
      render 'new'
    end
  end
end
