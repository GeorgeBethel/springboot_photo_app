package com.photoz.photoapp;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotosService {

    // A hardcoded database using Hashmaps
    private Map<String, Photos> db = new HashMap<>(){{

        put("1", new Photos("1","hello.jpg"));
        put("2", new Photos("2","hello2.jpg"));
        put("3", new Photos("3","hello3.jpg"));

    }};

    //Gets all the pictures in the database
    public Collection<Photos> get() {

        return db.values();
    }

    //Gets pictures by ID
    public Photos get(String id) {

        return db.get(id);
    }

    //Remove picture by ID
    public Photos remove(String id) {

        return  db.remove(id);
    }

    //Service method for saving uploaded pictures the database
    public Photos save(String fileName, byte[] data) {
        Photos photo = new Photos();
        photo.setId(UUID.randomUUID().toString());  // randomly generates the ID
        photo.setFilename(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo); //Inserts the file into the database
        return photo;

    }
}
