CREATE SEQUENCE hibernate_sequence;

CREATE TABLE application_user
(
  id bigint NOT NULL,
  last_modified_date timestamp without time zone NOT NULL,
  name character varying(255),
  CONSTRAINT application_user_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE application_user
OWNER TO postgres;

CREATE TABLE entity
(
  id bigint NOT NULL,
  last_modified_date timestamp without time zone NOT NULL,
  created_date timestamp without time zone NOT NULL,
  age integer NOT NULL,
  name character varying(255),
  created_by bigint NOT NULL,
  last_modified_by bigint NOT NULL,
  CONSTRAINT entity_pkey PRIMARY KEY (id),
  CONSTRAINT fk_entity_application_user_last_modified_by FOREIGN KEY (last_modified_by)
      REFERENCES application_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_entity_application_user_created_by FOREIGN KEY (created_by)
      REFERENCES application_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE entity
  OWNER TO postgres;

CREATE TABLE nested_entity
(
  id bigint NOT NULL,
  last_modified_date timestamp without time zone NOT NULL,
  nested_age integer NOT NULL,
  nested_name character varying(255),
  entity_batch10 bigint,
  entity_no_batch bigint,
  CONSTRAINT nested_entity_pkey PRIMARY KEY (id),
  CONSTRAINT fk_nested_entity_no_batch FOREIGN KEY (entity_no_batch)
  REFERENCES entity (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_entity_nested_entity_batch10 FOREIGN KEY (entity_batch10)
  REFERENCES entity (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE nested_entity
OWNER TO postgres;