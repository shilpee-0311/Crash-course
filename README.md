🔧 Project Overview: Crash Course Management System

🎯 Purpose
To manage online or offline crash courses where students can:

View available courses

Enroll in a course

Track the course status

Admins (or instructors) can:

Add new courses

Update course information

Track enrollments

📁 Main Components
1. Course
Represents a crash course offered.

Fields: id, courseName, description, status, projectName (if added).

Status is managed using an enum (CourseStatus) like ACTIVE, INACTIVE, etc.

2. Enrollment
Represents a student enrolling in a course.

Contains references to course and student details.

Handles status of enrollment.

🔄 Architecture Layers
✅ Entity Layer
Course.java and Enrollment.java: Define the data models that are mapped to the database.

✅ DTO (Data Transfer Objects)
CourseDto.java, EnrollmentDto.java: Used to transfer data between layers while hiding internal details.

✅ Repository Layer
CourseRepository.java: Interface for database operations on courses.

✅ Service Layer
CourseService.java: Contains business logic for creating, updating, and managing courses.

✅ Controller Layer
CourseController.java, EnrollmentController.java: Handle HTTP requests (e.g., create course, enroll in course) and route them to the service layer.

✅ Mapper
CourseMapper.java: Converts between Course entity and CourseDto.

🌟 Key Features
Add new crash courses

Update course details (like status, description, or project name)

Enroll students in courses

List or filter courses by status

Map DTOs to entities and vice versa for cleaner architecture

🛠 Technologies Likely Used
Spring Boot: For backend REST API

Java: Language

JPA/Hibernate: For ORM/database interaction

PostgreSQL/MySQL: Likely for data storage

REST API: For handling requests (e.g., enroll, list courses)

