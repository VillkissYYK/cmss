package edu.ynmd.cms.service;

import edu.ynmd.cms.model.*;

import java.util.List;

public interface ManageService {

    public boolean addNews(News news);
    public boolean deletenews(String id);
    public boolean updateNews(News news);
    public News getNews(String id);
    public List<News> getNewsList();

    public boolean addCarousel(Carousel carousel);
    public boolean deleteCarousel(String id);
    public boolean updateCarousel(Carousel carousel);
    public Carousel getCarousel(String id);
    public List<Carousel> getCarouselList();

    public boolean addSinglepage(Singlepage singlepage);
    public boolean deleteSinglepage(String id);
    public boolean updateSinglepage(Singlepage singlepage);
    public Singlepage getSinglepage(String id);
    public List<Singlepage> getSinglepageList();

    public Users findUserByUsernameAndPassword(String username,String password);

    public String getCurrentUserId();
    public String getCurrentUserRole();

    //科目表
    public boolean addBook(Book book);
    public boolean deleteBook(String id);
    public boolean updateBook(Book book);
    public Book getBook(String id);
    public List<Book> getBookList();

    //教室
    public boolean addClassroom(Classroom classroom);
    public boolean deleteClassroom(String id);
    public boolean updateClassroom(Classroom classroom);
    public Classroom getClassroom(String id);
    public List<Classroom> getClassroomList();

    //班级
    public boolean addStudent(Student student);
    public boolean deleteStudent(String id);
    public boolean updateStudent(Student student);
    public Student getStudent(String id);
    public List<Student> getStudentList();

    //教师
    public boolean addTeacher(Teacher teacher);
    public boolean deleteTeacher(String id);
    public boolean updateTeacher(Teacher teacher);
    public Teacher getTeacher(String id);
    public List<Teacher> getTeacherList();



    //课程表-课程
//    public boolean addCourse(Course course);
//    public List<Course> getCourseByBook(String bookid);
//    public List<Course> getCourseByClassroom(String classroomid);
//    public List<Course> getCourseByStudent(String studentid);
//    public List<Course> getCourseByTeacher(String teacherid);
    public boolean addCourse(Course course);
    public boolean deleteCourse(String id);
    public boolean updateCourse(Course course);
    public Course getCourse(String id);
    public List<Course> getCourseList();

    public List<Course> getCourseByBook(String bookid);
    public List<Course> getCourseByClassroom(String classroomid);
    public List<Course> getCourseByStudent(String studentid);
    public List<Course> getCourseByTeacher(String teacherid);


    //接口声明
    public List<Course> findByBookLike(String book);






}
