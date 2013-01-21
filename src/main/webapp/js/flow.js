
function popupDiv(div_id,index) { 
var div_obj = $("#"+div_id); 
//var windowWidth = document.documentElement.clientWidth; 
//var windowHeight = document.documentElement.clientHeight; 
var windowWidth = document.body.clientWidth; 
var windowHeight =document.body.clientHeight ;
var popupHeight = div_obj.height(); 
var popupWidth = div_obj.width(); 
//��Ӳ���ʾ���ֲ� 
//$("<div id='mask'></div>").addClass("mask") 
//.width(windowWidth * 0.90) 
//.height(windowHeight * 0.90) 
//.click(function() {hideDiv(div_id); }) 
//.appendTo("body") 
//.fadeIn(200); 
var coverindex=index-1;
popCoverDiv(coverindex);
$("#"+div_id).css("z-index",index);
$("#cover_div"+coverindex).fadeIn(200); 
//document.getElementById("cover_div").style.display = ''; 
//alert([sz.PageW,sz.PageH,sz.WinW,sz.WinH].join(", ")); 
// window.scrollTo(0, sz.PageH); 
 var sl = GetPageScroll(); 
 //alert([sl.X,sl.Y].join(", "));
//alert( document.documentElement.scrollTop+'===='+ document.documentElement.scrollLeft );
//alert(windowHeight/2);
//alert(popupHeight/2);
var top=sl.Y+25;
div_obj.css({"position": "absolute"})
.animate({left: windowWidth/2-popupWidth/2, 
//.animate({left: 50, 
top:top, opacity: "show" }, "slow"); 
} 

function hideDiv(div_id) { 
var index=$("#"+div_id).css("z-index")-1;
$("#cover_div"+index).remove(); 
$("#" + div_id).animate({left: 0, top: 0, opacity: "hide" }, "slow"); 
}


 function popCoverDiv(Index){
   var coverDiv = document.createElement('div');
   document.body.appendChild(coverDiv);
   with(coverDiv.style) {
   display = 'none';
    position = 'absolute';
    background = '#CCCCCC';
    left = '0px';
    top = '0px';
	var sz = GetPageSize(); 
	//alert([sz.PageW,sz.PageH,sz.WinW,sz.WinH].join(", ")); 
    var bodySize = getBodySize();	
    width = bodySize[0] + 'px'
    //height = bodySize[1] + 'px';
	height = sz.PageH + 'px';
    //height =  window.screen.height + 'px';//�����Ļ�ĸ�
    zIndex = Index;
    if (isIE()) {
	filter="alpha(opacity=50)";
     //filter = "Alpha(Opacity=60)";
    } else {
     opacity = 0.6;
    }
  }
  coverDiv.id = 'cover_div'+Index;
 }
 
  function getBodySize(){
  var bodySize = [];
  with(document.documentElement) {
   bodySize[0] = (scrollWidth>clientWidth)?scrollWidth:clientWidth;
   bodySize[1] = (scrollHeight>clientHeight)?scrollHeight:clientHeight;
  }
  return bodySize;
 }
 function isIE(){
     return (document.all && window.ActiveXObject && !window.opera) ? true : false;
 }
 
 
function GetPageScroll() {  var x, y;  if(window.pageYOffset) {    
// all except IE
    y = window.pageYOffset;    x = window.pageXOffset; 
	} else if(document.documentElement     && document.documentElement.scrollTop) {  
	// IE 6 Strict
    y = document.documentElement.scrollTop;  
	x = document.documentElement.scrollLeft; 
	} else if(document.body) { 
	// all other IE 
	y = document.body.scrollTop;   
	x = document.body.scrollLeft; 
	}  return {X:x, Y:y};}


function GetPageSize() {  
var scrW, scrH;  if(window.innerHeight && window.scrollMaxY) {    
// Mozilla   
 scrW = window.innerWidth + window.scrollMaxX;   
 scrH = window.innerHeight + window.scrollMaxY; 
 } else if(document.body.scrollHeight > document.body.offsetHeight){ 
 // all but IE Mac   
 scrW = document.body.scrollWidth;  
 scrH = document.body.scrollHeight;  
 } else if(document.body) { 
 // IE Mac    
 scrW = document.body.offsetWidth;    
 scrH = document.body.offsetHeight; 
 }  var winW, winH;  if(window.innerHeight) { 
 // all except IE   
 winW = window.innerWidth;   
 winH = window.innerHeight;  
 } else if (document.documentElement     && document.documentElement.clientHeight) {
 // IE 6 Strict Mode    
 winW = document.documentElement.clientWidth;   
 winH = document.documentElement.clientHeight;  
 } else if (document.body) {
 // other  
 winW = document.body.clientWidth;  
 winH = document.body.clientHeight;  }  
 // for small pages with total size less then the viewport 
 var pageW = (scrW<winW) ? winW : scrW;  var pageH = (scrH<winH) ? winH : scrH;  
 return {PageW:pageW, PageH:pageH, WinW:winW, WinH:winH};}








