
package controller;

        import org.apache.ibatis.annotations.Insert;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
        import service.InsertService;
        import util.JsonResult;

        import javax.annotation.Resource;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
@RequestMapping("/test")
@Controller
public class Controle {
    @Resource
    InsertService insertService;

    @ResponseBody
    @RequestMapping("/test.do")
    public JsonResult listStock(int page) {
        /* 第一次错误执行，回滚*/
        int result1=insertService.insert(404);
        /* 第二次正确执行*/
        int result2=insertService.insert(200);
        return new JsonResult(result2);
    }

}
