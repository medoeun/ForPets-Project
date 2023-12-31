<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY=" crossorigin="anonymous" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>

	.careDIA-box{
		width: 80%;
		margin-left: auto;
		margin-right: auto;
	}
    
    .filter-result .job-box {
      -webkit-box-shadow: 0 1px 3px 0 #dbdbdb;
              box-shadow: 0 1px 3px 0 #dbdbdb;
      border-radius: 10px;
      padding: 10px 35px;
    }
    
    ul {
      list-style: none; 
    }
    
    .list-disk li {
      list-style: none;
      margin-bottom: 12px;
    }
    
    .list-disk li:last-child {
      margin-bottom: 0;
    }
    
    .job-box .img-holder {
      height: 65px;
      width: 65px;
      background-image: linear-gradient(to right, rgba(78, 99, 215, 0.9) 0%, #5a85dd 100%);
      font-family: "Open Sans", sans-serif;
      color: #fff;
      font-size: 22px;
      font-weight: 700;
      display: -webkit-box;
      display: -ms-flexbox;
      display: flex;
      -webkit-box-pack: center;
          -ms-flex-pack: center;
              justify-content: center;
      -webkit-box-align: center;
          -ms-flex-align: center;
              align-items: center;
      border-radius: 65px;
          background-size: cover;
    }
    

    
    @media (min-width: 992px) {
      .job-overview {
        position: -webkit-sticky;
        position: sticky;
        top: 70px;
      }
    }
    
    .job-content ul li {
      font-weight: 600;
      opacity: 0.75;
      border-bottom: 1px solid #ccc;
      padding: 10px 5px;
          margin-right: 5px;
    }
    
    @media (min-width: 768px) {
      .job-content ul li {
        border-bottom: 0;
        padding: 0;
            margin-right: 5px;
      }
    }
    
    .job-content ul li i {
      font-size: 20px;
      position: relative;
      top: 1px;
    }
    .mb-30 {
        margin-bottom: 30px;
    }
    </style>
</head>
<body>

<div class="careDIA-box">



            <div>
                    <div class="section-title text-center ">
                        <h3 class="top-c-sep mb-5">돌봄일지보기</h3>
                    </div>
            </div>
            
            	<c:if test="${empty careDIA || careDIA eq ''}">
					<jsp:include page="./noData/no_careDiary.jsp"></jsp:include>
				</c:if>

            <div class="row">
                <div class="col-lg-10 mx-auto">
                    <div class="career-search mb-60">
                        <div class="filter-result">

						<c:forEach items="${careDIA }" var="dia">
                            <div class="job-box d-md-flex align-items-center justify-content-between mb-30">
                                <div class="job-left my-4 d-md-flex align-items-center flex-wrap">
                                    <div class="img-holder mr-md-4 mb-md-0 mb-4 mx-auto mx-md-0 d-md-none d-lg-flex" 
                                    	style="background-image: url('../partner/display?fileName=${dia.voR.voP.img}');"></div>
                                    
                                    <div class="job-content">
                                        <h5 class="text-center text-md-left">💁‍♂️'${dia.voR.voP.part_name}'펫트너님의 돌봄일지 </h5>
                                        <ul class="d-md-flex flex-wrap text-capitalize ff-open-sans">
                                            <li class="mr-md-4">
                                                <i class="zmdi zmdi-format-subject"></i> 
                                                <c:choose>
          											<c:when test="${dia.voR.s_num eq 1}">기본돌봄서비스</c:when>
          											<c:when test="${dia.voR.s_num eq 2}">산책돌봄서비스</c:when>
          											<c:when test="${dia.voR.s_num eq 4}">병원픽업서비스</c:when>
          											<c:when test="${dia.voR.s_num eq 5}">미용픽업서비스</c:when>
                                                </c:choose>
                                            </li>
                                            <li class="mr-md-4">
                                                <i class="zmdi zmdi-favorite"></i> ${dia.voR.voPet.name }
                                            </li>
                                            <li class="mr-md-4">
                                                <i class="zmdi zmdi-time mr-2"></i> ${dia.complete_day} 작성
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="job-right my-4 flex-shrink-0">
                                    <a id="check-user-careDiary-detail" class="btn d-block w-100 d-sm-inline-block btn-light" onclick="getID(${dia.diary_id})">돌봄일지보기</a>
                                </div>
                            </div>
						</c:forEach></div>
                    </div>
                </div>
            </div>

        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</body>
</html>