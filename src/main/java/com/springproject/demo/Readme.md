
# JWT Authentication with Roles in Spring Boot

## Overview

This guide provides step-by-step instructions to implement JWT authentication with two roles: **USER** and **ADMIN**. This will enable you to authenticate users and restrict access to certain parts of your API based on their roles.

## Steps Overview

1. Setting Up Dependencies
2. Creating User Entity with Roles
3. Creating a Repository to Fetch Users
4. Setting Up the Authentication Service
5. Generating JWT Tokens with Role Information
6. Creating a JWT Filter to Validate Tokens
7. Securing Endpoints Based on Roles
8. Testing with Postman

## 1. Setting Up Dependencies

First, make sure you have the following dependencies in your `pom.xml` (if you're using Maven):

```xml
<dependencies>
    <!-- Spring Boot and Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- JWT for Token Creation and Validation -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.9.1</version>
    </dependency>

    <!-- JPA for interacting with the database -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL or H2 for database -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- Lombok (optional, for reducing boilerplate code) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>

```

## Overview of JWT Authentication in Spring Boot
In a Spring Boot application, JWT is commonly used for securing RESTful APIs. This approach eliminates the need for server-side session storage, as all user information is encoded in the JWT itself. Here’s how the process typically works:

1. User logs in with credentials.

2. Server validates the credentials.

3. Server generates a JWT token and sends it back to the client.

4. Client stores the JWT and sends it with each request. 

5. Server validates the JWT with each request.

## Breakdown of JWT Process
Client Sends Credentials: The client sends a request with the username and password to the server (via the AuthController).

Authentication Process: The server retrieves the credentials through the AuthController. It then uses the JwtAuthenticationFilter to authenticate the user by checking the provided credentials.

JWT Token Generation: If the authentication is successful, the filter generates a JWT token using the JwtUtil.

Response with Token: The JWT token is sent back in the response header to the client.

Token Storage: The client can save this token locally (e.g., in local storage or cookies).

Subsequent Requests: For future requests, the client includes the JWT in the Authorization header to access protected resources without needing to re-enter credentials.

## Example for Subsequent Requests
Admin Access Using JWT

Initial Login:

The admin logs into the admin panel by entering their username and password.
The server verifies the credentials and generates a JWT, which is sent back to the admin's client (web browser or application).
Storing the JWT:

The admin’s client stores the JWT (e.g., in local storage or cookies).
Accessing Protected Functions:

Whenever the admin wants to perform an action that requires authentication (like viewing books, managing categories, etc.), they do not need to enter their password again.
Instead, the client includes the JWT in the Authorization header of each request for those actions. For example:
http
Copy code
GET /api/admin/books
Authorization: Bearer <jwt_token>
Server Processing:

The server checks the Authorization header for the JWT:
If valid and not expired, the server processes the request, allowing the admin to view or manage books or categories.
If the JWT is invalid or expired, the server will return an error (e.g., 401 Unauthorized), and the admin will need to log in again to obtain a new token.

## Class Details

1. SecurityConfig
Purpose: This class configures Spring Security for the application.

Role:

Defines the security rules, such as which endpoints are publicly accessible and which require authentication.
Configures the authentication manager with in-memory user details for demonstration purposes.
Specifies stateless session management to ensure that no session is stored on the server.
Registers the JwtAuthenticationFilter, which will handle JWT authentication during login requests.
2. JwtUtil
Purpose: This is a utility class for creating and validating JWT tokens.

Role:

generateToken(String username): Creates a JWT for a given username.
createToken(Map<String, Object> claims, String subject): Builds the JWT with claims (optional metadata), subject (the username), issue time, and expiration time.
validateToken(String token, String username): Checks if the token is valid by comparing the username and ensuring the token is not expired.
extractUsername(String token): Retrieves the username from the JWT.
isTokenExpired(String token): Checks if the JWT has expired.
3. JwtAuthenticationFilter
Purpose: This filter intercepts login requests to authenticate users.

Role:

attemptAuthentication(HttpServletRequest request, HttpServletResponse response): Tries to authenticate the user by extracting the username and password from the request and passing them to the authentication manager.
successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult): If authentication is successful, this method generates a JWT token and adds it to the response header for the client to use in subsequent requests.
4. AuthController
Purpose: This is the controller that handles authentication-related endpoints.

Role:

login(@RequestBody AuthRequest authRequest): Receives login requests containing a username and password. It authenticates the user and, upon success, returns a JWT token to the client.
5. AuthRequest
Purpose: A simple data transfer object (DTO) for holding authentication request details.

Role:

Contains the fields for username and password, along with their getters and setters. This class is used in the login method of the AuthController to bind the request body.
6. JwtRequestFilter (additional)
Purpose: A filter that validates the JWT on each incoming request.

Role:

Checks the Authorization header for a JWT token.
Validates the token using the JwtUtil.
If valid, retrieves the user details and sets the security context to allow the user to access secured resources.

## Final Overview
In a Spring Boot application, JWT is commonly used for securing RESTful APIs. This approach eliminates the need for server-side session storage, as all user information is encoded in the JWT itself. Here’s how the process typically works:

1. User logs in with credentials.

2. Server validates the credentials.

3. Server generates a JWT token and sends it back to the client.

4. Client stores the JWT and sends it with each request.

5. Server validates the JWT with each request.