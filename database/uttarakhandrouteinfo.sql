-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.16 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2013-04-17 20:53:20
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for uttarakhandrouteinfo
CREATE DATABASE IF NOT EXISTS `uttarakhandrouteinfo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `uttarakhandrouteinfo`;


-- Dumping structure for table uttarakhandrouteinfo.citymapping
CREATE TABLE IF NOT EXISTS `citymapping` (
  `entryid` int(10) NOT NULL AUTO_INCREMENT,
  `x` int(10) DEFAULT NULL,
  `y` int(10) DEFAULT NULL,
  `width` int(10) DEFAULT NULL,
  `height` int(10) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table uttarakhandrouteinfo.citymapping: ~6 rows (approximately)
/*!40000 ALTER TABLE `citymapping` DISABLE KEYS */;
INSERT INTO `citymapping` (`entryid`, `x`, `y`, `width`, `height`, `city`) VALUES
	(1, 86, 314, 95, 314, 'Dehradun'),
	(6, 351, 425, 60, 425, 'Pauri'),
	(7, 55, 471, 23, 471, 'Roorkee'),
	(8, 156, 447, 17, 447, 'Haridwar'),
	(9, 188, 409, 19, 409, 'Rishikesh'),
	(10, 265, 385, 18, 385, 'Devprayag');
/*!40000 ALTER TABLE `citymapping` ENABLE KEYS */;


-- Dumping structure for table uttarakhandrouteinfo.cityroute
CREATE TABLE IF NOT EXISTS `cityroute` (
  `entryid` int(11) NOT NULL AUTO_INCREMENT,
  `source` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `distance` float DEFAULT NULL,
  `cityfrom` varchar(50) DEFAULT NULL,
  `cityto` varchar(50) DEFAULT NULL,
  `via` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table uttarakhandrouteinfo.cityroute: ~11 rows (approximately)
/*!40000 ALTER TABLE `cityroute` DISABLE KEYS */;
INSERT INTO `cityroute` (`entryid`, `source`, `destination`, `distance`, `cityfrom`, `cityto`, `via`) VALUES
	(4, 'Roorkee', 'Haridwar', 30, 'Roorkee', 'Badrinath', 'Srinagar'),
	(5, 'Haridwar', 'Rishikesh', 25, 'Roorkee', 'Badrinath', 'Srinagar'),
	(6, 'Rishikesh', 'Devprayag', 50, 'Roorkee', 'Badrinath', 'Srinagar'),
	(7, 'Devprayag', 'Srinagar', 55, 'Roorkee', 'Badrinath', 'Srinagar'),
	(8, 'Roorkee', 'Haridwar', 30, 'Roorkee', 'Badrinath', 'Pauri'),
	(9, 'Haridwar', 'Pauri', 120, 'Roorkee', 'Badrinath', 'Pauri'),
	(10, 'Pauri', 'Srinagar', 70, 'Roorkee', 'Badrinath', 'Pauri'),
	(11, 'Roorkee', 'Haridwar', 30, 'Roorkee', 'Kausani', 'Ramnagar'),
	(12, 'Haridwar', 'Kashipur', 120, 'Roorkee', 'Kausani', 'Ramnagar'),
	(13, 'Kashipur', 'Ramnagar', 25, 'Roorkee', 'Kausani', 'Ramnagar'),
	(14, 'Ramnagar', 'Ranikhet', 80, 'Roorkee', 'Kausani', 'Ramnagar');
/*!40000 ALTER TABLE `cityroute` ENABLE KEYS */;


-- Dumping structure for table uttarakhandrouteinfo.userinfo
CREATE TABLE IF NOT EXISTS `userinfo` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table uttarakhandrouteinfo.userinfo: ~1 rows (approximately)
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`username`, `password`) VALUES
	('kavita', 'anjum');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
