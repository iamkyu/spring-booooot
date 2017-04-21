CREATE TABLE ARTICLE (
  ID LONG PRIMARY KEY,
  TITLE VARCHAR(255),
  AUTHOR VARCHAR(255),
  BODY VARCHAR(255),
  CREATED TIMESTAMP
);

INSERT INTO ARTICLE (ID, TITLE, AUTHOR, BODY, CREATED)
VALUES
(1L, 'title1', 'author1', 'body', now()),
(2L, 'title2', 'author2', 'body', now()),
(3L, 'title3', 'author3', 'body', now()),
(4L, 'title4', 'author4', 'body', now()),
(5L, 'title5', 'author5', 'body', now()),
(6L, 'title6', 'author6', 'body', now()),
(7L, 'title7', 'author7', 'body', now()),
(8L, 'title8', 'author8', 'body', now()),
(9L, 'title9', 'author9', 'body', now()),
(10L, 'title10', 'author10', 'body', now()),
(11L, 'title11', 'author11', 'body', now()),
(12L, 'title12', 'author12', 'body', now()),
(13L, 'title13', 'author13', 'body', now()),
(14L, 'title14', 'author14', 'body', now()),
(15L, 'title15', 'author15', 'body', now()),
(16L, 'title16', 'author16', 'body', now()),
(17L, 'title', 'author', 'body', now()),
(18L, 'title', 'author', 'body', now()),
(19L, 'title', 'author', 'body', now()),
(20L, 'title', 'author', 'body', now()),
(21L, 'title', 'author', 'body', now()),
(22L, 'title', 'author', 'body', now());
