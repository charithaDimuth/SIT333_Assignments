<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Previous Date Question</title></head>
<body>
<h2>Enter a date to find the previous date</h2>
<p style="color:green;">${message}</p>

<form action="/q5" method="post">
    <label>Date (yyyy-MM-dd):</label>
    <input type="text" name="inputDate" required />
    <button type="submit">Submit</button>
</form>
</body>
</html>