package ru.stc.ebpas.crm.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private Long id;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "userinfo_id"
    )
    private UserInfo userInfo;

    @OneToMany
//    @JoinColumn(
//            name = "products"
//    )
    private List<OrderEntity> products = new ArrayList<OrderEntity>();

    public ShoppingCart(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
