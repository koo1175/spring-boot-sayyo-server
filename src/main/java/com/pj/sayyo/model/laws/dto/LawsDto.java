package com.pj.sayyo.model.laws.dto;

public class LawsDto {
    private String name;
    private String link;
    private String tryDate;
    private String kindOfLaw;
    private String promulgation;
    private String changes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTryDate() {
        return tryDate;
    }

    public void setTryDate(String tryDate) {
        this.tryDate = tryDate;
    }

    public String getKindOfLaw() {
        return kindOfLaw;
    }

    public void setKindOfLaw(String kindOfLaw) {
        this.kindOfLaw = kindOfLaw;
    }

    public String getPromulgation() {
        return promulgation;
    }

    public void setPromulgation(String promulgation) {
        this.promulgation = promulgation;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
