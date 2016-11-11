/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.tags;

import edu.elon.business.Calculator;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author Sabrina
 */
public class YearIteratorTag extends BodyTagSupport {
  
  private ArrayList<Calculator> amountArray;
  private Iterator iterator;
  private Calculator calculator;
  
  @Override
    public int doStartTag() {
        Calculator calculator = (Calculator) pageContext.findAttribute("calculator");
        int arraySize = calculator.getYears();
        if (amountArray.size() <= 0) {
            return SKIP_BODY;
        } else {
            return EVAL_BODY_BUFFERED;
        }
    }
    
    @Override
    public void doInitBody() throws JspException {
        iterator = amountArray.iterator();
        if (iterator.hasNext()) {
           // calculator = (C) iterator.next();
           // this.setItemAttributes(item);
        }
    }
  
}
