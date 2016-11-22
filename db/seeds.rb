# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)

cli = HighLine.new

if User.count == 0
  email = cli.ask('Email? ') { |q| q.default = 'admin@change-me.com' }
  password = cli.ask('Password? ') { |q| q.default = 'change-me' }

  user = User.new name: 'administrator',
                  email: email,
                  password: password,
                  password_confirmation: password
  user.skip_confirmation!
  user.save

  %w(admin root).each {|r| user.grant r}

end

Rails.application.config.engines.each {|e| Object.const_get("#{e}::Engine").load_seed}
