package com.licenta.Licenta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "infrastructura")
public class Infrastructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "infrastructure_id", nullable = false)
    private Integer infrastructure_id;

    @Column(name = "infrastructure_name")
    private String infrastructure_name;

    @Column(name = "infrastructure_description")
    private String infrastructure_description;

    @Column(name = "infrastructure_lon")
    private Double infrastructure_lon;

    @Column(name = "infrastructure_lat")
    private Double infrastructure_lat;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "infrastructure_email")
    private String infrastructure_email;

    @Column(name = "infrastructure_phone")
    private String infrastructure_phone;

    @Column(name = "infrastructure_benefits")
    private String infrastructure_benefits;

    @Column(name = "infrastructure_access_info")
    private String infrastructure_access_info;

    @Column(name = "infrastructure_tehnical_specification")
    private String infrastructure_tehnical_specification;

    @Column(name = "infrastructure_key_words")
    private String infrastructure_key_words;

    @Column(name = "private_status")
    private boolean private_status;

    @Column(name = "infrastructure_data_publication")
    private LocalDate infrastructure_data_publication;
}
