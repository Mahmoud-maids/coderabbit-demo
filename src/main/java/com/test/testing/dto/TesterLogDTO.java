package com.test.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TesterLogDTO {
    private Long logId;

    private Long testerId;

    private String source;

    private String target;
}
