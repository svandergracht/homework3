<%--Copyright 2016 Sabrina van der Gracht and Xenia Zant (Jourdan Parham)--%>
<%@ include file="/includes/header.html" %>
      <h1>Future Value Calculator</h1>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="add">
        <label>Investment Amount</label>
        <input type="number" min="0" name="amount" value="${calculator.amount}" required><br>
        <label>Yearly Interest Rate</label>
        <input type="number" min="0" name="interest" value="${calculator.interest}" required><br>
        <label>Number of Years</label>
        <input type="number" min="0" name="years" placeholder="Integer number of years" value="${calculator.years}" required><br>
        <input type="submit" value="Calculate" id="button"/>
      </form>
    </main>
    <%@include file="/includes/footer.html" %>
