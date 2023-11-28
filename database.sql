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
                        `profileImgUrl` VARCHAR(256)
);

CREATE TABLE `text` (
                        `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
                        `userId` INTEGER,
                        `timestamp` VARCHAR(11),
                        `content` VARCHAR(1024)
);

CREATE TABLE `upvote` (
                          `userId` INTEGER,
                          `textId` INTEGER
);

CREATE TABLE `downvote` (
                            `userId` INTEGER,
                            `textId` INTEGER
);

ALTER TABLE `text` ADD FOREIGN KEY (`userId`) REFERENCES `user` (`id`);
ALTER TABLE `upvote` ADD FOREIGN KEY (`userId`) REFERENCES `user` (`id`);
ALTER TABLE `downvote` ADD FOREIGN KEY (`userId`) REFERENCES `user` (`id`);
ALTER TABLE `upvote` ADD FOREIGN KEY (`textId`) REFERENCES `text` (`id`);
ALTER TABLE `downvote` ADD FOREIGN KEY (`textId`) REFERENCES `text` (`id`);
