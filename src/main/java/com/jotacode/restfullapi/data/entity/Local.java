package com.jotacode.restfullapi.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "locals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Floor is mandatory")
    private String floor;

    @Column(nullable = false)
    @NotBlank(message = "Code is mandatory")
    @Length(min = 4, max = 6, message = "Code must be 3 characters")
    private String code;

    /**
     * Un local tiene un gerente,y un gerente pertenece a un local
     */

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    @NotNull(message = "Manager is mandatory")
    private Manager manager;

    /**
     * Un local tiene una lista de ordenes, y una orden pertenece a un local
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "local_id", referencedColumnName = "local_id")
    private List<Order> listaOrdenes;

    /**
     * Un local puede tener varios clientes, y un cliente puede pertenecer a varios locales
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "local_customer_map",
            joinColumns = @JoinColumn(name = "local_id", referencedColumnName = "local_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    )
    private List<Customer> customers;

}
