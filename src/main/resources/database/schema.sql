DROP TABLE IF EXISTS USERS;

CREATE TABLE "USERS" (
    "ID" NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "FIRST_NAME" VARCHAR2(30) NOT NULL,
    "LAST_NAME" VARCHAR2(100) NOT NULL,
    "EMAIL" VARCHAR2(100) NOT NULL UNIQUE,
    "TELEFONO" VARCHAR2(100) NOT NULL
);
