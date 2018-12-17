package edu.ynmd.cms.service;

import edu.ynmd.cms.model.News;

import java.util.List;

public interface ManageService {

    public boolean addNews(News news);
    public boolean deletenews(String id);
    public boolean updateNews(News news);
    public News getNews(String id);
    public List<News> getNewsList();

}
