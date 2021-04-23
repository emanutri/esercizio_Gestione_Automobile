<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Inserisci nuovo</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">
		<div
			class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}"
			role="alert">
			${errorMessage}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<div class='card'>
			<div class='card-header'>
				<h5>Inserisci nuovo elemento</h5>
			</div>

			<div class='card-body'>

				<form method="post" action="ExecuteInsertAutoServlet"
					novalidate="novalidate">

					<div class="form-row">

						<div class="form-group col-md-6">
							<label>Marca </label> 
							<input type="text" name="marca" id="marca" class="form-control" value="<c:out value="${automobileDaInserire.marca}"/>"
								placeholder="Inserire la marca" required >
						</div>

						<div class="form-group col-md-6">
							<label>Modello </label> 
							<input	type="text" name="modello" id="modello" class="form-control" value="<c:out value="${automobileDaInserire.modello}"/>"
								placeholder="Inserire il modello" required>
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Cilindrata </label> <input
								type="number" class="form-control" name="cilindrata" id="cilindrata" value="<c:out value="${automobileDaInserire.cilindrata}"/>"
								placeholder="Inserire cilindrata" required>
						</div>
						
						<div class="form-group col-md-3">
							<label>Data di Immatricolazione</label>
							<input class="form-control" id="dataImmatricolazione" type="date" value="<fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${automobileDaInserire.dataImmatricolazione}"/>"
								placeholder="dd/MM/yy" title="formato : gg/mm/aaaa"
								name="dataImmatricolazione" required>
						</div>

					</div>
					<form method="post" action="ListAutoServlet">
				    	<button type="submit" name="submit" value="submit" id="submit"
								class="btn  btn-sm btn-outline-secondary">Back</button>
					</form>
					<button type="submit" name="submit" value="submit" id="submit"
						class="btn btn-primary">Conferma</button>

				</form>
				<!-- end card-body -->
			</div>
		</div>

		<!-- end container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>