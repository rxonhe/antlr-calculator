# Calculator API

This is a simple calculator API built using Kotlin, Spring Boot, and ANTLR. It evaluates mathematical expressions and returns the result.

## Getting Started

To get started with the project, follow the instructions below.

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Node.js and npm

### Installation

1. Clone the repository to your local machine:

```shell
git clone https://github.com/your-username/calculator.git
```

2. Change into the project directory:

```shell
cd calculator
```

### Backend Setup

1. Build the backend using Gradle:

```shell
./gradlew build
```

2. Run the backend server:

```shell
./gradlew bootRun
```

The backend server will start running on `http://localhost:8080`.

### Frontend Setup

1. Change into the frontend directory:

```shell
cd frontend
```

2. Install the dependencies:

```shell
npm install
```

3. Start the frontend development server:

```shell
npm start
```

The frontend development server will start running on `http://localhost:3000`.

## API Usage

### Evaluate Expression

Certainly! Here are the updated use examples in a more concise and friendly format:

### Evaluate Mathematical Expressions

You can use the API to evaluate various mathematical expressions. Here are some examples:

**Endpoint**: `/calculator/evaluate`

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

---

The API allows you to evaluate mathematical expressions by sending a POST request to the `/calculator/evaluate` endpoint with the expression in the request body. The response will contain the evaluated result.

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue on the repository.

---

Feel free to customize the README file according to your project's specific details, such as project structure, additional endpoints, and any other relevant information.

Make sure to include the necessary sections, such as Getting Started, API Usage, Contributing, and License. Provide clear instructions for installation, running the backend and frontend, and examples of API usage.

If you have any specific requirements or need further assistance, please let me know!