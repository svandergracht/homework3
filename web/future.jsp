<%--Copyright 2016 Sabrina van der Gracht and Xenia Zantello (and Jourdan Parham)--%>

<%@ taglib prefix="elon" uri="/WEB-INF/tlds/elon.tld" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ include file="/includes/header.html" %>
      <h1>Future Value Calculator</h1>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="add">
        <label class="left">Investment Amount:</label>
        <span class="right"><elon:currencyFormat field="${calculator.amount}"/></span><br>
        <label class="left">Yearly Interest Rate:</label>
        <span class="right">${calculator.interest}</span><br>
        <label class="left">Number of Years:</label>
        <span class="right">${calculator.years}</span><br>
        <label class="left">Value:</label>
        <span class="right"><elon:currencyFormat field="${calculator.value}"/></span><br>
      </form>
        <div class="chartContainer">
          <p class="chartTitle">Year&emsp;&emsp;&emsp;&emsp;Value</p>
          <p class="chart">${calculator.formattedValueCount}</p>
        </div>
        <p class="return"><a href="/homework3/index.jsp">Return to calculator.</a></p>
    </main>
    <%@include file="/includes/footer.html" %>
