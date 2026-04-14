# Contact Manager

A Java + Angular app to manage contacts with names, emails, phone numbers, companies, and favorites.

## Features

- Add, edit, delete contacts
- Fields: first name, last name, email, phone, company, job title, notes, favorite flag
- Search by name or email
- Filter by company text
- Toggle view for favorites only

## Tech Stack

- **Backend:** Java 11, Spring Boot 2.7, Spring Web, Spring Data JPA, H2 (port 8093)
- **Frontend:** Angular 15

## Run

### Backend

```bash
cd 2026/ContactManager/backend
mvn spring-boot:run
```

Backend runs on `http://localhost:8093`.

### Frontend

```bash
cd 2026/ContactManager/frontend
npm install
npm start
```

Frontend runs on `http://localhost:4200`.

## API

Base path: `/api/contacts`

- `GET /api/contacts` – list all
- `GET /api/contacts/{id}` – get by id
- `GET /api/contacts/search?q=...` – search by last name
- `GET /api/contacts/company?q=...` – search by company
- `GET /api/contacts/favorites` – favorites only
- `POST /api/contacts` – create
- `PUT /api/contacts/{id}` – update
- `DELETE /api/contacts/{id}` – delete

## H2 Console

- URL: `http://localhost:8093/h2-console`
- JDBC URL: `jdbc:h2:mem:contactdb`
- User: `sa`
- Password: _empty_

