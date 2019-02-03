package com.movie.demo.dao;

import com.movie.demo.entity.Type;
import org.springframework.stereotype.Repository;

@Repository("typeDAO")
public class TypeDAO extends AbstractDAO<Integer, Type> {
}
