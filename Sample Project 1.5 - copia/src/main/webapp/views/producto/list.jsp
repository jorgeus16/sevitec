<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<div class="table-responsive">
<display:table pagesize="25" class="table table-striped table-hover" name="productos" requestURI="${requestURI}" id="producto">
	
	<!-- Attributes -->
	<spring:message code="producto.referencia" var="referencia" />
	<display:column property="referencia" title="${referencia}"
		sortable="true" />
		
	<spring:message code="producto.nombre" var="nombre" />
	<display:column property="nombre" title="${nombre}"
		sortable="true" />


	<spring:message code="producto.imagen" var="imagen"/>
	<display:column title="${imagen}">
			<a class="fancybox" href="${producto.imagen}">
			<img class="mini-circle" src="${producto.imagen}" /></a>	
		
	</display:column>
	
		<spring:message code="producto.precio" var="euros"></spring:message>
	<display:column property="euros" title="${euros}"
		sortable="true" />
		
</display:table>
</div>
			<acme:buttonMD href="" type="button" code="producto.return"/>
	
