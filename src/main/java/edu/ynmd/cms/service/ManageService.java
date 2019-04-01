package edu.ynmd.cms.service;

import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Singlepage;
import edu.ynmd.cms.model.Users;

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

}
