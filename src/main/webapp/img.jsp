<%@page import="com.lafengmaker.core.util.NumberUtil"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.util.Random"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%
response.setContentType("image/jpeg");
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);      
int width=60, height=20;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
Graphics g = image.getGraphics();
Random random = new Random();
g.setColor(new NumberUtil().getRandColor(100,500));
g.fillRect(0, 0, width, height);
g.setFont(new Font("Times New Roman",Font.PLAIN,18));
for (int i=0;i<155;i++) {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    int xl = random.nextInt(12);
    int yl = random.nextInt(12);
    g.drawLine(x,y,x+xl,y+yl);
}

String sRand="8888";
/*for (int i=0;i<4;i++){
    String rand=String.valueOf(random.nextInt(10));
    sRand+=rand;
    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));// ���ú����������ɫ��ͬ����������Ϊ����̫�ӽ�����ֻ��ֱ�����
    g.drawString(rand,13*i+6,16);
}*/
for (int i=0;i<sRand.length();i++){
	g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
	 g.drawString(sRand.valueOf(sRand.charAt(i)),13*i+6,16);
}
session.setAttribute("code",sRand);
g.dispose();
ServletOutputStream  responseOutputStream =response.getOutputStream();
ImageIO.write(image, "JPEG", responseOutputStream);
responseOutputStream.flush();
responseOutputStream.close();
responseOutputStream=null;
response.flushBuffer();  
out.clear();  
out = pageContext.pushBody();  
%>