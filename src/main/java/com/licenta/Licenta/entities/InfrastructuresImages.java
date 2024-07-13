package com.licenta.Licenta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "infrastructures_images")
public class InfrastructuresImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Integer image_id;

    @Column(name = "infrastructure_id", nullable = false)
    private Integer infrastructure_id;

    @Column(name = "image")
    private byte[] data;
}
