package beQualified.utilities.enums;

import java.util.HashMap;
import java.util.Map;

public enum ErrorMessages {
    INVALID_USERNAME_OR_PASSWORD_ERROR("Epic sadface: Username and password do not match any user in this service"),
    EMPTY_USERNAME_ERROR("Epic sadface: Username is required"),
    EMPTY_PASSWORD_ERROR("Epic sadface: Password is required");


    private String errorMessage;

    ErrorMessages(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
