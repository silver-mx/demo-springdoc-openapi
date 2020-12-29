package com.example.demo;

import java.time.Instant;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@Builder
@Jacksonized
public class MyBody {

    /*
     * See more constraints at
     * https://docs.jboss.org/hibernate/validator/6.1/reference/en-US/html_single/#
     * section-builtin-constraints
     */

    @Min(1)
    @Max(5)
    private final int x;

    @NotBlank
    private final String y;

    @NotNull
    @FutureOrPresent
    private final Instant z;
}
