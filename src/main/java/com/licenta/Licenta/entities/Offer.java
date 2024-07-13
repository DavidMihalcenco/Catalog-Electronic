package com.licenta.Licenta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Integer offer_id;

    @Column(name = "offer_name")
    private String offer_name;

    @Column(name = "offer_description")
    private String offer_description;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "offer_context")
    private String offer_context;

    @Column(name = "offer_benefits")
    private String offer_benefits;

    @Column(name = "offer_utilization")
    private String offer_utilization;

    @Column(name = "offer_colaborations")
    private String offer_colaboration;

    @Column(name = "offer_phone")
    private String offer_phone;

    @Column(name = "offer_email")
    private String offer_email;

    @Column(name = "offer_status")
    private String offer_status;

    @Column(name = "offer_key_words")
    private String offer_key_words;

    @Column(name = "private_status")
    private boolean private_status;

    @Column(name = "offer_data_publication")
    private LocalDate offer_data_publication;
}
