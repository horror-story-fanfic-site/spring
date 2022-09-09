INSERT INTO users (email, password, first_name, last_name, username, profile_pic) VALUES (
    'testuser@gmail.com',
    'password',
    'Test',
    'User',
    'Username',
    'https://i.imgur.com/ICK2lr1.jpeg'
);
INSERT INTO users(email, password, first_name, last_name, username, profile_pic)
VALUES ('kylereese@gmail.com', 'password', 'kyle', 'reese', 'KRichy123', 'https://i.imgur.com/XUbwQ5E.jpeg');
INSERT INTO users(email, password, first_name, last_name, username, profile_pic) 
VALUES ('mattbuchanan@gmail.com', 'password', 'matt', 'buchanan', 'MBerrysan23', 'https://i.imgur.com/riE0O8R.png');
INSERT INTO users(email, password, first_name, last_name, username, profile_pic) 
VALUES ('gingerventura@gmail.com', 'password', 'ginger', 'ventura', 'GVentelli234', 'https://i.imgur.com/ZAb8lQF.jpeg');
INSERT INTO users(email, password, first_name, last_name, username, profile_pic) 
VALUES ('calebbousman@gmail.com', 'password', 'caleb', 'bousman', 'CBoose634', 'https://i.imgur.com/yQeXp8Q.jpeg');
INSERT INTO users(email, password, first_name, last_name, username, profile_pic) 
VALUES ('alangrant@gmail.com', 'password', 'alan', 'grant', 'Alanant52', 'https://i.imgur.com/5eMAuXg.jpeg');
INSERT INTO users(email, password, first_name, last_name, username, profile_pic) 
VALUES ('ianmalcolm@gmail.com', 'password', 'ian', 'malcolm', 'Ialcone34', 'https://i.imgur.com/qMVVzkT.jpeg');
INSERT INTO users(email, password, first_name, last_name, username, profile_pic) 
VALUES ('johnhammond@gmail.com', 'password', 'john', 'hammond', 'user7', 'https://i.imgur.com/xYrSm2G.jpeg');
INSERT INTO users(email, password, first_name, last_name, username, profile_pic) 
VALUES ('nlyman0120@gmail.com', 'password', 'Bob', 'Jack', 'user8', 'https://i.imgur.com/MlCQEhQ.png');

INSERT INTO emoji (emoji_name, emoji_pic) VALUES ('thumbsup', 'https://images.emojiterra.com/google/noto-emoji/v2.034/512px/1f44d.png');
INSERT INTO emoji (emoji_name, emoji_pic) VALUES ('laughing', 'https://toppng.com/uploads/preview/emoji-transparent-laughing-emoji-11550234631y6jwxckdn1.png');
INSERT INTO emoji (emoji_name, emoji_pic) VALUES ('scared', 'https://toppng.com/uploads/preview/omg-face-emoji-png-sh-11545508210l9uqnywdn1.png');
INSERT INTO emoji (emoji_name, emoji_pic) VALUES ('wow', 'https://e7.pngegg.com/pngimages/496/17/png-clipart-computer-icons-emoticon-smiley-like-button-smiley-miscellaneous-smiley.png');

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