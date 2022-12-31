-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2022 at 11:17 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `magasinburger`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_mobil`
--

CREATE TABLE `data_mobil` (
  `id_burger` int(8) NOT NULL,
  `varian` varchar(30) NOT NULL,
  `ukuran` varchar(30) NOT NULL,
  `harga` int(8) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_mobil`
--

INSERT INTO `data_mobil` (`id_burger`, `varian`, `ukuran`, `harga`, `status`) VALUES
(1, 'BBQ Rasher Burger', 'Kecil', 30000, 'Tersedia'),
(2, 'BBQ Rasher Burger', 'Besar', 35000, 'Tersedia'),
(3, 'Crispy Chicken Burger', 'Besar', 33000, 'Tersedia'),
(4, 'Crispy Chicken Burger', 'Kecil', 29000, 'Tersedia'),
(5, 'Mushroom Swiss Burger', 'Besar', 45000, 'Tersedia'),
(6, 'Mushroom Swiss Burger', 'Kecil', 40000, 'Tersedia'),
(7, 'Plant Based Burger', 'Besar', 28000, 'Tersedia'),
(8, 'Plant Based Burger', 'Kecil', 24000, 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `no_pembelian` int(3) NOT NULL,
  `nama_pembeli` varchar(30) NOT NULL,
  `id_burger` int(3) NOT NULL,
  `varian` varchar(30) NOT NULL,
  `ukuran` varchar(30) NOT NULL,
  `hargatotal` int(99) NOT NULL,
  `tgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`no_pembelian`, `nama_pembeli`, `id_burger`, `varian`, `ukuran`, `hargatotal`, `tgl`) VALUES
(1, 'faa', 1, 'null', 'null', 0, '2022-12-31'),
(1111, 'Dean', 4, 'Toyota', 'Inova', 252000000, '2021-12-31'),
(2222, 'Qiqi', 5, 'Tesla', 'Tesla', 800000000, '2021-12-31');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_mobil`
--
ALTER TABLE `data_mobil`
  ADD PRIMARY KEY (`id_burger`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`no_pembelian`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
