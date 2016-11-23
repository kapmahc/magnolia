class CreateNotices < ActiveRecord::Migration[5.0]
  def change
    create_table :notices do |t|
      t.string :lang, null:false, index:true
      t.text :body, null:false
      t.timestamps
    end
  end
end
