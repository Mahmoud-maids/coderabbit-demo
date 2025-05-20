package com.test.testing.dto;

import java.util.List;
import java.util.stream.Collectors;

public class NumbersDTO {
    private List<String> callerNumbers;
    
    private List<String> calledNumbers;

    public List<String> getCallerNumbers() {
        return callerNumbers.stream()
                .map(number -> {
                    if (number.startsWith(" ")) {
                        return "+" + number.trim();
                    }
                    return number;
                })
                .collect(Collectors.toList());
    }

    public void setCallerNumbers(List<String> callerNumbers) {
        this.callerNumbers = callerNumbers;
    }

    public List<String> getCalledNumbers() {
        return calledNumbers.stream()
                .map(number -> {
                    if (number.startsWith(" ")) {
                        return "+" + number.trim();
                    }
                    return number;
                })
                .collect(Collectors.toList());
    }

    public void setCalledNumbers(List<String> calledNumbers) {
        this.calledNumbers = calledNumbers;
    }
} 