# Ecom Catalog API

**Ecom Catalog API** is a lightweight Spring Boot RESTful service for managing product catalogs in e‑commerce prototypes. It supports full CRUD for products, keyword search across product fields, and image upload/retrieval — all using an in‑memory H2 database for rapid development and demo purposes.

---

## Key Features

* Create, read, update, and delete products (CRUD)
* Upload and serve product images (binary storage in DB)
* Keyword search across name, description, brand, and category
* Auto-loaded sample data at startup for immediate testing
* Clear REST endpoints designed for frontend integration or quick demos

---

## Product Model (summary)

Each product contains the following core fields:

* `id` — integer identifier
* `name` — product name
* `description` — detailed description
* `brand` — brand name
* `price` — numeric price value
* `category` — product category
* `releaseDate` — release or launch date
* `productAvailable` — boolean availability flag
* `stockQuantity` — integer stock count
* `imageName` — original image file name
* `imageType` — image MIME type
* `imageDate` — binary image data

---

## API Endpoints

All endpoints are prefixed with `/api`.

* **GET** `/api/products` — List all products
* **GET** `/api/product/{id}` — Get product by ID
* **POST** `/api/product` — Add product (multipart: product JSON + `imageFile`)
* **PUT** `/api/product/{id}` — Update product (multipart: product JSON + `imageFile`)
* **DELETE** `/api/product/{id}` — Delete product
* **GET** `/api/products/search?keyword=...` — Search products by keyword
* **GET** `/api/product/{productId}/image` — Download product image (binary)

### Example: Add Product (curl)

```bash
curl -X POST "http://localhost:8080/api/product" \
  -F "product={\"name\":\"Ford Mustang\",\"brand\":\"Ford\",\"price\":35000}" \
  -F "imageFile=@/path/to/image.jpg;type=image/jpeg"
```

---

## Architecture Overview

* **Controller Layer**: Handles HTTP requests and multipart payloads, returns proper HTTP responses.
* **Service Layer**: Encapsulates business logic, validation, image handling, and search operations.
* **Repository Layer**: Spring Data JPA repositories for DB access (H2 by default).
* **Model Layer**: JPA entity representing products and image metadata.

The app uses a simple, modular design that makes it easy to swap the in‑memory DB for a persistent one and extend functionality (orders, users, authentication) later.

---

## Getting Started (Local)

### Prerequisites

* Java 21+ installed
* Maven (`mvn`) available on PATH

### Run the application

From the project root:

```bash
./mvnw spring-boot:run
# or
mvn spring-boot:run
```

The API will be available at `http://localhost:8080/api`.

---

## Sample Data

`src/main/resources/data1.sql` contains sample car products that are loaded automatically at startup to help with quick manual testing.

---

## Extending the Project

Ideas for production hardening and features:

* Replace H2 with a persistent DB (MySQL, PostgreSQL) and add migrations (Flyway/Liquibase)
* Add authentication/authorization for admin and user roles
* Move image storage to a file system or cloud storage (S3) and store references in DB
* Add pagination, filtering, and sorting for product listings
* Add Swagger/OpenAPI documentation and request validation

---

## Tests

Run backend tests with Maven:

```bash
mvn test
```

---

## Technologies

**Java 21, Spring Boot 3.3, Spring Data JPA, Spring Web, H2 Database, Lombok, Maven**

---

