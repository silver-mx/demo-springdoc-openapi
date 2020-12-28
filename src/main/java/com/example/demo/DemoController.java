package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("first-path")
public class DemoController {

    @Operation(summary = "GET example", description = "This is an example of a GET request.", tags = {
            "get-example" })
    /*@ApiResponses(value = { @ApiResponse(description = "successful operation", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = MyBody.class)) }) })*/
    @GetMapping(path = "second-path", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<MyBody> getSomething(@RequestParam("queryParam1") int x, @RequestParam("queryParam2") String y) {
        return new HttpEntity<>(new MyBody(x, y));
    }

    @Operation(summary = "POST example", description = "This is an example of a POST request.", tags = {
            "post-example" })
    @PostMapping(path = "second-path", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<MyBody> postSomething(@RequestBody MyBody body) {
        return new HttpEntity<>(body);
    }

}
