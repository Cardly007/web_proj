package com.blogger.blogger_box_backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(
        name = "Hello wolrd Apis",
        description = "apis"
)
public class HelloController {

    @GetMapping("/yo")
    @Operation( description = " yo api")
    public String SayHEllo()
    {
        return "Hello World";
    }

    @GetMapping("/say-hello/{name}")
    public  String sayHelloV1(@PathVariable String name){
        return "V2 -" + name;

    }

    @GetMapping("/say-hello")
    public  String sayHelloV2(@RequestParam String name){
        return "V2 -" + name;

    }



}
