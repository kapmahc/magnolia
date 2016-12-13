create table vpn_users (
  id serial primary key,
  email varchar(255) not null,
  password varchar(255) not null,
  details text,
  online bool not null default false,
  enable bool not null default false,
  start_up date not null default '2016-12-13',
  shut_down date not null default current_date,
  created_at timestamp without time zone not null default now(),
  updated_at timestamp without time zone not null
);
create unique index idx_vpn_users_email on vpn_users(email);

create table vpn_logs (
  id serial primary key,
  user_id int not null,
  trusted_ip inet,
  trusted_port smallint,
  remote_ip inet,
  remote_port smallint,
  start_up timestamp without time zone not null default CURRENT_TIMESTAMP,
  shut_down timestamp without time zone,
  received float not null default '0.0',
  send float not null default '0.0'
);