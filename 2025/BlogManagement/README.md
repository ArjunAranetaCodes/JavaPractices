# Blog Management System

A simple full-stack blog management application with Angular frontend and Java Spring Boot backend for creating, editing, and managing blog posts.

## Project Structure

```
2025/BlogManagement/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete blog posts
- Track blog post details: title, content, author, category, tags
- Post status (Draft, Published, Archived)
- Post categories (Technology, Lifestyle, Travel, Food, Health, Business, Education, Entertainment, Other)
- Tags for better organization
- Publication date and last modified date
- Featured post flag
- Reading time estimation
- Search posts by title, content, or tags
- Filter by status, category, and author
- Statistics dashboard (total posts, published posts, drafts, etc.)
- Beautiful card-based UI with rich content display
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
cd 2025/BlogManagement/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8101`.

### API Endpoints

- `GET /api/posts` - Get all blog posts
- `GET /api/posts/{id}` - Get post by ID
- `GET /api/posts/search?query={query}` - Search posts by title, content, or tags
- `GET /api/posts/status/{status}` - Get posts by status
- `GET /api/posts/category/{category}` - Get posts by category
- `GET /api/posts/author/{author}` - Get posts by author
- `POST /api/posts` - Create new post
- `PUT /api/posts/{id}` - Update post
- `DELETE /api/posts/{id}` - Delete post

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/BlogManagement/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Blog Post Model

### Fields
- `id` - Unique identifier
- `title` - Post title (required)
- `content` - Post content/body (required)
- `author` - Author name
- `category` - Post category (TECHNOLOGY, LIFESTYLE, TRAVEL, FOOD, HEALTH, BUSINESS, EDUCATION, ENTERTAINMENT, OTHER)
- `tags` - Comma-separated tags
- `status` - Post status (DRAFT, PUBLISHED, ARCHIVED)
- `publicationDate` - Publication date
- `readingTime` - Estimated reading time in minutes
- `featured` - Whether post is featured
- `excerpt` - Short excerpt/summary
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Date handling for publication dates
- Reading time calculation based on content length
- Simple and straightforward implementation


