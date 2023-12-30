BookStore Project :


GET API : curl -X GET http://localhost:8080/books/1
GET API : curl -X GET http://localhost:8080/books/all
POST API :
curl -X POST -H "Content-Type: application/json" -d "{\"title\": \"Deepak's IT comapany\", \"author\": \"Deepak\", \"genre\": \"Fiction\"}" http://localhost:8080/books
