## Build
``docker compose build``

## Run
``docker compose up ``

## Docker down 
``docker compose down``

## Login credentials
``{
"email":"admin@admin.com",
"password":"123"
}``
 ``url : http://localhost:8082/uaa/login``

## CSV processing endpoint 
``http://localhost:8082/processcsv``
Add Authorization header with the Bearer token from login
