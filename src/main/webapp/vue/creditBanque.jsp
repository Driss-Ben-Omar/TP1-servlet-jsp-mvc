<%@page import="web.CreditModel"%>
<%
CreditModel model = (CreditModel) request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Credit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="col align-self-center ">
			<div class="card bg-info">
				<div class="card-heading navbar-toggler">La semulation de
					credit</div>
				<div class="card-body">
					<form action="calcule.do" method="post">
						<div class="form-group">
							<label class="col-form-label">Montant :</label> <input
								type="text" name="montant" value="<%=model.getMontant()%>"
								class="form-control">
						</div>
						<div class="form-group">
							<label class="col-form-label">Taux :</label> <input type="text"
								name="taux" value="<%=model.getTaux()%>" class="form-control">
						</div>
						<div class="form-group">
							<label class="col-form-label">Duree :</label> <input type="text"
								name="duree" value="<%=model.getDuree()%>" class="form-control">
						</div>
						<div>
							<button type="submit" class="btn btn-dark">Calculer</button>
						</div>
					</form>
				</div>
				<div class="card-footer">
					La mensualiter est :
					<%=model.getMensualite()%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>