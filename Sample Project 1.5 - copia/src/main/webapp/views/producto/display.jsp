<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>





<div class="table-responsive">


	<h1>
			<jstl:out value="${producto.nombre}" />
	</h1>
	
			<a class="fancybox" href="${producto.imagen}">
			<img src="${producto.imagen}" /></a>
			
			

			<a class="fancybox" href="${producto.imagenEspec}">
			<img src="${producto.imagenEspec}" /></a>		
			
		<div class="col-centered" style="width:50%">	
	
			<jstl:out value="${producto.descripcion}" />
		</div>
			<br><br><br>
			
	
	<div class="col-md-6 col-centered" style="width:100%">
	<div class="well bs-component">
			<a class="fancybox" href="${producto.imagenTabla}">
			<img src="${producto.imagenTabla}" width="100%"/></a>
			</div></div>

	</div>
	<br><br><br><br><br><br>
