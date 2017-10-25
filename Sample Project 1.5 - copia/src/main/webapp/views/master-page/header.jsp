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

								<security:authorize access="hasRole('USUARIO')">
			
							<form class="navbar-form navbar-left" action="producto/search.do">

								<div class="form-group">


									<input name="keyword" type="text" class="form-control col-md-8"
										placeholder="<spring:message
									code="master.page.search" />" onchange="this.form.submit();">


								</div>
							</form>

							
							<ul class="nav navbar-nav">		


									<li class="dropdown"><a href="javascript:void(0)"
										data-target="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message
												code="master.page.categorias" /></a>
										<ul class=dropdown-menu>
				
							
									<li><a href="categoria/list.do"><spring:message
												code="master.page.categoriasAll" /></a></li>
							</ul></li>

									<li class="dropdown"><a href="javascript:void(0)"
										data-target="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message
												code="master.page.productos" /></a>
										<ul class=dropdown-menu>
				
							
									<li><a href="producto/listAll.do"><spring:message
												code="master.page.productosAll" /></a></li>
			
									<li><a href="searchTemplate/usuario/edit.do"><spring:message
												code="master.page.searcher" /></a></li>
							</ul></li>

							</ul>

								</security:authorize>
							
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