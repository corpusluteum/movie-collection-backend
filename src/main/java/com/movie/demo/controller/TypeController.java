package com.movie.demo.controller;

import com.movie.demo.entity.Type;
import com.movie.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping("/types")
    public ResponseEntity<List<Type>> getTypes() {
        List<Type> typeList = this.service.list();
        return new ResponseEntity<List<Type>>(typeList, HttpStatus.OK);
    }
}
