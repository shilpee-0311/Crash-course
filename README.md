🧩 Crash Course Management System
A scalable Spring Boot REST API for managing crash courses, built with clean architecture and real-world business logic.

🎯 Project Objective
Build a backend platform that allows:

📘 Mentors to create and manage short-term educational courses

🧑‍🎓 Students to register and enroll in those courses

✅ The system to track course capacity, enrollment status, and handle validations

Inspired by platforms like Udemy and Coursera, this project simulates how education tech systems manage dynamic enrollments and mentor-student interactions.

⚙️ Tech Stack
Layer	Tech
🧠 Language	Java
🔧 Backend Framework	Spring Boot
💾 ORM	Spring Data JPA (Hibernate)
🗃️ Database	MySQL / PostgreSQL (configurable)
🧬 Architecture	Layered (Controller → Service → Repository → Entity)
📦 Data Transfer	DTOs & Mappers
🚨 Exception Handling	Custom (NotFoundException)
🧪 Testing	(Optional) JUnit / Mockito (To be added)

📚 Modules & Features
1. 🧑‍🎓 Student Module
Register, update, fetch, and delete students

Clean data using StudentDto

Auto-validation & 404 error handling via StudentService and NotFoundException

http
Copy
Edit
GET /students/{id} → Fetch student by ID
2. 👨‍🏫 Mentor Module
Add mentors

Each course is assigned one mentor

MentorRepository ensures only valid mentors are mapped

3. 📘 Course Module
Create and retrieve course info

Key fields:

name, description, capacity, price, mentor, status, startDate, enrollmentEndDate

Controlled states with CourseStatus enum

Linked to mentors using CourseMapper

4. 📝 Enrollment Module
Enroll students into courses

Validations include:

🕐 Enrollment date < Course start date

❌ Capacity check before saving

Tracked with EnrollmentStatus enum (ACTIVE, COMPLETE, CANCELLED)

Mapped using EnrollmentMapper

🔄 Sample Data Flow
mermaid
Copy
Edit
sequenceDiagram
    actor Student
    Student->>+EnrollmentController: Enroll in course (POST)
    EnrollmentController->>EnrollmentMapper: Map DTO to Entity
    EnrollmentMapper->>StudentRepository: Find Student
    EnrollmentMapper->>CourseRepository: Find Course
    EnrollmentMapper-->>Enrollment: Create Enrollment Object
    EnrollmentController->>EnrollmentService: Validate & Save
    EnrollmentService->>EnrollmentRepository: Save to DB
    EnrollmentRepository-->>Student: Confirmation Response
📊 Highlights & Unique Features
✅ Controlled Status States

CourseStatus & EnrollmentStatus enums for robust data modeling

✅ Exception Safety

NotFoundException prevents crashing on missing data

✅ DTO + Mapper Architecture

Ensures clean separation of concerns and future flexibility

✅ Business Logic Validation

Course capacity check

Date validations for enrollment

✅ Query Methods

findByStudentAndStatus() for filtered views

countByCourse() for capacity management

🛠️ Future Enhancements
🔐 Spring Security Integration for authentication/authorization

🌐 Swagger/OpenAPI for API documentation

💻 Frontend in React or Angular

📈 Analytics Dashboard for mentors/students

🧪 Unit & Integration Testing with JUnit/Mockito

🚀 Getting Started
Clone the Repository
bash
Copy
Edit
git clone https://github.com/your-username/crash-course-management.git
cd crash-course-management
Run the App
Make sure you have Java & Maven installed.

bash
Copy
Edit
./mvnw spring-boot:run
📁 Project Structure
pgsql
Copy
Edit
com.example.spring_boot
├── controller
├── service
├── repository
├── entities
├── dto
├── enums
├── mapper
└── exception

👨‍💻 Author

Shilpee Srivastava
Passionate about backend development, clean code, and building scalable enterprise solutions.
📫 LinkedIn | 🌐 Portfolio
