DROP TABLE car;
DROP TABLE profile;
DROP TABLE agency;
DROP TABLE contact;
DROP TABLE messages;


--
-- Name: profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE profile (
    id integer NOT NULL,
    agencyid integer NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    name character varying(100) NOT NULL,
    mail character varying(100) NOT NULL,
    phone character varying(50) NOT NULL,
    job integer NOT NULL,
    label character varying(100) NOT NULL,
	token character varying(100),
	googlekey character varying(100)
);

--
-- Name: car; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE car (
    id integer NOT NULL,
    agencyid integer NOT NULL,
    imei character varying(100) NOT NULL,
    simnumber character varying(100) NOT NULL,
    immatriculation character varying(100) NOT NULL,
    vin character varying(100) NOT NULL,
    mark character varying(100) NOT NULL,
    model character varying(100) NOT NULL,
	color character varying(100) NOT NULL,
    photo character varying(100) NOT NULL,
    status integer DEFAULT 0,
	deviceid integer NOT NULL,
	maxspeed integer NOT NULL,
	mileage integer NOT NULL,
	consumption decimal,
	fuel character varying(3) NOT NULL,
	latitude1 decimal,
	longitude1 decimal,
	latitude2 decimal,
	longitude2 decimal,
	latitude3 decimal,
	longitude3 decimal,
	latitude4 decimal,
	longitude4 decimal,
	latitude5 decimal,
	longitude5 decimal,
	latitude6 decimal,
	longitude6 decimal,
	colorcode character varying(15),
	isgeofence boolean,
	isnotifgeofence boolean,
	isnotifdefaultgeofence boolean,
	devicetype character varying(10)
);

--
-- Name: agency; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE agency (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    code integer NOT NULL,
    city character varying(100) NOT NULL,
    address character varying(250) NOT NULL,
    phone character varying(50) NOT NULL,
    fax character varying(50) NOT NULL,
    carnumber integer NOT NULL
);

--
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE contact (
    id integer NOT NULL,
    city character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    mail character varying(100) NOT NULL,
    phone character varying(100) NOT NULL,
    photo character varying(100) NOT NULL
);

--
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE messages (
    id  SERIAL PRIMARY KEY,
    deviceid integer,
    creationdate timestamp default current_timestamp,
    texte varchar(1000)
);

CREATE TABLE pushnotification (
    login varchar(1000),
    pushnotiftoken varchar(1000)
);

--
-- Name: agency_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY agency ADD CONSTRAINT agency_pkey PRIMARY KEY (id);

--
-- Name: profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY profile ADD CONSTRAINT profile_pkey PRIMARY KEY (id);

--
-- Name: profile_agencyid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY profile ADD CONSTRAINT profile_agencyid_fkey FOREIGN KEY (agencyid) REFERENCES agency(id);

--
-- Name: car_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY car ADD CONSTRAINT car_pkey PRIMARY KEY (id);

--
-- Name: car_agencyid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY car ADD CONSTRAINT car_agencyid_fkey FOREIGN KEY (agencyid) REFERENCES agency(id);

--
-- Name: car_agencyid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY car ADD CONSTRAINT car_deviceid_fkey FOREIGN KEY (deviceid) REFERENCES devices(id);

--
-- Create Index 
--
CREATE INDEX deviceid_idx ON positions (deviceid);
CREATE INDEX servertime_idx ON positions (servertime);
CREATE INDEX valid_idx ON positions (valid);
