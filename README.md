# Palrent

**Palrent** is a web-based application designed for booking apartments in Palestine. It connects users with available rental properties, allowing property owners to list their apartments, and users to search and book accommodations in various cities and locations throughout Palestine.

## Mission Statement

Our mission is to provide a seamless platform for users to discover and book apartments while giving property owners an efficient way to list and manage their properties.

## Features

- **User Registration and Authentication**: Secure sign-up and login functionalities.
- **Property Listings**: Property owners can add, update, and delete apartment listings.
- **Search Functionality**: Users can search for apartments by location, price, and other criteria.
- **Booking System**: Users can book available apartments and view booking history.
- **Admin Dashboard**: Administrators can manage users, properties, and bookings.

## Overview

The Palrent application is built using:

- **Spring Boot**: Core framework for business logic and data management.
- **JSP (JavaServer Pages)**: For rendering web views.
- **MySQL**: Relational database for storing user, property, and booking data.

### Components

- **Frontend**: Web application using JSP and Bootstrap.
- **Backend**: Spring Boot application.
- **Database**: MySQL.
- **Authentication**: Managed with Spring Security.

## Technical Specifications

### Technologies Used

- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **Authentication**: Spring Security
- **Persistence**: Spring Data JPA

### System Requirements

- **Java Version**: 17 or later
- **Spring Boot Version**: 3.3.1
- **Database**: MySQL 8.0
- **Build Tool**: Maven

## Deployment

### Environment

- **Development**: Local development with an embedded database.
- **Staging**: Deploy on a staging server for testing.
- **Production**: Deploy on a cloud provider such as AWS or Azure.

### Build and Deploy

- **Build Tool**: Maven
- **Deployment**: Deploy using Docker or directly on a server.

## Security

### Authentication

- Spring security for user authentication.
- Secure password storage using bcrypt.

### Authorization

- Role-based access control (e.g., USER, ADMIN).
- Configured using Spring Security.

## Testing

### Unit Testing

- **Framework**: JUnit 5
- **Coverage**: Business logic, repository methods.

### Integration Testing

- **Framework**: Spring Boot Test
- **Coverage**: API endpoints, database interactions.


## Troubleshooting

### Common Issues

- **Database Connection Issues**: Check database URL and credentials.
- **Authentication Failures**: Ensure JWT token validity and configuration.

### Logging

- Use Spring Boot’s logging framework for debugging.

## Future Enhancements

- **Mobile Application**: Develop a mobile version of the platform.
- **Enhanced Search**: Implement advanced search features and filters.
- **User Reviews**: Add a review and rating system for properties.


