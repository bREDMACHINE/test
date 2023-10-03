package com.retail.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "public")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "L3_product_category_code")
    private Integer L3ProductCategoryCode;
    @Column(name = "L3_product_category_name")
    private String L3ProductCategoryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return L3ProductCategoryCode != null && Objects.equals(L3ProductCategoryCode, category.L3ProductCategoryCode);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
