package dao;

import entity.Film;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("insertdao")
public interface Insertdao {
    int insert(Film film);
}
