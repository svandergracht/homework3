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
  //private double[] amountList;

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
  
  public String getFormattedValueCount() {
    return formattedValueCount;
  }
  
  public void setFormattedValueCount(String formattedValueCount) {
    this.formattedValueCount = formattedValueCount;
  }
  
  /*public double[] getAmountList() {
    return amountList;
  }
  
  public void setAmountList(double[] amountList) {
    this.amountList = amountList;
  }*/

  public double calculateValue(double principle, double percent, int time) {
    double rate = percent / 100;
    double n = 1 + rate;
    double power = Math.pow(n, time);
    double value = principle * power;
    return value;
  }
  
  public String displayYears(double principle, double percent, int time) {
    double yearValue;
    //double[] amountList = new double[time];
    
    /*for (int i = 0; i<time; i++) {
      double currentAmount = calculateValue(principle, percent, time);
      amountList[i] = currentAmount;
    }*/
    String yearNumber;
    formattedValueCount = "";
    for (int i = 1; i <= time; i++) {
    yearNumber = "" + i + "&emsp;&emsp;&emsp;&emsp;";
    yearValue = calculateValue(principle, percent, i);
    formattedValueCount = formattedValueCount + String.format("%3s%1s%20.2f", yearNumber, "$", yearValue) + "<br>";
    }
    return formattedValueCount;
    //return amountList;
  }

}
