package com.buyogo.Backend_Traini8_saurav.entities;
import com.buyogo.Backend_Traini8_saurav.model.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.List;



@Data
@Entity
@NoArgsConstructor
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Center name should not be empty")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @Column(name = "center_code", unique = true)
    @NotEmpty(message = "Center code should not be empty")
    @Size(min = 12, max = 12, message = "Center code must be exactly 12 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Center code must be alphanumeric")
    private String centerCode;

    @Valid
    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private long createdOn = Instant.now().getEpochSecond();

    @Email(message = "Email is not in valid format")
    private String contactEmail;

    @NotEmpty(message = "Contact phone number should not be empty")
    private String contactPhone;
}
