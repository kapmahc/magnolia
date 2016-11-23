class LeaveWord < ApplicationRecord
  validates :body, :email, :username, presence: true
end
