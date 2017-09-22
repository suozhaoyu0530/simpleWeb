-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: sampledb
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_login_log`
--

DROP TABLE IF EXISTS `t_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ip` varchar(23) DEFAULT NULL,
  `login_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_login_log`
--

LOCK TABLES `t_login_log` WRITE;
/*!40000 ALTER TABLE `t_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `last_visit` datetime DEFAULT NULL,
  `last_ip` varchar(23) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin',NULL,'123456',NULL,NULL),(3,'John',NULL,'password',NULL,NULL),(4,'John',NULL,'password',NULL,NULL),(7,'John',NULL,'password',NULL,NULL),(8,'John',NULL,'password',NULL,NULL),(9,'John',NULL,'password',NULL,NULL),(12,'John',NULL,'password',NULL,NULL),(13,'John',NULL,'password',NULL,NULL),(16,'John',NULL,'password',NULL,NULL),(17,'John',NULL,'password',NULL,NULL),(18,'John',NULL,'password',NULL,NULL),(19,'John',NULL,'password',NULL,NULL),(24,'John',NULL,'password',NULL,NULL),(25,'John',NULL,'password',NULL,NULL),(26,'John',NULL,'password',NULL,NULL),(29,'John',NULL,'password',NULL,NULL),(30,'John',NULL,'password',NULL,NULL),(31,'John',NULL,'password',NULL,NULL),(32,'John',NULL,'password',NULL,NULL),(33,'John',NULL,'password',NULL,NULL),(34,'John',NULL,'password',NULL,NULL),(35,'John',NULL,'password',NULL,NULL),(36,'John',NULL,'password',NULL,NULL),(37,'John',NULL,'password',NULL,NULL),(38,'John',NULL,'password',NULL,NULL),(39,'John',NULL,'password',NULL,NULL),(40,'John',NULL,'password',NULL,NULL),(41,'John',NULL,'password',NULL,NULL),(42,'John',NULL,'password',NULL,NULL),(43,'John',NULL,'password',NULL,NULL),(44,'John',NULL,'password',NULL,NULL),(45,'John',NULL,'password',NULL,NULL),(46,'John',NULL,'password',NULL,NULL),(47,'John',NULL,'password',NULL,NULL),(48,'John',NULL,'password',NULL,NULL),(49,'John',NULL,'password',NULL,NULL),(50,'John',NULL,'password',NULL,NULL),(51,'John',NULL,'password',NULL,NULL),(52,'John',NULL,'password',NULL,NULL),(53,'John',NULL,'password',NULL,NULL),(54,'John',NULL,'password',NULL,NULL),(55,'John',NULL,'password',NULL,NULL),(56,'John',NULL,'password',NULL,NULL),(57,'John',NULL,'password',NULL,NULL),(58,'John',NULL,'password',NULL,NULL),(59,'John',NULL,'password',NULL,NULL),(60,'John',NULL,'password',NULL,NULL),(61,'John',NULL,'password',NULL,NULL),(62,'John',NULL,'password',NULL,NULL),(63,'John',NULL,'password',NULL,NULL),(64,'John',NULL,'password',NULL,NULL),(65,'John',NULL,'password',NULL,NULL),(66,'John',NULL,'password',NULL,NULL),(67,'John',NULL,'password',NULL,NULL),(68,'John',NULL,'password',NULL,NULL),(69,'John',NULL,'password',NULL,NULL),(70,'John',NULL,'password',NULL,NULL),(71,'John',NULL,'password',NULL,NULL),(72,'John',NULL,'password',NULL,NULL),(73,'John',NULL,'password',NULL,NULL),(74,'John',NULL,'password',NULL,NULL),(75,'John',NULL,'password',NULL,NULL),(76,'John',NULL,'password',NULL,NULL),(77,'John',NULL,'password',NULL,NULL),(78,'John',NULL,'password',NULL,NULL),(79,'John',NULL,'password',NULL,NULL),(80,'John',NULL,'password',NULL,NULL),(81,'John',NULL,'password',NULL,NULL),(84,'John',NULL,'password',NULL,NULL),(85,'John',NULL,'password',NULL,NULL),(86,'John',NULL,'password',NULL,NULL),(87,'John',NULL,'password',NULL,NULL),(88,'John',NULL,'password',NULL,NULL),(89,'John',NULL,'password',NULL,NULL),(90,'John',NULL,'password',NULL,NULL),(91,'John',NULL,'password',NULL,NULL),(92,'John',NULL,'password',NULL,NULL),(93,'John',NULL,'password',NULL,NULL),(94,'John',NULL,'password',NULL,NULL),(95,'John',NULL,'password',NULL,NULL),(96,'John',NULL,'password',NULL,NULL),(97,'John',NULL,'password',NULL,NULL),(98,'John',NULL,'password',NULL,NULL),(99,'John',NULL,'password',NULL,NULL),(100,'John',NULL,'password',NULL,NULL),(101,'John',NULL,'password',NULL,NULL),(102,'John',NULL,'password',NULL,NULL),(103,'John',NULL,'password',NULL,NULL),(106,'John',NULL,'password',NULL,NULL),(107,'John',NULL,'password',NULL,NULL),(108,'John',NULL,'password',NULL,NULL),(109,'John',NULL,'password',NULL,NULL),(110,'John',NULL,'password',NULL,NULL),(111,'John',NULL,'password',NULL,NULL),(112,'John',NULL,'password',NULL,NULL),(113,'John',NULL,'password',NULL,NULL),(114,'John',NULL,'password',NULL,NULL),(115,'John',NULL,'password',NULL,NULL),(116,'John',NULL,'password',NULL,NULL),(117,'John',NULL,'password',NULL,NULL),(118,'John',NULL,'password',NULL,NULL),(119,'John',NULL,'password',NULL,NULL),(120,'John',NULL,'password',NULL,NULL),(121,'John',NULL,'password',NULL,NULL),(122,'John',NULL,'password',NULL,NULL),(123,'John',NULL,'password',NULL,NULL),(124,'John',NULL,'password',NULL,NULL),(125,'John',NULL,'password',NULL,NULL),(126,'John',NULL,'password',NULL,NULL),(127,'John',NULL,'password',NULL,NULL),(128,'John',NULL,'password',NULL,NULL),(132,'John',NULL,'password',NULL,NULL),(133,'John',NULL,'password',NULL,NULL),(134,'John',NULL,'password',NULL,NULL),(135,'John',NULL,'password',NULL,NULL),(136,'John',NULL,'password',NULL,NULL),(140,'John',NULL,'password',NULL,NULL),(143,'John',NULL,'password',NULL,NULL),(144,'John',NULL,'password',NULL,NULL),(145,'John',NULL,'password',NULL,NULL),(146,'John',NULL,'password',NULL,NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sampledb'
--
/*!50003 DROP PROCEDURE IF EXISTS `bat_update_cominfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bat_update_cominfo`(IN oldValue varchar(64), IN newValue varchar(64))
BEGIN
	declare tname varchar(32);
    declare cname varchar(64);
    declare done int default false;
    declare rowi int default 0;
    declare cur cursor for 
		select distinct table_name, column_name from information_schema.columns 
        where table_schema="unib" and (column_name='com_code' or column_comment like '%企业编号%');
	declare continue handler for not found set done = true;
    
    open cur;
    read_loop: loop
		fetch cur into tname, cname;
		set rowi = rowi+1;
        set @sql = concat('update ', tname, ' set com_code=', newValue, 'where com_code=', oldValue);
        prepare stmt from @sql;
        execute stmt;
        select concat('第', i, '次执行，执行表：', tname, '列：', cname) as log into outfile '/tmp/updateComInfo.txt';
        if done then
			leave read_loop;
		end if;
	end loop;
    close cur;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-22  9:20:50
