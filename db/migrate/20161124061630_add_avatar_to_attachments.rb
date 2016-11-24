class AddAvatarToAttachments < ActiveRecord::Migration[5.0]
  def change
    add_column :attachments, :avatar, :string
  end
end
