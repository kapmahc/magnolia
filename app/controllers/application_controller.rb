class ApplicationController < ActionController::Base
  include Pundit
  protect_from_forgery with: :exception

  before_action :set_locale
  before_action :configure_permitted_parameters, if: :devise_controller?

  def default_url_options
    { locale: I18n.locale }
  end

  protected
  def set_locale
    I18n.locale = params[:locale] || browser.accept_language.first.full #I18n.default_locale
  end

  def configure_permitted_parameters
    added_attrs = [:name, :password, :password_confirmation, :remember_me]
    devise_parameter_sanitizer.permit :sign_up, keys: added_attrs + [:email]
    devise_parameter_sanitizer.permit :account_update, keys: added_attrs
  end
end
