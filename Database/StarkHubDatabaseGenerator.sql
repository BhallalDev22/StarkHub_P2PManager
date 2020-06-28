CREATE DATABASE  IF NOT EXISTS `StarkHub` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `StarkHub`;
-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: StarkHub
-- ------------------------------------------------------
-- Server version	8.0.20-0ubuntu0.20.04.1

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
-- Table structure for table `ChannelList`
--

DROP TABLE IF EXISTS `ChannelList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ChannelList` (
  `ChannelName` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `ChannelCreationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NumberOfVideos` int unsigned NOT NULL DEFAULT '0',
  `NumberOfSubscribers` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`ChannelName`),
  UNIQUE KEY `ChannelName_UNIQUE` (`ChannelName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `CommentList`
--

DROP TABLE IF EXISTS `CommentList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CommentList` (
  `CommentID` int unsigned NOT NULL AUTO_INCREMENT,
  `VideoName` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `Comment` varchar(600) NOT NULL,
  `CommentCreationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CommentID`),
  UNIQUE KEY `CommentID_UNIQUE` (`CommentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `LoginCredentials`
--

DROP TABLE IF EXISTS `LoginCredentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LoginCredentials` (
  `UserName` varchar(100) NOT NULL,
  `EmailID` varchar(100) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Status` int NOT NULL DEFAULT '0',
  `AccountCreationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IPAddress` varchar(100) DEFAULT NULL,
  `UserID` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`UserName`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  UNIQUE KEY `UserID_UNIQUE` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NotificationsList`
--

DROP TABLE IF EXISTS `NotificationsList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NotificationsList` (
  `NotificationID` int unsigned NOT NULL AUTO_INCREMENT,
  `ChannelName` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `VideoName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`NotificationID`),
  UNIQUE KEY `NotificationID_UNIQUE` (`NotificationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SubscriberList`
--

DROP TABLE IF EXISTS `SubscriberList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubscriberList` (
  `SubscriberID` int unsigned NOT NULL AUTO_INCREMENT,
  `ChannelName` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `SubscribeTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`SubscriberID`),
  UNIQUE KEY `SuscriberID_UNIQUE` (`SubscriberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `VideoList`
--

DROP TABLE IF EXISTS `VideoList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `VideoList` (
  `VideoName` varchar(100) NOT NULL,
  `ChannelName` varchar(100) NOT NULL,
  `VideoLikes` int unsigned NOT NULL DEFAULT '0',
  `VideoDislikes` int unsigned NOT NULL DEFAULT '0',
  `VideoViews` int unsigned NOT NULL DEFAULT '0',
  `CurrentViews` int unsigned NOT NULL DEFAULT '0',
  `VideoCreationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NumberOfComments` int unsigned NOT NULL DEFAULT '0',
  `VideoPath` varchar(250) NOT NULL,
  `Status` int NOT NULL DEFAULT '1',
  `UserName` varchar(100) NOT NULL,
  `VideoTag` varchar(100) NOT NULL,
  PRIMARY KEY (`VideoName`),
  UNIQUE KEY `VideoName_UNIQUE` (`VideoName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `WatchHistory`
--

DROP TABLE IF EXISTS `WatchHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WatchHistory` (
  `WatchID` int unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(100) NOT NULL,
  `VideoName` varchar(100) NOT NULL,
  `ChannelName` varchar(100) NOT NULL,
  `WatchTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`WatchID`),
  UNIQUE KEY `WatchID_UNIQUE` (`WatchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `WatchLaterList`
--

DROP TABLE IF EXISTS `WatchLaterList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WatchLaterList` (
  `WatchLaterID` int unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(100) NOT NULL,
  `VideoName` varchar(100) NOT NULL,
  `ChannelName` varchar(100) NOT NULL,
  `WatchLaterTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`WatchLaterID`),
  UNIQUE KEY `WatchLaterID_UNIQUE` (`WatchLaterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'StarkHub'
--

--
-- Dumping routines for database 'StarkHub'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-29  4:31:26
