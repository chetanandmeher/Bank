CREATE TABLE `piggy-bank`.`accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(2) NOT NULL,
  `rate_of_interest` decimal(4,2) NOT NULL,
  `balance` decimal(12,2) DEFAULT '0.00',
  `created_by` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_by` int DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `foreign_key`
  FOREIGN KEY (`user_id`)
  REFERENCES `users` (`id`)
)