package com.eval2.newapp.models;

public class ApiResponse {
    public class Message {
        String status;
        String content;
        
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
    }
    Message message;

    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }
}
