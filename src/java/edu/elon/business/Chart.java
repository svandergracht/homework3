/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sabrina
 */
public class Chart implements Serializable {
  private Calculator calculator;
  private ArrayList<Calculator> calculatorList;
  
  public Chart() {
    calculatorList = new ArrayList<Calculator>();
  }
  
  public Calculator getCalculator() {
    return calculator;
  }
  
  public void setCalculator(Calculator calculator) {
    this.calculator = calculator;
  }
  
  public ArrayList<Calculator> getCalculatorList() {
    return calculatorList;
  }
  
  public void addValues(Calculator calculator) {
    int time = calculator.getYears();
    double principle = calculator.getAmount();
    double rate = calculator.getInterest();
    for (int i = 0; i <= time; i++) {
      double newValue = calculator.calculateValue(principle,rate,time);
      calculator.setValue(newValue);
      calculatorList.add(calculator);
    }
  }
  
}
