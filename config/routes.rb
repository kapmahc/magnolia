require 'sidekiq/web'

Rails.application.routes.draw do
  scope '/:locale' do
    get '/dashboard' => 'home#dashboard'
    get 'personal/logs'

    Rails.application.config.engines.each {|e| mount Object.const_get("#{e}::Engine") => e.downcase}
  end

  devise_for :users

  # authenticate :user, lambda { |u| u.admin? } do
    mount Sidekiq::Web => '/sidekiq'
  # end

  root to: 'home#index'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
