-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_design_final_project
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchases` (
  `id` int NOT NULL AUTO_INCREMENT,
  `purchase_date` datetime DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `ebook_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `ebook_id_idx` (`ebook_id`),
  CONSTRAINT `purchases_to_ebook` FOREIGN KEY (`ebook_id`) REFERENCES `ebooks` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `purchases_to_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
INSERT INTO `purchases` VALUES (1,'2019-01-23 00:00:00',1,1),(2,'2020-03-29 00:00:00',1,2),(3,'2021-03-03 00:00:00',1,3),(4,'2020-09-30 00:00:00',2,4),(5,'2021-11-01 00:00:00',2,5);
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `purchases_BEFORE_INSERT` BEFORE INSERT ON `purchases` FOR EACH ROW BEGIN
	DECLARE time_difference_user long;
    DECLARE time_difference_ebook integer;
    DECLARE purchased integer;
    
    SELECT NEW.purchase_date - users.date_of_birth
    INTO time_difference_user
    FROM users
    WHERE NEW.user_id = users.id;
    
    SELECT YEAR(NEW.purchase_date) - ebooks.published_year
    INTO time_difference_ebook
    FROM ebooks
    WHERE NEW.ebook_id = ebooks.id;
    
    SELECT count(purchases.id)
    INTO purchased
    FROM purchases
    WHERE NEW.user_id = purchases.user_id
    AND NEW.ebook_id = purchases.ebook_id;
    
    IF time_difference_user < 0 THEN
		signal sqlstate '45000' set message_text = 'User cannot purchases books before born';
	ELSEIF time_difference_ebook < 0  THEN
		signal sqlstate '45000' set message_text = 'Ebook cannot be purchase before published';
	ELSEIF purchased > 0 THEN
		signal sqlstate '45000' set message_text = 'User cannot purchases a book twice';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `purchases_BEFORE_UPDATE` BEFORE UPDATE ON `purchases` FOR EACH ROW BEGIN
DECLARE time_difference_user long;
    DECLARE time_difference_ebook integer;
    DECLARE purchased integer;
    
    SELECT NEW.purchase_date - users.date_of_birth
    INTO time_difference_user
    FROM users
    WHERE NEW.user_id = users.id;
    
    SELECT YEAR(NEW.purchase_date) - ebooks.published_year
    INTO time_difference_ebook
    FROM ebooks
    WHERE NEW.ebook_id = ebooks.id;
    
    SELECT count(purchases.id)
    INTO purchased
    FROM purchases
    WHERE NEW.user_id = purchases.user_id
    AND NEW.ebook_id = purchases.ebook_id;
    
    IF time_difference_user < 0 THEN
		signal sqlstate '45000' set message_text = 'User cannot purchases books before born';
	ELSEIF time_difference_ebook < 0  THEN
		signal sqlstate '45000' set message_text = 'Ebook cannot be purchase before published';
	ELSEIF purchased > 0 THEN
		signal sqlstate '45000' set message_text = 'User cannot purchases a book twice';
	END IF;
END */;;
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

-- Dump completed on 2021-11-25 16:46:09
