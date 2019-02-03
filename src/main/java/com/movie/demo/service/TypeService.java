package com.movie.demo.service;

import com.movie.demo.dao.TypeDAO;
import com.movie.demo.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("typeService")
public class TypeService {

    @Autowired
    private TypeDAO dao;

    public List<Type> list() {
        return dao.list();
    }
}
