Rails.application.routes.draw do

  scope '/:locale' do
    resources :notices, only: :index
    resources :leave_words, only: [:new, :create]

    get '/dashboard' => 'home#dashboard'
    get 'personal/logs'
  end

  Rails.application.config.engines.each {|e| mount Object.const_get("#{e}::Engine") => e.downcase}

  devise_for :users

  root 'home#index'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
