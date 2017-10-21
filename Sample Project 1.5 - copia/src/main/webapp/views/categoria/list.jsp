<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>


<div class="table-responsive">
<display:table pagesize="25" class="table table-striped table-hover" name="categorias" requestURI="${requestURI}" id="categoria">
	
	<!-- Attributes -->

	<spring:message code="categoria.nombre" var="nombre" />
	<display:column property="nombre" title="${nombre}"
		sortable="true" />


	<spring:message code="categoria.imagen" var="imagen"/>
	<display:column title="${imagen}">
			<a class="fancybox" href="${categoria.imagen}">
			<img class="mini-circle" src="${categoria.imagen}" /></a>	
		
	</display:column>
	
	<!-- Action links -->
	<display:column>
	<jstl:if test="${categoria.children!=null and not empty categoria.children}">

		<a href="categoria/listChildren.do?parentId=${categoria.id}" ><spring:message code="categoria.listChildren" /></a>

	</jstl:if>

	<jstl:if test="${categoria.children==null or empty categoria.children }">

		<a href="producto/list.do?categoriaId=${categoria.id}" >
		<spring:message code="categoria.producto" /></a>

	</jstl:if>
	</display:column>
</display:table>
</div>

	<input type="button" value="<spring:message code="categoria.return" />"
	onclick="javascript: history.back()" />
	
