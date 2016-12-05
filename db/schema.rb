# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20161205233463) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "attachments", force: :cascade do |t|
    t.integer  "user_id"
    t.string   "title",        null: false
    t.string   "content_type", null: false
    t.integer  "size",         null: false
    t.datetime "created_at",   null: false
    t.datetime "updated_at",   null: false
    t.string   "avatar"
    t.index ["content_type"], name: "index_attachments_on_content_type", using: :btree
    t.index ["title"], name: "index_attachments_on_title", using: :btree
    t.index ["user_id"], name: "index_attachments_on_user_id", using: :btree
  end

  create_table "forum_articles", force: :cascade do |t|
    t.string   "title",                                     null: false
    t.string   "summary",                                   null: false
    t.text     "body",                                      null: false
    t.string   "lang",                                      null: false
    t.string   "flag",       limit: 8, default: "markdown", null: false
    t.integer  "vote",                 default: 0,          null: false
    t.integer  "user_id"
    t.datetime "created_at",                                null: false
    t.datetime "updated_at",                                null: false
    t.index ["lang"], name: "index_forum_articles_on_lang", using: :btree
    t.index ["title"], name: "index_forum_articles_on_title", using: :btree
    t.index ["user_id"], name: "index_forum_articles_on_user_id", using: :btree
  end

  create_table "forum_articles_tags", id: false, force: :cascade do |t|
    t.integer "forum_article_id"
    t.integer "forum_tag_id"
    t.index ["forum_article_id", "forum_tag_id"], name: "index_forum_articles_tags_on_forum_article_id_and_forum_tag_id", unique: true, using: :btree
    t.index ["forum_article_id"], name: "index_forum_articles_tags_on_forum_article_id", using: :btree
    t.index ["forum_tag_id"], name: "index_forum_articles_tags_on_forum_tag_id", using: :btree
  end

  create_table "forum_comments", force: :cascade do |t|
    t.text     "body",                                            null: false
    t.string   "flag",             limit: 8, default: "markdown", null: false
    t.integer  "vote",                       default: 0,          null: false
    t.integer  "forum_article_id"
    t.integer  "user_id"
    t.datetime "created_at",                                      null: false
    t.datetime "updated_at",                                      null: false
    t.index ["flag"], name: "index_forum_comments_on_flag", using: :btree
    t.index ["forum_article_id"], name: "index_forum_comments_on_forum_article_id", using: :btree
    t.index ["user_id"], name: "index_forum_comments_on_user_id", using: :btree
  end

  create_table "forum_tags", force: :cascade do |t|
    t.string   "name",       null: false
    t.string   "lang",       null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["lang"], name: "index_forum_tags_on_lang", using: :btree
    t.index ["name"], name: "index_forum_tags_on_name", unique: true, using: :btree
  end

  create_table "leave_words", force: :cascade do |t|
    t.string   "lang",                       null: false
    t.string   "email",                      null: false
    t.string   "username",                   null: false
    t.string   "phone"
    t.text     "body",                       null: false
    t.boolean  "processed",  default: false, null: false
    t.datetime "created_at",                 null: false
    t.index ["email"], name: "index_leave_words_on_email", using: :btree
    t.index ["lang"], name: "index_leave_words_on_lang", using: :btree
    t.index ["phone"], name: "index_leave_words_on_phone", using: :btree
    t.index ["username"], name: "index_leave_words_on_username", using: :btree
  end

  create_table "logs", force: :cascade do |t|
    t.string   "message",    null: false
    t.integer  "user_id"
    t.datetime "created_at", null: false
    t.index ["user_id"], name: "index_logs_on_user_id", using: :btree
  end

  create_table "notices", force: :cascade do |t|
    t.string   "lang",       null: false
    t.text     "body",       null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["lang"], name: "index_notices_on_lang", using: :btree
  end

  create_table "reading_books", force: :cascade do |t|
    t.string   "author",                   null: false
    t.string   "publisher",                null: false
    t.string   "title",                    null: false
    t.string   "version",                  null: false
    t.string   "lang",                     null: false
    t.string   "subject",                  null: false
    t.string   "file",                     null: false
    t.integer  "vote",         default: 0, null: false
    t.date     "published_at",             null: false
    t.datetime "created_at",               null: false
    t.datetime "updated_at",               null: false
    t.index ["author"], name: "index_reading_books_on_author", using: :btree
    t.index ["file"], name: "index_reading_books_on_file", unique: true, using: :btree
    t.index ["lang"], name: "index_reading_books_on_lang", using: :btree
    t.index ["publisher"], name: "index_reading_books_on_publisher", using: :btree
    t.index ["subject"], name: "index_reading_books_on_subject", using: :btree
    t.index ["title"], name: "index_reading_books_on_title", using: :btree
    t.index ["version"], name: "index_reading_books_on_version", using: :btree
  end

  create_table "reading_favorites", force: :cascade do |t|
    t.string   "href",       null: false
    t.string   "title",      null: false
    t.integer  "user_id"
    t.datetime "created_at", null: false
    t.index ["href", "user_id"], name: "index_reading_favorites_on_href_and_user_id", unique: true, using: :btree
    t.index ["title"], name: "index_reading_favorites_on_title", using: :btree
    t.index ["user_id"], name: "index_reading_favorites_on_user_id", using: :btree
  end

  create_table "reading_notes", force: :cascade do |t|
    t.string   "flag",            limit: 8, default: "markdown", null: false
    t.text     "body",                                           null: false
    t.integer  "vote",                      default: 0,          null: false
    t.integer  "reading_book_id"
    t.integer  "user_id"
    t.datetime "created_at",                                     null: false
    t.datetime "updated_at",                                     null: false
    t.index ["flag"], name: "index_reading_notes_on_flag", using: :btree
    t.index ["reading_book_id"], name: "index_reading_notes_on_reading_book_id", using: :btree
    t.index ["user_id"], name: "index_reading_notes_on_user_id", using: :btree
  end

  create_table "roles", force: :cascade do |t|
    t.string   "name"
    t.string   "resource_type"
    t.integer  "resource_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.index ["name", "resource_type", "resource_id"], name: "index_roles_on_name_and_resource_type_and_resource_id", using: :btree
    t.index ["name"], name: "index_roles_on_name", using: :btree
  end

  create_table "settings", force: :cascade do |t|
    t.string   "var",                   null: false
    t.text     "value"
    t.integer  "thing_id"
    t.string   "thing_type", limit: 30
    t.datetime "created_at"
    t.datetime "updated_at"
    t.index ["thing_type", "thing_id", "var"], name: "index_settings_on_thing_type_and_thing_id_and_var", unique: true, using: :btree
  end

  create_table "shop_addresses", force: :cascade do |t|
    t.string   "full_name",                 null: false
    t.string   "content",                   null: false
    t.string   "phone",                     null: false
    t.string   "zip_code",        limit: 8, null: false
    t.integer  "shop_country_id"
    t.integer  "user_id"
    t.datetime "created_at",                null: false
    t.datetime "updated_at",                null: false
    t.index ["content"], name: "index_shop_addresses_on_content", using: :btree
    t.index ["full_name"], name: "index_shop_addresses_on_full_name", using: :btree
    t.index ["phone"], name: "index_shop_addresses_on_phone", using: :btree
    t.index ["shop_country_id"], name: "index_shop_addresses_on_shop_country_id", using: :btree
    t.index ["user_id"], name: "index_shop_addresses_on_user_id", using: :btree
    t.index ["zip_code"], name: "index_shop_addresses_on_zip_code", using: :btree
  end

  create_table "shop_chargebacks", force: :cascade do |t|
    t.string   "state",         limit: 16,                          null: false
    t.decimal  "amount",                   precision: 12, scale: 2, null: false
    t.integer  "operator_id"
    t.integer  "shop_order_id"
    t.datetime "created_at",                                        null: false
    t.datetime "updated_at",                                        null: false
    t.index ["shop_order_id"], name: "index_shop_chargebacks_on_shop_order_id", using: :btree
    t.index ["state"], name: "index_shop_chargebacks_on_state", using: :btree
  end

  create_table "shop_countries", force: :cascade do |t|
    t.string   "name",                       null: false
    t.string   "alpha_2",         limit: 2,  null: false
    t.string   "alpha_3",         limit: 3,  null: false
    t.string   "code",            limit: 3,  null: false
    t.string   "iso3166_2",       limit: 16, null: false
    t.string   "region",          limit: 16, null: false
    t.string   "sub_region",      limit: 32, null: false
    t.string   "region_code",     limit: 3,  null: false
    t.string   "sub_region_code", limit: 3,  null: false
    t.datetime "created_at",                 null: false
    t.datetime "updated_at",                 null: false
    t.index ["alpha_2"], name: "index_shop_countries_on_alpha_2", using: :btree
    t.index ["alpha_3"], name: "index_shop_countries_on_alpha_3", using: :btree
    t.index ["code"], name: "index_shop_countries_on_code", using: :btree
    t.index ["iso3166_2"], name: "index_shop_countries_on_iso3166_2", using: :btree
    t.index ["name"], name: "index_shop_countries_on_name", unique: true, using: :btree
    t.index ["region"], name: "index_shop_countries_on_region", using: :btree
    t.index ["region_code"], name: "index_shop_countries_on_region_code", using: :btree
    t.index ["sub_region"], name: "index_shop_countries_on_sub_region", using: :btree
    t.index ["sub_region_code"], name: "index_shop_countries_on_sub_region_code", using: :btree
  end

  create_table "shop_currencies", force: :cascade do |t|
    t.string   "cid",        limit: 3, null: false
    t.string   "code",       limit: 3, null: false
    t.string   "name",                 null: false
    t.string   "country",              null: false
    t.string   "units",      limit: 8, null: false
    t.datetime "created_at",           null: false
    t.datetime "updated_at",           null: false
  end

  create_table "shop_inventory_units", force: :cascade do |t|
    t.integer  "lock_version",                            null: false
    t.string   "state",                        limit: 16, null: false
    t.integer  "shop_order_id"
    t.integer  "shop_variant_id"
    t.integer  "shop_shipment_id"
    t.integer  "shop_return_authorization_id"
    t.datetime "created_at",                              null: false
    t.datetime "updated_at",                              null: false
    t.index ["shop_order_id"], name: "index_shop_inventory_units_on_shop_order_id", using: :btree
    t.index ["shop_return_authorization_id"], name: "index_shop_inventory_units_on_shop_return_authorization_id", using: :btree
    t.index ["shop_shipment_id"], name: "index_shop_inventory_units_on_shop_shipment_id", using: :btree
    t.index ["shop_variant_id"], name: "index_shop_inventory_units_on_shop_variant_id", using: :btree
    t.index ["state"], name: "index_shop_inventory_units_on_state", using: :btree
  end

  create_table "shop_line_items", force: :cascade do |t|
    t.integer  "quantity",                                 null: false
    t.decimal  "price",           precision: 12, scale: 2, null: false
    t.integer  "shop_variant_id"
    t.integer  "shop_order_id"
    t.datetime "created_at",                               null: false
    t.datetime "updated_at",                               null: false
    t.index ["shop_order_id"], name: "index_shop_line_items_on_shop_order_id", using: :btree
    t.index ["shop_variant_id"], name: "index_shop_line_items_on_shop_variant_id", using: :btree
  end

  create_table "shop_orders", force: :cascade do |t|
    t.string   "uid",              limit: 36,                          null: false
    t.string   "state",            limit: 8,                           null: false
    t.string   "shipment_state",   limit: 8,                           null: false
    t.string   "payment_state",    limit: 8,                           null: false
    t.decimal  "item_total",                  precision: 12, scale: 2, null: false
    t.decimal  "total",                       precision: 12, scale: 2, null: false
    t.decimal  "adjustment_total",            precision: 12, scale: 2, null: false
    t.decimal  "payment_total",               precision: 12, scale: 2, null: false
    t.integer  "user_id"
    t.integer  "shop_address_id"
    t.datetime "completed_at"
    t.datetime "created_at",                                           null: false
    t.datetime "updated_at",                                           null: false
    t.index ["payment_state"], name: "index_shop_orders_on_payment_state", using: :btree
    t.index ["shipment_state"], name: "index_shop_orders_on_shipment_state", using: :btree
    t.index ["shop_address_id"], name: "index_shop_orders_on_shop_address_id", using: :btree
    t.index ["state"], name: "index_shop_orders_on_state", using: :btree
    t.index ["uid"], name: "index_shop_orders_on_uid", unique: true, using: :btree
    t.index ["user_id"], name: "index_shop_orders_on_user_id", using: :btree
  end

  create_table "shop_payment_methods", force: :cascade do |t|
    t.string   "name",                                           null: false
    t.string   "flag",                 limit: 8,                 null: false
    t.text     "description"
    t.text     "encrypted_profile"
    t.string   "encrypted_profile_iv"
    t.boolean  "active",                         default: false, null: false
    t.datetime "created_at",                                     null: false
    t.datetime "updated_at",                                     null: false
    t.index ["name"], name: "index_shop_payment_methods_on_name", unique: true, using: :btree
  end

  create_table "shop_payments", force: :cascade do |t|
    t.string   "state",                  limit: 8,                          null: false
    t.string   "response_code"
    t.string   "avs_response"
    t.decimal  "amount",                           precision: 12, scale: 2, null: false
    t.integer  "shop_order_id"
    t.integer  "shop_payment_method_id"
    t.datetime "created_at",                                                null: false
    t.datetime "updated_at",                                                null: false
    t.index ["shop_order_id"], name: "index_shop_payments_on_shop_order_id", using: :btree
    t.index ["shop_payment_method_id"], name: "index_shop_payments_on_shop_payment_method_id", using: :btree
    t.index ["state"], name: "index_shop_payments_on_state", using: :btree
  end

  create_table "shop_products", force: :cascade do |t|
    t.string   "name",        null: false
    t.text     "description", null: false
    t.datetime "created_at",  null: false
    t.datetime "updated_at",  null: false
    t.index ["name"], name: "index_shop_products_on_name", using: :btree
  end

  create_table "shop_return_authorizations", force: :cascade do |t|
    t.string   "tracking",                                                    null: false
    t.string   "uid",                                                         null: false
    t.string   "state",                   limit: 16,                          null: false
    t.decimal  "amount",                             precision: 12, scale: 2, null: false
    t.text     "reason",                                                      null: false
    t.integer  "enter_by"
    t.datetime "enter_at"
    t.integer  "shop_order_id"
    t.integer  "shop_shipping_method_id"
    t.datetime "created_at",                                                  null: false
    t.datetime "updated_at",                                                  null: false
    t.index ["shop_order_id"], name: "index_shop_return_authorizations_on_shop_order_id", using: :btree
    t.index ["shop_shipping_method_id"], name: "index_shop_return_authorizations_on_shop_shipping_method_id", using: :btree
  end

  create_table "shop_shipments", force: :cascade do |t|
    t.string   "tracking",                                                    null: false
    t.string   "uid",                                                         null: false
    t.string   "state",                   limit: 16,                          null: false
    t.decimal  "cost",                               precision: 12, scale: 2, null: false
    t.datetime "shipped_at"
    t.integer  "shop_order_id"
    t.integer  "shop_shipping_method_id"
    t.datetime "created_at",                                                  null: false
    t.datetime "updated_at",                                                  null: false
    t.index ["shop_order_id"], name: "index_shop_shipments_on_shop_order_id", using: :btree
    t.index ["shop_shipping_method_id"], name: "index_shop_shipments_on_shop_shipping_method_id", using: :btree
    t.index ["uid"], name: "index_shop_shipments_on_uid", unique: true, using: :btree
  end

  create_table "shop_shipping_methods", force: :cascade do |t|
    t.string   "name",                                 null: false
    t.string   "tracking",                             null: false
    t.text     "description"
    t.text     "encrypted_profile"
    t.string   "encrypted_profile_iv"
    t.boolean  "active",               default: false, null: false
    t.datetime "created_at",                           null: false
    t.datetime "updated_at",                           null: false
    t.index ["name"], name: "index_shop_shipping_methods_on_name", unique: true, using: :btree
  end

  create_table "shop_shipping_methods_countries", id: false, force: :cascade do |t|
    t.integer "shop_shipping_method_id"
    t.integer "shop_country_id"
    t.index ["shop_country_id"], name: "idx_shop_shipping_methods_countries_c", using: :btree
    t.index ["shop_shipping_method_id", "shop_country_id"], name: "idx_shop_shipping_methods_countries", unique: true, using: :btree
    t.index ["shop_shipping_method_id"], name: "idx_shop_shipping_methods_countries_s", using: :btree
  end

  create_table "shop_states", force: :cascade do |t|
    t.string   "name",            null: false
    t.integer  "shop_country_id"
    t.datetime "created_at",      null: false
    t.datetime "updated_at",      null: false
    t.index ["name", "shop_country_id"], name: "index_shop_states_on_name_and_shop_country_id", unique: true, using: :btree
    t.index ["shop_country_id"], name: "index_shop_states_on_shop_country_id", using: :btree
  end

  create_table "shop_variants", force: :cascade do |t|
    t.string   "sku",             limit: 36,                          null: false
    t.decimal  "price",                      precision: 12, scale: 2, null: false
    t.decimal  "cost_price",                 precision: 12, scale: 2
    t.decimal  "weight",                     precision: 12, scale: 2
    t.decimal  "height",                     precision: 12, scale: 2
    t.decimal  "width",                      precision: 12, scale: 2
    t.decimal  "length",                     precision: 12, scale: 2
    t.integer  "shop_product_id"
    t.datetime "created_at",                                          null: false
    t.datetime "updated_at",                                          null: false
    t.index ["shop_product_id"], name: "index_shop_variants_on_shop_product_id", using: :btree
    t.index ["sku"], name: "index_shop_variants_on_sku", unique: true, using: :btree
  end

  create_table "users", force: :cascade do |t|
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.inet     "current_sign_in_ip"
    t.inet     "last_sign_in_ip"
    t.string   "confirmation_token"
    t.datetime "confirmed_at"
    t.datetime "confirmation_sent_at"
    t.string   "unconfirmed_email"
    t.integer  "failed_attempts",        default: 0,  null: false
    t.string   "unlock_token"
    t.datetime "locked_at"
    t.datetime "created_at",                          null: false
    t.datetime "updated_at",                          null: false
    t.string   "name",                                null: false
    t.index ["confirmation_token"], name: "index_users_on_confirmation_token", unique: true, using: :btree
    t.index ["email"], name: "index_users_on_email", unique: true, using: :btree
    t.index ["reset_password_token"], name: "index_users_on_reset_password_token", unique: true, using: :btree
    t.index ["unlock_token"], name: "index_users_on_unlock_token", unique: true, using: :btree
  end

  create_table "users_roles", id: false, force: :cascade do |t|
    t.integer "user_id"
    t.integer "role_id"
    t.index ["user_id", "role_id"], name: "index_users_roles_on_user_id_and_role_id", using: :btree
  end

  add_foreign_key "attachments", "users"
  add_foreign_key "forum_articles", "users"
  add_foreign_key "forum_articles_tags", "forum_articles"
  add_foreign_key "forum_articles_tags", "forum_tags"
  add_foreign_key "forum_comments", "forum_articles"
  add_foreign_key "forum_comments", "users"
  add_foreign_key "logs", "users"
  add_foreign_key "reading_favorites", "users"
  add_foreign_key "reading_notes", "reading_books"
  add_foreign_key "reading_notes", "users"
  add_foreign_key "shop_addresses", "shop_countries"
  add_foreign_key "shop_addresses", "users"
  add_foreign_key "shop_chargebacks", "shop_orders"
  add_foreign_key "shop_inventory_units", "shop_orders"
  add_foreign_key "shop_inventory_units", "shop_return_authorizations"
  add_foreign_key "shop_inventory_units", "shop_shipments"
  add_foreign_key "shop_inventory_units", "shop_variants"
  add_foreign_key "shop_line_items", "shop_orders"
  add_foreign_key "shop_line_items", "shop_variants"
  add_foreign_key "shop_orders", "shop_addresses"
  add_foreign_key "shop_orders", "users"
  add_foreign_key "shop_payments", "shop_orders"
  add_foreign_key "shop_payments", "shop_payment_methods"
  add_foreign_key "shop_return_authorizations", "shop_orders"
  add_foreign_key "shop_return_authorizations", "shop_shipping_methods"
  add_foreign_key "shop_shipments", "shop_orders"
  add_foreign_key "shop_shipments", "shop_shipping_methods"
  add_foreign_key "shop_shipping_methods_countries", "shop_countries"
  add_foreign_key "shop_shipping_methods_countries", "shop_shipping_methods"
  add_foreign_key "shop_states", "shop_countries"
  add_foreign_key "shop_variants", "shop_products"
end
