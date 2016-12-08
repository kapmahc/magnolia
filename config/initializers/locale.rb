require 'i18n/backend/active_record'

I18n.default_locale = :en

if I18n::Backend::ActiveRecord::Translation.table_exists?
  I18n.backend = I18n::Backend::Chain.new(I18n::Backend::ActiveRecord.new, I18n.backend)

end