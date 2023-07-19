# ANTLR Calculator

This project features an NLP-based calculator API with a frontend interface. 
The backend, developed with Kotlin and Spring Boot, uses ANTLR for parsing and evaluating mathematical expressions expressed in natural language. 
The frontend, built with React, provides a user-friendly interface for inputting expressions and obtaining accurate results. This integration of technologies enables effortless interaction with the calculator, making complex calculations accessible through natural language queries.

## Getting Started

To get started with the project, follow the instructions below.

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Node.js and npm
- Docker
- Docker Compose

### Installation

1. Clone the repository to your local machine:

```shell
git clone https://github.com/rxonhe/antlr-calculator.git
```

### Setup Using Docker Compose

1. Build the services using Docker Compose:

```shell
docker-compose build
```

2. Run the services:

```shell
docker-compose up
```

The frontend will be accessible on `http://localhost:8080`, and the backend will be accessible on `http://localhost:8080/api`.

## API Usage

### Evaluate Mathematical Expressions

You can use the API to evaluate various mathematical expressions. Here are some examples:

**Endpoint**: `/api/v1/calculator/evaluate`

**Method**: `POST`

1. Simple Addition:
   - Expression: `2 + 2`
   - Result: `4`

2. Complex Expression with Multiple Operations:
   - Expression: `(2 + 3) * 4 - 6 / 2`
   - Result: `16`

3. Expression with Multiplication and Division:
   - Expression: `10 * 2 / 5`
   - Result: `4`

4. Expression with Parentheses:
   - Expression: `2 * (3 + 4)`
   - Result: `14`

5. Expression with Negative Numbers:
   - Expression: `-5 + 8`
   - Result: `3`

6. Text Expression with Numbers:
   - Expression: `"2 times 2 divided by 3"`
   - Result: `1.3333334`

Feel free to explore different mathematical expressions and test the capabilities of the calculator API.

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue on the repository.
