# RailsSettings Model
class Setting < RailsSettings::Base
  source Rails.root.join('config/app.yml')
  namespace Rails.env

  def self.site_info(k)
    self["#{I18n.locale}://site/#{k}"]
  end
end
