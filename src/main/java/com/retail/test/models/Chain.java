package com.retail.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chains", schema = "public")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Chain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chain_id")
    private Byte id;
    @Column(name = "chain_name")
    private String chainName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Chain chain = (Chain) o;
        return id != null && Objects.equals(id, chain.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
