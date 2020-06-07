curl -d '{"message":"Hi from demo5", "datetime": "2020-08-02 14:23", "timezone": "Europe/Copenhagen"}' \
-H "Content-Type: application/json" \
"localhost:8090/api/message"