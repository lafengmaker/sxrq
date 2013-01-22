package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lafengmaker.core.util.NumberUtil;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public final class img_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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
    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));// ï¿½ï¿½ï¿½Ãºï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½É«ï¿½ï¿½Í¬ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Îªï¿½ï¿½ï¿½ï¿½Ì«ï¿½Ó½ï¿½ï¿½ï¿½ï¿½ï¿½Ö»ï¿½ï¿½Ö±ï¿½ï¿½ï¿½ï¿½ï¿½
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

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
