package br.com.tiagoiwamoto.personalfinnancecontrolapi.repository;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 30/03/2021 | 07:31
 */

import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.InvestmentMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentMovementRepository extends JpaRepository<InvestmentMovement, Long> {
}
