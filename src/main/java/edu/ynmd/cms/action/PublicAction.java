package edu.ynmd.cms.action;

import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Users;
import edu.ynmd.cms.service.ManageService;
import edu.ynmd.cms.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("public")
public class PublicAction {


    @Autowired
    private ManageService manageService;


    @PostMapping("login")
    @ResponseBody
    public HashMap login(@RequestBody Users users) throws Exception {
        HashMap m = new HashMap();
        Users u = manageService.findUserByUsernameAndPassword(users.getUsername(), users.getPassword());

        if (u != null) {

            String token = JwtUtil.generateToken(u.getRole(), u.getUserid());


            m.put("msg", "ok");
            m.put("token", token);

        } else {
            m.put("msg", "error");
        }

        return m;

    }

    @GetMapping("getNewsList")
    @ResponseBody
    public List<News> getNewsList() throws Exception {

        return manageService.getNewsList();
    }

    @GetMapping("getCarouselList")
    @ResponseBody
    public  List<Carousel> getCarouselList() throws Exception{
        return manageService.getCarouselList();
    }

}




