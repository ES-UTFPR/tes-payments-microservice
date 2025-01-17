# Payment API Documentation

This document provides an overview of the available endpoints for managing payments in the Payment API.

## Base URL

All endpoints are prefixed with `/payments`

---

## Endpoints

### 1. **Create Payment**

**POST** `/payments`

Creates a new payment record.

### Request Body:

```json
{
  "userId": "string",
  "orderId": "string",
  "amount": "number",
  "status": "string"
}
```

### Response:

- **200 OK**
```json
{
  "id": "number",
  "userId": "string",
  "orderId": "string",
  "amount": "number",
  "status": "string"
}
```

### 2. **Get All Payments**

**GET** `/payments`

Retrieves a list of all payment records.

### Response:

- **200 OK**

```json
[
  {
    "id": "number",
    "userId": "string",
    "orderId": "string",
    "amount": "number",
    "status": "string"
  }
]
```

## 3. **Get Payment by ID**

**GET** `/payments/{id}`

Retrieves a payment record by its ID.

## Path Parameters:

id (Long): The ID of the payment.

### Response:

- **200 OK**

```json
{
  "id": "number",
  "userId": "string",
  "orderId": "string",
  "amount": "number",
  "status": "string"
}
```

### 404 Not Found: Payment not found.

## 4. **Get Payments by User ID**

**GET** `/payments/user/{userId}`

Retrieves a list of payments for a specific user.

## Path Parameters:

userId (String): The ID of the user.

### Response:

- **200 OK**

```json
[
  {
    "id": "number",
    "userId": "string",
    "orderId": "string",
    "amount": "number",
    "status": "string"
  }
]
```

## 5. **Update Payment Status**

**PATCH** `/payments/{id}/status`

Updates the status of a specific payment and publishes a payment confirmation event.

## Path Parameters:

id (Long): The ID of the payment.

## Request Body:

```json
{
  "status": "string"
}
```

### Response:

- **200 OK** "Payment status updated successfully!"

- **404 Not Found**: Payment not found.
