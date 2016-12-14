CREATE TABLE mail_domains (
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(128)                NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);
CREATE UNIQUE INDEX idx_mail_domains_name
  ON mail_domains (name);

CREATE TABLE mail_users (
  id         SERIAL PRIMARY KEY,
  domain_id  INT                         NOT NULL,
  email      VARCHAR(255)                NOT NULL,
  name       VARCHAR(128)                NOT NULL,
  password   VARCHAR(255)                NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);
CREATE UNIQUE INDEX idx_mail_users_email
  ON mail_users (email);
CREATE INDEX idx_mail_users_name
  ON mail_users (name);

CREATE TABLE mail_aliases (
  id          SERIAL PRIMARY KEY,
  domain_id   INT                         NOT NULL,
  source      VARCHAR(255)                NOT NULL,
  destination VARCHAR(255)                NOT NULL,
  created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
  updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL
);
CREATE UNIQUE INDEX idx_mail_aliases_source
  ON mail_aliases (source);
CREATE INDEX idx_mail_aliases_destination
  ON mail_aliases (destination);