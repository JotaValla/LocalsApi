package com.jotacode.restfullapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "managers")
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
//Esta propiedad sirve para que no se genere un ciclo infinito al momento de serializar el objeto
//Ignora la propiedad local del objeto Manager
@JsonIgnoreProperties("local")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long managerId;

    @NotBlank @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "manager", fetch = FetchType.EAGER)
    private Local local;

}
