-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2020 at 03:34 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_detail`
--

CREATE TABLE `book_detail` (
  `book_id` int(20) NOT NULL,
  `book_name` varchar(20) NOT NULL,
  `book_author` varchar(20) NOT NULL,
  `no_of_book` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_detail`
--

INSERT INTO `book_detail` (`book_id`, `book_name`, `book_author`, `no_of_book`) VALUES
(1, 'ansi', 'c balagur', 9),
(2, 'softwer', 'abc', 10),
(3, 'intro. algo', 'cormen', 10),
(4, 'abc', 'abc', 9),
(5, 'lenovo', 'ideapad', 9),
(6, 'qwe', 'ewq', 10),
(7, 'qwe', 'iop', 10),
(8, 'mmmm', 'nnn', 10),
(9, 'yash garala', 'Galara', 10);

-- --------------------------------------------------------

--
-- Table structure for table `issued_book`
--

CREATE TABLE `issued_book` (
  `book_id` int(20) NOT NULL,
  `user_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issued_book`
--

INSERT INTO `issued_book` (`book_id`, `user_id`) VALUES
(4, 3),
(5, 3),
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `superuser` varchar(20) NOT NULL,
  `id` int(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `branch` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`username`, `password`, `superuser`, `id`, `email`, `branch`) VALUES
('yash', 'yash', '1', 1, 'abc@gmail.com', 'CE'),
('dhruv', 'dhruv', '0', 2, 'qwe@gmailc.com', 'CE'),
('darshik', 'da', '0', 3, 'dar@gmail.com', 'CE'),
('gal', 'gal', '0', 4, 'gal@gmail.com', 'IT'),
('gokul', 'go', '0', 5, 'gok@gmail.com', 'EC'),
('pou', 'p', '0', 6, 'uu@gm.com', 'CE'),
('kunj', 'k', '0', 11, 'k@gmil.coom', 'CE'),
('darshik', 'd', '0', 13, 'darshik@gmail.com', 'CE');

-- --------------------------------------------------------

--
-- Table structure for table `user_book`
--

CREATE TABLE `user_book` (
  `id` int(20) NOT NULL,
  `book1` varchar(20) DEFAULT NULL,
  `book1_date` varchar(20) DEFAULT NULL,
  `book2` varchar(20) DEFAULT NULL,
  `book2_date` varchar(20) DEFAULT NULL,
  `book3` varchar(20) DEFAULT NULL,
  `book3_date` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_book`
--

INSERT INTO `user_book` (`id`, `book1`, `book1_date`, `book2`, `book2_date`, `book3`, `book3_date`) VALUES
(2, NULL, NULL, NULL, NULL, NULL, NULL),
(5, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'abc', '2020-04-15', 'lenovo', '2020-03-18', 'ansi', '2020-04-21'),
(4, NULL, NULL, NULL, NULL, NULL, NULL),
(1, NULL, NULL, NULL, NULL, NULL, NULL),
(6, NULL, NULL, NULL, NULL, NULL, NULL),
(11, NULL, NULL, NULL, NULL, NULL, NULL),
(13, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_detail`
--
ALTER TABLE `book_detail`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `issued_book`
--
ALTER TABLE `issued_book`
  ADD KEY `book_id` (`book_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_book`
--
ALTER TABLE `user_book`
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_detail`
--
ALTER TABLE `book_detail`
  MODIFY `book_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issued_book`
--
ALTER TABLE `issued_book`
  ADD CONSTRAINT `issued_book_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book_detail` (`book_id`),
  ADD CONSTRAINT `issued_book_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `test` (`id`);

--
-- Constraints for table `user_book`
--
ALTER TABLE `user_book`
  ADD CONSTRAINT `user_book_ibfk_1` FOREIGN KEY (`id`) REFERENCES `test` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
