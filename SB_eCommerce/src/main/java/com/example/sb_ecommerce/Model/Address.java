package com.example.sb_ecommerce.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address_line_1", nullable = false, length = 512)
    private String addressLine1;

    @Column(name = "addressline_2", length = 512)
    private String addressline2;

    @Column(name = "city")
    private String city;



    @Column(name = "state", nullable = false, length = 75)
    private String state;

    @Column(name = "country", nullable = false, length = 75)
    private String country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "local_user_id", nullable = false)
    private LocalUser localUser;

}