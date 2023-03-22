package org.example.Homework;

public class CustomException extends RuntimeException
{
    public CustomException(String errorMessage, Throwable cause)
    {
        super(errorMessage, cause);
    }
}
