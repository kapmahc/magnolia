class Notice < ApplicationRecord
  validates :body, :lang, presence: true
end
