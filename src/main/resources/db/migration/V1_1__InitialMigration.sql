CREATE TABLE application_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  last_modified_date TIMESTAMP,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE entity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  last_modified_date TIMESTAMP,
  age int(11) NOT NULL,
  name varchar(255) DEFAULT NULL,
  created_by bigint(20) NOT NULL,
  last_modified_by bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_iwpbr6o3ql9il1iqfn1e4q3pu (created_by),
  KEY FK_39v0bcwqdehg7b0219sdix5t1 (last_modified_by),
  CONSTRAINT FK_39v0bcwqdehg7b0219sdix5t1 FOREIGN KEY (last_modified_by) REFERENCES application_user (id),
  CONSTRAINT FK_iwpbr6o3ql9il1iqfn1e4q3pu FOREIGN KEY (created_by) REFERENCES application_user (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE nested_entity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  last_modified_date TIMESTAMP,
  nested_age int(11) NOT NULL,
  nested_name varchar(255) DEFAULT NULL,
  entity_batch10 bigint(20) DEFAULT NULL,
  entity_no_batch bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_qn2n19wnq8kcc5c1hji0q9c73 (entity_batch10),
  KEY FK_47j275l0xij9lqyeu0t53xqsh (entity_no_batch),
  CONSTRAINT FK_47j275l0xij9lqyeu0t53xqsh FOREIGN KEY (entity_no_batch) REFERENCES entity (id),
  CONSTRAINT FK_qn2n19wnq8kcc5c1hji0q9c73 FOREIGN KEY (entity_batch10) REFERENCES entity (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
