class CreateLeaveWords < ActiveRecord::Migration[5.0]
  def change
    create_table :leave_words do |t|
      t.string :lang, null:false, index:true
      t.string :email, null:false, index:true
      t.string :username, null:false, index:true
      t.string :phone, index:true
      t.text :body, null:false
      t.boolean :processed, null:false, default: false

      t.datetime :created_at, null:false
    end

  end
end
