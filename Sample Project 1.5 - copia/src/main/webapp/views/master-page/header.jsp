<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="bs-docs-section clearfix">
	<div class="row">
		<div class="col-md-12">

			<div class="bs-component">
				<div class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-responsive-collapse">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"></a>
						</div>
						<div class="navbar-collapse collapse navbar-responsive-collapse">

							<ul class="nav navbar-nav">

								<security:authorize access="hasRole('ADMIN')">
									
								</security:authorize>

							</ul>
							
							<form class="navbar-form navbar-left">
								<div class="form-group">
		
								</div>
							</form>
							<ul class="nav navbar-nav">		
							<security:authorize access="hasRole('USUARIO')">


									<li class="dropdown"><a href="javascript:void(0)"
										data-target="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message
												code="master.page.categorias" /></a>
										<ul class=dropdown-menu>
				
							
									<li><a href="categoria/list.do"><spring:message
												code="master.page.categoriasAll" /></a></li>
												
	


										</ul></li>

								</security:authorize>
							</ul>

							<ul class="nav navbar-nav navbar-right">

								<li class="dropdown"><a href="javascript:void(0)"
									data-target="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message
											code="master.page.chooselanguage" /> <i
										class="material-icons">language</i><b class="caret"></b> </a>
									<ul class="dropdown-menu">
										<li><a href="?language=en"><spring:message
													code="master.page.english" /></a></li>
										<li><a href="?language=es"><spring:message
													code="master.page.spanish" /></a></li>
									</ul></li>

								<security:authorize access="hasRole('ADMIN')">
									<!-- Espacio a la izquierda para el admin -->
								</security:authorize>

								<security:authorize access="isAnonymous()">

									<li><a href="security/login.do"><spring:message
												code="master.page.login" /></a></li>
								
								</security:authorize>

								<security:authorize access="isAuthenticated()">

									<li class="dropdown"><a href="javascript:void(0)"
										class="dropdown-toggle" data-toggle="dropdown"><spring:message
												code="master.page.profile" /><b class="caret"></b> </a>
										<ul class="dropdown-menu">
											<li><a href="javascript:void(0)"> (<security:authentication
														property="principal.username" />)
											</a></li>
											<li><a href="j_spring_security_logout"><spring:message
														code="master.page.logout" /> </a></li>
										</ul></li>

								</security:authorize>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>