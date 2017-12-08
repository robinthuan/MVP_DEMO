package com.example.administrator.mvp_demo.mvp.model;

/**
 * Created by administrator on 12/8/17.
 */

public class People {
  Name name;
  String gender;
  String phone;
  Picture picture;

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Picture getPicture() {
    return picture;
  }

  public void setPicture(Picture picture) {
    this.picture = picture;
  }
}
