class CreateLogs < ActiveRecord::Migration[5.0]
  def change
    create_table :logs do |t|
      t.string :message, null: false
      t.belongs_to :user, foreign_key: true

      t.datetime :created_at, null: false
    end
  end
end
