-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2023 at 11:16 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cakehouse`
--

-- --------------------------------------------------------

--
-- Table structure for table `cus_order`
--

CREATE TABLE `cus_order` (
  `id` int(100) NOT NULL,
  `order_id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cus_order`
--

INSERT INTO `cus_order` (`id`, `order_id`, `userName`, `name`, `type`, `quantity`, `price`, `image`, `date`) VALUES
(3, 1, 'C1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-04'),
(4, 2, 'C1', 'Bubble Tea', 'Drinks', 1, 12.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\BubbleTea2.jpg', '2023-05-04'),
(5, 2, 'C1', 'Tiramisu', 'Cake', 1, 15.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Tiramisu6.jpg', '2023-05-04'),
(7, 3, 'C1', 'Hot Chocolate', 'Cake', 2, 11.8, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\Chocolate2.jpg', '2023-05-04'),
(8, 3, 'C1', 'Black Forest Cake', 'Cake', 1, 12.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\BlackForest2.jpg', '2023-05-04'),
(11, 4, 'C1', 'Latte', 'Drinks', 1, 7.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Latte2.png', '2023-05-04'),
(12, 4, 'C1', 'French Crepe', 'Cake', 1, 10.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\FrenchCrepe2.jpg', '2023-05-04'),
(13, 5, 'C1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-04'),
(14, 5, 'C1', 'Latte', 'Drinks', 1, 7.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Latte2.png', '2023-05-04'),
(15, 6, 'C1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-04'),
(16, 7, 'C1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-04'),
(17, 8, 'C1', 'Tiramisu', 'Cake', 1, 15.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Tiramisu6.jpg', '2023-05-04'),
(23, 9, 'Shuao', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-07'),
(25, 10, 'Shuao', 'French Crepe', 'Cake', 1, 10.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\FrenchCrepe2.jpg', '2023-05-07'),
(26, 11, 'Shuao', 'Tiramisu', 'Cake', 1, 15.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Tiramisu6.jpg', '2023-05-07'),
(27, 11, 'shuao', 'Hot Chocolate', 'Cake', 1, 5.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\Chocolate2.jpg', '2023-05-07'),
(30, 12, 'Shuao', 'Rose Latte', 'Cake', 1, 6.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\RoseLatte1.jpg', '2023-05-07'),
(32, 13, 'shuao', 'Iced Americano', 'Drinks', 1, 13.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\IcedAmericano1.jpg', '2023-05-07'),
(33, 14, 'shuao', 'Black Forest Cake', 'Cake', 1, 16.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\BlackForest2.jpg', '2023-05-07'),
(34, 15, 'shuao', 'Hot Chocolate', 'Cake', 1, 5.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\Chocolate2.jpg', '2023-05-07'),
(36, 16, 'ykl1e22', 'Bubble Tea', 'Drinks', 1, 6.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\BubbleTea2.jpg', '2023-05-08'),
(37, 16, 'ykl1e22', 'Tiramisu', 'Cake', 1, 15.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Tiramisu6.jpg', '2023-05-08'),
(38, 16, 'ykl1e22', 'Cheesecake', 'Cake', 3, 50.699999999999996, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-08'),
(39, 16, 'ykl1e22', 'Iced Americano', 'Drinks', 4, 55.6, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\IcedAmericano1.jpg', '2023-05-08'),
(40, 17, 'oh1e22', 'Rose Latte', 'Cake', 3, 20.700000000000003, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\RoseLatte1.jpg', '2023-05-08'),
(41, 17, 'oh1e22', 'Hot Chocolate', 'Cake', 1, 5.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\Chocolate2.jpg', '2023-05-08'),
(42, 17, 'oh1e22', 'Latte', 'Drinks', 1, 7.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Latte2.png', '2023-05-08'),
(43, 17, 'oh1e22', 'Tiramisu', 'Cake', 1, 15.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Tiramisu6.jpg', '2023-05-08'),
(44, 18, 'oh1e22', 'Black Forest Cake', 'Cake', 5, 84.5, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\BlackForest2.jpg', '2023-05-08'),
(45, 18, 'oh1e22', 'Rose Latte', 'Cake', 1, 6.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\RoseLatte1.jpg', '2023-05-08'),
(46, 18, 'oh1e22', 'French Crepe', 'Cake', 2, 21.8, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\FrenchCrepe2.jpg', '2023-05-08'),
(47, 18, 'oh1e22', 'Latte', 'Drinks', 6, 47.400000000000006, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Latte2.png', '2023-05-08'),
(48, 19, 'oliva', 'Rose Latte', 'Cake', 1, 6.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\RoseLatte1.jpg', '2023-05-08'),
(49, 19, 'oliva', 'Black Forest Cake', 'Cake', 1, 16.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\BlackForest2.jpg', '2023-05-08'),
(51, 20, 'shaoai', 'Cheesecake', 'Cake', 2, 33.8, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-08'),
(52, 20, 'shaoai', 'Rose Latte', 'Cake', 4, 27.6, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\RoseLatte1.jpg', '2023-05-08'),
(53, 20, 'shaoai', 'Black Forest Cake', 'Cake', 3, 50.699999999999996, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\BlackForest2.jpg', '2023-05-08'),
(54, 20, 'shaoai', 'Iced Americano', 'Drinks', 1, 13.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\IcedAmericano1.jpg', '2023-05-08');

-- --------------------------------------------------------

--
-- Table structure for table `cus_receipt`
--

CREATE TABLE `cus_receipt` (
  `receipt_id` int(100) NOT NULL,
  `order_id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `total` double(6,2) NOT NULL,
  `paymentMethod` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cus_receipt`
--

INSERT INTO `cus_receipt` (`receipt_id`, `order_id`, `userName`, `total`, `paymentMethod`, `date`) VALUES
(1, 1, 'C1', 16.90, 'TnG', '2023-05-04'),
(2, 2, 'C1', 28.80, 'TnG', '2023-05-04'),
(3, 3, 'C1', 24.70, 'TnG', '2023-05-04'),
(4, 4, 'C1', 18.80, 'Debit/Credit Card', '2023-05-04'),
(5, 5, 'C1', 41.70, 'TnG', '2023-05-04'),
(6, 6, 'C1', 33.80, 'TnG', '2023-05-04'),
(7, 7, 'C1', 33.80, 'TnG', '2023-05-04'),
(8, 8, 'C1', 15.90, 'Cash', '2023-05-04'),
(9, 9, 'Shuao', 16.90, 'Debit/Credit Card', '2023-05-07'),
(10, 10, 'Shuao', 10.90, 'TnG', '2023-05-07'),
(11, 11, 'shuao', 21.80, 'Cash', '2023-05-07'),
(12, 12, 'Shuao', 6.90, 'Cash', '2023-05-07'),
(13, 13, 'shuao', 13.90, 'TnG', '2023-05-07'),
(14, 14, 'shuao', 16.90, 'Debit/Credit Card', '2023-05-07'),
(15, 15, 'shuao', 5.90, 'TnG', '2023-05-07'),
(16, 16, 'ykl1e22', 129.10, 'TnG', '2023-05-08'),
(17, 17, 'oh1e22', 50.40, 'Cash', '2023-05-08'),
(18, 18, 'oh1e22', 160.60, 'TnG', '2023-05-08'),
(19, 19, 'oliva', 23.80, 'TnG', '2023-05-08'),
(20, 20, 'shaoai', 126.00, 'Debit/Credit Card', '2023-05-08');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `price` double NOT NULL,
  `status` varchar(100) NOT NULL,
  `date` date DEFAULT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `name`, `type`, `stock`, `price`, `status`, `date`, `image`) VALUES
(1, 'Cheesecake', 'Cake', 100, 16.9, 'Available', '2023-04-15', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\Cheesecake2.jpg'),
(2, 'Bubble Tea', 'Drinks', 23, 6.9, 'Available', '2023-04-15', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\BubbleTea2.jpg'),
(3, 'Matcha Lava Cake', 'Cake', 20, 7.9, 'Available', '2023-04-15', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\MatchaLavaCake2.jpg'),
(4, 'Latte', 'Drinks', 100, 7.9, 'Available', '2023-04-17', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\Latte2.png'),
(5, 'Tiramisu', 'Cake', 25, 15.9, 'Available', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\Tiramisu6.jpg'),
(6, 'Matcha Tea', 'Drinks', 40, 7.9, 'Unavailable', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\MatchaBubbleTea1.jpg'),
(7, 'Rainbow Cake', 'Cake', 30, 12.9, 'Unavailable', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\RainbowCake1.jpg'),
(8, 'French Crepe', 'Cake', 46, 10.9, 'Available', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\FrenchCrepe2.jpg'),
(9, 'Black Forest Cake', 'Cake', 18, 16.9, 'Available', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\BlackForest2.jpg'),
(10, 'Hot Chocolate', 'Cake', 25, 5.9, 'Available', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\Chocolate2.jpg'),
(11, 'Rose Latte', 'Drinks', 30, 6.9, 'Available', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\RoseLatte1.jpg'),
(12, 'Yam Slice Cake', 'Cake', 17, 8.9, 'Available', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\YamSliceCake.jpg'),
(13, 'Iced Americano', 'Drinks', 4, 13.9, 'Available', '2023-05-02', 'C:\\Users\\Beh Shu Ao\\IdeaProjects\\Cakehouse\\src\\main\\resources\\IcedAmericano1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(100) NOT NULL,
  `order_id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `order_id`, `userName`, `name`, `type`, `quantity`, `price`, `image`, `date`) VALUES
(12, 1, 'A1', 'Cheesecake', 'Cake', 2, 33.8, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-16'),
(13, 1, 'A1', 'Matcha Lava Cake', 'Cake', 2, 15.8, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2593.JPG', '2023-04-16'),
(14, 1, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:UsersBeh Shu AoPicturesIPhone202109__MyHBIMG_2592.JPG', '2023-04-16'),
(15, 1, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-16'),
(16, 1, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-17'),
(17, 1, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-17'),
(18, 1, 'A1', 'Cheesecake', 'Cake', 2, 33.8, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-17'),
(19, 2, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-18'),
(20, 3, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-18'),
(23, 4, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-28'),
(28, 5, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-04-29'),
(29, 6, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Pictures\\IPhone\\202109__MyHB\\IMG_2592.JPG', '2023-05-01'),
(32, 7, 'A1', 'Bubble Tea', 'Drinks', 1, 12.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\BubbleTea2.jpg', '2023-05-03'),
(33, 7, 'A1', 'Black Forest Cake', 'Cake', 1, 12.9, 'C:\\\\Users\\\\Beh Shu Ao\\\\Downloads\\\\COMP1206 CW1 GUI\\\\BlackForest2.jpg', '2023-05-03'),
(36, 8, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-05'),
(37, 8, 'A1', 'Bubble Tea', 'Drinks', 2, 25.8, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\BubbleTea2.jpg', '2023-05-05'),
(38, 9, 'A1', 'Bubble Tea', 'Drinks', 2, 25.8, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\BubbleTea2.jpg', '2023-05-05'),
(39, 9, 'A1', 'Cheesecake', 'Cake', 1, 16.9, 'C:\\Users\\Beh Shu Ao\\Downloads\\COMP1206 CW1 GUI\\Cheesecake2.jpg', '2023-05-05');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `receipt_id` int(100) NOT NULL,
  `order_id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `total` double(6,2) NOT NULL,
  `paymentMethod` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`receipt_id`, `order_id`, `userName`, `total`, `paymentMethod`, `date`) VALUES
(1, 1, 'A1', 151.00, 'TnG', '2023-04-18'),
(2, 2, 'A1', 16.90, 'Cash', '2023-04-18'),
(3, 3, 'A1', 16.90, 'Debit/Credit Card', '2023-04-18'),
(4, 4, 'A1', 16.90, 'TnG', '2023-04-28'),
(5, 5, 'A1', 16.90, 'Cash', '2023-05-01'),
(6, 6, 'A1', 16.90, 'Debit/Credit Card', '2023-05-01'),
(7, 7, 'A1', 25.80, 'Debit/Credit Card', '2023-05-04'),
(8, 8, 'A1', 59.40, 'Cash', '2023-05-05'),
(9, 9, 'A1', 42.70, 'Debit/Credit Card', '2023-05-08');

-- --------------------------------------------------------

--
-- Table structure for table `survey`
--

CREATE TABLE `survey` (
  `id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `way` varchar(100) NOT NULL,
  `food_quality` varchar(100) NOT NULL,
  `order_accuracy` varchar(100) NOT NULL,
  `cleanliness` varchar(100) NOT NULL,
  `service_quality` varchar(100) NOT NULL,
  `experience` varchar(100) NOT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `survey`
--

INSERT INTO `survey` (`id`, `userName`, `way`, `food_quality`, `order_accuracy`, `cleanliness`, `service_quality`, `experience`, `comment`, `date`) VALUES
(1, 'Shuao', 'Dine In', 'Average', 'Good', 'Good', 'Average', 'Average', '-', '2023-05-07'),
(2, 'Shuao', 'Dine In', 'Average', 'Dissatisfied', 'Good', 'Excellent', 'Dissatisfied', 'Very Slowly ', '2023-05-07'),
(3, 'C1', 'Take Out', 'Average', 'Good', 'Good', 'Good', 'Excellent', '', '2023-05-07'),
(4, 'ykl1e22', 'Take Out', 'Dissatisfied', 'Dissatisfied', 'Excellent', 'Good', 'Dissatisfied', 'matcha us unavailable then why display on the menu.', '2023-05-08'),
(5, 'oh1e22', 'Take Out', 'Average', 'Good', 'Excellent', 'Good', 'Good', 'Nice everything is okay =)', '2023-05-08'),
(6, 'oliva', 'Dine In', 'Excellent', 'Excellent', 'Average', 'Dissatisfied', 'Excellent', 'Some are delicious', '2023-05-08'),
(7, 'shaoai', 'Take Out', 'Average', 'Good', 'Average', 'Good', 'Good', 'goodddd come again', '2023-05-08');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `emailAdd` varchar(100) NOT NULL,
  `identity` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userName`, `password`, `emailAdd`, `identity`, `date`) VALUES
('A1', '3339', 'park@gmail.com', 'Admin', '2023-04-11'),
('C1', '3456', 'john@gmail.com', 'Customer', '2023-04-11'),
('oh1e22', '54321', 'oh1e22@soton.ac.uk', 'Customer', '2023-05-08'),
('oliva', '12345', 'oliva@gmail.com', 'Customer', '2023-05-08'),
('shaoai', 'bii666', 'shaoai@yahoo.com', 'Customer', '2023-05-08'),
('Shuao', '010908', 'shuao0908@gmail.com', 'Customer', '2023-05-07'),
('taha', 'asd123', 'taha@yahoo.com', 'Customer', '2023-05-08'),
('ykl1e22', '12345', 'ykl1e22@soton.ac.uk', 'Customer', '2023-05-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cus_order`
--
ALTER TABLE `cus_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userName` (`userName`);

--
-- Indexes for table `cus_receipt`
--
ALTER TABLE `cus_receipt`
  ADD PRIMARY KEY (`receipt_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userName` (`userName`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`receipt_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `survey`
--
ALTER TABLE `survey`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cus_order`
--
ALTER TABLE `cus_order`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `cus_receipt`
--
ALTER TABLE `cus_receipt`
  MODIFY `receipt_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `receipt_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `survey`
--
ALTER TABLE `survey`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `user` (`userName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
