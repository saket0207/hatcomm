# Hatcomm

Hatcomm is a modular monolith e-commerce backend application being built under Lumorix.

The goal of this project is not just to build an e-commerce application, but to deeply understand:

* Backend architecture evolution
* Domain-driven module ownership
* Database design
* Inventory consistency
* Payment and order workflows
* Concurrency and locking
* Scalable backend thinking
* Incremental system evolution

The application intentionally starts simple and evolves only when real pain points appear.

---

# Tech Stack

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* PostgreSQL
* Flyway
* Maven

---

# Architectural Style

Current architecture:

```text
Modular Monolith
```

Modules are organized by business capability rather than technical layer.

Example:

```text
com.lumorix.hatcomm
├── user
├── product
├── inventory
├── cart
├── order
├── payment
├── review
└── notification
```

---

# Current Features (V1 Scope)

* User authentication
* Guest checkout
* Product catalog
* Categories and subcategories
* Cart management
* Inventory reservation
* Order creation
* Payment flow
* Delivery status updates
* Product reviews
* Email notifications

---

# Database Strategy

* PostgreSQL as primary database
* Flyway for schema migrations
* SQL-first schema evolution approach

---

# Security Strategy (V1)

* Session-based authentication
* Role-based authorization

Roles:

* CUSTOMER
* ADMIN
* DELIVERY

---

# Project Philosophy

This project intentionally avoids premature complexity.

The system will evolve gradually based on real or intentionally induced pain points such as:

* Increased traffic
* Search limitations
* Inventory contention
* Reporting complexity
* Distributed workflows
* Async processing needs

Future evolution may include:

* Kafka
* Redis
* Search service
* Microservices
* Distributed caching
* JWT/OAuth2

Only when justified.

---

# Current Status

Initial project bootstrap completed:

* Spring Boot setup
* PostgreSQL integration
* Flyway setup
* First migration created
* Modular package structure initialized
