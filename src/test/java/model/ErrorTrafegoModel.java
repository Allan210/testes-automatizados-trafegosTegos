package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ErrorTrafegoModel {
    @Expose
    private String message;
}
