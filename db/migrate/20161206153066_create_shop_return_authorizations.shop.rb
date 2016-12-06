# This migration comes from shop (originally 20161205230654)
class CreateShopReturnAuthorizations < ActiveRecord::Migration[5.0]
  def change
    create_table :shop_return_authorizations do |t|
      t.string :tracking, null:false
      t.string :uid, null:false

      # :authorized :canceled
      t.string :state, null:false, limit:16

      t.decimal :amount, precision: 12, scale: 2, null:false
      t.text :reason, null:false

      t.integer :enter_by
      t.datetime :enter_at

      t.belongs_to :shop_order, foreign_key: true
      t.belongs_to :shop_shipping_method, foreign_key: true

      t.timestamps
    end
  end
end