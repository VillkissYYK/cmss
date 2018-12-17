package edu.ynmd.cms.service.impl;

import edu.ynmd.cms.dao.NewsDao;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private NewsDao newsDao;


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
}
