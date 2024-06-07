package com.user.repositories;

import com.user.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long>
{
    Cart findByItem(String item);
}
