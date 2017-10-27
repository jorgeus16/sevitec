<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="favicon.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<!-- Material Design fonts -->
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/icon?family=Material+Icons">
<%-- 
<!-- Bootstrap Material Design -->
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-material-design.min.css">
<link rel="stylesheet" type="text/css" href="css/ripples.min.css">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">

--%>


<!-- FancyBox -->
<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css?v=2.1.5"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="js/fancybox/jquery.fancybox.pack.js?v=2.1.5"></script>

<!-- Material Design for Bootstrap -->
<script src="js/material.min.js"></script>
<script src="js/ripples.min.js"></script>

<!-- CookieBar -->
<link rel="stylesheet" href="css/jquery.cookiebar.css" type="text/css" />
<script type="text/javascript" src="js/jquery.cookiebar.js"></script>

<!-- core CSS of SnackbarJS -->
<link href="css/snackbar.min.css" rel="stylesheet">
<!-- the default theme of SnackbarJS -->
<link href="css/material.css" rel="stylesheet">

<!-- Accordion -->
<script src="js/accordion.js"></script>


<!-- SnackbarJS -->
<script src="js/snackbar.min.js" type="text/javascript"></script>


<!-- Retoques -->
<link rel="stylesheet" type="text/css" href="css/style.css" />

<script>
	$(document).ready(function() {
		$.cookieBar({
			message : '<spring:message code="master.page.cookie" />',
			acceptText : '<spring:message code="master.page.acceptcookie" />'
		});
	});
</script>

<!-- Retoques -->
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script>
	$(function() {
		$.material.init();
	});
</script>

<script type="text/javascript">
	function relativeRedir(loc) {
		var b = document.getElementsByTagName('base');
		if (b && b[0] && b[0].href) {
			if (b[0].href.substr(b[0].href.length - 1) == '/'
					&& loc.charAt(0) == '/')
				loc = loc.substr(1);
			loc = b[0].href + loc;
		}
		window.location.replace(loc);
	}

	function hiddenOrShow() {
		var elemento = document.getElementById("alerta");
		if (elemento.style.display == "none") {
			elemento.style.display = "block";
		} else {
			elemento.style.display = "none";
		}
	}
	
	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".fancybox").fancybox();
	});

	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})
</script>


<script>
$(document).ready(function(){
  $('.dropdown-submenu a.test').on("click", function(e){
    $(this).next('ul').toggle();
    e.stopPropagation();
    e.preventDefault();
  });
});
</script>






<title><tiles:insertAttribute name="title" ignore="true" /></title>


    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
.dropdown-submenu {
    position: relative;
}

.dropdown-submenu .dropdown-menu {
    top: 0;
    left: 100%;
    margin-top: -1px;
}
</style>
</head>
<body>
	<div class="container">

		<div class="page-header" id="banner">
			<div class="row" style="display: flex; align-items: center;">
				
			<security:authorize access="hasRole('USUARIO')">	
			<jstl:if test="${usuario != null}">
			
				<div class="col-sm-3">
						<a href="#"><img width="100%" src="${usuario.logo}" /></a>			
				</div>			
			</jstl:if>
			</security:authorize>
			<security:authorize access="hasRole('ADMIN')">	
				<div class="col-sm-3">
					<a href="#"><img width="100%" src="images/carousel_02.jpg"/></a>		
				</div>			
			</security:authorize>
			<security:authorize access="isAnonymous()">	
				<div class="col-sm-3">
					<a href="#"><img width="100%" src="images/logo.png"/></a>		
				</div>			
			</security:authorize>			
			
				<div class="col-sm-9 text-right">
					<h1>
						<a style="text-decoration: none;" href="#"> </a>
					</h1>
					<h2>
						<tiles:insertAttribute name="title" />
					</h2>
				</div>
			</div>
		</div>
		<tiles:insertAttribute name="header" />

		<div class="bs-docs-section clearfix">
			<div class="row row-centered">
				<tiles:insertAttribute name="body" />
				<jstl:if test="${message != null}">
					<div class="alert alert-dismissible alert-danger">
						<button type="button" class="close" data-dismiss="alert">×</button>
						<spring:message code='${message}' />
					</div>
				</jstl:if>
			</div>
		</div>
	</div>

	<footer>
		<div class="container">
			<div id="footer-content" class="text-center">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</footer>

</body>
</html>