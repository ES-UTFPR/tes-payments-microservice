package tes.project.payment.domain.payment.dto;

import tes.project.payment.domain.payment.PaymentStatus;

import java.math.BigDecimal;

public record PaymentDTO(
    String userId,
    BigDecimal amount,
    PaymentStatus status
) {
}
