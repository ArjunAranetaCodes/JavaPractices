# Budget Tracker

A Java + Angular app to track income and expenses by category.

## Features

- Add income and expense transactions (amount, date, category, description)
- Filter by type (Income/Expense) and category
- Summary: total income, total expense, balance
- Edit and delete transactions

## Tech Stack

- **Backend:** Java 11, Spring Boot 2.7, JPA, H2 (port 8085)
- **Frontend:** Angular 15

## Run

**Backend**
```bash
cd 2026/BudgetTracker/backend
mvn spring-boot:run
```

**Frontend**
```bash
cd 2026/BudgetTracker/frontend
npm install
npm start
```

Open http://localhost:4200

## API

- `GET /api/transactions` – list all
- `GET /api/transactions/{id}` – get one
- `GET /api/transactions/type/{type}` – by type (INCOME/EXPENSE)
- `GET /api/transactions/category/{category}` – by category
- `GET /api/transactions/range?start=YYYY-MM-DD&end=YYYY-MM-DD` – by date range
- `POST /api/transactions` – create
- `PUT /api/transactions/{id}` – update
- `DELETE /api/transactions/{id}` – delete

## H2 Console

http://localhost:8085/h2-console  
JDBC URL: `jdbc:h2:mem:budgetdb`  
User: `sa`  
Password: (empty)
