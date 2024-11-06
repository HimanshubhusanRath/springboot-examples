# Spring Boot - Basic Security
* This project covers the basic security (form-login, http basic auth, role based access) in Spring boot applications.
* Using Spring security, we are able to achieve the below security in the project.
  * 'http://localhost:8080/not-secure/msg' --> This is not secured and accessible to all (without getting authenticated).
  * 'http://localhost:8080/secure/msg' --> This is a secured URL and accessible to all logged-in users only (irrespective of the roles).
  * 'http://localhost:8080/secure/admin/msg' --> This is a secured URL and accessible only to the logged-in users having a 'ADMIN' role.

### Spring Boot Version: 2.7.11