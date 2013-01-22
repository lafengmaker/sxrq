function isInteger(str){
	return  numberchechk('0+',str);
}
function checknum(obj,type){
		var objv=$(obj).val();
		if(objv && !numberchechk(type,objv) ){
			alert($(obj).parent().prev().text()+'格式不正确');
			$(obj).css("border-color","red");
			$(obj).focus();
		}
}
function checklength(obj,length){
	var objv=$(obj).val();
	var l=parseInt(getByteLen(objv));
	var ln=parseInt(length);
	if(l>ln){
		alert($(obj).parent().prev().text()+'输入内容太长，请修改');
		$(obj).css("border-color","red");
		$(obj).focus();
	}
}
function numberchechk(type,obj){
	var reg;
	if(type=='0+'){//正整数
		reg=/^\d{0,3}$/
	}else if(type=='0'){//整数
		reg=/^[-+]?\d+$/
	}else if(type=='m'){//元
		//reg = /^(\d{1,6})(\.?)(\d{0,2})$/;
		reg = /^(\d{1,6})(\.[0-9]{1,2})?$/;
	}else if(type=='p'){//百分比
		reg=/^([1-9][0-9]?(\.[0-9]{1,2})?)$|^(0\.[0-9][0-9]?)$|^(0\.[0-9][1-9])$|^100(\.00)?$/
	}else if(type=='0m'){
		reg=/^\d{0,6}$/
	}else{
		return false;
		
	}
	return reg.test(obj);
//	var regu = /^(\d+)(\.?)(\d{0,2})$/;
//	var re = new RegExp(regu); 
//	  String eL = "";   
//      if(type.equals("0+"))eL = "^\\d+$";//非负整数   
//      else if(type.equals("+"))eL = "^\\d*[1-9]\\d*$";//正整数   
//      else if(type.equals("-0"))eL = "^((-\\d+)|(0+))$";//非正整数   
//      else if(type.equals("-"))eL = "^-\\d*[1-9]\\d*$";//负整数   
//      else eL = "^-?\\d+$";//整数   
//      Pattern p = Pattern.compile(eL);   
//      Matcher m = p.matcher(num);   
//      boolean b = m.matches();   
//      return b;   
//	reg=/^[-+]?\d+$/;    
}

function getByteLen(val) {
    var len = 0;
    for (var i = 0; i < val.length; i++) {
    	 if (val.charAt(i).match(/[^\x00-\xff]/ig) != null) //全角
            len += 2;
        else
            len += 1;
    }
    return len;
}