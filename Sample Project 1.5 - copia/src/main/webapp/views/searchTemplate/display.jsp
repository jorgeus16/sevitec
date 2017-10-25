<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<div>
	<h3>
		<spring:message code="searchTemplate.keyword" />:&nbsp; <jstl:out value="${keyword}" />
	</h3>
	
	<h3>
		<spring:message code="searchTemplate.color" />:&nbsp; <jstl:out value="${color}" />
	</h3>

	<h3>
		<spring:message code="searchTemplate.carcasa" />:&nbsp; <jstl:out value="${carcasa}" />
	</h3>

	<h3>
		<spring:message code="searchTemplate.lente" />:&nbsp; <jstl:out value="${lente}" />
	</h3>


</div>

	<acme:buttonMD href="searchTemplate/usuario/edit.do" type="button" code="searchTemplate.edit"/>
	<acme:buttonMD href="searchTemplate/usuario/search.do" type="button" code="searchTemplate.search"/>
	<acme:buttonMD href="" type="button" code="searchTemplate.back"/>
	

<div class="table-responsive">		
<display:table name="productos" id="rowSearch" pagesize="5" class="displaytag" keepStatus="false"  requestURI="${requestURI}" >
		
	<spring:message code="producto.nombre" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="false" />

	<spring:message code="categoria.imagen" var="imagen"/>
	<display:column title="${imagen}">
			<a class="fancybox" href="${categoria.imagen}">
			<img class="mini-circle" src="${categoria.imagen}" /></a>	
		
	</display:column>
</display:table>
</div>