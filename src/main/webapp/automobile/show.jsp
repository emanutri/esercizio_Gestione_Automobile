<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Visualizza elemento</title>
<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Marca:</dt>
				  <dd class="col-sm-9"><c:out value="${visualizza_automobile_attr.marca}"/></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Modello:</dt>
				  <dd class="col-sm-9"><c:out value="${visualizza_automobile_attr.modello}"/></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cilindrata:</dt>
				  <dd class="col-sm-9"><c:out value="${visualizza_automobile_attr.cilindrata}"/></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Immatricolazione:</dt>
				  <dd class="col-sm-9"><fmt:formatDate type="date" pattern="dd/MM/yyy" value="${visualizza_automobile_attr.dataImmatricolazione}"/></dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		    	<form method="post" action="ListAutoServlet">
			    	<button type="submit" name="submit" value="submit" id="submit"
							class="btn  btn-sm btn-outline-secondary">Back</button>
				</form>
		        
		    </div>
		    
		</div>	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	

</body>
</html>