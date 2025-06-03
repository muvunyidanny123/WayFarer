package com.example.WayFarer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Author: Nkurikiyimana Aimable, Iradukunda Joselyne, Mariza Jeanne
 * RegNo: 24582/2024, 21438/2024, 21504/2023
 */
@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tripId;
    private Integer userId;

    @Temporal(TemporalType.DATE)
    private Date createdOn = new Date();
}
