package com.admin.repositories;

import com.admin.entities.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long>
{

}
