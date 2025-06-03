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
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer seatingCapacity;
    private String busLicenseNumber;
    private String origin;
    private String destination;

    @Temporal(TemporalType.DATE)
    private Date tripDate;

    private Float fare;
    private String status = "active"; // default
}
