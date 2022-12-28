package com.photoz.photoapp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;

public class Photos {

    public Photos() {
    }

    public Photos(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    private String id;

    @JsonIgnore
    private byte [] data;

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

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

    @NotEmpty
    private String filename;

}
