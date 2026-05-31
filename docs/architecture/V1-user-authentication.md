# V1 User Authentication

## Objective
Establish foundational backend patterns before Product, Cart, Inventory and Order modules.

## Major Decisions
- Modular Monolith
- Flyway migrations
- Hybrid JPA + SQL strategy
- BIGSERIAL user identifiers
- DTO separation
- Dedicated mapper layer
- Enum-based roles
- BCrypt password hashing
- Session-based authentication
- Global exception handling

## Features Implemented
- User Registration
- User Login
- Session Creation
- Current User Endpoint
- Password Hashing
- Security Configuration

## Session Model
Stored:
- userId
- role

Not Stored:
- email

Reason:
Email can change and become stale.

## Discovery
HttpSession authentication is not the same as Spring Security authentication.
