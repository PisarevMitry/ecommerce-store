package ru.stc.ebpas.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stc.ebpas.crm.core.model.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}
