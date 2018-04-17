CREATE TABLE texts
(
  id SERIAL PRIMARY KEY ,
  content VARCHAR (10000)
);

CREATE TABLE images
(
  id SERIAL PRIMARY KEY,
  googleId VARCHAR (1000),
  hash VARCHAR (1000),
  name VARCHAR (50)
)

