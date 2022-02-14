package model;

import java.util.Date;

public class loggEntry {
    private String message;
    private String author;
    private Date createdAt;

    public loggEntry(String message, String author) {
        this.message = message;
        this.author = author;
        this.createdAt = new Date();
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "loggEntry{" +
                "message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
