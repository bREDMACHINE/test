package com.retail.test.repositories;

import com.retail.test.models.Actual;
import com.retail.test.models.ActualWithPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ActualRepository extends JpaRepository<Actual, Long> {

    @Query("select new com.retail.test.models.ActualWithPrice(ac.id, ac.dates, ac.product, ac.customer, ac.chains, " +
            "ac.volumeOrUnits, ac.actualSalesValue, ac.promoSign, pri.regularPricePerUnit) " +
            "from Actual as ac "+
            "left outer join Price as pri on ac.chains = pri.product and ac.product = pri.product " +
            "where ac.chains in (select ch.id " +
                                "from Chain as ch " +
                                "where ch.chainName = ?1) "+
            "and ac.dates between ?2 and ?3" +
            "and pri.product in (select pro.materialNo " +
                                "from Product as pro " +
                                "where pro.category in (select cat.productCategoryCode " +
                                                        "from Category as cat " +
                                                        "where cat.productCategoryName = ?4))")
    List<ActualWithPrice> getAllActualsWithPrice(String chain, LocalDate dateFrom, LocalDate dateTo, String category);

    List<Actual> findAllByDatesIsAndChainsInAndProductIn(LocalDate date, List<Long> chains, List<Long> products);
}
