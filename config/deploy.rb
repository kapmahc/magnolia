# config valid only for current version of Capistrano
lock '3.6.1'

set :application, 'magnolia'
set :repo_url, 'https://github.com/kapmahc/magnolia.git'

# Default branch is :master
# ask :branch, `git rev-parse --abbrev-ref HEAD`.chomp

# Default deploy_to directory is /var/www/my_app_name
# set :deploy_to, '/var/www/my_app_name'
set :deploy_to, -> { "/var/www/#{fetch :app_domain, 'localhost'}" }

# Default value for :scm is :git
# set :scm, :git

# Default value for :format is :airbrussh.
# set :format, :airbrussh

# You can configure the Airbrussh format using :format_options.
# These are the defaults.
# set :format_options, command_output: true, log_file: 'log/capistrano.log', color: :auto, truncate: :auto

# Default value for :pty is false
# set :pty, true

# Default value for :linked_files is []
# append :linked_files, 'config/database.yml', 'config/secrets.yml'
append :linked_files, 'config/app.yml', 'config/database.yml', 'config/magnolia.yml', 'config/sidekiq.yml', 'config/schedule.yml', '.rbenv-vars'

# Default value for linked_dirs is []
# append :linked_dirs, 'log', 'tmp/pids', 'tmp/cache', 'tmp/sockets', 'public/system'
append :linked_dirs, 'log', 'tmp/pids', 'tmp/cache', 'tmp/sockets', 'tmp/sessions', 'public/system', 'public/attachments', 'tmp/books', 'node_modules'

# Default value for default_env is {}
# set :default_env, { path: "/opt/ruby/bin:$PATH" }

# Default value for keep_releases is 5
# set :keep_releases, 5

# rbenv
set :rbenv_type, :user # or :system, depends on your rbenv setup
set :rbenv_ruby, File.read('.ruby-version').strip


# nginx
set :nginx_config_name, -> { "#{fetch(:app_domain)}" }
set :nginx_server_name, -> { fetch :app_domain }
set :nginx_use_ssl, true