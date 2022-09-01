INSERT INTO users (email, password, first_name, last_name, username) VALUES (
    'testuser@gmail.com',
    'password',
    'Test',
    'User',
    'Username'
),
(
	'testuser@gmail.com',
	'password',
	'Nathan',
	'Lyman',
	'Nathan'
);
INSERT INTO users(email, password, first_name, last_name, username)
VALUES ('kylereese@gmail.com', 'password', 'kyle', 'reese', 'user1');
INSERT INTO users(email, password, first_name, last_name, username) 
VALUES ('mattbuchanan@gmail.com', 'password', 'matt', 'buchanan', 'user2');
INSERT INTO users(email, password, first_name, last_name, username) 
VALUES ('gingerventura@gmail.com', 'password', 'ginger', 'ventura', 'user3');
INSERT INTO users(email, password, first_name, last_name, username) 
VALUES ('calebbousman@gmail.com', 'password', 'caleb', 'bousman', 'user4');
INSERT INTO users(email, password, first_name, last_name, username) 
VALUES ('alangrant@gmail.com', 'password', 'alan', 'grant', 'user5');
INSERT INTO users(email, password, first_name, last_name, username) 
VALUES ('ianmalcolm@gmail.com', 'password', 'ian', 'malcolm', 'user6');
INSERT INTO users(email, password, first_name, last_name, username) 
VALUES ('johnhammond@gmail.com', 'password', 'john', 'hammond', 'user7');
INSERT INTO users(email, password, first_name, last_name, username) 
VALUES ('nlyman0120@gmail.com', 'password', 'Bob', 'Jack', 'user8');

INSERT INTO posts (id, text, image_url, author_id) VALUES (
    10000,
	'The classic',
    'https://i.imgur.com/fhgzVEt.jpeg',
    1
),
(
    10001,
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    '',
    1
); 