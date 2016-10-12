-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema shopping_list
--

CREATE DATABASE IF NOT EXISTS shopping_list;
USE shopping_list;

--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`,`name`) VALUES 
 (1,'Guice Book'),
 (2,'Pizza'),
 (3,'World of Warcraft'),
 (4,'Wine'),
 (5,'Milk'),
 (6,'Bread'),
 (7,'Candy');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `shoppinglist`
--

DROP TABLE IF EXISTS `shoppinglist`;
CREATE TABLE `shoppinglist` (
  `id` bigint(20) NOT NULL auto_increment,
  `login` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shoppinglist`
--

/*!40000 ALTER TABLE `shoppinglist` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppinglist` ENABLE KEYS */;


--
-- Definition of table `shoppinglist_product`
--

DROP TABLE IF EXISTS `shoppinglist_product`;
CREATE TABLE `shoppinglist_product` (
  `shoppinglist_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  KEY `FK662DBBB692B1E78D` (`product_id`),
  KEY `FK662DBBB6DAA0B7C7` (`shoppinglist_id`),
  CONSTRAINT `FK662DBBB692B1E78D` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK662DBBB6DAA0B7C7` FOREIGN KEY (`shoppinglist_id`) REFERENCES `shoppinglist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shoppinglist_product`
--

/*!40000 ALTER TABLE `shoppinglist_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppinglist_product` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
