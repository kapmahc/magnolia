class LeaveWord < ApplicationRecord
  validates :body, :email, :username, :phone, presence: true
end
