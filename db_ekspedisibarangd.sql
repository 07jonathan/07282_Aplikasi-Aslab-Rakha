-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2022 at 01:43 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_ekspedisibarangd`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `nama_admin` varchar(15) NOT NULL,
  `password_admin` varchar(15) NOT NULL,
  `alamat_admin` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `password_admin`, `alamat_admin`) VALUES
(1, 'anin', 'admin', 'jl.jeruk'),
(2, 'rahma', 'admin', 'jl.apel');

-- --------------------------------------------------------

--
-- Table structure for table `alamat`
--

CREATE TABLE `alamat` (
  `id_alamat` int(11) NOT NULL,
  `nama_alamat` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `alamat`
--

INSERT INTO `alamat` (`id_alamat`, `nama_alamat`) VALUES
(1, 'Jl. Bali'),
(2, 'Jl. Jawa'),
(3, 'Jl. Kalimantan'),
(4, 'Jl. Madura');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(15) NOT NULL,
  `jenis_barang` varchar(15) NOT NULL,
  `status_barang` varchar(15) NOT NULL,
  `kirim_at` timestamp NULL DEFAULT current_timestamp(),
  `terima_at` timestamp NULL DEFAULT current_timestamp(),
  `ongkir` int(11) NOT NULL,
  `pengirim_id` int(11) DEFAULT NULL,
  `penerima_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `kurir_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jenis_barang`, `status_barang`, `kirim_at`, `terima_at`, `ongkir`, `pengirim_id`, `penerima_id`, `admin_id`, `kurir_id`) VALUES
(1, 'Sepatu', 'Alas Kaki', 'diproses', '2022-06-01 05:13:49', NULL, 27000, 1, 2, 1, 2),
(2, 'Sapu', 'Alas Rumah', 'diterima', '2022-06-01 05:14:40', '2022-06-01 05:14:40', 27000, 2, 1, 1, 1),
(3, 'Sapu', 'Alas Rumah', 'dikirim', '2022-06-01 05:15:23', '2022-06-01 05:15:23', 27000, 1, 2, 1, 1),
(4, 'sandal', 'Alas Kaki', 'dikirim', '2022-06-02 13:49:26', NULL, 27000, 1, 1, 1, 2),
(5, 'Sabun', 'Alat Mandi', 'dikirim', '2022-06-04 00:44:01', '2022-06-04 00:44:01', 0, 3, 1, 1, 1),
(6, 'sabun', 'alat olahraga', 'diproses', '2022-06-14 20:29:42', '2022-06-09 06:17:24', 0, 1, 1, 1, 3),
(7, 'vas bunga', 'elektronik', 'diterima', '2022-06-19 05:06:54', NULL, 54000, 1, 5, 1, 1),
(8, 'vas bunga', 'elektronik', 'diproses', '2022-06-19 05:07:24', NULL, 54000, 1, 5, 1, 1),
(9, 'pak e', 'dekorasi rumah', 'diproses', '2022-06-19 05:09:56', NULL, 27000, 1, 4, 1, 1),
(10, 'norris', 'alat olahraga', 'diproses', '2022-06-19 05:10:29', NULL, 27000, 1, 2, 1, 1),
(11, 'gh', 'dekorasi rumah', 'diproses', '2022-06-20 00:23:00', NULL, 54000, 1, 5, 1, NULL),
(12, 'hhhh', 'dekorasi rumah', 'diproses', '2022-06-20 00:25:08', NULL, 27000, 1, 4, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `id_kurir` int(11) NOT NULL,
  `nama_kurir` varchar(15) NOT NULL,
  `password_kurir` int(11) NOT NULL,
  `admin_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kurir`
--

INSERT INTO `kurir` (`id_kurir`, `nama_kurir`, `password_kurir`, `admin_id`) VALUES
(1, 'cahyadi', 456, 1),
(2, 'Tommy', 12811, 1),
(3, 'azhar', 987, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `penerima`
--

CREATE TABLE `penerima` (
  `id_penerima` int(11) NOT NULL,
  `nama_penerima` varchar(15) NOT NULL,
  `password_penerima` varchar(15) NOT NULL,
  `notelp_penerima` varchar(12) NOT NULL,
  `alamat_penerima` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penerima`
--

INSERT INTO `penerima` (`id_penerima`, `nama_penerima`, `password_penerima`, `notelp_penerima`, `alamat_penerima`) VALUES
(1, 'jonathan', '123', '089533553442', 2),
(2, 'ananda', '123', '089533553443', 1),
(3, 'pipi', '987', '', 1),
(4, 'Adi', '123', '19211', 3),
(5, 'alex', '321', '09876241', 4),
(6, 'Santi', '888', '5678', 4);

-- --------------------------------------------------------

--
-- Table structure for table `pengirim`
--

CREATE TABLE `pengirim` (
  `id_pengirim` int(11) NOT NULL,
  `nama_pengirim` varchar(15) NOT NULL,
  `password_pengirim` varchar(15) NOT NULL,
  `notelp_pengirim` varchar(12) NOT NULL,
  `alamat_pengirim` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengirim`
--

INSERT INTO `pengirim` (`id_pengirim`, `nama_pengirim`, `password_pengirim`, `notelp_pengirim`, `alamat_pengirim`) VALUES
(1, 'jonathan', '123', '089533553442', 2),
(2, 'anandar', '123', '089533553443', 1),
(3, 'pipi', '987', '', 1),
(4, 'Adi', '123', '19211', 2),
(5, 'alex', '321', '09876241', 2),
(7, 'Santi', '888', '5678', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `alamat`
--
ALTER TABLE `alamat`
  ADD PRIMARY KEY (`id_alamat`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `admin_id` (`admin_id`),
  ADD KEY `pengirim_id` (`pengirim_id`),
  ADD KEY `penerima_id` (`penerima_id`),
  ADD KEY `kurir_id` (`kurir_id`);

--
-- Indexes for table `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`id_kurir`),
  ADD KEY `admin1_id` (`admin_id`);

--
-- Indexes for table `penerima`
--
ALTER TABLE `penerima`
  ADD PRIMARY KEY (`id_penerima`),
  ADD UNIQUE KEY `notelp_penerima` (`notelp_penerima`),
  ADD UNIQUE KEY `nama_penerima` (`nama_penerima`),
  ADD KEY `alamat_penerima` (`alamat_penerima`);

--
-- Indexes for table `pengirim`
--
ALTER TABLE `pengirim`
  ADD PRIMARY KEY (`id_pengirim`),
  ADD UNIQUE KEY `notelp_pengirim` (`notelp_pengirim`),
  ADD UNIQUE KEY `nama_pengirim` (`nama_pengirim`),
  ADD UNIQUE KEY `nama_pengirim_2` (`nama_pengirim`),
  ADD KEY `alamat_pengirim` (`alamat_pengirim`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `alamat`
--
ALTER TABLE `alamat`
  MODIFY `id_alamat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `kurir`
--
ALTER TABLE `kurir`
  MODIFY `id_kurir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `penerima`
--
ALTER TABLE `penerima`
  MODIFY `id_penerima` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `pengirim`
--
ALTER TABLE `pengirim`
  MODIFY `id_pengirim` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `admin_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id_admin`),
  ADD CONSTRAINT `kurir_id` FOREIGN KEY (`kurir_id`) REFERENCES `kurir` (`id_kurir`),
  ADD CONSTRAINT `penerima_id` FOREIGN KEY (`penerima_id`) REFERENCES `penerima` (`id_penerima`),
  ADD CONSTRAINT `pengirim_id` FOREIGN KEY (`pengirim_id`) REFERENCES `pengirim` (`id_pengirim`);

--
-- Constraints for table `kurir`
--
ALTER TABLE `kurir`
  ADD CONSTRAINT `admin1_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id_admin`);

--
-- Constraints for table `penerima`
--
ALTER TABLE `penerima`
  ADD CONSTRAINT `penerima_ibfk_1` FOREIGN KEY (`alamat_penerima`) REFERENCES `alamat` (`id_alamat`);

--
-- Constraints for table `pengirim`
--
ALTER TABLE `pengirim`
  ADD CONSTRAINT `pengirim_ibfk_1` FOREIGN KEY (`alamat_pengirim`) REFERENCES `alamat` (`id_alamat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
