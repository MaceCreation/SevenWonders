package com.seven.wonders.pojo.entity;

/**
 * Created by user on 02.04.2017.
 */
public abstract class AbstractWonder {

    // FIELDS
    private Long id;

    private String name;

    //CONSTRUCTORS

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}