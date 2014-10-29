CREATE TABLE pornlen.applicationUser (
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	lastModifiedDate   datetime  NOT NULL  ,
	name                 varchar(255)    ,
	CONSTRAINT pk_application_user PRIMARY KEY ( id )
 );

CREATE TABLE pornlen.contract ( 
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	name                 varchar(100)  NOT NULL  ,
	CONSTRAINT pk_contract PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE TABLE pornlen.driver ( 
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	createdBy           int UNSIGNED NOT NULL  ,
	createdDate         datetime  NOT NULL  ,
	deleted              bit    ,
	firstName           varchar(255)    ,
	lastLoginDate      datetime    ,
	lastModifiedBy     int UNSIGNED NOT NULL  ,
	lastModifiedDate   datetime  NOT NULL  ,
	lastName            varchar(255)    ,
	location             varchar(255)    ,
	password             int UNSIGNED NOT NULL    ,
	pin                  int UNSIGNED NOT NULL    ,
	CONSTRAINT pk_driver PRIMARY KEY ( id ),
	CONSTRAINT fk_driver FOREIGN KEY ( lastModifiedBy ) REFERENCES pornlen.applicationUser( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_driver_0 FOREIGN KEY ( createdBy ) REFERENCES pornlen.applicationUser( id ) ON DELETE NO ACTION ON UPDATE NO ACTION
 );

CREATE INDEX FK_cpno6c2vj5nq69x2e8bx20o6o ON pornlen.driver ( createdBy );

CREATE INDEX FK_arjuijk08evt1ileiyv61drf1 ON pornlen.driver ( lastModifiedBy );

CREATE TABLE pornlen.driverContract ( 
	driver               int UNSIGNED NOT NULL  ,
	contract             int UNSIGNED   ,
	CONSTRAINT pk_vehicle_contract_0 PRIMARY KEY ( driver ),
	CONSTRAINT fk_driver_contract FOREIGN KEY ( driver ) REFERENCES pornlen.driver( id ) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT fk_driver_contract_0 FOREIGN KEY ( contract ) REFERENCES pornlen.contract( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 );

CREATE INDEX idx_vehicle_contract_0 ON pornlen.driverContract ( contract );

CREATE TABLE pornlen.fuelType ( 
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	lastModifiedDate   datetime  NOT NULL  ,
	name                 varchar(255)    ,
	CONSTRAINT pk_product PRIMARY KEY ( id )
 );

CREATE TABLE pornlen.role ( 
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	name                 varchar(100)  NOT NULL  ,
	description          varchar(100)    ,
	field                int UNSIGNED NOT NULL  ,
	roleOrder           int UNSIGNED NOT NULL  ,
	CONSTRAINT pk_rights PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE TABLE pornlen.station ( 
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	lastModifiedDate   datetime  NOT NULL  ,
	mobStationNumber   varchar(255)    ,
	place                varchar(255)    ,
	sapNumber           varchar(255)    ,
	street               varchar(255)    ,
	CONSTRAINT pk_station PRIMARY KEY ( id )
 );

CREATE TABLE pornlen.terminal ( 
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	code                 varchar(255)    ,
	expectedUnloading   varchar(255)    ,
	expectedUnloadingAddress varchar(255)    ,
	lastModifiedDate   datetime  NOT NULL  ,
	name                 varchar(255)    ,
	CONSTRAINT pk_terminal PRIMARY KEY ( id )
 );

CREATE TABLE pornlen.vehicle ( 
	id                   int UNSIGNED NOT NULL  AUTO_INCREMENT,
	lastModifiedDate   datetime  NOT NULL  ,
	number               varchar(255)  NOT NULL  ,
	sideNumber          varchar(255)    ,
	vehicleType         enum('TRUCK','SEMI')   NOT NULL DEFAULT 'TRUCK' ,
	CONSTRAINT pk_truck PRIMARY KEY ( id )
 );

CREATE TABLE pornlen.vehicleContract ( 
	vehicle              int UNSIGNED NOT NULL  ,
	contract             int UNSIGNED   ,
	CONSTRAINT pk_vehicle_contract PRIMARY KEY ( vehicle ),
	CONSTRAINT fk_vehicle_contract FOREIGN KEY ( contract ) REFERENCES pornlen.contract( id ) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT fk_vehicle_contract_0 FOREIGN KEY ( vehicle ) REFERENCES pornlen.vehicle( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_vehicle_contract ON pornlen.vehicleContract ( contract );

CREATE TABLE pornlen.applicationUserRole ( 
	applicationUser     int UNSIGNED NOT NULL  ,
	role                 int UNSIGNED NOT NULL  ,
	CONSTRAINT pk_application_user_role PRIMARY KEY ( applicationUser ),
	CONSTRAINT fk_application_user_role FOREIGN KEY ( applicationUser ) REFERENCES pornlen.applicationUser( id ) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT fk_application_user_role_0 FOREIGN KEY ( role ) REFERENCES pornlen.role( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_application_user_role ON pornlen.applicationUserRole ( role );

CREATE TABLE pornlen.schedule ( 
	id                   bigint UNSIGNED NOT NULL  AUTO_INCREMENT,
	carrier              varchar(255)    ,
	carrierDescription  varchar(255)    ,
	density              float(12)    ,
	distributionFinished bit    ,
	driver               int UNSIGNED   ,
	forwarder            varchar(255)    ,
	forwarderDescription varchar(255)    ,
	fuelType            int UNSIGNED   ,
	kilograms            int    ,
	lastModifiedDate   datetime  NOT NULL  ,
	liters               int    ,
	loadingDate         datetime    ,
	orderNumber         bigint    ,
	pool                 varchar(255)    ,
	pourCardNumber     varchar(255)    ,
	propane              varchar(255)    ,
	region               varchar(255)    ,
	reservationNumber   int    ,
	routeNumber         int    ,
	semiTrailer         int UNSIGNED   ,
	station              int UNSIGNED   ,
	tdsNumber           varchar(255)    ,
	temperature          float(12)    ,
	loadTerminal        int UNSIGNED   ,
	truck                int UNSIGNED   ,
	unloadTerminal      int UNSIGNED   ,
	unLoadingDate       datetime    ,
	weightAfter         int    ,
	weightAmountNumber varchar(255)    ,
	weightBefore        int    ,
	CONSTRAINT pk_schedule PRIMARY KEY ( id ),
	CONSTRAINT fk_schedule FOREIGN KEY ( truck ) REFERENCES pornlen.vehicle( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_schedule_0 FOREIGN KEY ( semiTrailer ) REFERENCES pornlen.vehicle( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_schedule_1 FOREIGN KEY ( driver ) REFERENCES pornlen.driver( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_schedule_2 FOREIGN KEY ( station ) REFERENCES pornlen.station( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_schedule_3 FOREIGN KEY ( unloadTerminal ) REFERENCES pornlen.terminal( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_schedule_4 FOREIGN KEY ( loadTerminal ) REFERENCES pornlen.terminal( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_schedule_5 FOREIGN KEY ( fuelType ) REFERENCES pornlen.fuelType( id ) ON DELETE NO ACTION ON UPDATE NO ACTION
 );

CREATE INDEX FK_5ilcttfvt5nth9sb91oceahb ON pornlen.schedule ( driver );

CREATE INDEX FK_op5bqbb72tjgbf7qqqcujadtm ON pornlen.schedule ( fuelType );

CREATE INDEX FK_lkrbg9vwwl8tkgiw0fwo441ks ON pornlen.schedule ( semiTrailer );

CREATE INDEX FK_18y3knou9icartmgpwjs0jsnt ON pornlen.schedule ( station );

CREATE INDEX FK_8x50s1kf36ncr4v2atoil956q ON pornlen.schedule ( loadTerminal );

CREATE INDEX FK_g5ofk4dnbxj60v69qng971kxw ON pornlen.schedule ( truck );

CREATE INDEX FK_ibfnp40kfkoaiv68f0h75lhuf ON pornlen.schedule ( unloadTerminal );

