/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.tags;

import edu.elon.business.Calculator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

/**
 *
 * @author Sabrina
 */
public class YearIteratorTag extends BodyTagSupport {
  
  private ArrayList<Calculator> calculatorList;
  private Iterator iterator;
  private Calculator calculator;
  
  @Override
    public int doStartTag() {
        Calculator calculator = (Calculator) pageContext.findAttribute("calculator");
        int arraySize = calculator.getYears();
        if (calculatorList.size() <= 0) {
            return SKIP_BODY;
        } else {
            return EVAL_BODY_BUFFERED;
        }
    }
    
    @Override
    public void doInitBody() throws JspException {
        iterator = calculatorList.iterator();
        if (iterator.hasNext()) {
           calculator = (Calculator) iterator.next();
           this.setCalculatorAttributes(calculator);
        }
    }
    
    private void setCalculatorAttributes(Calculator calculator) {
        pageContext.setAttribute(
                "itemYear", calculator.getYears());
        pageContext.setAttribute(
                "itemValue", calculator.getValue());
    }
    
    @Override
    public int doAfterBody() throws JspException {
        try {
            if (iterator.hasNext()) {
                calculator = (Calculator) iterator.next();
                this.setCalculatorAttributes(calculator);
                return EVAL_BODY_AGAIN;
            } else {
                JspWriter out = bodyContent.getEnclosingWriter();
                bodyContent.writeOut(out);
                return SKIP_BODY;
            }
        } catch (IOException ioe) {
            System.err.println("error in doAfterBody " + ioe.getMessage());
            return SKIP_BODY;
        }
    }
  
}
