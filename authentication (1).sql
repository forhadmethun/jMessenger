-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2014 at 02:52 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `authentication`
--

-- --------------------------------------------------------

--
-- Table structure for table `a`
--

CREATE TABLE IF NOT EXISTS `a` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `a`
--

INSERT INTO `a` (`id`, `message`) VALUES
(1, ''),
(2, ''),
(3, ''),
(4, ''),
(5, ''),
(6, ''),
(7, 'sdf'),
(8, 'sdfgerqfds');

-- --------------------------------------------------------

--
-- Table structure for table `ac`
--

CREATE TABLE IF NOT EXISTS `ac` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `b`
--

CREATE TABLE IF NOT EXISTS `b` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `b`
--

INSERT INTO `b` (`id`, `message`) VALUES
(1, 'it is working i think'),
(2, 'i thinik i am not working :('),
(3, 'how are you'),
(4, 'how are you'),
(5, 'hlw'),
(6, 'i am not getting messages'),
(7, 'qwe'),
(8, 'sdf'),
(9, 'wet'),
(10, 'it am working with it'),
(11, 'twftyes'),
(12, 'fu'),
(13, 'it is not working'),
(14, 'i dont know -_-'),
(15, 'hi'),
(16, 'ed'),
(17, 'but how :o'),
(18, 'hi'),
(19, 'i am fine u ?'),
(20, 'whats about your plan in the pl ?'),
(21, 'hlw'),
(22, 'how are you'),
(23, 'hi'),
(24, 'i am okay ..'),
(25, 'i am fine'),
(26, 'it is b :P');

-- --------------------------------------------------------

--
-- Table structure for table `c`
--

CREATE TABLE IF NOT EXISTS `c` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `c`
--

INSERT INTO `c` (`id`, `message`) VALUES
(1, ''),
(2, ''),
(3, ''),
(4, ''),
(5, ''),
(6, ''),
(7, ''),
(8, 'sdf'),
(9, 'sdf'),
(10, 'sdfsaga'),
(11, 'it is working now :D'),
(12, 'yes man u are right :)'),
(13, 'hlw'),
(14, 'hlw'),
(15, 'hi'),
(16, ''),
(17, 'how are you'),
(18, 'agsd'),
(19, 'gdsa'),
(20, 'ge'),
(21, 'dy'),
(22, 'it is also '),
(23, 'as'),
(24, 'rfg'),
(25, 'but why :o'),
(26, 'fds'),
(27, 'it is now working -_-'),
(28, 'how are you'),
(29, 'i am okay :) '),
(30, 'i dont have any idea :/'),
(31, 'hi'),
(32, 'it is working '),
(33, 'it is function'),
(34, 'c'),
(35, 'c'),
(36, 'd'),
(37, 'hi'),
(38, 'hi'),
(39, 'hlw'),
(40, 'whats up man ? '),
(41, 'it is not fine -_-'),
(42, 'what do u mean :3'),
(43, 'it is c '),
(44, 'it is c ');

-- --------------------------------------------------------

--
-- Table structure for table `e`
--

CREATE TABLE IF NOT EXISTS `e` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `e`
--

INSERT INTO `e` (`id`, `message`) VALUES
(1, '');

-- --------------------------------------------------------

--
-- Table structure for table `f`
--

CREATE TABLE IF NOT EXISTS `f` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `f`
--

INSERT INTO `f` (`id`, `message`) VALUES
(1, ''),
(2, ''),
(3, ''),
(4, ''),
(5, 'it is f :P'),
(6, 'it will not work ........');

-- --------------------------------------------------------

--
-- Table structure for table `g`
--

CREATE TABLE IF NOT EXISTS `g` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `g`
--

INSERT INTO `g` (`id`, `message`) VALUES
(1, 'i am g a bad guy '),
(2, ''),
(3, ''),
(4, ''),
(5, ''),
(6, 'it is g'),
(7, 'i am not going to work :v'),
(8, 'it is g.........');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
  `username` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `id` int(11) NOT NULL,
  `message` text NOT NULL,
  FULLTEXT KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`username`, `password`, `email`, `id`, `message`) VALUES
('first', '1234', 'first@mail.com', 1, '  <empty message >'),
('first', '1234', 'first@mail.com', 1, '  <empty message >'),
('second', '5678', 'second@mail.com', 1, '  <empty message >'),
('second', '5678', 'second@mail.com', 1, '  <empty message >'),
('third', 'third', 'third@mail.com', 1, '<empty message > '),
('fourth', 'fourth', 'fourth@mail.com', 1, '<empty message>'),
(' vfv3trgvf', 'g3t4', 'gt', 1, '<empty message>'),
('forhad', 'forhad', 'forhad@mail.com', 1, '<empty message>'),
('useless', 'useless', 'useless', 1, '<empty message>'),
('me', 'me', 'me@gmail.com', 1, '<empty message>'),
('methun', 'methun', 'methun@mail.com', 1, '<empty message>'),
('someone', 'someone', 'someone@mail.com', 1, '<empty message>'),
('message', 'mwssage', 'message@mail.com', 1, '<empty message>'),
('ac', 'ac', 'ac@mail.com', 1, '<empty message>'),
('a', 'a', 'a@mail.com', 1, '<empty message>'),
('b', 'b', 'b@mail.com', 1, '<empty message>'),
('c', 'c', 'c@mail.com', 1, '<empty message>'),
('d', 'd', 'd@mail.com', 1, '<empty message>'),
('e', 'e', 'e@mail.com', 1, '<empty message>'),
('f', 'f', 'f@mail.com', 1, '<empty message>'),
('e', 'e', 'e@mail.com', 1, '<empty message>'),
('f', 'f', 'f@mail.com', 1, '<empty message>'),
('g', 'g', 'g', 1, '<empty message>');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
