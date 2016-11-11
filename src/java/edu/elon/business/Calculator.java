/* Copyright 2016 Xenia Zantello and Sabrina van der Gracht (and Jourdan Parham)*/

package edu.elon.business;

import java.io.Serializable;

/**
 *
 * @author Sabrina
 */
public class Calculator implements Serializable {

  private double amount;
  private double interest;
  private int years;
  private double value;
  private String formattedValueCount;

  //no argument constructor
  public Calculator() {
  }

  //get and set methods
  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getInterest() {
    return interest;
  }

  public void setInterest(double interest) {
    this.interest = interest;
  }

  public int getYears() {
    return years;
  }

  public void setYears(int years) {
    this.years = years;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public double calculateValue(double principle, double percent, int time) {
    double rate = percent / 100;
    double n = 1 + rate;
    double power = Math.pow(n, time);
    double value = principle * power;
    return value;
  }
  
  public String displayYears(double principle, double percent, int time) {
    double yearValue;
    String yearNumber;
    formattedValueCount = String.format("%3s%20s", "Year", "Value\n");
    for (int i = 1; i < time; i++) {
    yearNumber = "" + i;
    yearValue = calculateValue(principle, percent, i);
    formattedValueCount = formattedValueCount + String.format("%3s%20.2f%1s", yearNumber, yearValue, "\n");
    }
    return formattedValueCount;
  }

}
