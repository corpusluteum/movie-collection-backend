package com.movie.demo.dao;

import com.movie.demo.entity.Language;
import org.springframework.stereotype.Repository;

@Repository("languageDAO")
public class LanguageDAO extends AbstractDAO<Integer, Language> {
}

