class Translation < ApplicationRecord
  validates :locale, :key, :value, presence: true
  validates :key, uniqueness: { scope: :locale}
end
