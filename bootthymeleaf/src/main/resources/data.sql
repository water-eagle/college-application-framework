-- single line comment
/*
multi line comment
*/

DELETE FROM chat_user WHERE user_id = 'user1';

INSERT INTO chat_user (user_id, nickname, user_mail, user_pwd)
VALUES ('user1', '테스트사용자1', 'user1@example.com', '1234');
