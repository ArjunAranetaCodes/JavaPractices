# Product Catalog Application

A full-stack web application for managing a product catalog, built with Java Spring Boot backend and Angular frontend.

## Features

- **Product Management**: Create, read, update, and delete products
- **Search Functionality**: Search products by name
- **Category Filtering**: Filter products by category
- **Modern UI**: Beautiful and responsive user interface
- **RESTful API**: Clean REST API for product operations

## Tech Stack

### Backend
- Java 11
- Spring Boot 2.7.14
- Spring Data JPA
- H2 Database (in-memory)
- Maven

### Frontend
- Angular 15
- TypeScript
- RxJS
- HTML5/CSS3

## Project Structure

```
ProductCatalog/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/product/
│   │   │   │   ├── ProductCatalogApplication.java
│   │   │   │   ├── controller/
│   │   │   │   │   └── ProductController.java
│   │   │   │   ├── model/
│   │   │   │   │   └── Product.java
│   │   │   │   ├── repository/
│   │   │   │   │   └── ProductRepository.java
│   │   │   │   └── service/
│   │   │   │       └── ProductService.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   └── pom.xml
└── frontend/
    ├── src/
    │   ├── app/
    │   │   ├── components/
    │   │   │   ├── product-list/
    │   │   │   └── product-form/
    │   │   ├── models/
    │   │   │   └── product.model.ts
    │   │   ├── services/
    │   │   │   └── product.service.ts
    │   │   ├── app.component.ts
    │   │   └── app.module.ts
    │   ├── index.html
    │   ├── main.ts
    │   └── styles.css
    ├── angular.json
    ├── package.json
    └── tsconfig.json
```

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Node.js 16+ and npm
- Angular CLI 15

## Setup Instructions

### Backend Setup

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

   The backend will start on `http://localhost:8080`

4. Access H2 Console (optional):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:productcatalogdb`
   - Username: `sa`
   - Password: (leave empty)

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
   npm start
   ```

   The frontend will start on `http://localhost:4200`

## API Endpoints

### Products

- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/category/{category}` - Get products by category
- `GET /api/products/search?name={name}` - Search products by name
- `POST /api/products` - Create a new product
- `PUT /api/products/{id}` - Update a product
- `DELETE /api/products/{id}` - Delete a product

### Product Model

```json
{
  "id": 1,
  "name": "Product Name",
  "description": "Product Description",
  "price": 99.99,
  "quantity": 10,
  "category": "Electronics"
}
```

## Usage

1. Start both backend and frontend servers
2. Open your browser and navigate to `http://localhost:4200`
3. Use the interface to:
   - View all products
   - Search for products
   - Filter by category
   - Add new products
   - Edit existing products
   - Delete products

## Categories

The application supports the following product categories:
- Electronics
- Clothing
- Books
- Food
- Sports
- Home
- Other

## Development

### Backend Development
- The backend uses Spring Boot DevTools for hot reloading
- H2 database is in-memory and resets on application restart
- API documentation can be accessed via the endpoints

### Frontend Development
- Angular CLI is used for development
- Hot reload is enabled by default
- The frontend communicates with the backend via HTTP requests

## License

This project is for educational purposes.
