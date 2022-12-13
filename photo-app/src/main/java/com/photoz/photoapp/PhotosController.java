package com.photoz.photoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotosController {

    private List<Photos> db = List.of(new Photos("1","hello.jpg"));

    @GetMapping("/home")
    public String hello(){

        return "hello world";
    }

    @GetMapping("/photos")
    private List<Photos> get(){

        return db;
    }
}
