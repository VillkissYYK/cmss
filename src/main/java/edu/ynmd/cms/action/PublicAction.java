package edu.ynmd.cms.action;

import edu.ynmd.cms.model.*;
import edu.ynmd.cms.service.ManageService;
import edu.ynmd.cms.tools.JwtUtil;
import edu.ynmd.cms.vo.Parmone;
import edu.ynmd.cms.vo.Parms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public List<Carousel> getCarouselList() throws Exception {
        return manageService.getCarouselList();
    }

    @GetMapping("getBookList")
    @ResponseBody
    public List<Book> getBookList() throws Exception {
        return manageService.getBookList();
    }


    @GetMapping("getClassroomList")
    @ResponseBody
    public List<Classroom> getClassroomList() throws Exception {
        return manageService.getClassroomList();
    }

    @GetMapping("getStudentList")
    @ResponseBody
    public List<Student> getStudentList() throws Exception {
        return manageService.getStudentList();
    }


    @GetMapping("getTeacherList")
    @ResponseBody
    public List<Teacher> getTeacherList() throws Exception {
        return manageService.getTeacherList();
    }

    @GetMapping("getCourseList")
    @ResponseBody
    public List<Course> getCourseList() throws Exception {
        return manageService.getCourseList();
    }


    @PostMapping("getCourseListByParm")
    @ResponseBody
    public List<Course> getCourseListByParm(@RequestBody Parms parms) throws Exception {
        List<Course> cl = new ArrayList();

        switch (parms.getKey()) {
            case "book":
                cl = manageService.getCourseByBook(parms.getValue());
                break;
            case "classroom":
                cl = manageService.getCourseByClassroom(parms.getValue());
                break;
            case "student":
                cl = manageService.getCourseByStudent(parms.getValue());
                break;
            case "teacher":
                cl = manageService.getCourseByTeacher(parms.getValue());
                break;
        }
        return cl;
    }



    @PostMapping("findByBookLike")
    @ResponseBody
    public List<Course> findByBookLike(@RequestBody String book)throws  Exception{
        return manageService.findByBookLike("'%"+book+"%'");
    }

//    @PostMapping("findByBookLike")
//    @ResponseBody
//    public List<Course> findByBookLike(String book){
//        return  manageService.findByBookLike("%"+book+"%");
//    }
}




















