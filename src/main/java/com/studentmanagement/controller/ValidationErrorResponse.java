package com.studentmanagement.controller;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter

public class ValidationErrorResponse {
    private List<Violation> violations = new ArrayList<>();

    public List<Violation> getViolations() {
        return violations;
    }

}
