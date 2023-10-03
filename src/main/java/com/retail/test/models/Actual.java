package com.retail.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "actuals", schema = "public")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Actual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actual_id")
    private Long id;
    private LocalDate dates;
    @ManyToOne
    @JoinColumn(name = "product_material_no")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "customer_ch_3_ship_to_code")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "chain_chain_id")
    private Chain chain;
    @Column(name = "volume_units")
    private Short volumeOrUnits;
    @Column(name = "actual_sales_value")
    private Float actualSalesValue;
    private Boolean promo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Actual actual = (Actual) o;
        return id != null && Objects.equals(id, actual.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
