package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Car")
public class Car {

  @Id
  @GeneratedValue
  private Long id;

  private String brand;
  private int year;
  private String color;

  public Car() {}

  public Car(Long id, String brand, int year, String color) {
    this.id = id;
    this.brand = brand;
    this.year = year;
    this.color = color;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
