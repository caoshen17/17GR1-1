$(document).ready(function(){
	$(".btn").click(function(){
		var name =document.getElementById("user");
		if(name.validity.valueMissing==true){
			name.setCustomValidity("用户名不能为空");
		}
		else if(name.validity.patternMismatch==true){
			name.setCustomValidity("用户名必须是字母开头的4~16位的英文字母和数字");
		}
		else{
			name.setCustomValidity("");
		}
		var passworder=document.getElementById("repwd");
		if(passworder.validity.valueMissing==true){
			passworder.setCustomValidity("用户密码不能为空");
		}else if(passworder.validity.patternMismatch==true){
			passworder.setCustomValidity("密码必须是4~10位的英文字母和数字");
		}else{
			passworder.setCustomValidity("");
		}
		var eml=document.getElementById("email");
		if(eml.validity.valueMissing==true){
			eml.setCustomValidity("eml不能为空");
		}else if(eml.validity.patternMismatch==true){
			eml.setCustomValidity("格式不正确");
		}else{
			eml.setCustomValidity("");
		}
		var sjh=document.getElementById("mobile");
		if(sjh.validity.valueMissing==true){
			sjh.setCustomValidity("手机号不能为空");
		}else if(sjh.validity.patternMismatch==true){
			sjh.setCustomValidity("手机必须是1开头的11位数字");
		}else{
			sjh.setCustomValidity("");
		}
		var sr=document.getElementById("birth");
		if(sr.validity.valueMissing==true){
			sr.setCustomValidity("生日不能为空");
		}else if(sr.validity.patternMismatch==true){
			sr.setCustomValidity("生日的年份必须为1900～2016之间，格式为1980-5-12或1988-05-04");
		}else{
			sr.setCustomValidity("");
		}
	});
})