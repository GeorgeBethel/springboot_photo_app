package com.photoz.photoapp;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PhotosService {

    private Map<String, Photos> db = new HashMap<>(){{

        put("1", new Photos("1","hello.jpg"));
        put("2", new Photos("2","hello2.jpg"));
        put("3", new Photos("3","hello3.jpg"));

    }};

}
