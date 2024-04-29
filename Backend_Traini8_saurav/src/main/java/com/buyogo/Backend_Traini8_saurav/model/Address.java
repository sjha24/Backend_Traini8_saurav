package com.buyogo.Backend_Traini8_saurav.model;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;



@Data
@Embeddable
public class Address {

    @NotEmpty(message = "Address Details Should not be empty")
    private String addressDetails;

    @NotEmpty(message = "City Should not be empty")
    private String city;

    @NotEmpty(message = "State should not be empty")
    private String state;

    @NotEmpty(message = "Pin code should not be empty")
    private String pincode;
}
