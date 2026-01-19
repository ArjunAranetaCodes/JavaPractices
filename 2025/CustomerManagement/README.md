# Customer Management System

A simple full-stack customer relationship management (CRM) application with Angular frontend and Java Spring Boot backend for managing customer information and interactions.

## Project Structure

```
2025/CustomerManagement/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete customers
- Track customer details: name, email, phone, company, industry, status, address, notes
- Customer status tracking (LEAD, ACTIVE, INACTIVE, CLOSED)
- Industry categorization (TECHNOLOGY, HEALTHCARE, FINANCE, RETAIL, EDUCATION, MANUFACTURING, CONSULTING, OTHER)
- Contact information management
- Notes and comments tracking
- Search customers by name, email, company, or notes
- Filter by status and industry
- Statistics dashboard (total customers, active, leads, by industry)
- Beautiful card-based UI with status indicators
- RESTful API backend with in-memory H2 database

## Backend (Spring Boot)

### Tech Stack
- Java 11
- Spring Boot 2.7.x
- Spring Web
- Spring Data JPA
- H2 in-memory database
- Maven

### Running Backend

```bash
cd 2025/CustomerManagement/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8104`.

### API Endpoints

- `GET /api/customers` - Get all customers
- `GET /api/customers/{id}` - Get customer by ID
- `GET /api/customers/search?query={query}` - Search customers by name, email, company, or notes
- `GET /api/customers/status/{status}` - Get customers by status
- `GET /api/customers/industry/{industry}` - Get customers by industry
- `POST /api/customers` - Create new customer
- `PUT /api/customers/{id}` - Update customer
- `DELETE /api/customers/{id}` - Delete customer

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/CustomerManagement/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Customer Model

### Fields
- `id` - Unique identifier
- `firstName` - First name (required)
- `lastName` - Last name (required)
- `email` - Email address
- `phone` - Phone number
- `company` - Company name
- `industry` - Industry type (TECHNOLOGY, HEALTHCARE, FINANCE, RETAIL, EDUCATION, MANUFACTURING, CONSULTING, OTHER)
- `status` - Customer status (LEAD, ACTIVE, INACTIVE, CLOSED)
- `address` - Physical address
- `city` - City
- `state` - State/Province
- `zipCode` - ZIP/Postal code
- `country` - Country
- `notes` - Additional notes and comments
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple and straightforward implementation
