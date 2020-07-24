<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Flights</title>
</head>
<body>

<h2>Compete Reservation</h2>

<form action="completeReservation" method="post">
		<pre>
			<h2> Passenger Details</h2>
			me="securityCode" />

			<input type="hidden" name="flightId" value="${flight.id}" />
			<input type="submit" value="Confirm" />
		</pre>
</form>

</body>
</html>