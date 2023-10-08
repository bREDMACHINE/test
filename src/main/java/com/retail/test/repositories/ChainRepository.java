package com.retail.test.repositories;

import com.retail.test.models.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChainRepository extends JpaRepository<Chain, Long> {

    Optional<Chain> findByChainName(String chainName);
}
