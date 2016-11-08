/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
  
}
