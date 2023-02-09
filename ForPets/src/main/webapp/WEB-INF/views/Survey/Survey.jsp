<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<title>Survey page</title>
<script type="text/javascript">
	$(document).ready(function(){
		// 구분을 위한 count 변수
		var count = 1;
		
		// 설문지 추가 버튼
		$("#addSurBtn").click(function(){
			// 구분을 위한 count 증가
			count += 1;
			
			// 설문지 최대 번호 구하기 -> 증가
			var last = $("#survey tr:last").attr("class").replace("item","");
			var newitem = $("#survey tr:eq(1)").clone();

			newitem.removeClass();
			newitem.find("td:eq(0)").attr("rowspan", "1");
			
			// item 추가할 때 title, type, answer 구분자를 추가해서 name 설정
			newitem.find("td:eq(0)").find("input:eq(0)").attr("name", "sd_title"+count);
			newitem.find("td:eq(1)").find("select:eq(0)").attr("name", "sd_type"+count);
			newitem.find("td:eq(2)").find("input:eq(1)").attr("name", "sc_answer"+count);
			
			newitem.addClass("item"+(parseInt(last)+1));
			
			// 총 작성된 질문 수 = count
			$("#survey_count").val(count);

			$("#survey").append(newitem);
		}); // 설문지 추가 END
		
		
		// 항목 추가 버튼
		$(".addBtn").live("click", function(){
			var click = $(this).parent().parent();
			var cls = click.attr("class");
			
			// tr복사 후 마지막에 추가
			var newrow = click.clone();
			newrow.find("td:eq(0)").children().remove();
			newrow.find("td:eq(1)").children().remove();
			newrow.insertAfter($("#survey ."+cls+":last"));
		}); // 항목 추가 END
		


        
        // 삭제버튼 클릭 시 
        $(".delBtn").live("click", function() {
        	var click = $(this).parent().parent();
        	var cls = click.attr("class");
        	
        	if (click.find("td:eq(0)").attr("rowspan")) {
        		if(click.next().hasClass(cls)) {
        			click.next().preped(click.find("td:eq(0)"));
        		}
        	}
        	click.remove();
        
        });
		
	});
     
 	 $(document).change("select[name=sd_type]", function() { 
	
		let qs = $("#surOpt").find("option:selected").val();	 
				
	 	 /* 	if (qs == "gaek") {
		    		alert (qs);
		    		
		    	} else if (qs == "check") {
		    		alert (qs); 
		    		
		    	} else if (qs == "ju") {
		    		alert (qs);
		    		
		    	} else if (qs == "time") {
		        		alert (qs);	
		        		
		    	} else if (qs == "schedule") {
		    		alert (qs);	 */
		    		
		    	//} // if end 
			}); 
			
	
</script>
</head>
<body>

<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="date"><fmt:formatDate value="${now}" pattern="yyMMddmmss" /></c:set>
<c:set var="min"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set>
	
	
	<h1>설문지 작성하기</h1>

<form action="insertsurvey.do" method="post">
	<input type="hidden" value="1" id="survey_count" name="survey_count">
	<input type="hidden" value="sur${date}" name="c_code">
	<p>설문지 제목 : <input type="text" placeholder="설문지 제목을 입력하세요." size=80></p>
	
	<table id="survey">
		<tr>
			<th>질문 내용</th>
			<th>질문 유형</th>
			<th>옵션 추가</th>
			<th><button type="button" id="addSurBtn">설문지 추가</button></th>
		</tr>
		<tr class="item1">
			<td>
			<!-- 	<input type="hidden" name="sd_order"> -->
				<input type="text" placeholder = "질문 내용을 입력해 주세요." size=60 name="sd_title1"></td>
			<td><select id="surOpt" name="sd_type1">
					<option value="">-- 설문지 유형을 선택해 주세요 --</option>
					<option value="gaek">객관식</option>
					<option value="ju">주관식</option>
					<option value="check">체크박스</option>
					<option value="time">시간형</option>
					<option value="schedule">달력형</option>
				</select>
			</td>
            <td><input type="hidden" name="sc_ascode" value=""><input type="text" name="sc_answer1"/><button type="button" class="addBtn">항목추가</button></td>
            <td><button class="delBtn">삭제</button></td>
		</tr>
		
<!-- 		<tr class="item2">
			<td><input type="text" placeholder = "질문 내용을 입력해 주세요." size=60 name="sd_title"></td>
			<td><select id="surOpt" name="SD_TYPE">
					<option value="">-- 설문지 유형을 선택해 주세요 --</option>
					<option value="gaek">객관식</option>
					<option value="ju">주관식</option>
					<option value="check">체크박스</option>
					<option value="time">시간형</option>
					<option value="schedule">달력형</option>
				</select>
			</td>
            <td><input type="text" /><button class="addBtn">항목추가</button></td>
            <td><button class="delBtn">삭제</button></td>
		</tr> -->
	</table>
	 

	  	<input type="submit" value="작성완료">
	 </form>

	
	
<!-- 	<script>
	
	function click(){
		alert("확인");
/* 		 $.ajax({
			 method:"POST",
			 url:"/insertsurvey.do"
		 })			  */
	 }// click()
	
	</script> -->


</body>
</html>