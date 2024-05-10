# CRUD REST APIs Using Spring Boot, PostgreSQL

A complete example of a "CRUD" service built with SpringBoot + PostgreSQL


#### REST Service

|HTTP Method|URL|Description|
|---|---|---|
|`POST`|http://localhost:8080/api/student | Create new Student |
|`PUT`|http://localhost:8080/api/student/{id} | Update Student by ID |
|`GET`|http://localhost:8080/api/student | Get Student List |
|`GET`|http://localhost:8080/api/student/{id} | Get Student by ID |
|`DELETE`|http://localhost:8085/api/student/{id} | Delete Student by ID |
|`GET`|http://localhost:8085/api/student?name="{value}"&studentClass="{value}" | Search Student with Name or class |
