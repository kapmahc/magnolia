Magnolia is a complete open source e-commerce solution for Ruby on Rails.
---

## Ruby version
* Install zsh
```bash
sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

* Install rbenv
```bash
git clone https://github.com/rbenv/rbenv.git ~/.rbenv
cd ~/.rbenv && src/configure && make -C src
git clone https://github.com/rbenv/ruby-build.git ~/.rbenv/plugins/ruby-build
git clone https://github.com/rbenv/rbenv-vars.git ~/.rbenv/plugins/rbenv-vars
```

* Setup rbenv
```bash
echo 'export PATH="$HOME/.rbenv/bin:$PATH"' >> ~/.zshrc
echo 'eval "$(rbenv init -)"' >> ~/.zshrc
```

* Install ruby
```bash
rbenv install -l
rbenv install 2.3.3
rbenv local 2.3.3
gem install bundler
```

## Database creation
```bash
psql -U postgres
CREATE DATABASE db-name WITH ENCODING = 'UTF8';
CREATE USER user-name WITH PASSWORD 'change-me';
GRANT ALL PRIVILEGES ON DATABASE db-name TO user-name;
```

* ExecStartPre=/usr/bin/postgresql-check-db-dir ${PGROOT}/data (code=exited, status=1/FAILURE)

```bash
initdb  -D '/var/lib/postgres/data'
```

* Peer authentication failed for user
Need edit file "/etc/postgresql/9.5/main/pg_hba.conf" change line:
```
local   all             all                                     peer
```
to:
```
local   all             all                                     md5
```

## For development
```bash
git clone https://github.com/kapmahc/magnolia.git
cd magnolia

bundle install

rake db:migrate
rake db:seed

rails s
```

## Deployment instructions

```bash
# deploy
bundle exec cap production deploy
# upload puma.conf
bundle exec cap production puma:config
# upload nginx config file
bundle exec cap production puma:nginx_config
# create sitemap.xml.gz
bundle exec cap production deploy:sitemap:create
```

```bash
bundle exec rake db:seed
whenever --update-crontab
crontab -l
```

## Notes

* sqlite3
```bash
.tables # show tables
.schema ?TABLE? # Show the CREATE statements
```

* rails
```bash
rails new magnolia -d postgresql
rails plugin new forum --mountable
rails g controller Home index --no-assets --no-helper
rails railties:install:migrations
```

## Documents

- http://guides.rubyonrails.org/

## Contributing

## License
The gem is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
