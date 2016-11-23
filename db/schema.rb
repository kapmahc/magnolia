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

ActiveRecord::Schema.define(version: 20161123230019) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "forum_articles", force: :cascade do |t|
    t.string   "title",                                     null: false
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
    t.integer  "forum_article_id"
    t.integer  "vote",                       default: 0,          null: false
    t.datetime "created_at",                                      null: false
    t.datetime "updated_at",                                      null: false
    t.index ["flag"], name: "index_forum_comments_on_flag", using: :btree
    t.index ["forum_article_id"], name: "index_forum_comments_on_forum_article_id", using: :btree
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

  create_table "shop_countries", force: :cascade do |t|
    t.string   "name",                       null: false
    t.boolean  "active",     default: false, null: false
    t.datetime "created_at",                 null: false
    t.datetime "updated_at",                 null: false
    t.index ["name"], name: "index_shop_countries_on_name", unique: true, using: :btree
  end

  create_table "shop_currencies", force: :cascade do |t|
    t.string   "cid",        limit: 3,                                          null: false
    t.string   "code",       limit: 3,                                          null: false
    t.string   "name",                                                          null: false
    t.string   "country",                                                       null: false
    t.decimal  "rate",                 precision: 12, scale: 4
    t.string   "units",      limit: 8,                                          null: false
    t.boolean  "active",                                        default: false, null: false
    t.datetime "created_at",                                                    null: false
    t.datetime "updated_at",                                                    null: false
    t.index ["cid"], name: "index_shop_currencies_on_cid", using: :btree
    t.index ["code"], name: "index_shop_currencies_on_code", using: :btree
    t.index ["country"], name: "index_shop_currencies_on_country", using: :btree
    t.index ["name"], name: "index_shop_currencies_on_name", using: :btree
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
    t.index ["flag"], name: "index_shop_payment_methods_on_flag", using: :btree
    t.index ["name"], name: "index_shop_payment_methods_on_name", unique: true, using: :btree
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

  create_table "shop_states", force: :cascade do |t|
    t.string   "name",            null: false
    t.integer  "shop_country_id"
    t.datetime "created_at",      null: false
    t.datetime "updated_at",      null: false
    t.index ["name", "shop_country_id"], name: "index_shop_states_on_name_and_shop_country_id", unique: true, using: :btree
    t.index ["name"], name: "index_shop_states_on_name", using: :btree
    t.index ["shop_country_id"], name: "index_shop_states_on_shop_country_id", using: :btree
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

  add_foreign_key "forum_articles", "users"
  add_foreign_key "forum_articles_tags", "forum_articles"
  add_foreign_key "forum_articles_tags", "forum_tags"
  add_foreign_key "forum_comments", "forum_articles"
  add_foreign_key "logs", "users"
  add_foreign_key "reading_favorites", "users"
  add_foreign_key "reading_notes", "reading_books"
  add_foreign_key "reading_notes", "users"
  add_foreign_key "shop_states", "shop_countries"
end
