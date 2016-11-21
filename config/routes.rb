require 'forum'
require 'shop'
require 'reading'
require 'ops'
require 'sidekiq/web'

Rails.application.routes.draw do
  scope '/:locale' do
    mount Forum::Engine => '/forum'
    mount Shop::Engine => '/shop'
    mount Reading::Engine => '/reading'
    mount Ops::Engine => '/ops'
  end

  devise_for :users

  authenticate :user, lambda { |u| u.admin? } do
    mount Sidekiq::Web => '/sidekiq'
  end

  root to: 'home#index'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
