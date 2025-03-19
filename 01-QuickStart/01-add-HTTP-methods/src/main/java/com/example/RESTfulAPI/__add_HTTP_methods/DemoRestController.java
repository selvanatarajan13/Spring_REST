package com.example.RESTfulAPI.__add_HTTP_methods;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class DemoRestController {

    @GetMapping()
    public String getMethod() {
        return "This endpoint was called Get method";
    }

    @PostMapping()
    public String getPostMethod() {
        return "This endpoint was called Post method";
    }

    @PutMapping()
    public String getPutMethod() {
        return "This endpoint was called Put method";
    }

    @DeleteMapping()
    public String getDeleteMethod() {
        return "This endpoint was called Delete method";
    }
}
