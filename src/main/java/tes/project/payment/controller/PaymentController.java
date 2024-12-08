package tes.project.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tes.project.payment.domain.payment.Payment;
import tes.project.payment.domain.payment.PaymentStatus;
import tes.project.payment.domain.payment.dto.PaymentDTO;
import tes.project.payment.repository.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentRepository repository;

    public PaymentController(PaymentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody PaymentDTO payment) {
        Payment newPayment = new Payment(payment.userId(), payment.amount(), payment.status());

        this.repository.save(newPayment);

        return ResponseEntity.ok(newPayment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> payments() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Payment>> find(@PathVariable Long id) {
        return ResponseEntity.ok(this.repository.findById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> findByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(this.repository.findByUserId(userId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestParam PaymentStatus status) {
        Payment payment = (Payment) this.repository.findById(id);

        payment.setStatus(status);

        this.repository.save(payment);

        return ResponseEntity.ok("Payment status updated successfully!");
    }
}
