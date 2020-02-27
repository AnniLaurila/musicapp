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
	<h1>MusicApp!</h1>
	<p>All ${fn:length(artists)} artists</p>
	</div>
	<table class=center>
		<tr>
    		<th>#</th>
    		<th>Artist</th>
    		<th>Albums</th>
  		</tr>
	
    	<c:forEach items="${artists}" var="artist">
        	<tr id="artist-${ artist.getArtistId() }">
        	<td><c:out value="${artist.artistId}"></c:out></td>
        	<td><c:out value="${artist.name}"></c:out></td>
        	<td><!-- uses the id of the current product as the id parameter -->
			<button onclick="showAlbums(${ artist.getArtistId() })">Albums</button>
			</td>
        	</tr>

        	
		</c:forEach>
	</table>
	<br><br>
	<p class=center>Create a new artist:</p>
	<form class= center id="add-new-form" method="post">
    	<input id="new-artist-title" name="name" required type="text" placeholder="type artist here..." autofocus /> 
   		<input type="submit" id="add-new-artist" value="Add to list" />
	</form>

</body>

</html>