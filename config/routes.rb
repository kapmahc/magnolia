Rails.application.routes.draw do

  scope '/:locale' do
    resources :notices, only: :index
    resources :leave_words, only: [:new, :create]

    get '/dashboard' => 'home#dashboard'
    get 'personal/logs'
  end

  get '/google(*id).html', to: 'home#google', as: :google_verify
  get '/baidu_verify_(*id).html', to: 'home#baidu', as: :baidu_verify
  get '/robots', to: 'home#robots', as: :robots_txt, constraints: {format: :txt}

  Rails.application.config.engines.each {|e| mount Object.const_get("#{e}::Engine") => e.downcase}

  devise_for :users

  root 'home#index'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
