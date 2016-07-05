CREATE SCHEMA IF NOT EXISTS phoneBook;

CREATE TABLE IF NOT EXISTS phoneBook.lang (
  id   SERIAL      NOT NULL UNIQUE ,
  lang VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS phoneBook.person (
  id            SERIAL      NOT NULL UNIQUE ,
  user_name     VARCHAR(15) NOT NULL,
  user_password VARCHAR(15) NOT NULL,
  lang_id       INTEGER     NOT NULL DEFAULT (1),
  deleted       BOOLEAN              DEFAULT (FALSE ),
  PRIMARY KEY (id),
  CONSTRAINT fk_lang
  FOREIGN KEY (lang_id)
  REFERENCES phoneBook.lang (id)
);

CREATE TABLE IF NOT EXISTS phoneBook.address (
  id           SERIAL      NOT NULL UNIQUE ,
  country_name VARCHAR(30) NOT NULL,
  city_name    VARCHAR(30),
  streets_name  VARCHAR(40),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS phoneBook.contact (
  id          SERIAL      NOT NULL UNIQUE ,
  first_name  VARCHAR(15) NOT NULL,
  last_name   VARCHAR(15) NOT NULL,
  mobil_phone VARCHAR(20) NOT NULL,
  home_phone  VARCHAR(20),
  email       VARCHAR(20),
  date_creating DATE NOT NULL,
  address     INT,
  creator_id INT,
  PRIMARY KEY (id),
  CONSTRAINT fk_creator
    FOREIGN KEY (creator_id)
    REFERENCES phoneBook.person (id),
  CONSTRAINT fk_address
    FOREIGN KEY (address)
    REFERENCES phoneBook.address(id)
);

