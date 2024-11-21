Here’s a summary of the points in markdown with checkboxes:

- [x] **IDE Requirement**: Use NetBeans IDE for the lab.

- [x] **Application Structure**: The program should have two Java files:
  - [x] **CreateUserAccount.java**: Main application class containing logic from Exercise 5D, managing the program’s flow.
  - [x] **UserAccount.java**: Object class that creates user account objects with name, email, and password (from Exercise 5A).

- [x] **Email Validation**:
  - [x] Email must include an "@" symbol and be unique.
  - [x] Prevent user from proceeding until a valid email is provided.

- [x] **Data Storage**:
  - [x] Avoid parallel arrays.
  - [x] Each user account should be stored as an object, with a maximum of 20 entries allowed.

- [ ] **User Actions**:
  - [ ] **Add Option**: Show error if the database is full; otherwise, collect email, name, and password for new records. Prevent duplicate emails.
  - [ ] **Change Option**: Show error if the database is empty; otherwise, request the existing email and a new password to update records. Prevent changing non-existent emails.
    - [ ] **Question**: How should we implement this? Could I have a view the users, or view all users then select the user you want to modify.

- [ ] **Constraints**:
  - [x] No record deletions.
  - [ ] Output the array’s contents after each transaction or based on user choice.
  - [ ] Implementing a "Quit" function is optional.

- [ ] **Design & Output**: Add ASCII design with system details in the output.