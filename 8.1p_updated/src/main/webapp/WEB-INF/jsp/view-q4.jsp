<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Next Date Question</title></head>
<body>
<h2>Enter a date to find the next date</h2>
<form action="/q4" method="post">
    <label>Date (yyyy-MM-dd):</label>
    <input type="text" name="inputDate" required />
    <input type="hidden" name="action" value="q4" />
    <button type="submit">Submit</button>
</form>
</body>
</html>