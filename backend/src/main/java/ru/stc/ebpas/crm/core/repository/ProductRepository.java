package ru.stc.ebpas.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stc.ebpas.crm.core.model.Product;
import ru.stc.ebpas.crm.core.model.Arrival;
import ru.stc.ebpas.crm.core.model.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByArrival(Arrival arrival);
    List<Product> findAllByProductType(ProductType productType);
//    Optional<Product> findById(Long id);

    @Query("SELECT p FROM Product p WHERE p.productType=?1 AND p.arrival=?2")
    List<Product> findAllByArrivalAndSex(ProductType sex, Arrival arrival);
}
