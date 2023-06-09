package ru.stc.ebpas.crm.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @Id
    @SequenceGenerator(
            name = "order_entity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_entity_sequence"
    )
    private Long id;
    private Integer quantity;

    @OneToOne
    private Product product;

    public OrderEntity(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
