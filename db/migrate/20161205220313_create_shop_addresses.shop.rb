# This migration comes from shop (originally 20161125001325)
class CreateShopAddresses < ActiveRecord::Migration[5.0]
  def change
    create_table :shop_addresses do |t|
      t.string :full_name, null:false, index: true
      t.string :address1, null: false, index: true
      t.string :address2, null: false
      t.string :phone, null:false, index:true
      t.string :zip_code, null:false, limit: 8, index: true
      t.string :country, null:false, index:true
      t.string :state, null:false, index:true
      t.string :city, null:false, index: true

      t.belongs_to :shop_state, foreign_key: true
      t.belongs_to :user, foreign_key: true

      t.timestamps
    end
  end
end
