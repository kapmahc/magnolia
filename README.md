Magnolia is a complete open source e-commerce solution for Ruby on Rails.
---

## Ruby version
* Install zsh
```
sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

* Install rbenv
```
git clone https://github.com/rbenv/rbenv.git ~/.rbenv
cd ~/.rbenv && src/configure && make -C src
git clone https://github.com/rbenv/ruby-build.git ~/.rbenv/plugins/ruby-build
git clone https://github.com/rbenv/rbenv-vars.git ~/.rbenv/plugins/rbenv-vars
```

* Setup rbenv
```
echo 'export PATH="$HOME/.rbenv/bin:$PATH"' >> ~/.zshrc
echo 'eval "$(rbenv init -)"' >> ~/.zshrc
```

* Install ruby
```
rbenv install -l
rbenv install 2.3.1
```

## Database creation
```
psql -U postgres
CREATE DATABASE db-name WITH ENCODING = 'UTF8';
CREATE USER user-name WITH PASSWORD 'change-me';
GRANT ALL PRIVILEGES ON DATABASE db-name TO user-name;
```

* ExecStartPre=/usr/bin/postgresql-check-db-dir ${PGROOT}/data (code=exited, status=1/FAILURE)

```
initdb  -D '/var/lib/postgres/data'
```

## For development
```
git clone https://github.com/kapmahc/magnolia.git
cd magnolia

gem install bundler
bundle install

rake db:migrate
rake db:seed

rails s
```

## Deployment instructions
* Run on server
```
```

* Run on local
```
```