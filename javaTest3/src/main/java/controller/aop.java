package controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Aspect
public class aop {
    @Autowired
    Insert insert;
    @Before("bean(insertService)")
    public void beTest(){
        insert.startInsert();
    }
    @After("bean(insertService)")
    public void afTest(){
        insert.endInsert();
    }

}
class BeforeInsertFilmEvent extends ApplicationEvent {

    public BeforeInsertFilmEvent(Object source) {
        super(source);
        System.out.println("After Insert Film Data");
    }
}
class AfterInsertFilmEvent extends ApplicationEvent {
    public AfterInsertFilmEvent(Object source) {
        super(source);
        System.out.println("After Insert Film Data");
    }
}

@Component("insert")
class Insert {
    @Autowired
    private ApplicationContext applicationContext;  //容器事件由容器触发

    public void startInsert(){
        BeforeInsertFilmEvent event = new BeforeInsertFilmEvent(applicationContext);
        applicationContext.publishEvent(event);
    }
    public void endInsert(){
        AfterInsertFilmEvent event = new AfterInsertFilmEvent(applicationContext);
        applicationContext.publishEvent(event);
    }
}