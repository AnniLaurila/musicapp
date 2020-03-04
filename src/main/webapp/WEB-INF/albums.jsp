<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>MusicApp</title>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>
	<div class=center>
	<h2><c:out value="${artist.name}"></c:out></h2>
	<p><c:out value="${fn:length(albums)}"></c:out> albums</p>
	</div>
	<table class=center>
		<tr>
    		<th>#</th>
    		<th>Album</th>
  		</tr>
	
    	<c:forEach items="${albums}" var="album">
        	<td><c:out value="${album.albumId}"></c:out></td>
        	<td><c:out value="${album.title}"></c:out></td> 
        	</tr>

        	
		</c:forEach>
	</table>


</body>

</html>