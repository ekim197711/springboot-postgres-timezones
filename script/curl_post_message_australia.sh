curl -d '{"message":"Hi from demo4", "datetime": "2020-08-02 14:23", "timezone": "Australia/Perth"}' \
-H "Content-Type: application/json" \
"localhost:8090/api/message"