package tes.project.payment.domain.payment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record updateStatusDTO(
    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "pending|completed|canceled", message = "Invalid status value")
    String status
) {
    
}
