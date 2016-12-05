# This migration comes from shop (originally 20161205224451)
class CreateShopOrders < ActiveRecord::Migration[5.0]
  def change
    create_table :shop_orders do |t|
      t.string :uid, null:false, limit: 36

      # :cart, :address, :delivery, :payment, :confirm, :complete
      t.string :state, null:false, limit: 8, index:true

      # :ready, :pending, :partial, :shipped, :backorder, :canceled
      t.string :shipment_state, null:false, limit: 8, index:true

      # :balance_due, :paid, :credit_owed, :failed, :void
      t.string :payment_state, null:false, limit: 8, index:true

      t.decimal :item_total, precision: 12, scale: 2, null:false
      t.decimal :total, precision: 12, scale: 2, null:false
      t.decimal :adjustment_total, precision: 12, scale: 2, null:false
      t.decimal :payment_total, precision: 12, scale: 2, null:false

      t.belongs_to :user, foreign_key: true
      t.belongs_to :shop_address, foreign_key: true

      t.datetime :completed_at
      t.timestamps
    end
    add_index :shop_orders, :uid, unique: true
  end
end
