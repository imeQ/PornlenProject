CREATE DATABASE  IF NOT EXISTS pornlen;
USE pornlen;

--
-- Table structure for table application_user
--

DROP TABLE IF EXISTS application_user;
CREATE TABLE application_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Table structure for table driver
--

DROP TABLE IF EXISTS driver;
CREATE TABLE driver (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  created_date datetime NOT NULL,
  deleted bit(1) DEFAULT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_login_date datetime DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  location varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  pin varchar(255) DEFAULT NULL,
  created_by bigint(20) NOT NULL,
  last_modified_by bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_cpno6c2vj5nq69x2e8bx20o6o (created_by),
  KEY FK_arjuijk08evt1ileiyv61drf1 (last_modified_by),
  CONSTRAINT FK_arjuijk08evt1ileiyv61drf1 FOREIGN KEY (last_modified_by) REFERENCES application_user (id),
  CONSTRAINT FK_cpno6c2vj5nq69x2e8bx20o6o FOREIGN KEY (created_by) REFERENCES application_user (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table entity
--

DROP TABLE IF EXISTS entity;
CREATE TABLE entity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  created_date datetime NOT NULL,
  deleted bit(1) DEFAULT NULL,
  age int(11) NOT NULL,
  name varchar(255) DEFAULT NULL,
  created_by bigint(20) NOT NULL,
  last_modified_by bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_iwpbr6o3ql9il1iqfn1e4q3pu (created_by),
  KEY FK_39v0bcwqdehg7b0219sdix5t1 (last_modified_by),
  CONSTRAINT FK_39v0bcwqdehg7b0219sdix5t1 FOREIGN KEY (last_modified_by) REFERENCES application_user (id),
  CONSTRAINT FK_iwpbr6o3ql9il1iqfn1e4q3pu FOREIGN KEY (created_by) REFERENCES application_user (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Table structure for table nested_entity
--

DROP TABLE IF EXISTS nested_entity;
CREATE TABLE nested_entity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  nested_age int(11) NOT NULL,
  nested_name varchar(255) DEFAULT NULL,
  entity_batch10 bigint(20) DEFAULT NULL,
  entity_no_batch bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_qn2n19wnq8kcc5c1hji0q9c73 (entity_batch10),
  KEY FK_47j275l0xij9lqyeu0t53xqsh (entity_no_batch),
  CONSTRAINT FK_47j275l0xij9lqyeu0t53xqsh FOREIGN KEY (entity_no_batch) REFERENCES entity (id),
  CONSTRAINT FK_qn2n19wnq8kcc5c1hji0q9c73 FOREIGN KEY (entity_batch10) REFERENCES entity (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Table structure for table product
--

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table semi_trailer
--

DROP TABLE IF EXISTS semi_trailer;
CREATE TABLE semi_trailer (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  number varchar(255) DEFAULT NULL,
  side_number varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table station
--

DROP TABLE IF EXISTS station;
CREATE TABLE station (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  mob_station_number varchar(255) DEFAULT NULL,
  place varchar(255) DEFAULT NULL,
  sap_number varchar(255) DEFAULT NULL,
  street varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table terminal
--

DROP TABLE IF EXISTS terminal;
CREATE TABLE terminal (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  code varchar(255) DEFAULT NULL,
  expected_unloading varchar(255) DEFAULT NULL,
  expected_unloading_address varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table truck
--

DROP TABLE IF EXISTS truck;
CREATE TABLE truck (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  number varchar(255) DEFAULT NULL,
  side_number varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table schedule
--

DROP TABLE IF EXISTS schedule;
CREATE TABLE schedule (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  last_modified_date datetime NOT NULL,
  carrier varchar(255) DEFAULT NULL,
  carrier_description varchar(255) DEFAULT NULL,
  density float DEFAULT NULL,
  distribution_finished bit(1) DEFAULT NULL,
  forwarder varchar(255) DEFAULT NULL,
  forwarder_description varchar(255) DEFAULT NULL,
  kilograms_number int(11) DEFAULT NULL,
  liters int(11) DEFAULT NULL,
  loading_date datetime DEFAULT NULL,
  order_number bigint(20) DEFAULT NULL,
  pool varchar(255) DEFAULT NULL,
  pour_card_number varchar(255) DEFAULT NULL,
  propane varchar(255) DEFAULT NULL,
  region varchar(255) DEFAULT NULL,
  reservation_number int(11) DEFAULT NULL,
  route_number int(11) DEFAULT NULL,
  tds_number varchar(255) DEFAULT NULL,
  temperature float DEFAULT NULL,
  unloading_date datetime DEFAULT NULL,
  weight_after int(11) DEFAULT NULL,
  weight_amount_number varchar(255) DEFAULT NULL,
  weight_before int(11) DEFAULT NULL,
  driver bigint(20) DEFAULT NULL,
  product bigint(20) DEFAULT NULL,
  semi_trailer bigint(20) DEFAULT NULL,
  station bigint(20) DEFAULT NULL,
  terminal bigint(20) DEFAULT NULL,
  truck bigint(20) DEFAULT NULL,
  unload_terminal bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_5ilcttfvt5nth9sb91oceahb (driver),
  KEY FK_op5bqbb72tjgbf7qqqcujadtm (product),
  KEY FK_lkrbg9vwwl8tkgiw0fwo441ks (semi_trailer),
  KEY FK_18y3knou9icartmgpwjs0jsnt (station),
  KEY FK_8x50s1kf36ncr4v2atoil956q (terminal),
  KEY FK_g5ofk4dnbxj60v69qng971kxw (truck),
  KEY FK_ibfnp40kfkoaiv68f0h75lhuf (unload_terminal),
  CONSTRAINT FK_ibfnp40kfkoaiv68f0h75lhuf FOREIGN KEY (unload_terminal) REFERENCES terminal (id),
  CONSTRAINT FK_18y3knou9icartmgpwjs0jsnt FOREIGN KEY (station) REFERENCES station (id),
  CONSTRAINT FK_5ilcttfvt5nth9sb91oceahb FOREIGN KEY (driver) REFERENCES driver (id),
  CONSTRAINT FK_8x50s1kf36ncr4v2atoil956q FOREIGN KEY (terminal) REFERENCES terminal (id),
  CONSTRAINT FK_g5ofk4dnbxj60v69qng971kxw FOREIGN KEY (truck) REFERENCES truck (id),
  CONSTRAINT FK_lkrbg9vwwl8tkgiw0fwo441ks FOREIGN KEY (semi_trailer) REFERENCES semi_trailer (id),
  CONSTRAINT FK_op5bqbb72tjgbf7qqqcujadtm FOREIGN KEY (product) REFERENCES product (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
