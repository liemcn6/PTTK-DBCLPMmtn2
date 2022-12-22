$(function(){
	$("#name_error").hide();
	$("#username_error").hide();
	$("#mail_error").hide();
	$("#password_error").hide();
	$("#confirm_password_error").hide();

	var name_error = false;
	var username_error = false;
	var mail_error = false;
	var password_error = false;
	var confirm_password_error = false;


	$("#name").focusout(function() {
		checkName();
	});
	$("#username").focusout(function() {
		checkUsername();
	});
	$("#mail").focusout(function() {
		checkMail();
	});
	$("#password").focusout(function() {
		checkPassword();
	});
	$("#confirm_password").focusout(function() {
		checkConfirmPassword();
	});

	function checkName(){
		if($("#name").val().length == 0){
			$("#name_error").html("Vui lòng nhập vào họ tên");
			name_error = true;
			$("#name_error").show();     
		}
		else{
			name_error = false;
			$("#name_error").hide();
		}
	}
	function checkUsername(){
		if($("#username").val().length == 0){
			$("#username_error").html("Vui lòng nhập vào tên đăng nhập");
			username_error = true;
			$("#username_error").show();
		}else if($("#username").val().length < 6){
			$("#username_error").html("Tên đăng nhập phải có ít nhất 6 kí tự");
			username_error = true;
			$("#username_error").show();
		}
		else{
			username_error = false;
			$("#username_error").hide();
		}
	}
	function checkMail(){
		if($("#mail").val().length == 0){
			$("#mail_error").html("Vui lòng nhập vào mail");
			mail_error = true;
			$("#mail_error").show();
		}else if(!($("#mail").text().includes("@")) && !($("#mail").text().includes("."))){
			$("#mail_error").html("Vui lòng nhập đúng định dạng");
			mail_error = true;
			$("#mail_error").show();
		}
		else{
			$("#mail_error").hide();
			mail_error = false;
		}
	}
	function checkPassword(){
		if($("#password").val().length < 6 || $("#password_error").val().length > 15){
			$("#password_error").html("Password phải có 6-15 kí tự");
			password_error = true;
			$("#password_error").show();
		}
		else{
			password_error = false;
			$("#password_error").hide();
		}
	}
	function checkConfirmPassword(){
		if($("#confirm_password").text() != $("#password").text()){
			$("#confirm_password_error").html("Password không giống nhau");
			confirm_password_error = true;

			$("#confirm_password_error").show();
		}
		else if($("#confirm_password").val().length == 0){
			$("#confirm_password_error").html("Vui lòng nhập xác nhận mật khẩu");
			confirm_password_error = true;

			$("#confirm_password_error").show();

		}
		else{
			confirm_password_error = false;
			$("#confirm_password_error").hide();
		}
	}

	$("#register_form").submit(function() {
		checkName();
		checkPassword();
		checkMail();
		checkUsername();
		checkConfirmPassword();

		if(name_error || username_error || mail_error || password_error || confirm_password_error){
			return false;
		}
		else{
			return true;
		}
	});
});