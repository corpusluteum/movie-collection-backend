package com.movie.demo.controller;

import com.movie.demo.entity.Language;
import com.movie.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LanguageController {

    @Autowired
    private LanguageService service;

    @GetMapping("/languages")
    public ResponseEntity<List<Language>> getLanguages() {
        List<Language> languageList = this.service.list();
        return new ResponseEntity<List<Language>>(languageList, HttpStatus.OK);
    }
}
