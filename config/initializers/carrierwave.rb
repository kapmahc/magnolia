CarrierWave.configure do |config|
  config.permissions = 0644
  config.directory_permissions = 0755
  config.storage = :fog

  config.fog_credentials = Rails.application.config.magnolia['fog']
  config.fog_directory = 'tmp'
  config.fog_public = true
  config.fog_attributes = {'Cache-Control' => "max-age=#{5.years.to_i}"}

end