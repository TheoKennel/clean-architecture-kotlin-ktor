# Backend Clean Architecture Kotlin / Ktor 

This project is a backend application built using Ktor, following Clean Architecture principles and integrating Firebase as the database. The project is designed with a factory pattern to support multiple databases. You can easily switch the database by changing the value of `DATABASE` in `utils/constants` to the desired database type and then init the good one in KtorApplication.

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
  - [User](#user)
  - [Custom Dex](#custom-dex)
    - [Get](#get)
    - [Save](#save)
  - [Dex](#dex)
  - [Shiny](#shiny)
  - [Counters](#counters)
- [Notes](#notes)
- [License](#license)

## Requirements

- Kotlin
- Ktor
- Firebase SDK
- A Firebase project with Realtime Database enabled

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/TheoKennel/clean-architecture-kotlin-ktor.git
    cd backend-clean-archi-ktor
    ```

2. Open the project in your preferred IDE (IntelliJ IDEA is recommended).

## Configuration

1. Create a `.env` file in the `main/resources` directory.

2. Add your Firebase credentials and database URL to the `.env` file:

    ```
    FIREBASE_SDK = /path/to/your/db-credential.json
    DATABASE_URL = https://your-database-url.firebaseio.com
    ```

## Running the Application

    The application will start and be accessible at `http://localhost:8080`.

## Project Structure

- `app/src/main/kotlin`: Contains the main source code for the application.
  - `domain`: Contains the domain models and use cases.
  - `data`: Contains the data repositories and Firebase integration.
  - `presenter`: Contains the controllers, request handling logic and ktor configuration.
  - `di`: Contains the dependency injection modules.
  - `utils`: Contains constants.
- `app/src/main/resources`: Contains the resources, including the `.env` file for configuration.

## API Endpoints

### User

- `DELETE /user/{id}`: Delete a user by ID.
- `GET /user`: Get all users.
- `GET /user/{id}`: Get a user by ID.
- `POST /user`: Create a new user.
- `PATCH /user/{id}`: Update a user by ID.

### Custom Dex

#### Get

- `GET /custom-dex/get/{id}`: Get a custom dex by user ID.
- `GET /custom-dex/get/{id}/{name}`: Get a custom dex by user ID and name.
- `GET /custom-dex/get/{id}/{name}/first-filter-list`: Get the first filter list of a custom dex.
- `GET /custom-dex/get/{id}/{name}/pkm-catch`: Get the Pokémon catch list of a custom dex.
- `GET /custom-dex/get/{id}/{name}/pkm-list`: Get the Pokémon list of a custom dex.
- `GET /custom-dex/get/{id}/{name}/second-filter-list`: Get the second filter list of a custom dex.

#### Save

- `PATCH /custom-dex/save/name/{id}/{name}`: Save or update the name of a custom dex.
- `PATCH /custom-dex/save/first-filter/{id}/{name}`: Save or update the first filter list of a custom dex.
- `PATCH /custom-dex/save/first-filter-name/{id}/{name}`: Save or update the first filter name of a custom dex.
- `PATCH /custom-dex/save/pkm-catch/{id}/{name}`: Save or update the Pokémon catch list of a custom dex.
- `PATCH /custom-dex/save/pkm-list/{id}/{name}`: Save or update the Pokémon list of a custom dex.
- `PATCH /custom-dex/save/second-filter-list/{id}/{name}`: Save or update the second filter list of a custom dex.
- `PATCH /custom-dex/save/second-filter-name/{id}/{name}`: Save or update the second filter name of a custom dex.

### Dex

- `GET /dex/{id}`: Get the main dex by user ID.
- `PATCH /dex/{id}`: Save or update the main dex by user ID.

### Shiny

- `GET /shiny/{id}`: Get the shiny catch list by user ID.
- `PATCH /shiny/{id}`: Save or update the shiny catch list by user ID.

### Counters

- `GET /counters/{id}`: Get the counter by ID.
- `PATCH /counters/{id}`: Save or update the counter by ID.

## Notes

- Ensure that your Firebase credentials file (`db-credential.json`) is correctly referenced in the `.env` file.
- Make sure your Firebase Realtime Database rules are properly configured to allow read and write operations as needed by your application.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Feel free to contribute to this project by opening issues or submitting pull requests.

Happy coding!
