# MAP SOLID & GRASP Workshop

A practical workshop demonstrating how a simple sales order system can evolve from a legacy implementation into a more maintainable, testable and extensible solution using SOLID, GRASP, JUnit and Mockito.

## Main Question

> How do professional developers organize code so that it becomes easier to evolve, test and maintain?

---

## Technologies

* Java 21
* Maven
* JUnit 5
* Mockito

---

## Workshop Structure

The project was intentionally developed in stages, with each branch representing a specific evolution of the system.

### initial-version

Legacy implementation.

Characteristics:

* Multiple responsibilities in a single class
* High coupling
* Conditional logic for payment processing
* Difficult to test
* Difficult to maintain

---

### step-1-srp

**Single Responsibility Principle (SRP)**

Refactoring goals:

* Separate responsibilities
* Improve cohesion
* Reduce complexity

New classes introduced:

* DiscountService
* PaymentService
* OrderRepository
* EmailService

---

### step-2-information-expert

**GRASP - Information Expert**

Refactoring goals:

* Move behavior closer to the data it uses
* Improve encapsulation

Changes:

* Total calculation moved from `OrderService` to `Order`

Example:

```java
order.calculateTotal();
```

---

### step-3-ocp

**Open/Closed Principle (OCP)**

Refactoring goals:

* Support new payment methods without modifying existing logic

New abstractions:

* PaymentMethod
* PixPayment
* CardPayment
* CashPayment

---

### step-4-dip

**Dependency Inversion Principle (DIP)**

Refactoring goals:

* Depend on abstractions instead of concrete implementations

New abstractions:

* OrderRepository
* NotificationService

Implementations:

* MySqlOrderRepository
* EmailService

Constructor injection introduced in `OrderService`.

---

### step-5-junit

**Unit Testing with JUnit 5**

Topics covered:

* Writing clear and focused tests
* Testing business rules
* Testing domain behavior

Examples:

* Order total calculation
* Discount application

Example naming convention:

```java
shouldCalculateTotalWhenOrderHasMultipleItems()
```

---

### step-6-mockito

**Mockito**

Topics covered:

* Mocking external dependencies
* Interaction testing
* Verifying behavior

Examples:

```java
verify(repository).saveOrder(order);
```

```java
verify(notificationService)
        .sendConfirmation(order);
```

---

### final-version

Final version of the project.

Concepts applied:

* SRP
* OCP
* DIP
* Information Expert
* High Cohesion
* Low Coupling
* JUnit 5
* Mockito

---

## Lessons Learned

Good software design is not about applying patterns for the sake of using patterns.

The goal is to build software that remains understandable, testable and maintainable as requirements evolve.

SOLID, GRASP and testing practices are tools that help achieve that goal.

---

## Author

Luiz Henrique Rangel

Computer Science Student

Teaching Assistant – Advanced Programming Methods (MAP)
