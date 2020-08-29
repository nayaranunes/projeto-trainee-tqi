CREATE TABLE IF NOT EXISTS login
(
    id            BIGINT       NOT NULL PRIMARY KEY,
    username      VARCHAR(100) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    credential_id BIGINT       NOT NULL,
    status        BOOLEAN      NOT NULL,
    password      VARCHAR(255) NOT NULL,
    CONSTRAINT fk_login_x_credential FOREIGN KEY (credential_id) REFERENCES credential (id)
);

CREATE SEQUENCE IF NOT EXISTS login_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS credential
(
    id            BIGINT       NOT NULL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    document      VARCHAR(50)  NOT NULL,
    document_type VARCHAR(4)   NOT NULL,
    birthday      DATE         NOT NULL NOT NULL,
    phone         VARCHAR(255) NOT NULL,
    created_at    TIMESTAMP DEFAULT now()
);

CREATE SEQUENCE IF NOT EXISTS credential_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- create table if not exists emprestimo
