class Log < ApplicationRecord
  validates :user_id, :message, presence: true
  belongs_to :user
end
