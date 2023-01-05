package com.photoz.photoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    /**
     * or write below without the @Autowired annotation ---> Dependency injection
     *
     * // constructor injection
    public PhotosController(@Autowired PhotosService photosService){
        this.photosService = photosService;
        //private List<Photos> db = List.of(new Photos("1","hello.jpg"));
    }
    **/
    @GetMapping("/home")
    public String hello(){

        return "hello world";
    }

    //Method to get all the photos in the database
    @GetMapping("/photos")
    private Collection<Photos> get(){

        return photosService.get();
    }

    //Method to get photos by ID
    @GetMapping("/photos/{id}")
    private Photos get(@PathVariable String id){

        Photos photo = photosService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND); // throws a not found error if the picture with that ID s not found
        return photo;
    }

    //Method for deleting pictures by ID.
    @DeleteMapping("/photos/{id}")
    private void delete(@PathVariable String id){
        Photos photo = photosService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    //Method for uploading the images.
    @PostMapping("/upload")  // Client looks at the endpoint /upload to fetch the images. e.g await fetch('http://localhost:8080/upload')
    private Photos create(@RequestPart("data") MultipartFile file) throws IOException {

        //photosService save method requires the filename and the bytes.The model --> "photos"
        // also has the same variables declared which needs to be supplied. values supplied below

        Photos photo = photosService.save(file.getOriginalFilename(), file.getBytes());
        return photo;
    }
}
