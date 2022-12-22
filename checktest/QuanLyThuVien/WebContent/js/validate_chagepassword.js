$(function(){

	$("#old_password_error").hide();
	$("#new_password_error").hide();
	$("#confirm_password_error").hide();

	
	var old_password_error = false;
	var new_password_error = false;
	var confirm_password_error = false;


	$("#old_password").focusout(function() {
		checkOldPassword();
	});
	$("#new_password").focusout(function() {
		checkNewPassword();
	});
	$("#confirm_password").focusout(function() {
		checkConfirmPassword();
	});

	function checkOldPassword(){
		if($("#new_password").val().length < 6 || $("#new_password").val().length > 15){
			$("#old_password_error").html("Password phải có 6-15 kí tự");
			old_password_error = true;
			$("#old_password_error").show();
		}
		else{
			old_password_error = false;
			$("#old_password_error").hide();
		}
	}
	function checkNewPassword(){
		if($("#new_password").val().length < 6 || $("#new_password").val().length > 15){
			$("#new_password_error").html("Password phải có 6-15 kí tự");
			password_error = true;
			$("#new_password_error").show();
		}
		else{
			password_error = false;
			$("#new_password_error").hide();
		}
	}
	function checkConfirmPassword(){
		if($("#confirm_password").text() != $("#new_password").text()){
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
		
		checkOldPassword();
		checkNewPassword();
		checkConfirmPassword();

		if( old_password_error || new_password_error || confirm_password_error){
			return false;
		}
		else{
			return true;
		}
	});
	
});