package com.pj.sayyo.model.issue.dto;

public class IssueDto {
    private String search;
    private String title;
    private String link;
    private String image;
    private String content;

    private String magazine;

    private String wrotetime;

    private String newsLogo;

    private int importScore;

    private int loadScore;
    private String accuracy;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMagazine() {
        return magazine;
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
    }

    public String getWrotetime() {
        return wrotetime;
    }

    public void setWrotetime(String wrotetime) {
        this.wrotetime = wrotetime;
    }

    public String getNewsLogo() {
        return newsLogo;
    }

    public void setNewsLogo(String newsLogo) {
        this.newsLogo = newsLogo;
    }

    public int getImportScore() {
        return importScore;
    }

    public void setImportScore(int importScore) {
        this.importScore = importScore;
    }

    public int getLoadScore() {
        return loadScore;
    }

    public void setLoadScore(int loadScore) {
        this.loadScore = loadScore;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }
}
