/*
 * Copyright 2016 Jourdan Parham and Sabrina van der Gracht
 */
package edu.elon.controllers;

import edu.elon.business.Calculator;
import java.io.IOException;
import java.text.NumberFormat;
import static javax.management.Query.value;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sabrina and Jourdan
 */
public class CalculatorServlet extends HttpServlet {

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    //initialize message and url variables
    String message = "";
    String url = "/index.jsp";
    NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    //check action
    String action = request.getParameter("action");
    if (action == null) {
      url = "/index.jsp";
    } else if (action.equals("add")) {
      //get variables as strings
      String amountString = request.getParameter("amount");
      String interestString = request.getParameter("interest");
      String yearsString = request.getParameter("years");

      //create variables to check for doubles
      boolean amountBoolean = isDouble(amountString);
      boolean interestBoolean = isDouble(interestString);
      boolean yearsBoolean = isInteger(yearsString);

      if (amountBoolean == true && interestBoolean == true && yearsBoolean == true) {
        //set double variables
        double amountDouble = Double.parseDouble(amountString);
        double interest = Double.parseDouble(interestString);
        int years = Integer.parseInt(yearsString);
        double valueDouble = calculateValue(amountDouble, interest, years);
        
        //format money
        /*String amount = moneyFormat.format(amountDouble);
        String value = moneyFormat.format(valueDouble);*/
        
        Calculator calculator = new Calculator();
        calculator.setAmount(amountDouble);
        calculator.setInterest(interest);
        calculator.setYears(years);
        calculator.setValue(valueDouble);
        request.setAttribute("calculator", calculator);
        
        url = "/future.jsp";
      } else {
        message = "Please enter valid numbers for each field.";
        url = "/index.jsp";
      }
    }
    getServletContext().getRequestDispatcher(url).forward(request, response);

  }

  private boolean isDouble(String s) {
    try {
      Double.parseDouble(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
  
  private boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
  
  private double calculateValue(double principle, double percent, int time) {
    double rate = percent/100;
    double n = 1 + rate;
    double power = Math.pow(n, time);
    double value = principle * power;
    return value;
  }
}
