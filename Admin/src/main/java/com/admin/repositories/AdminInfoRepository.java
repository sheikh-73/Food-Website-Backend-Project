package com.admin.repositories;

import com.admin.entities.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface AdminInfoRepository extends JpaRepository<AdminInfo, Long>
{
    AdminInfo findByEmail(String email);
}
