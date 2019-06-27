package edu.ynmd.cms.service.impl;

import edu.ynmd.cms.dao.*;
import edu.ynmd.cms.model.*;
import edu.ynmd.cms.service.ManageService;
import edu.ynmd.cms.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static java.sql.DriverManager.println;
import static javafx.beans.binding.Bindings.concat;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private CarouselDao carouselDao;

    @Autowired
    private Singlepagedao singlepagedao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private  CourseDao courseDao;



   @Autowired
   private ClassroomDao classroomDao;

   @Autowired
   private StudentDao studentDao;

   @Autowired
   private TeacherDao teacherDao;


    @Override
    public boolean addNews(News news) {

        try {
            newsDao.save(news);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean deletenews(String id) {
        try {
            newsDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }



    }

    @Override
    public boolean updateNews(News news) {
        try {
            newsDao.save(news);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public News getNews(String id) {

        return newsDao.findOne(id);
    }

    @Override
    public List<News> getNewsList() {

        return newsDao.findAll();
    }

    @Override
    public boolean addCarousel(Carousel carousel) {
        try {
            carouselDao.save(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCarousel(String id) {
        try {
            carouselDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCarousel(Carousel carousel) {
        try {
            carouselDao.save(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Carousel getCarousel(String id) {
        return carouselDao.findOne(id);
    }

    @Override
    public List<Carousel> getCarouselList() {
        return carouselDao.findAll();
    }

    @Override
    public boolean addSinglepage(Singlepage singlepage) {
        try {
            singlepagedao.save(singlepage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSinglepage(String id) {
        try {
            singlepagedao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSinglepage(Singlepage singlepage) {
        try {
            singlepagedao.save(singlepage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Singlepage getSinglepage(String id) {
        return singlepagedao.findOne(id);
    }

    @Override
    public List<Singlepage> getSinglepageList() {
        return singlepagedao.findAll();
    }

    @Override
    public Users findUserByUsernameAndPassword(String username, String password) {
        return usersDao.getUsersByUsernameAndPassword(username,password);
    }

    @Override
    public String getCurrentUserId() {
        String userid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (Tools.isNullOrSpace(userid)) {
            return null;
        } else {
            return userid;
        }

    }


    @Override
    public String getCurrentUserRole () {
        String role = null;
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();

        }

        if (Tools.isNullOrSpace(role)) {
            return null;
        } else {
            return role;
        }

    }

    @Override
    public boolean addBook(Book book) {
        try {
            bookDao.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(String id) {
        try {
            bookDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            bookDao.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book getBook(String id) {

        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBookList() {

        return bookDao.findAll();
    }
//教室
    @Override
    public boolean addClassroom(Classroom classroom) {
        try {
            classroomDao.save(classroom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteClassroom(String id) {
        try {
            classroomDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateClassroom(Classroom classroom) {
        try {
            classroomDao.save(classroom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Classroom getClassroom(String id) {
        return classroomDao.findOne(id);
    }

    @Override
    public List<Classroom> getClassroomList() {
        return classroomDao.findAll();
    }

    //学生
    @Override
    public boolean addStudent(Student student) {
        try {
            studentDao.save(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        try {
            studentDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            studentDao.save(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudent(String id) {
        return studentDao.findOne(id);
    }

    @Override
    public List<Student> getStudentList() {
        return studentDao.findAll();
    }
//教师

    @Override
    public boolean addTeacher(Teacher teacher) {
        try {
            teacherDao.save(teacher);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(String id) {
        try {
            teacherDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try {
            teacherDao.save(teacher);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Teacher getTeacher(String id) {
        return teacherDao.findOne(id);
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDao.findAll();
    }


    //课程表-book


//    @Override
//    public boolean addCourse(Course course) {
//        try {
//            courseDao.save(course);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }


    @Override
    public boolean addCourse(Course course) {
        try {
            courseDao.save(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String id) {
        try {
            courseDao.delete(id);
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        try {
            courseDao.save(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Course getCourse(String id) {
        return courseDao.findOne(id);
    }

    @Override
    public List<Course> getCourseList() {
        return courseDao.findAll();
    }

    @Override
    public List<Course> getCourseByBook(String bookid) {
        return courseDao.getCourseListByBook(bookid);
    }

    @Override
    public List<Course> getCourseByClassroom(String classroomid) {
        return courseDao.getCourseListByClassroom(classroomid);
    }

    @Override
    public List<Course> getCourseByStudent(String studentid) {
        return courseDao.getCourseListByStudent(studentid);
    }

    @Override
    public List<Course> getCourseByTeacher(String teacherid) {
        return courseDao.getCourseListByTeacher(teacherid);
    }






    @Override
    public List<Course> findByBookLike(String book) {
        book = "%"+book+"%";
//        String str = "%开%";
//        String str = "%"+book+"%";
        println(book);

        return courseDao.findByBookLike(book);
    }
}


