<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Cerca automobile</title>

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
				<h5>Ricerca automobile</h5>
			</div>

			<div class='card-body'>
				<a class="btn btn-primary " href="PrepareInsertAutoServlet">Add New</a>
				<h6 class="card-title">
					Immettere i dati dell'automobile
				</h6>

				<form method="post" action="ListAutoServlet"
					novalidate="novalidate">

					<div class="form-row">

						<div class="form-group col-md-6">
							<label>Marca </label> 
							<input type="text" name="marca" id="marca" class="form-control" 
								placeholder="Inserire la marca" required >
						</div>

						<div class="form-group col-md-6">
							<label>Modello </label> 
							<input	type="text" name="modello" id="modello" class="form-control" 
								placeholder="Inserire il modello" required>
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Cilindrata </label> <input
								type="number" class="form-control" name="cilindrata" id="cilindrata" 
								placeholder="Inserire la cilindrata" required>
						</div>
						
						<div class="form-group col-md-3">
							<label>Data di Immatricolazione</label>
							<input class="form-control" id="dataImmatricolazione" type="date" 
								placeholder="dd/MM/yy" title="formato : gg/mm/aaaa"
								name="dataImmatricolazione" required>
						</div>

					</div>
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