package tes.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tes.project.payment.domain.payment.Payment;
import tes.project.payment.domain.payment.PaymentStatus;
import tes.project.payment.domain.payment.dto.PaymentDTO;
import tes.project.payment.domain.payment.dto.updateStatusDTO;
import tes.project.payment.repository.PaymentRepository;
import tes.project.payment.service.PaymentEventPublisher;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentEventPublisher eventPublisher;

    private final PaymentRepository repository;

    public PaymentController(PaymentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody PaymentDTO payment) {
        Payment newPayment = new Payment(payment.userId(), payment.orderId(), payment.amount(), payment.status());

        this.repository.save(newPayment);

        return ResponseEntity.ok(newPayment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> payments() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> find(@PathVariable Long id) {
        return ResponseEntity.ok(this.repository.findById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> findByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(this.repository.findByUserId(userId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody updateStatusDTO dto) {
        Payment payment = this.repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Payment not found for ID: " + id));

        payment.setStatus(dto.status());

        this.repository.save(payment);

        eventPublisher.publishPaymentConfirmedEvent(id);

        return ResponseEntity.ok("Payment status updated successfully!");
    }
}
