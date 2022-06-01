package com.sih.kheloindia;

import java.io.Serializable;

public class purposal_modal implements Serializable {
    String cost;
    String doa;
    String just;
    String location;

    public purposal_modal(String cost, String name_project, String status, String name_applicant) {
        this.cost = cost;
        this.name_project = name_project;
        this.status = status;
        this.name_applicant = name_applicant;
    }

    public purposal_modal() {
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    public String getJust() {
        return just;
    }

    public void setJust(String just) {
        this.just = just;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName_applicant() {
        return name_applicant;
    }

    public void setName_applicant(String name_applicant) {
        this.name_applicant = name_applicant;
    }

    public String getCompletiontime() {
        return completiontime;
    }

    public void setCompletiontime(String completiontime) {
        this.completiontime = completiontime;
    }

    public purposal_modal(String cost, String doa, String just, String location, String name_project, String owner, String mob, String postal, String sport, String stage, String status, String userid, String area, String name_applicant, String completiontime) {
        this.cost = cost;
        this.doa = doa;
        this.just = just;
        this.location = location;
        this.name_project = name_project;
        this.owner = owner;
        this.mob = mob;
        this.postal = postal;
        this.sport = sport;
        this.stage = stage;
        this.status = status;
        this.userid = userid;
        this.area = area;
        this.name_applicant = name_applicant;
        this.completiontime = completiontime;
    }

    String name_project;
    String owner;
    String mob;
    String postal;
    String sport;
    String stage;
    String status;
    String userid;
    String area;
    String name_applicant;
    String completiontime;
}
