INSERT INTO users (id, email, password, first_name, last_name, username) VALUES (
    1,
    'testuser@gmail.com',
    'password',
    'Test',
    'User',
    'Username'
),
(
	2,
	'testuser@gmail.com',
	'password',
	'Nathan',
	'Lyman',
	'Nathan'
);
INSERT INTO users(id, email, password, first_name, last_name, username)
VALUES (2, 'kylereese@gmail.com', 'password', 'kyle', 'reese', 'user1');
INSERT INTO users(id, email, password, first_name, last_name, username) 
VALUES (3, 'mattbuchanan@gmail.com', 'password', 'matt', 'buchanan', 'user2');
INSERT INTO users(id, email, password, first_name, last_name, username) 
VALUES (4, 'gingerventura@gmail.com', 'password', 'ginger', 'ventura', 'user3');
INSERT INTO users(id, email, password, first_name, last_name, username) 
VALUES (5, 'calebbousman@gmail.com', 'password', 'caleb', 'bousman', 'user4');
INSERT INTO users(id, email, password, first_name, last_name, username) 
VALUES (6, 'alangrant@gmail.com', 'password', 'alan', 'grant', 'user5');
INSERT INTO users(id, email, password, first_name, last_name, username) 
VALUES (7, 'ianmalcolm@gmail.com', 'password', 'ian', 'malcolm', 'user6');
INSERT INTO users(id, email, password, first_name, last_name, username) 
VALUES (8, 'johnhammond@gmail.com', 'password', 'john', 'hammond', 'user7');

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