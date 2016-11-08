<%--Copyright 2016 Jourdan Parham and Sabrina van der Gracht--%>

<%@ taglib prefix="elon" uri="/WEB-INF/tlds/elon.tld" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ include file="/includes/header.html" %>
      <h1>Future Value Calculator</h1>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="add">
        <%--jsp:useBean id="calculator" scope="request" class="edu.elon.business.Calculator"/--%>
        <label>Investment Amount:</label>
        <span><%--jsp:getProperty name="calculator" property="amount"/--%><elon:currencyFormat field="${calculator.amount}"/></span><br>
        <label>Yearly Interest Rate:</label>
        <span><%--jsp:getProperty name="calculator" property="interest"/--%>${calculator.interest}</span><br>
        <label>Number of Years:</label>
        <span><%--jsp:getProperty name="calculator" property="years"/--%>${calculator.years}</span><br>
        <label>Value:</label>
        <span><%--jsp:getProperty name="calculator" property="value"/--%><elon:currencyFormat field="${calculator.value}"/></span><br>
      </form>
    </main>
    <%@include file="/includes/footer.html" %>
