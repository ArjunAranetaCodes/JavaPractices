# Expense Tracker Application

A full-stack expense tracking application built with Java Spring Boot backend and Angular frontend.

## Features

- Create, read, update, and delete expenses
- Filter expenses by category and payment method
- Search expenses by description or notes
- View total expenses summary
- Track expenses by date, category, and payment method

## Tech Stack

### Backend
- Java 11
- Spring Boot 2.7.0
- Spring Data JPA
- H2 Database (in-memory)

### Frontend
- Angular 15
- TypeScript
- RxJS

## Project Structure

```
ExpenseTracker/
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/expensetracker/
│   │       │   ├── ExpenseTrackerApplication.java
│   │       │   ├── controller/
│   │       │   ├── model/
│   │       │   ├── repository/
│   │       │   └── service/
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
└── frontend/
    ├── src/
    │   └── app/
    │       ├── components/
    │       ├── models/
    │       ├── services/
    │       └── app.module.ts
    └── package.json
```

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Node.js 16+ and npm
- Angular CLI 15

### Backend Setup

1. Navigate to the backend directory:
```bash
cd backend
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8085`

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
ng serve
```

The frontend will start on `http://localhost:4200`

## API Endpoints

- `GET /api/expenses` - Get all expenses
- `GET /api/expenses/{id}` - Get expense by ID
- `POST /api/expenses` - Create new expense
- `PUT /api/expenses/{id}` - Update expense
- `DELETE /api/expenses/{id}` - Delete expense
- `GET /api/expenses/category/{category}` - Get expenses by category
- `GET /api/expenses/date-range?startDate=&endDate=` - Get expenses in date range
- `GET /api/expenses/payment-method/{method}` - Get expenses by payment method
- `GET /api/expenses/search?query=` - Search expenses
- `GET /api/expenses/total/category/{category}` - Get total by category
- `GET /api/expenses/total/date-range?startDate=&endDate=` - Get total in date range

## Expense Categories

- FOOD
- TRANSPORTATION
- SHOPPING
- BILLS
- ENTERTAINMENT
- HEALTH
- EDUCATION
- TRAVEL
- OTHER

## Payment Methods

- CASH
- CREDIT_CARD
- DEBIT_CARD
- BANK_TRANSFER
- DIGITAL_WALLET
- OTHER

## Database

The application uses H2 in-memory database. Access the H2 console at:
`http://localhost:8085/h2-console`

- JDBC URL: `jdbc:h2:mem:expensedb`
- Username: `sa`
- Password: (empty)
