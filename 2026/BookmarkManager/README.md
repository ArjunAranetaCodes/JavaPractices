# Bookmark Manager

A Java + Angular app to save and organize bookmarks (title, URL, category, notes).

## Features

- Add, edit, delete bookmarks
- Filter by category, search by title/URL/notes
- Open link in new tab

## Tech Stack

- **Backend:** Java 11, Spring Boot 2.7, JPA, H2 (port 8084)
- **Frontend:** Angular 15

## Run

**Backend**
```bash
cd 2026/BookmarkManager/backend
mvn spring-boot:run
```

**Frontend**
```bash
cd 2026/BookmarkManager/frontend
npm install
npm start
```

Open http://localhost:4200

## API

- `GET /api/bookmarks` – list all
- `GET /api/bookmarks/{id}` – get one
- `GET /api/bookmarks/category/{category}` – by category
- `GET /api/bookmarks/search?q=...` – search
- `POST /api/bookmarks` – create
- `PUT /api/bookmarks/{id}` – update
- `DELETE /api/bookmarks/{id}` – delete

## H2 Console

http://localhost:8084/h2-console  
JDBC URL: `jdbc:h2:mem:bookmarkdb`  
User: `sa`  
Password: (empty)
