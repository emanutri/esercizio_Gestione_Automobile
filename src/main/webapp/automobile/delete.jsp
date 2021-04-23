<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
	<jsp:include page="../header.jsp" />
		<title>Elimina automobile</title>
		 <link href="./assets/css/global.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../navbar.jsp" />
		<main role="main" class="container">
		
			<div class='card'>
			    <div class='card-header'>
			        Sei sicuro di voler eliminare la seguente automobile?
			    </div>
			    
			    <div class='card-body'>
			    	
			    	<dl class="row">
					  <dt class="col-sm-3 text-right">Marca:</dt>
					  <dd class="col-sm-9"><c:out value="${automobileDaEliminare.marca}"/></dd>
			    	</dl>
			    	
			    	<dl class="row">
					  <dt class="col-sm-3 text-right">Modello:</dt>
					  <dd class="col-sm-9"><c:out value="${automobileDaEliminare.modello}"/></dd>
			    	</dl>
			    	
			    	<dl class="row">
					  <dt class="col-sm-3 text-right">Cilindrata:</dt>
					  <dd class="col-sm-9"><c:out value="${automobileDaEliminare.cilindrata}"/></dd>
			    	</dl>
			    	
			    	<dl class="row">
					  <dt class="col-sm-3 text-right">Data di Immatricolazione:</dt>
					  <dd class="col-sm-9"><fmt:formatDate type="date" pattern="dd/MM/yyy" value="${automobileDaEliminare.dataImmatricolazione}"/></dd>
			    	</dl>
			    	
			    </div>
			    
			    <div class='card-footer'>
				    <form method="post" action="ListAutoServlet">
				    	<button type="submit" name="submit" value="submit" id="submit"
								class="btn  btn-sm btn-outline-secondary">Back</button>
					</form>
			    	<form method="post" action="ExecuteDeleteAutoServlet">
				    	
				    	<a href="ListAutoServlet" class="btn  btn-sm btn-outline-secondary" style='width:80px'>
			            <i class='fa fa-chevron-left'></i> Back
				        </a>
					   
					    <button type="submit" name="elimina" value="elimina" id="elimina" class="btn btn-outline-danger btn-sm">Elimina</button>
					    <input type="hidden" name ="inputId" value=<c:out value="${automobileDaEliminare.id}"/>>
			    
			    	</form>
			    </div>
			</div>	
		</main>
		<jsp:include page="../footer.jsp" />
	</body>
</html>