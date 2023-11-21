
# Hospital Management System

## Overview

This project is a Hospital Management System developed for individual use. The system is built using Java with JDBC for database connectivity and SQL for database operations. The primary aim of this project is to facilitate reception purposes within a hospital environment.

## Features

- **View Patients:** Display a list of registered patients along with their details.
- **View Doctors:** Show a list of available doctors with their specialties and contact information.
- **Book Appointment:** Schedule appointments for patients with respective doctors or departments.
- **Check Doctor Availability:** Check the availability schedule for specific doctors.
- **Add Patient Information:** Add new patients details.

## Project Setup

### Requirements

- Java Development Kit (JDK)
- JDBC Driver
- SQL Database (e.g., MySQL, PostgreSQL)

### Installation Steps

1. **Clone the Repository:**
    ```
    git clone https://github.com/yourusername/hospital-management.git
    ```
2. **Set Up Database:**
    - Create the necessary database tables using the provided SQL script.
    - Configure the JDBC connection string in the project code (`src/main/java/yourpackage/DatabaseConnection.java`).

3. **Compile and Run:**
    ```
    javac Main.java
    java Main
    ```

## Usage

- **View Patients:**
    - Access the "View Patients" feature to see the list of registered patients.

- **View Doctors:**
    - Use the "View Doctors" functionality to display available doctors along with their specialties and contact information.

- **Book Appointment:**
    - Schedule appointments for patients. Follow the prompts to select the patient, doctor, and appointment date/time.

- **Check Doctor Availability:**
    - Check the schedule availability for specific doctors before booking appointments.

- **Add/Edit Patient Information:**
    - Add new patients or modify existing patient details as required.

## Contributing

This project is an individual effort and is not open for external contributions at this time.

## License

This project is licensed under the [MIT License](LICENSE).

---
