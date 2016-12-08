class Attachment < ApplicationRecord
  mount_uploader :avatar, AvatarUploader
  validates :title, :content_type, :size, :resource_type, :resource_id, presence: true

  belongs_to :user

  def image?
    self.content_type.start_with? 'image'
  end

  def read!
    self.content_type = self.avatar.content_type
    self.title = self.avatar.filename
    self.size = self.avatar.size
    # self.size = File.size self.avatar.tempfile
  end
end
