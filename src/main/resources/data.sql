-- Users
INSERT INTO users(username, password, role) VALUES ('likhitha', 'pass12345', 'STUDENT');
INSERT INTO users(username, password, role) VALUES ('sridevi', 'pass12345', 'INSTRUCTOR');
INSERT INTO users(username, password, role) VALUES ('meghana', 'admin12345', 'ADMIN');

-- Students
INSERT INTO student(name, email) VALUES ('Likhitha', 'likhitha@email.com');
INSERT INTO student(name, email) VALUES ('Ram', 'ram@email.com');

-- Courses
INSERT INTO course(title, description, instructor_id) VALUES ('Spring Boot Basics', 'Learn Spring Boot step by step', 2);

-- Enrollments
INSERT INTO enroll(student_id, course_course_id) VALUES (1, 1);
