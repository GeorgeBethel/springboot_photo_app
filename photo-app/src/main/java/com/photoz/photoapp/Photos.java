package com.photoz.photoapp;

public class Photos {

    public Photos() {
    }

    public Photos(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private String filename;


}
