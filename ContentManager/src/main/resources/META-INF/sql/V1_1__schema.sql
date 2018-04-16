CREATE TABLE texts
(
  id SERIAL PRIMARY KEY ,
  content VARCHAR (3000)
);

INSERT INTO texts (content)
VALUES ('some text');