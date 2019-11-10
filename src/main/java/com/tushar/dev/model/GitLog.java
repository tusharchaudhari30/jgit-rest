package com.tushar.dev.model;


public class GitLog {

    private String id;
    private String username;
    private String email;
    private String body;
    private String message;

    public GitLog(String id, String username, String email, String body, String message) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.body = body;
        this.message = message;
    }

    public GitLog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
