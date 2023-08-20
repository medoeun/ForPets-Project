function show_pet() {
	$("#set_pet").show();
}

function show_partner() {
	$("#set_partner").show();
}
function getPetListPopUp(){
	var url = "http://localhost:8081/biz/getPetList";
	var name = "getPetList"
	var option = "width = 500, height = 500, top = 100, left = 200, location = no";
	window.open(url, name, option);
}

function getPartnerListPopUp() {
	var url = "http://localhost:8081/biz/getPartnerList";
	var name = "getPartnerList"
	var option = "width = 500, height = 500, top = 100, left = 200, location = no";
	window.open(url, name, option);
}
function reserveMake() {
	call_info();
}
function call_info() {
	$.ajax({
			type : "POST",
			url : "http://localhost:8081/biz/getPet",
			data : {pet_id : $("#pet_id").val()},
			success : function(){
				$.ajax({
					type : "POST",
					url : "http://localhost:8081/biz/getPartner",
					data : {part_id : $("#part_id").val()},
					success : function(){
						$("form").submit();
					},
					error : function(){
						alert("Partner_info error");
					}
				});
			},
			error : function(){
				alert("Pet_info error");
			}
	});
}