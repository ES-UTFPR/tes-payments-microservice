package tes.project.payment.domain.payment;

public enum PaymentStatus {
    PENDING("pending"),
    COMPLETED("completed"),
    CANCELED("canceled");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
