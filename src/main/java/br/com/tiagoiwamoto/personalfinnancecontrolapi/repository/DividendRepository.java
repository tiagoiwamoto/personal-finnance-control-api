package br.com.tiagoiwamoto.personalfinnancecontrolapi.repository;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 20:47
 */

import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Dividends;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.FundoImobiliario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DividendRepository extends JpaRepository<Dividends, Long> {

    List<Dividends> findAllByPaymentDateBetweenAndFundoImobiliarioOrderByPaymentDateAsc(LocalDate paymentDate, LocalDate currentDate, FundoImobiliario fii);

}
