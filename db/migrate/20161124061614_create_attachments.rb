class CreateAttachments < ActiveRecord::Migration[5.0]
  def change
    create_table :attachments do |t|
      t.belongs_to :user, foreign_key: true

      t.string :resource_type, null:false, index:true
      t.integer :resource_id, null:false

      t.string :title, null: false, index: true
      t.string :content_type, null: false, index: true
      t.integer :size, null: false

      t.integer :sort_order, null:false

      t.timestamps
    end
  end
end
