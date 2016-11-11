/*
 * Copyright 2016 Sabrina van der Gracht and Xenia Zantello (and Jourdan Parham)
 */
package edu.elon.controllers;

import edu.elon.business.Calculator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sabrina and Xenia (and Jourdan)
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
    String url = "/index.jsp";
    Calculator calculator = new Calculator();
    HttpSession session = request.getSession(false);
    if (session == null) {
      session = request.getSession(true);
    }
    //check action
    String action = request.getParameter("action");
    if (action == null) {
      url = "/index.jsp";
    } else if (action.equals("add")) {
      //get variables as strings
      String amountString = request.getParameter("amount");
      String interestString = request.getParameter("interest");
      String yearsString = request.getParameter("years");

        double amountDouble = Double.parseDouble(amountString);
        double interest = Double.parseDouble(interestString);
        int years = Integer.parseInt(yearsString);
        double valueDouble = calculator.calculateValue(amountDouble, interest, years);
        String yearChart = calculator.displayYears(amountDouble, interest, years);
        request.setAttribute("table",yearChart);
        
        calculator.setAmount(amountDouble);
        calculator.setInterest(interest);
        calculator.setYears(years);
        calculator.setValue(valueDouble);
        session.setAttribute("calculator", calculator);   
        
        url = "/future.jsp";
    }
    getServletContext().getRequestDispatcher(url).forward(request, response);
  }
}
