package com.test.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TesterDTO {
    private Long testerId;

    private String testerName;

    private String testerNumber;
}
