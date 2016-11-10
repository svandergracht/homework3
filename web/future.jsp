<%--Copyright 2016 Jourdan Parham and Sabrina van der Gracht--%>

<%@ taglib prefix="elon" uri="/WEB-INF/tlds/elon.tld" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ include file="/includes/header.html" %>
      <h1>Future Value Calculator</h1>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="add">
        <label>Investment Amount:</label>
        <span><elon:currencyFormat field="${calculator.amount}"/></span><br>
        <label>Yearly Interest Rate:</label>
        <span>${calculator.interest}</span><br>
        <label>Number of Years:</label>
        <span>${calculator.years}</span><br>
        <label>Value:</label>
        <span><elon:currencyFormat field="${calculator.value}"/></span><br>
      </form>
    </main>
    <%@include file="/includes/footer.html" %>
