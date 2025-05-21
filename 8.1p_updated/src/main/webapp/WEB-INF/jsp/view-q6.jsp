<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Gravitational Force</title></head>
<body>
<h2>Calculate Gravitational Force</h2>
<p style="color:green;">${message}</p>

<form action="/q6" method="post">
    <label>Mass 1 (kg):</label>
    <input type="text" name="mass1" required /><br/>
    <label>Mass 2 (kg):</label>
    <input type="text" name="mass2" required /><br/>
    <label>Distance (m):</label>
    <input type="text" name="distance" required /><br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>