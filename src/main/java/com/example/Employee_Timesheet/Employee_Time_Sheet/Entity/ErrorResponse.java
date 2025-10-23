package com.example.Employee_Timesheet.Employee_Time_Sheet.Entity;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime localDateTime;
    private int code;
    private String message;

    public ErrorResponse(LocalDateTime localDateTime, int code, String message) {
        this.localDateTime = localDateTime;
        this.code = code;
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
