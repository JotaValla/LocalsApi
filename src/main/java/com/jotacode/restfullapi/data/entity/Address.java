package com.jotacode.restfullapi.data.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Main street is required")
    private String mainStreet;

    @NotBlank(message = "Second street is required")
    private String secondStreet;


}
