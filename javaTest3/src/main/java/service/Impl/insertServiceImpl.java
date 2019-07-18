package service.Impl;

import dao.Insertdao;
import entity.Film;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import service.InsertService;


import javax.annotation.Resource;
@Transactional
@Service("insertService")
public class insertServiceImpl implements InsertService {
    @Resource
    Insertdao insertdao;
    @ResponseBody
    public int insert(int code) {
        if (code != 200) {
            Film film = new Film();
            film.setTitle("test1");
            film.setLanguageid(1);
            insertdao.insert(film);
            System.out.println("成功");
            return 0;
        } else if (code == 200) {
            Film film = new Film();
            film.setTitle("test1");
            film.setDescription("test2");
            film.setLanguageid(1);
            insertdao.insert(film);
            System.out.println("成功");
            return 1;
        }
        return 0;
    }
}
