CREATE TABLE IF NOT EXISTS lang (
  id   SERIAL      NOT NULL UNIQUE,
  lang VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS person (
  id            SERIAL      NOT NULL UNIQUE,
  user_name     VARCHAR(15) NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  lang_id       INTEGER     NOT NULL DEFAULT (1),
  deleted       BOOLEAN              DEFAULT (FALSE),
  PRIMARY KEY (id),
  CONSTRAINT fk_lang
  FOREIGN KEY (lang_id)
  REFERENCES lang (id)
);

CREATE TABLE IF NOT EXISTS address (
  id           SERIAL      NOT NULL UNIQUE,
  country_name VARCHAR(30) NOT NULL,
  city_name    VARCHAR(30),
  streets_name VARCHAR(40),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS group_c (
  id         SERIAL      NOT NULL UNIQUE,
  group_name VARCHAR(20) NOT NULL UNIQUE,
  is_default BOOLEAN,
  created_by INT DEFAULT NULL,
  CONSTRAINT group_creator
  FOREIGN KEY (created_by)
  REFERENCES person (id)
);

CREATE TABLE IF NOT EXISTS contact (
  id            SERIAL      NOT NULL UNIQUE,
  first_name    VARCHAR(15) NOT NULL,
  last_name     VARCHAR(15) NOT NULL,
  mobil_phone   VARCHAR(20) NOT NULL,
  home_phone    VARCHAR(20),
  email         VARCHAR(40),
  date_creating DATE        NOT NULL,
  address       INT,
  group_id      INT,
  creator_id    INT,
  PRIMARY KEY (id),
  CONSTRAINT fk_group
  FOREIGN KEY (group_id)
  REFERENCES group_c (id),
  CONSTRAINT fk_creator
  FOREIGN KEY (creator_id)
  REFERENCES person (id),
  CONSTRAINT fk_address
  FOREIGN KEY (address)
  REFERENCES address (id)
);


