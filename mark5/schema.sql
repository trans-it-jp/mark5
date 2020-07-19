
/* Drop Indexes */

DROP INDEX IF EXISTS index_organization_role_organization;
DROP INDEX IF EXISTS index_organization_role_user;
DROP INDEX IF EXISTS organization_role_organization_user;
DROP INDEX IF EXISTS index_project_organization;
DROP INDEX IF EXISTS index_project_image_project;
DROP INDEX IF EXISTS index_user_image_user;



/* Drop Tables */

DROP TABLE IF EXISTS documents;
DROP TABLE IF EXISTS project_images;
DROP TABLE IF EXISTS project_roles;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS document_templates;
DROP TABLE IF EXISTS organization_images;
DROP TABLE IF EXISTS organization_roles;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS user_images;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS logs;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE clients
(
	id bigserial NOT NULL,
	organization_id bigint NOT NULL,
	name varchar NOT NULL,
	phone varchar,
	postal_code varchar,
	address varchar,
	subject varchar,
	person_in_charge varchar,
	department varchar,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE documents
(
	id bigserial NOT NULL,
	project_id bigint NOT NULL,
	sales_id bigint,
	template_id bigint,
	document_number int,
	document_date date NOT NULL,
	content text NOT NULL,
	document_type int,
	status int NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE document_templates
(
	id bigserial NOT NULL,
	organization_id bigint NOT NULL,
	content text NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE images
(
	id bigserial NOT NULL,
	user_id bigint NOT NULL,
	file_name float NOT NULL,
	file_stream bytea NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE items
(
	id bigserial NOT NULL,
	name varchar,
	sales_id bigint NOT NULL,
	product_id bigint NOT NULL,
	description varchar,
	unit_price int,
	unit varchar,
	item_count int,
	price int,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE logs
(
	id bigserial NOT NULL,
	user_id bigint NOT NULL,
	description varchar,
	create_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE organizations
(
	id bigserial NOT NULL,
	name varchar NOT NULL,
	abbreviation varchar NOT NULL UNIQUE,
	phone varchar,
	postal_code varchar,
	address varchar,
	document_counter int NOT NULL,
	image_id bigint,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE organization_images
(
	id bigserial NOT NULL,
	organization_id bigint NOT NULL,
	image_id bigint NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE organization_roles
(
	id bigserial NOT NULL,
	organization_id bigint NOT NULL,
	user_id bigint NOT NULL,
	authority int NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE products
(
	id bigserial NOT NULL,
	organization_id bigint NOT NULL,
	name varchar NOT NULL,
	description varchar,
	unit_price int NOT NULL,
	unit varchar NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE projects
(
	id bigserial NOT NULL,
	organization_id bigint NOT NULL,
	client_id bigint,
	name varchar NOT NULL,
	abbreviation varchar NOT NULL,
	image_id bigint,
	description varchar,
	status int NOT NULL,
	start_date date NOT NULL,
	end_date date NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp,
	PRIMARY KEY (id),
	CONSTRAINT UNIQUE_PROJECT_ORGANIZATION_ABBREVIATION UNIQUE (organization_id, abbreviation)
) WITHOUT OIDS;


CREATE TABLE project_images
(
	id bigserial NOT NULL,
	project_id bigint NOT NULL,
	image_id bigint NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE project_roles
(
	id bigserial NOT NULL,
	project_id bigint NOT NULL,
	user_id bigint NOT NULL,
	authority int NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE sales
(
	id bigserial NOT NULL,
	project_id bigint NOT NULL,
	name varchar NOT NULL,
	sales_date date NOT NULL,
	status int NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE users
(
	id bigserial NOT NULL,
	name varchar NOT NULL,
	email varchar NOT NULL UNIQUE,
	password varchar NOT NULL,
	is_admin boolean NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE user_images
(
	id bigserial NOT NULL,
	user_id bigint NOT NULL,
	image_id bigint NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE projects
	ADD FOREIGN KEY (client_id)
	REFERENCES clients (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE documents
	ADD FOREIGN KEY (template_id)
	REFERENCES document_templates (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE organizations
	ADD FOREIGN KEY (image_id)
	REFERENCES images (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE organization_images
	ADD FOREIGN KEY (image_id)
	REFERENCES images (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE projects
	ADD FOREIGN KEY (image_id)
	REFERENCES images (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_images
	ADD FOREIGN KEY (image_id)
	REFERENCES images (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE clients
	ADD FOREIGN KEY (organization_id)
	REFERENCES organizations (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE document_templates
	ADD FOREIGN KEY (organization_id)
	REFERENCES organizations (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE organization_images
	ADD FOREIGN KEY (organization_id)
	REFERENCES organizations (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE organization_roles
	ADD FOREIGN KEY (organization_id)
	REFERENCES organizations (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE products
	ADD FOREIGN KEY (organization_id)
	REFERENCES organizations (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE projects
	ADD FOREIGN KEY (organization_id)
	REFERENCES organizations (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE items
	ADD FOREIGN KEY (product_id)
	REFERENCES products (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE documents
	ADD FOREIGN KEY (project_id)
	REFERENCES projects (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE project_images
	ADD FOREIGN KEY (project_id)
	REFERENCES projects (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE project_roles
	ADD FOREIGN KEY (project_id)
	REFERENCES projects (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sales
	ADD FOREIGN KEY (project_id)
	REFERENCES projects (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE documents
	ADD FOREIGN KEY (sales_id)
	REFERENCES sales (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE items
	ADD FOREIGN KEY (sales_id)
	REFERENCES sales (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE images
	ADD FOREIGN KEY (user_id)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE logs
	ADD FOREIGN KEY (user_id)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE organization_roles
	ADD FOREIGN KEY (user_id)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE project_images
	ADD FOREIGN KEY (image_id)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE project_roles
	ADD FOREIGN KEY (user_id)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_images
	ADD FOREIGN KEY (user_id)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE INDEX index_organization_role_organization ON organization_roles (organization_id);
CREATE INDEX index_organization_role_user ON organization_roles (user_id);
CREATE INDEX organization_role_organization_user ON organization_roles (organization_id, user_id);
CREATE INDEX index_project_organization ON projects (organization_id);
CREATE INDEX index_project_image_project ON project_images (project_id);
CREATE INDEX index_user_image_user ON user_images (user_id);



