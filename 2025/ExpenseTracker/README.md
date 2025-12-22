# Expense Tracker System

A simple full-stack expense tracking application with Angular frontend and Java Spring Boot backend for managing personal expenses.

## Project Structure

```
2025/ExpenseTracker/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Add, edit, and delete expenses
- View all expenses in a list
- Filter expenses by category
- Search expenses by description
- View total expenses summary
- Simple and clean UI
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
cd 2025/ExpenseTracker/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8087`.

### API Endpoints

- `GET /api/expenses` - Get all expenses
- `GET /api/expenses/{id}` - Get expense by ID
- `GET /api/expenses/search?query={query}` - Search expenses by description
- `GET /api/expenses/category/{category}` - Get expenses by category
- `GET /api/expenses/total` - Get total expenses amount
- `POST /api/expenses` - Create new expense
- `PUT /api/expenses/{id}` - Update expense
- `DELETE /api/expenses/{id}` - Delete expense

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/ExpenseTracker/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Expense Model

### Fields
- `id` - Unique identifier
- `description` - Expense description (required)
- `amount` - Expense amount (required)
- `category` - Expense category (e.g., Food, Transport, Shopping, etc.)
- `expenseDate` - Date of the expense

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple and straightforward implementation

