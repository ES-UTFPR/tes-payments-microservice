package tes.project.payment.domain.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "payments")
@Entity(name = "payments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private Integer orderId;
    private Integer amount;
    private String status;
    private LocalDateTime createdAt;

    public Payment() {
    }

    public Payment(String userId, Integer orderId, Integer amount, String status) {
        this.userId = userId;
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
