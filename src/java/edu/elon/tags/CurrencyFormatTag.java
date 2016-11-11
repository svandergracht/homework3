/*
 * Copyright 2016 Xenia Zantello and Sabrina van der Gracht
 */
package edu.elon.tags;

import edu.elon.business.Calculator;
import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Sabrina
 */
public class CurrencyFormatTag extends TagSupport {
  
  private double field;
  private String valueFormatted;
  
  public void setField(double field) {
    this.field = field;
  }
  
  public void setValueFormatted(String valueFormatted) {
    this.valueFormatted = valueFormatted;
  }
  
    @Override
  public int doStartTag() throws JspException {
    NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    valueFormatted = moneyFormat.format(field);

    try {
      JspWriter out = pageContext.getOut();
      out.print(valueFormatted);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
    return SKIP_BODY;
  }
  
}
