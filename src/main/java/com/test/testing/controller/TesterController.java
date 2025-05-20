package com.test.testing.controller;

import com.test.testing.dto.TesterDTO;
import com.test.testing.dto.TesterLogDTO;
import com.test.testing.dto.NumbersDTO;
import com.test.testing.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tester")
public class TesterController {
    private final TesterService testerService;

    @Autowired
    public TesterController(TesterService testerService) {
        this.testerService = testerService;
    }

    @PostMapping
    public ResponseEntity<?> addTester(@RequestBody TesterDTO testerDTO) {
        return ResponseEntity.ok(testerService.addTester(testerDTO));
    }

    @PostMapping("/add-log")
    public ResponseEntity<?> addLog(@RequestBody TesterLogDTO testerLogDTO) {
        return ResponseEntity.ok(testerService.addLog(testerLogDTO));
    }

    @GetMapping
    public ResponseEntity<?> getTesters() {
        return ResponseEntity.ok(testerService.getTesters());
    }

    @GetMapping("/numbers/params")
    public ResponseEntity<Map<String, List<String>>> getNumbersWithParams(
            @RequestParam(value = "callerNumbers") List<String> callerNumbers,
            @RequestParam(value = "calledNumbers") List<String> calledNumbers) {
        Map<String, List<String>> response = new HashMap<>();
        
        response.put("callerNumbers", callerNumbers);
        response.put("calledNumbers", calledNumbers);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/numbers/dto")
    public ResponseEntity<Map<String, List<String>>> getNumbersWithDTO(NumbersDTO numbersDTO) {
        Map<String, List<String>> response = new HashMap<>();
        response.put("callerNumbers", numbersDTO.getCallerNumbers());
        response.put("calledNumbers", numbersDTO.getCalledNumbers());
        return ResponseEntity.ok(response);
    }
}
