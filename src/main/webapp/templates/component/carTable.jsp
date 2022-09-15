<table>
	<tr>
		<th>
			ID
		</th>
		<th>
			Model
		</th>
		<th>
			Year
		</th>
		<th>
			Rented
		</th>
		<th>
			Kilometrage
		</th>
		<th>
			License Plate
		</th>
		<th>
			Price
		</th>
	</tr>
	<c:forEach var="car" items="${cars}">
		<%@include file="carLine.jsp"%>
	</c:forEach>
</table>