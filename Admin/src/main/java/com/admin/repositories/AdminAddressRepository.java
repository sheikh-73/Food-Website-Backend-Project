package com.admin.repositories;

import com.admin.entities.AdminAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface AdminAddressRepository extends JpaRepository<AdminAddress, Long>
{

}
