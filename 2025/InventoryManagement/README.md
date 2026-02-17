# Inventory Management System

A simple full-stack inventory management application with Angular frontend and Java Spring Boot backend for tracking products and stock levels.

## Project Structure

```
2025/InventoryManagement/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete products
- Track product details: name, description, SKU, category, price, quantity, supplier, location
- Product categories (ELECTRONICS, CLOTHING, FOOD, BOOKS, TOYS, SPORTS, HOME, BEAUTY, OTHER)
- Stock level tracking with low stock alerts
- Price management
- Supplier information
- Warehouse location tracking
- Search products by name, SKU, or description
- Filter by category, supplier, and stock status
- Statistics dashboard (total products, low stock items, total value)
- Beautiful card-based UI with stock indicators
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
cd 2025/InventoryManagement/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8103`.

### API Endpoints

- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/search?query={query}` - Search products by name, SKU, or description
- `GET /api/products/category/{category}` - Get products by category
- `GET /api/products/supplier/{supplier}` - Get products by supplier
- `GET /api/products/low-stock` - Get low stock products (quantity < 10)
- `GET /api/products/out-of-stock` - Get out of stock products
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/InventoryManagement/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Product Model

### Fields
- `id` - Unique identifier
- `name` - Product name (required)
- `description` - Product description
- `sku` - Stock Keeping Unit (SKU) code
- `category` - Product category (ELECTRONICS, CLOTHING, FOOD, BOOKS, TOYS, SPORTS, HOME, BEAUTY, OTHER)
- `price` - Product price
- `quantity` - Current stock quantity
- `supplier` - Supplier name
- `location` - Warehouse location
- `minStockLevel` - Minimum stock level for alerts (default: 10)
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Low stock threshold is set to 10 units by default
- Simple and straightforward implementation
