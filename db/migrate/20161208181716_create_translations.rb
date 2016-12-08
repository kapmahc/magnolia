class CreateTranslations < ActiveRecord::Migration[5.0]
  def change
    create_table :translations do |t|
      t.string :locale, null:false, index:true
      t.string :key, null:false, index:true
      t.text   :value, null:false
      t.text   :interpolations
      t.boolean :is_proc, default: false

      t.timestamps
    end
    add_index :translations, [:locale, :key], unique: true
  end
end
