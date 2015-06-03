-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 03 Cze 2015, 23:23
-- Wersja serwera: 5.6.20
-- Wersja PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `logistyka`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `adres`
--

CREATE TABLE IF NOT EXISTS `adres` (
`ID_ADRES` int(30) unsigned NOT NULL,
  `ULICA_MIEJSCOWOSC` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `NR_DOMU` varchar(64) COLLATE utf32_polish_ci DEFAULT NULL,
  `NR_LOKALU` varchar(64) COLLATE utf32_polish_ci DEFAULT NULL,
  `KOD_OCZTOWY` varchar(10) COLLATE utf32_polish_ci NOT NULL,
  `POCZTA` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `adres`
--

INSERT INTO `adres` (`ID_ADRES`, `ULICA_MIEJSCOWOSC`, `NR_DOMU`, `NR_LOKALU`, `KOD_OCZTOWY`, `POCZTA`) VALUES
(1, 'Rydla', '26', '2', '30-087', 'Kraków');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dostawa`
--

CREATE TABLE IF NOT EXISTS `dostawa` (
`ID_DOSTAWA` int(30) unsigned NOT NULL,
  `ID_DOSTAWCA` int(30) unsigned NOT NULL,
  `DATA_DOSTAWY` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dostawca`
--

CREATE TABLE IF NOT EXISTS `dostawca` (
`ID_DOSTAWCA` int(30) unsigned NOT NULL,
  `NAZWA_FIRMY` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `NIP` int(10) unsigned NOT NULL,
  `ID_ADRES` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategoria`
--

CREATE TABLE IF NOT EXISTS `kategoria` (
`ID_KATEGORIA` int(30) unsigned NOT NULL,
  `KATEGORIA` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kolor`
--

CREATE TABLE IF NOT EXISTS `kolor` (
  `KOLOR` varchar(64) COLLATE utf32_polish_ci NOT NULL,
`ID_KOLOR` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `koszyk`
--

CREATE TABLE IF NOT EXISTS `koszyk` (
`ID_KOSZYK` int(30) unsigned NOT NULL,
  `ID_KOSZYK_PRODUKT` int(30) unsigned NOT NULL,
  `ILOSC` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `koszyk_produkt`
--

CREATE TABLE IF NOT EXISTS `koszyk_produkt` (
`ID_KOSZYK_PRODUKT` int(30) unsigned NOT NULL,
  `ID_PRODUKT` int(30) unsigned NOT NULL,
  `ILOSC` int(30) unsigned NOT NULL,
  `CENA_PRODUKT` decimal(10,2) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lista_dostawa`
--

CREATE TABLE IF NOT EXISTS `lista_dostawa` (
`ID_LISTA_DOSTAWA` int(30) unsigned NOT NULL,
  `ID_PRODUKT` int(30) unsigned NOT NULL,
  `ID_DOSTAWA` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `magazyn`
--

CREATE TABLE IF NOT EXISTS `magazyn` (
`ID_MAGAZYN` int(30) unsigned NOT NULL,
  `NAZWA` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `ID_ADRES` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `marka`
--

CREATE TABLE IF NOT EXISTS `marka` (
`ID_MARKI` int(30) unsigned NOT NULL,
  `MARKA` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `produkt`
--

CREATE TABLE IF NOT EXISTS `produkt` (
`ID_PRODUKTU` int(30) unsigned NOT NULL,
  `NAZWA` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `CENA` decimal(10,2) NOT NULL,
  `ID_KATEGORIA` int(30) unsigned NOT NULL,
  `ID_MARKA` int(30) unsigned NOT NULL,
  `ID_KOLOR` int(30) unsigned NOT NULL,
  `ID_ROZMIAR` int(30) unsigned NOT NULL,
  `ID_TYP` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przechowywanie`
--

CREATE TABLE IF NOT EXISTS `przechowywanie` (
`ID_PRZECHOWYWANIE` int(30) unsigned NOT NULL,
  `ID_MAGAZYN` int(30) unsigned NOT NULL,
  `ID_PRODUKT` int(30) unsigned NOT NULL,
  `ILOSC` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przesylka`
--

CREATE TABLE IF NOT EXISTS `przesylka` (
`ID_PRZESYLKA` int(30) unsigned NOT NULL,
  `CENA` decimal(10,2) NOT NULL,
  `ID_TYP_PRZESYLKI` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rozmiar`
--

CREATE TABLE IF NOT EXISTS `rozmiar` (
`ID_ROZMIAR` int(30) unsigned NOT NULL,
  `ROZMIAR` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `status_zamowienia`
--

CREATE TABLE IF NOT EXISTS `status_zamowienia` (
`ID_STATUS` int(30) unsigned NOT NULL,
  `STATUS` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `typ`
--

CREATE TABLE IF NOT EXISTS `typ` (
`ID_TYP` int(30) unsigned NOT NULL,
  `TYP` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `typ_przesylki`
--

CREATE TABLE IF NOT EXISTS `typ_przesylki` (
`ID_TYP_PRZESYLKI` int(30) unsigned NOT NULL,
  `TYP_PRZESYLKI` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uprawnienia`
--

CREATE TABLE IF NOT EXISTS `uprawnienia` (
`ID_UPRAWNIENIA` int(30) unsigned NOT NULL,
  `UPRAWNIENIE` varchar(64) COLLATE utf32_polish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `uprawnienia`
--

INSERT INTO `uprawnienia` (`ID_UPRAWNIENIA`, `UPRAWNIENIE`) VALUES
(1, 'PRACOWNIK'),
(2, 'KLIENT');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownik`
--

CREATE TABLE IF NOT EXISTS `uzytkownik` (
`ID_UZYTKOWNIK` int(30) unsigned NOT NULL,
  `IMIE` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `NAZWISKO` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `ID_ADRES` int(30) unsigned NOT NULL,
  `EMAIL` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `HASLO` varchar(64) COLLATE utf32_polish_ci NOT NULL,
  `TELEFON` varchar(9) COLLATE utf32_polish_ci NOT NULL,
  `ID_UPRWNIENIA` int(30) unsigned NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=4 ;

--
-- Zrzut danych tabeli `uzytkownik`
--

INSERT INTO `uzytkownik` (`ID_UZYTKOWNIK`, `IMIE`, `NAZWISKO`, `ID_ADRES`, `EMAIL`, `HASLO`, `TELEFON`, `ID_UPRWNIENIA`) VALUES
(3, 'ADRIAN', 'WIDŁAK', 1, 'ADRIAN.WIDLAK@INTERIA.PL', 'ADRIAN', '602360496', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienie`
--

CREATE TABLE IF NOT EXISTS `zamowienie` (
`ID_ZAMOWIENIE` int(30) unsigned NOT NULL,
  `ID_UZYTKOWNIK` int(30) unsigned NOT NULL,
  `DATA_ZAMOWIENIA` datetime NOT NULL,
  `ID_KOSZYK` int(30) unsigned NOT NULL,
  `ID_STATUS` int(30) unsigned NOT NULL,
  `ID_PRZESYLKA` int(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci AUTO_INCREMENT=1 ;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `adres`
--
ALTER TABLE `adres`
 ADD PRIMARY KEY (`ID_ADRES`);

--
-- Indexes for table `dostawa`
--
ALTER TABLE `dostawa`
 ADD PRIMARY KEY (`ID_DOSTAWA`), ADD KEY `ID_DOSTAWCA` (`ID_DOSTAWCA`);

--
-- Indexes for table `dostawca`
--
ALTER TABLE `dostawca`
 ADD PRIMARY KEY (`ID_DOSTAWCA`), ADD KEY `ID_ADRES_DOSTAWCA` (`ID_ADRES`);

--
-- Indexes for table `kategoria`
--
ALTER TABLE `kategoria`
 ADD PRIMARY KEY (`ID_KATEGORIA`);

--
-- Indexes for table `kolor`
--
ALTER TABLE `kolor`
 ADD PRIMARY KEY (`ID_KOLOR`);

--
-- Indexes for table `koszyk`
--
ALTER TABLE `koszyk`
 ADD PRIMARY KEY (`ID_KOSZYK`), ADD KEY `ID_KOSZYK_PRODUKT` (`ID_KOSZYK_PRODUKT`);

--
-- Indexes for table `koszyk_produkt`
--
ALTER TABLE `koszyk_produkt`
 ADD PRIMARY KEY (`ID_KOSZYK_PRODUKT`), ADD KEY `ID_PRODUKT_KOSZYK_PRODUKT` (`ID_PRODUKT`);

--
-- Indexes for table `lista_dostawa`
--
ALTER TABLE `lista_dostawa`
 ADD PRIMARY KEY (`ID_LISTA_DOSTAWA`), ADD KEY `ID_DOSTAWA` (`ID_DOSTAWA`), ADD KEY `ID_PRODUKT_LISTA_DOSTAWA` (`ID_PRODUKT`);

--
-- Indexes for table `magazyn`
--
ALTER TABLE `magazyn`
 ADD PRIMARY KEY (`ID_MAGAZYN`), ADD KEY `ID_ADRES_MAGAZYN` (`ID_ADRES`);

--
-- Indexes for table `marka`
--
ALTER TABLE `marka`
 ADD PRIMARY KEY (`ID_MARKI`);

--
-- Indexes for table `produkt`
--
ALTER TABLE `produkt`
 ADD PRIMARY KEY (`ID_PRODUKTU`), ADD KEY `ID_KATEGORIA` (`ID_KATEGORIA`), ADD KEY `ID_MARKA` (`ID_MARKA`), ADD KEY `ID_KOLOR` (`ID_KOLOR`), ADD KEY `ID_ROZMIAR` (`ID_ROZMIAR`), ADD KEY `ID_TYP` (`ID_TYP`);

--
-- Indexes for table `przechowywanie`
--
ALTER TABLE `przechowywanie`
 ADD PRIMARY KEY (`ID_PRZECHOWYWANIE`), ADD KEY `ID_MAGAZYN` (`ID_MAGAZYN`), ADD KEY `ID_PRODUKT_PRZECHOWYWANIE` (`ID_PRODUKT`);

--
-- Indexes for table `przesylka`
--
ALTER TABLE `przesylka`
 ADD PRIMARY KEY (`ID_PRZESYLKA`), ADD KEY `ID_TYP_PRZESYLKI` (`ID_TYP_PRZESYLKI`);

--
-- Indexes for table `rozmiar`
--
ALTER TABLE `rozmiar`
 ADD PRIMARY KEY (`ID_ROZMIAR`);

--
-- Indexes for table `status_zamowienia`
--
ALTER TABLE `status_zamowienia`
 ADD PRIMARY KEY (`ID_STATUS`);

--
-- Indexes for table `typ`
--
ALTER TABLE `typ`
 ADD PRIMARY KEY (`ID_TYP`);

--
-- Indexes for table `typ_przesylki`
--
ALTER TABLE `typ_przesylki`
 ADD PRIMARY KEY (`ID_TYP_PRZESYLKI`);

--
-- Indexes for table `uprawnienia`
--
ALTER TABLE `uprawnienia`
 ADD PRIMARY KEY (`ID_UPRAWNIENIA`);

--
-- Indexes for table `uzytkownik`
--
ALTER TABLE `uzytkownik`
 ADD PRIMARY KEY (`ID_UZYTKOWNIK`), ADD KEY `ID_ADRES_KLIENT` (`ID_ADRES`), ADD KEY `ID_UPRAWNIENIA` (`ID_UPRWNIENIA`);

--
-- Indexes for table `zamowienie`
--
ALTER TABLE `zamowienie`
 ADD PRIMARY KEY (`ID_ZAMOWIENIE`), ADD KEY `ID_KOSZYK` (`ID_KOSZYK`), ADD KEY `ID_STATUS` (`ID_STATUS`), ADD KEY `ID_PRZESYLKA` (`ID_PRZESYLKA`), ADD KEY `ID_UZYTKOWNIK` (`ID_UZYTKOWNIK`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `adres`
--
ALTER TABLE `adres`
MODIFY `ID_ADRES` int(30) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `dostawa`
--
ALTER TABLE `dostawa`
MODIFY `ID_DOSTAWA` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `dostawca`
--
ALTER TABLE `dostawca`
MODIFY `ID_DOSTAWCA` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `kategoria`
--
ALTER TABLE `kategoria`
MODIFY `ID_KATEGORIA` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `kolor`
--
ALTER TABLE `kolor`
MODIFY `ID_KOLOR` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `koszyk`
--
ALTER TABLE `koszyk`
MODIFY `ID_KOSZYK` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `koszyk_produkt`
--
ALTER TABLE `koszyk_produkt`
MODIFY `ID_KOSZYK_PRODUKT` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `lista_dostawa`
--
ALTER TABLE `lista_dostawa`
MODIFY `ID_LISTA_DOSTAWA` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
MODIFY `ID_MAGAZYN` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `marka`
--
ALTER TABLE `marka`
MODIFY `ID_MARKI` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `produkt`
--
ALTER TABLE `produkt`
MODIFY `ID_PRODUKTU` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `przechowywanie`
--
ALTER TABLE `przechowywanie`
MODIFY `ID_PRZECHOWYWANIE` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `przesylka`
--
ALTER TABLE `przesylka`
MODIFY `ID_PRZESYLKA` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `rozmiar`
--
ALTER TABLE `rozmiar`
MODIFY `ID_ROZMIAR` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `status_zamowienia`
--
ALTER TABLE `status_zamowienia`
MODIFY `ID_STATUS` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `typ`
--
ALTER TABLE `typ`
MODIFY `ID_TYP` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `typ_przesylki`
--
ALTER TABLE `typ_przesylki`
MODIFY `ID_TYP_PRZESYLKI` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `uprawnienia`
--
ALTER TABLE `uprawnienia`
MODIFY `ID_UPRAWNIENIA` int(30) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `uzytkownik`
--
ALTER TABLE `uzytkownik`
MODIFY `ID_UZYTKOWNIK` int(30) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
MODIFY `ID_ZAMOWIENIE` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `dostawa`
--
ALTER TABLE `dostawa`
ADD CONSTRAINT `ID_DOSTAWCA` FOREIGN KEY (`ID_DOSTAWCA`) REFERENCES `dostawca` (`ID_DOSTAWCA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `dostawca`
--
ALTER TABLE `dostawca`
ADD CONSTRAINT `ID_ADRES_DOSTAWCA` FOREIGN KEY (`ID_ADRES`) REFERENCES `dostawca` (`ID_DOSTAWCA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `koszyk`
--
ALTER TABLE `koszyk`
ADD CONSTRAINT `ID_KOSZYK_PRODUKT` FOREIGN KEY (`ID_KOSZYK_PRODUKT`) REFERENCES `koszyk_produkt` (`ID_KOSZYK_PRODUKT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `koszyk_produkt`
--
ALTER TABLE `koszyk_produkt`
ADD CONSTRAINT `ID_PRODUKT_KOSZYK_PRODUKT` FOREIGN KEY (`ID_PRODUKT`) REFERENCES `produkt` (`ID_PRODUKTU`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `lista_dostawa`
--
ALTER TABLE `lista_dostawa`
ADD CONSTRAINT `ID_DOSTAWA` FOREIGN KEY (`ID_DOSTAWA`) REFERENCES `dostawa` (`ID_DOSTAWA`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_PRODUKT_LISTA_DOSTAWA` FOREIGN KEY (`ID_PRODUKT`) REFERENCES `produkt` (`ID_PRODUKTU`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
ADD CONSTRAINT `ID_ADRES_MAGAZYN` FOREIGN KEY (`ID_ADRES`) REFERENCES `adres` (`ID_ADRES`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `produkt`
--
ALTER TABLE `produkt`
ADD CONSTRAINT `ID_KATEGORIA` FOREIGN KEY (`ID_KATEGORIA`) REFERENCES `kategoria` (`ID_KATEGORIA`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_KOLOR` FOREIGN KEY (`ID_KOLOR`) REFERENCES `kolor` (`ID_KOLOR`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_MARKA` FOREIGN KEY (`ID_MARKA`) REFERENCES `marka` (`ID_MARKI`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_ROZMIAR` FOREIGN KEY (`ID_ROZMIAR`) REFERENCES `rozmiar` (`ID_ROZMIAR`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_TYP` FOREIGN KEY (`ID_TYP`) REFERENCES `typ` (`ID_TYP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `przechowywanie`
--
ALTER TABLE `przechowywanie`
ADD CONSTRAINT `ID_MAGAZYN` FOREIGN KEY (`ID_MAGAZYN`) REFERENCES `magazyn` (`ID_MAGAZYN`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_PRODUKT_PRZECHOWYWANIE` FOREIGN KEY (`ID_PRODUKT`) REFERENCES `produkt` (`ID_PRODUKTU`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `przesylka`
--
ALTER TABLE `przesylka`
ADD CONSTRAINT `ID_TYP_PRZESYLKI` FOREIGN KEY (`ID_TYP_PRZESYLKI`) REFERENCES `typ_przesylki` (`ID_TYP_PRZESYLKI`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `uzytkownik`
--
ALTER TABLE `uzytkownik`
ADD CONSTRAINT `ID_ADRES_KLIENT` FOREIGN KEY (`ID_ADRES`) REFERENCES `adres` (`ID_ADRES`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_UPRAWNIENIA` FOREIGN KEY (`ID_UPRWNIENIA`) REFERENCES `uprawnienia` (`ID_UPRAWNIENIA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
ADD CONSTRAINT `ID_KOSZYK` FOREIGN KEY (`ID_KOSZYK`) REFERENCES `koszyk` (`ID_KOSZYK`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_PRZESYLKA` FOREIGN KEY (`ID_PRZESYLKA`) REFERENCES `przesylka` (`ID_PRZESYLKA`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_STATUS` FOREIGN KEY (`ID_STATUS`) REFERENCES `status_zamowienia` (`ID_STATUS`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ID_UZYTKOWNIK` FOREIGN KEY (`ID_UZYTKOWNIK`) REFERENCES `uzytkownik` (`ID_UZYTKOWNIK`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
