package ru.stc.ebpas.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.stc.ebpas.crm.core.model.UserInfo;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
//    Optional<UserInfo> deleteUserInfoByEmail(String email);
}
