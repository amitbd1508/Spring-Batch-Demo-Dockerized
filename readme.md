# Mini Project One
## Project Description 

<pre>
Task:

Implement a Restful service allowing an admin to trigger a batch job.

The batch job , reads a CSV file and writes its contents into Mysql DB after performing some conversion.

 

CSV file format:

First , last , GPA , AGE

String, String,Double, INT>0

 

Database table format:

First , last , GPA , DOB

String, String,Double, Date ( first day of the year)

 

Deliverable:

- You service should implement security, only admin can access it

- Your batch will be executed once , feel free to remove DB contents every time your app starts

- Docker your solution along with README.md file to explain how to run it

 

 

Hints:

Get familiar with:

- Spring MVC/Restful , ORM , Spring security ( optionally with JWT tokens)

- Spring Batch

- Docker and usage of docker-compose. Don’t create DB image , use docker hub

- Upload only source code files , put your CSV  file inside your  app image


</pre>

##Prerequisite
- [Docker](https://docs.docker.com/engine/install/)(https://docs.docker.com/engine/install/)

## Steps to run the project using docker

### Clone
- ``git clone https://github.com/amitbd1508/Spring-Batch-Demo-Dockerized.git``
- ``cd Spring-Batch-Demo-Dockerized``
### Build
``docker compose build``

### Run
``docker compose up ``

### [optional] Stop running container 
``docker compose down``

### Login credentials
- **Login Endpoint:**  http://localhost:8082/uaa/login

- **Request Body:**
``{
"email":"admin@admin.com",
"password":"123"
}``

### CSV processing 
- Endpoint: http://localhost:8082/processcsv
- **Note**: Add Authorization header with the Bearer token from login


## Team Member
1. Amit Ghosh (614170)
2. Mohammed Abdul Kadir (614722)
3. Sanaullah Al Real (614245)
