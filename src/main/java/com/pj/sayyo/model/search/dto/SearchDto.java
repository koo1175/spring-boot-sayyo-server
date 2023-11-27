package com.pj.sayyo.model.search.dto;

public class SearchDto {

    private String title;
    private int count;

    @Override
    public String toString() {
        return "SearchDto{" +
                "keyword='" + title + '\'' +
                ", count=" + count +
                '}';
    }

    public String getKeyword() {
        return title;
    }

    public void setKeyword(String keyword) {
        this.title = keyword;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}