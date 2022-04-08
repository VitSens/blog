CREATE TABLE article (
    id serial NOT NULL PRIMARY KEY,
    title varchar(100) NOT NULL,
    text text NOT NULL
);

INSERT INTO article (title, text)
    VALUES ('Hello World', 'Hello! I''m hello');
INSERT INTO article (title, text)
    VALUES ('Hello World2', '2');
