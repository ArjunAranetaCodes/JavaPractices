# Shopping List Application

A simple full-stack shopping list management application with Angular frontend and Java Spring Boot backend for tracking shopping items with quantities, categories, and completion status.

## Project Structure

```
2025/ShoppingListApp/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete shopping items
- Track item quantities and units
- Item completion status (checked/unchecked)
- Categories for organizing items (Produce, Dairy, Meat, etc.)
- Priority levels (High, Medium, Low)
- Search items by name
- Filter by category, priority, and completion status
- Total items count and checked items count
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
cd 2025/ShoppingListApp/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8097`.

### API Endpoints

- `GET /api/items` - Get all shopping items
- `GET /api/items/{id}` - Get item by ID
- `GET /api/items/search?query={query}` - Search items by name
- `GET /api/items/status/{completed}` - Get items by completion status (true/false)
- `GET /api/items/category/{category}` - Get items by category
- `GET /api/items/priority/{priority}` - Get items by priority (HIGH, MEDIUM, LOW)
- `POST /api/items` - Create new item
- `PUT /api/items/{id}` - Update item
- `PUT /api/items/{id}/toggle` - Toggle item completion status
- `DELETE /api/items/{id}` - Delete item

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/ShoppingListApp/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Shopping Item Model

### Fields
- `id` - Unique identifier
- `name` - Item name (required)
- `quantity` - Item quantity
- `unit` - Unit of measurement (e.g., kg, lb, pcs, etc.)
- `priority` - Priority level (HIGH, MEDIUM, LOW)
- `completed` - Completion status (true/false)
- `category` - Item category (e.g., Produce, Dairy, Meat, etc.)
- `notes` - Additional notes
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple and straightforward implementation
