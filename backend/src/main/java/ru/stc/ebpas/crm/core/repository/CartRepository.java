package ru.stc.ebpas.crm.core.repository;

import ru.stc.ebpas.crm.core.model.ShoppingCart;
import ru.stc.ebpas.crm.core.model.UserInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserInfo(UserInfo userInfo);

    //    @Query(nativeQuery = true, value = "SELECT * FROM ShoppingCart s WHERE s.userInfo= :userinfo DESC LIMIT :cnt")
    List<ShoppingCart> findAllByUserInfo(UserInfo userInfo);

    List<ShoppingCart> findAllByUserInfo(UserInfo userInfo, Pageable p);

}
