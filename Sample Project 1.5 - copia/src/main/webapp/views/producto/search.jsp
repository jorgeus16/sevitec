<%--
 * action-1.jsp
 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

	
	<form action="producto/listByKeyword.do" method="get">

	<label><spring:message code="producto.search.keyword"/></label>
	<input type="text" name="keyword"/> <br />
	<br>
	<input type="submit" value="<spring:message code="producto.search" />" /> 	 
	<input type="button" value="<spring:message code="producto.return" />"
	onclick="javascript: history.back()" />

</form>
	

