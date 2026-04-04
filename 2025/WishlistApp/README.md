# Wishlist Application

A simple full-stack wishlist management application with Angular frontend and Java Spring Boot backend for tracking items you want to buy or acquire.

## Project Structure

```
2025/WishlistApp/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete wishlist items
- Track item details: name, description, price, priority
- Item status (Wanted, Purchased, Removed)
- Categories for organizing items
- Priority levels (High, Medium, Low)
- Link/URL for items
- Search items by name or description
- Filter items by status, category, and priority
- Total value calculation
- Beautiful card-based UI
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
cd 2025/WishlistApp/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8095`.

### API Endpoints

- `GET /api/items` - Get all wishlist items
- `GET /api/items/{id}` - Get item by ID
- `GET /api/items/search?query={query}` - Search items by name or description
- `GET /api/items/status/{status}` - Get items by status (WANTED, PURCHASED, REMOVED)
- `GET /api/items/category/{category}` - Get items by category
- `GET /api/items/priority/{priority}` - Get items by priority (HIGH, MEDIUM, LOW)
- `POST /api/items` - Create new item
- `PUT /api/items/{id}` - Update item
- `PUT /api/items/{id}/purchase` - Mark item as purchased
- `DELETE /api/items/{id}` - Delete item

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/WishlistApp/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Wishlist Item Model

### Fields
- `id` - Unique identifier
- `name` - Item name (required)
- `description` - Item description
- `price` - Item price
- `priority` - Priority level (HIGH, MEDIUM, LOW)
- `status` - Item status (WANTED, PURCHASED, REMOVED)
- `category` - Item category (e.g., Electronics, Clothing, Books, Home, Food, etc.)
- `link` - URL/link to the item
- `notes` - Additional notes
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Price is stored as a decimal value
- Simple and straightforward implementation

