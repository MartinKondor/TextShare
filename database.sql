DROP TABLE IF EXISTS `upvote`;
DROP TABLE IF EXISTS `downvote`;
DROP TABLE IF EXISTS `text`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
                        `username` VARCHAR(128),
                        `email` VARCHAR(128),
                        `password` VARCHAR(128),
                        `birthdate` VARCHAR(10),
                        `profile_img_url` VARCHAR(256)
);

CREATE TABLE `text` (
                        `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
                        `user_id` INTEGER,
                        `timestamp` VARCHAR(11),
                        `content` VARCHAR(1024)
);

CREATE TABLE `upvote` (
                          `user_id` INTEGER,
                          `text_id` INTEGER
);

CREATE TABLE `downvote` (
                            `user_id` INTEGER,
                            `text_id` INTEGER
);

ALTER TABLE `text` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `upvote` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `downvote` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `upvote` ADD FOREIGN KEY (`text_id`) REFERENCES `text` (`id`);
ALTER TABLE `downvote` ADD FOREIGN KEY (`text_id`) REFERENCES `text` (`id`);
