🧩 Project Title: Crash Course Management System

🎯 Objective:
To build a backend REST API that manages short-term (crash) courses, where students can enroll, mentors can manage their assigned courses, and the system tracks enrollments, course capacities, and statuses in a structured, scalable way.

⚙️ Tech Stack:

Language: Java

Framework: Spring Boot

Database: (Assumed: MySQL/PostgreSQL — can be mentioned if implemented)

JPA: For ORM and database interactions

DTOs & Mappers: For clean data flow

Exception Handling: Custom (NotFoundException)

Architecture: Layered (Controller → Service → Repository → Entity)

📚 Modules & Features
1. 🧑‍🎓 Student Module
Add, update, fetch, and delete students.

Validates student existence using StudentService.

DTOs ensure clean request/response data.

Example:

GET /students/{id} → fetches student by ID.

Throws NotFoundException if student doesn’t exist.

2. 👨‍🏫 Mentor Module
Mentors can be added and linked to courses.

Each course has one assigned mentor.

Managed using MentorRepository.

3. 📘 Course Module
Create and fetch course details.

Fields: name, description, duration, capacity, price, mentor, status (ACTIVE, COMPLETE, CANCELLED), start date, enrollment end date.

Ensures only existing mentors are linked using CourseMapper.

4. 📝 Enrollment Module
Students can enroll in courses.

Validations include:

Enrollment date must be before course start date.

Course capacity must not be exceeded.

Status options: ACTIVE, COMPLETE, CANCELLED.

🔄 Data Flow Example:
A student sends a request to enroll in a course via EnrollmentController.

The EnrollmentDto is passed to EnrollmentMapper.

The mapper fetches the student and course entities using repositories.

EnrollmentService checks for course capacity and date logic.

If valid, enrollment is saved via EnrollmentRepository.

📊 Highlights & Unique Features:
Used Enums for maintaining controlled state of CourseStatus and EnrollmentStatus.

Created custom exception (NotFoundException) to handle entity absence cleanly.

Mappers separate logic between DTOs and entities, improving maintainability.

Repository methods like findByStudentAndStatus() enable powerful filtering.

✅ Impact:
Mimics real-world education platforms like Udemy or Coursera (backend).

Clean layered structure makes it scalable and production-ready.

Can be easily extended with authentication (Spring Security) and frontend (React, Angular).
