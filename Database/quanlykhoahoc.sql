-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2022 at 06:51 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlykhoahoc`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `CourseID` int(11) NOT NULL,
  `Title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Credits` int(11) NOT NULL,
  `DepartmentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`CourseID`, `Title`, `Credits`, `DepartmentID`) VALUES
(1, 'Toan', 5, 1),
(2, 'Van', 4, 2),
(3, 'Sinh', 5, 1),
(4, 'Hoa', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `courseinstructor`
--

CREATE TABLE `courseinstructor` (
  `CourseID` int(11) NOT NULL,
  `PersonID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `courseinstructor`
--

INSERT INTO `courseinstructor` (`CourseID`, `PersonID`) VALUES
(1, 2),
(4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DepartmentID` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Budget` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `Administrator` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`DepartmentID`, `Name`, `Budget`, `StartDate`, `Administrator`) VALUES
(1, 'CNTT', 1500, '2022-10-03', 1),
(2, 'NNA', 1200, '2022-10-10', 2);

-- --------------------------------------------------------

--
-- Table structure for table `officeassignment`
--

CREATE TABLE `officeassignment` (
  `InstructorID` int(11) NOT NULL,
  `Location` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `onlinecourse`
--

CREATE TABLE `onlinecourse` (
  `CourseID` int(11) NOT NULL,
  `URL` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `onlinecourse`
--

INSERT INTO `onlinecourse` (`CourseID`, `URL`) VALUES
(1, 'abc'),
(4, 'cde');

-- --------------------------------------------------------

--
-- Table structure for table `onsitecourse`
--

CREATE TABLE `onsitecourse` (
  `CourseID` int(11) NOT NULL,
  `Location` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Days` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `onsitecourse`
--

INSERT INTO `onsitecourse` (`CourseID`, `Location`, `Days`, `Time`) VALUES
(2, 'abc', 'monday, thursday', '10:00:00'),
(3, 'aaa', 'wednesday', '12:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `PersonID` int(11) NOT NULL,
  `LastName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FirstName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `HireDate` date DEFAULT NULL,
  `EnrollmentDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`PersonID`, `LastName`, `FirstName`, `HireDate`, `EnrollmentDate`) VALUES
(1, 'Truong', 'Loc', '2022-10-05', NULL),
(2, 'Truong', 'Hoa', NULL, '2022-10-19'),
(3, 'Truong', 'Long', '2022-10-18', NULL),
(4, 'Nguyen', 'Xuan', NULL, '2022-10-09'),
(5, 'Nguyen', 'Nhi', NULL, '2022-10-07');

-- --------------------------------------------------------

--
-- Table structure for table `studentgrade`
--

CREATE TABLE `studentgrade` (
  `EnrollmentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `Grade` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `studentgrade`
--

INSERT INTO `studentgrade` (`EnrollmentID`, `CourseID`, `StudentID`, `Grade`) VALUES
(1, 1, 1, 10),
(2, 2, 2, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseID`),
  ADD KEY `FK_DepartmentID_Course` (`DepartmentID`);

--
-- Indexes for table `courseinstructor`
--
ALTER TABLE `courseinstructor`
  ADD PRIMARY KEY (`CourseID`,`PersonID`),
  ADD KEY `FK_PersonID_CourseInstructor` (`PersonID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Indexes for table `officeassignment`
--
ALTER TABLE `officeassignment`
  ADD PRIMARY KEY (`InstructorID`);

--
-- Indexes for table `onlinecourse`
--
ALTER TABLE `onlinecourse`
  ADD PRIMARY KEY (`CourseID`);

--
-- Indexes for table `onsitecourse`
--
ALTER TABLE `onsitecourse`
  ADD PRIMARY KEY (`CourseID`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`PersonID`);

--
-- Indexes for table `studentgrade`
--
ALTER TABLE `studentgrade`
  ADD PRIMARY KEY (`EnrollmentID`),
  ADD KEY `FK_CourseID_StudentGrade` (`CourseID`),
  ADD KEY `FK_StudentID_StudentGrade` (`StudentID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK_DepartmentID_Course` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`);

--
-- Constraints for table `courseinstructor`
--
ALTER TABLE `courseinstructor`
  ADD CONSTRAINT `FK_CourseID_CourseInstructor` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PersonID_CourseInstructor` FOREIGN KEY (`PersonID`) REFERENCES `person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `officeassignment`
--
ALTER TABLE `officeassignment`
  ADD CONSTRAINT `FK_InstructorID_OfficeAssignment` FOREIGN KEY (`InstructorID`) REFERENCES `person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `onlinecourse`
--
ALTER TABLE `onlinecourse`
  ADD CONSTRAINT `FK_CourseID_OnlineCourse` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `onsitecourse`
--
ALTER TABLE `onsitecourse`
  ADD CONSTRAINT `FK_CourseID_OnsiteCourse` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `studentgrade`
--
ALTER TABLE `studentgrade`
  ADD CONSTRAINT `FK_CourseID_StudentGrade` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_StudentID_StudentGrade` FOREIGN KEY (`StudentID`) REFERENCES `person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
