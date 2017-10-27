<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<div class="col-md-6 col-centered" style="width:20%">
	<div class="well bs-component">
	
		<form:form requestURI="${requestURI}" 	modelAttribute="searchTemplate" class="form-vertical" id="form"
			method="post">
			
			<form:hidden path="id" />
			<form:hidden path="version" />
			
			<acme:inputTextMD code="searchTemplate.keyword" path="keyword" /> 
			
			<acme:inputSelectMD2 items="${colores}"  code="searchTemplate.color" path="color"/>

			<acme:inputSelectMD2 items="${carcasas}" code="searchTemplate.carcasa" path="carcasa"/>

			<acme:inputSelectMD2 items="${lentes}"  code="searchTemplate.lente" path="lente"/>


			<acme:submitMD name="save" code="searchTemplate.search"/>
	

		</form:form>
		</div>
	</div>
<div class="table-responsive" style="width:80%">
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
	
	<spring:message code="producto.precio" var="euros" ></spring:message>
	<display:column  property="euros" title="${euros}" 
		sortable="true"></display:column>


			<display:column >
				<a href="producto/display.do?productoId=${producto.id}"><span class="glyphicon glyphicon-align-center"></span> <spring:message
					code="producto.especificaciones" /> </a>
			</display:column>		
</display:table>
</div>