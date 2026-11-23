package com.aquib.food_zone.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    public LocalDateTime timestamp;
    public int status;
    public String error;
    public String path;
    public String message;
}
