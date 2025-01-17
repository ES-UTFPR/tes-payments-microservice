package tes.project.payment.domain.payment.dto;

public record PaymentDTO(
    String userId,
    Integer orderId,
    Integer amount,
    String status
) {
}
