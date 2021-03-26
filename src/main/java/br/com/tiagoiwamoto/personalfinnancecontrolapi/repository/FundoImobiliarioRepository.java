package br.com.tiagoiwamoto.personalfinnancecontrolapi.repository;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 21:35
 */

import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.FundoImobiliario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FundoImobiliarioRepository extends JpaRepository<FundoImobiliario, Long> {

    Optional<FundoImobiliario> findByCode(String code);

}
