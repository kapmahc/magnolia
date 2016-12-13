create table cms_articles(
  id serial primary key,
  user_id int not null,
  title varchar(255) not null,
  summary varchar(800) not null,
  body text not null,
  type varchar(8) not null default 'markdown',
  created_at timestamp without time zone not null default now(),
  updated_at timestamp without time zone not null
);
create index idx_cms_articles on cms_articles(title);
create index idx_cms_type on cms_articles(type);

create table cms_tags(
  id serial primary key,
  name varchar(255) not null,
  created_at timestamp without time zone not null default now(),
  updated_at timestamp without time zone not null
);
create unique index idx_cms_tags_name on cms_tags(name);

create table cms_articles_tags(
  id serial primary key,
  article_id int not null,
  tag_id int not null
);
create unique index idx_cms_articles_tags on cms_articles_tags(article_id, tag_id);

create table cms_comments(
  id serial primary key,
  article_id int not null,
  user_id int not null,
  body text not null,
  type varchar(8) not null default 'markdown',
  created_at timestamp without time zone not null default now(),
  updated_at timestamp without time zone not null
);
create index idx_cms_comments_type on cms_comments(type);
