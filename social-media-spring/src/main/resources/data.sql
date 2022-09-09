INSERT INTO users (email, password, first_name, last_name, username) VALUES (
    'testuser@gmail.com',
    'password',
    'Test',
    'User',
    'Username'
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

INSERT INTO emoji (emoji_name, descript) VALUES ('thumbsup', 'its a like');
INSERT INTO emoji (emoji_name, descript) VALUES ('laughing', 'its a a laughing face');
INSERT INTO emoji (emoji_name, descript) VALUES ('scared', 'its a scared face');
INSERT INTO emoji (emoji_name, descript) VALUES ('wow', 'its a wow face');

INSERT INTO posts (id, text, image_url, author_id) VALUES (
    10000,
	'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
    'https://i.imgur.com/apxd0UA.jpeg',
    1
    
),
(
    10001,
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    'https://i.imgur.com/Tas7LAL.jpeg',
    2
),
(
    10002,
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    'https://i.imgur.com/CY3Xmtr.jpeg',
    3
),
(
    10003,
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    'https://i.imgur.com/feOP0m2.jpeg',
    4
)
; 