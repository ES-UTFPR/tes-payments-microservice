package tes.project.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tes.project.payment.domain.payment.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(String userId);
}
