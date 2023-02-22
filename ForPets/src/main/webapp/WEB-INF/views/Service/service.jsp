<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../favicon.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/Tip/tip.css" rel="stylesheet" />
<style>
	#main_content {
		display : table;
		width : 100%;
	}
	#sideNav, #main {
		display : table-cell;
	}
	main {
		padding-left : 50px;
	}
	#footer_div {
		position : relative;
		z-index : 900;
	}
	.navbar_forpets{
		padding-top : 9rem;
		position : absolute;
	}
</style>
</head>
<body>
	<jsp:include page="../nav.jsp" />
	<div id="main_content">
		
		<nav class="navbar navbar-expand-lg navbar-dark part-nav" id="sideNav">
            <div class="collapse navbar-collapse navbar_forpets" id="navbarResponsive">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/Service/choice">서비스 예약</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/FindHospital/findHospital">근처 병원 찾기</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/Tip/getTipList">팁 게시판</a></li>
                </ul>
            </div>
		</nav>
		
		<main id="main" class="main">
			<section class="section">
				<div class="row align-items-top">
					<div class="col-lg-10">
					</div>
				</div>
			</section>
		</main><!-- End #main -->
	</div>
	<div id="footer_div" style="background-color : white;">
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>