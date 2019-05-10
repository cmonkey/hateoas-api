package org.excavator.hateoas.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    private String firstName;
    private String secondName;
    private Duration dateOfBirth;
    private String profession;
    private int salary;
}
