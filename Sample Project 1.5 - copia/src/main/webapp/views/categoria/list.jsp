<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table pagesize="5" class="table table-striped table-hover" name="categorias" requestURI="${requestURI}" id="categoria">
	
	<!-- Attributes -->

	<spring:message code="categoria.nombre" var="nombre" />
	<display:column property="nombre" title="${nombre}"
		sortable="true" />

	<spring:message code="categoria.descripcion" var="descripcion" />
	<display:column property="descripcion" title="${descripcion}"
		sortable="true" />

	<spring:message code="categoria.imagen" var="imagen" />
	<display:column title="${imagen}">
			<a class="fancybox" href="${categoria.imagen}">
			<img class="mini-circle" src="${categoria.imagen}" /></a>	
		
	</display:column>		
	<!-- Action links -->
	
	<display:column>
		<a href="categoria/listChildren.do?parentId=${categoria.id}" ><spring:message code="categoria.listChildren" /></a>
	</display:column>
	
	<display:column>
		<a href="productos/listByCategory.do?categoryId=${categoria.id}" >
		<spring:message code="categoria.producto" /></a>
	</display:column>

</display:table>


	<input type="button" value="<spring:message code="categoria.return" />"
	onclick="javascript: history.back()" />
	
