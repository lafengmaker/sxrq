package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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

String path=request.getContextPath();


      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>后台管理系统</title>\r\n");
      out.write("<meta http-equiv=Content-Type content=text/html;charset=gb2312>\r\n");
      out.write("</head>\r\n");
      out.write("<frameset rows=\"64,*\"  frameborder=\"NO\" border=\"0\" framespacing=\"0\">\r\n");
      out.write("\t<frame src=\"admin_top.jsp\" noresize=\"noresize\" frameborder=\"NO\" name=\"topFrame\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\" target=\"main\" />\r\n");
      out.write("  <frameset cols=\"200,*\"  rows=\"560,*\" id=\"frame\">\r\n");
      out.write("\t<frame src=\"left.jsp\" name=\"leftFrame\" noresize=\"noresize\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" scrolling=\"no\" target=\"main\" />\r\n");
      out.write("\t<frame src=\"welcomeinfo\" name=\"main\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" scrolling=\"auto\" target=\"_self\" />\r\n");
      out.write("  </frameset>\r\n");
      out.write("<noframes>\r\n");
      out.write("    </noframes>\r\n");
      out.write("  <body>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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
