package com.spring.market.online_market.entities;

import java.util.ArrayList;
import java.util.List;

public class NewsListener implements Listener{

    private List<User> users;
    private String news;

    public NewsListener() {
        users = new ArrayList<>();
    }

    public void setNews(String news) {
        this.news = news;
        notifyUser();
    }

    @Override
    public void notifyUser() {
        for (User users : users)
            users.update(news);
    }
}
