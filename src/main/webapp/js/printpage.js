function printpr() //预览函数
{
document.all("qingkongyema").click();//打印之前去掉页眉，页脚
//document.all("dayinDiv").style.display="none"; //打印之前先隐藏不想打印输出的元素（此例中隐藏“打印”和“打印预览”两个按钮）
var OLECMDID = 7;
var PROMPT = 1;
var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
WebBrowser1.ExecWB(OLECMDID, PROMPT);
WebBrowser1.outerHTML = "";
//document.all("dayinDiv").style.display="";//打印之后将该元素显示出来（显示出“打印”和“打印预览”两个按钮，方便别人下次打印）
}
//function printTure() //打印函数
//{
////document.all('qingkongyema').click();//同上
////document.all("dayinDiv").style.display="none";//同上
//	$("table").hide();
//	alert($(".line_table").show());
////window.print();
////document.all("dayinDiv").style.display="";
//}
function printTure() //打印函数
{
	$("table").hide();
	$("span").hide();
	$("#print").css("width:950px");
	$("#print").html("<table cellpadding='0'  cellspacing='0' width='100%' border='1' style='border-color:#CCCCCC'>"+$(".line_table").html()+"</table>");
	$("#print .bordertd").removeClass("bordertd");
	$("#print .title").remove();
	$("#print .np").remove();
	$("#print").show();
	window.print();
	$("table").show();
	$("#print").hide();
	//$("#print").html("");
	$("span").show();
}
function doPage()
{
layLoading.style.display = "none";//同上
}