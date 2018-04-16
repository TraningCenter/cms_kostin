CREATE SEQUENCE posts_id_seq;

CREATE TABLE posts
(
  id integer not null DEFAULT nextval('posts_id_seq') PRIMARY KEY ,
  title VARCHAR (60),
  text_id int ,
  date TIMESTAMP
);

ALTER SEQUENCE posts_id_seq OWNED BY posts.id;

CREATE SEQUENCE images_image_id_seq;

CREATE TABLE images
(
 image_id INTEGER not null DEFAULT nextval('images_image_id_seq') PRIMARY KEY  ,
 cm_id int,
 position int
);

ALTER SEQUENCE images_image_id_seq OWNED BY images.image_id;

CREATE TABLE post_image (
  post_id    int REFERENCES posts (id) ON UPDATE CASCADE ON DELETE CASCADE
, image_id int REFERENCES images (image_id) ON UPDATE CASCADE
, CONSTRAINT post_image_pkey PRIMARY KEY (post_id, image_id)
);
/*
INSERT INTO posts (title,text_id,date)
VALUES ('some text',1,'1961-06-16');

insert INTO images(cm_id,position)
VALUES (4,2);

INSERT INTO post_image(post_id, image_id)
VALUES (1,1); */