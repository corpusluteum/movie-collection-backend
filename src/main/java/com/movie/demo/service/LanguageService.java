package com.movie.demo.service;

import com.movie.demo.dao.LanguageDAO;
import com.movie.demo.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("languageService")
public class LanguageService {

    @Autowired
    private LanguageDAO dao;

    public List<Language> list() {
        return dao.list();
    }

}
