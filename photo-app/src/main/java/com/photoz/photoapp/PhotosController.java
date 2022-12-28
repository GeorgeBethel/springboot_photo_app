package com.photoz.photoapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {

    private final PhotosService photosService;

    public PhotosController(PhotosService photosService){
        this.photosService = photosService;
    //private List<Photos> db = List.of(new Photos("1","hello.jpg"));
}
    @GetMapping("/home")
    public String hello(){

        return "hello world";
    }

    @GetMapping("/photos")
    private Collection<Photos> get(){

        return db.values();
    }

    @GetMapping("/photos/{id}")
    private Photos get(@PathVariable String id){

        Photos photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    private void delete(@PathVariable String id){
        Photos photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/photos")
    private Photos create(@RequestPart("data") MultipartFile file) throws IOException {
        Photos photo = new Photos();
        photo.setId(UUID.randomUUID().toString());
        photo.setFilename(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }
}
