package com.discovery.models;

import java.time.LocalDateTime;

public class ServiceRecord {

    private String url;
    private boolean status;

    private LocalDateTime timestamp;

    public ServiceRecord(String url, boolean status, LocalDateTime timestamp) {
        this.url = url;
        this.status = status;
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
