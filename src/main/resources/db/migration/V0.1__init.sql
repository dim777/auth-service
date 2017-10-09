DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES (1,'Admin','ADMIN'),(2,'User','USER'),(3,'Trader','TRADER'),(4,'Audit','AUDIT');
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activateddate` datetime DEFAULT NULL,
  `activatedlink` varchar(255) DEFAULT NULL,
  `addeddate` datetime NOT NULL,
  `avatarpath` varchar(255) DEFAULT NULL,
  `birthdate` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `lastvisitdate` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ibcfppmacbm81husxf339yq0e` (`email`),
  UNIQUE KEY `UK_t2qc4v4mxk0v4nl77knv3d3w` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (3,NULL,NULL,'1984-09-21 00:00:00',NULL,'1984-09-21 00:00:00','dim7779@ya.ru',NULL,'dtest3','2222',909090908);
UNLOCK TABLES;

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `roleid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  KEY `FK_r59o0ax6ex39l7yia29d34jqq` (`userid`),
  KEY `FK_8ieiiorvmeqeyrypdw0r7wj2l` (`roleid`),
  CONSTRAINT `FK_8ieiiorvmeqeyrypdw0r7wj2l` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_r59o0ax6ex39l7yia29d34jqq` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `userrole` WRITE;
INSERT INTO `userrole` VALUES (3,3),(1,3);
UNLOCK TABLES;