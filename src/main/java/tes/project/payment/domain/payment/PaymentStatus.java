package tes.project.payment.domain.payment;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PENDING("pending"),
    COMPLETED("completed"),
    CANCELED("canceled");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

}
