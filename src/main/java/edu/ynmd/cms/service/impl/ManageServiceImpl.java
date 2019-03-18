package edu.ynmd.cms.service.impl;

import edu.ynmd.cms.dao.CarouselDao;
import edu.ynmd.cms.dao.NewsDao;
import edu.ynmd.cms.dao.Singlepagedao;
import edu.ynmd.cms.dao.UsersDao;
import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Singlepage;
import edu.ynmd.cms.model.Users;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
