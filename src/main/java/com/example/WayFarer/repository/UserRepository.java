package com.example.WayFarer.repository;

import com.example.WayFarer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Nkurikiyimana Aimable, Iradukunda Joselyne, Mariza Jeanne
 * RegNo: 24582/2024, 21438/2024, 21504/2023
 */

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
