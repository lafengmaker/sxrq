package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html;charset=utf-8");
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
      out.write("  \r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>管理页面</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/prototype.lite.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/moo.fx.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/moo.fx.pack.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\tfont:12px Arial, Helvetica, sans-serif;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\tbackground-color: #EEF2FB;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("}\r\n");
      out.write("#container {\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("}\r\n");
      out.write("H1 {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tline-height: 20px;\t\r\n");
      out.write("}\r\n");
      out.write("H1 a {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tmoz-outline-style: none;\r\n");
      out.write("\tbackground-image: url(images/menu_bgS.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tline-height: 30px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("}\r\n");
      out.write(".content{\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write(".MM ul {\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write(".MM li {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tpadding-left: 0px;\r\n");
      out.write("}\r\n");
      out.write(".MM {\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\tleft: 0px;\r\n");
      out.write("\ttop: 0px;\r\n");
      out.write("\tright: 0px;\r\n");
      out.write("\tbottom: 0px;\r\n");
      out.write("\tclip: rect(0px,0px,0px,0px);\r\n");
      out.write("}\r\n");
      out.write(".MM a:link {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tbackground-image: url(images/menu_bg1.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".MM a:visited {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tbackground-image: url(images/menu_bg1.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".MM a:active {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tbackground-image: url(images/menu_bg1.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".MM a:hover {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tcolor: #006600;\r\n");
      out.write("\tbackground-image: url(images/menu_bg2.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" height=\"280\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#EEF2FB\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"182\" valign=\"top\"><div id=\"container\">\r\n");
      out.write("      <h1 class=\"type\"><a href=\"javascript:void(0)\">常用功能</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("          <li><a href=\"welcomeinfo\" target=\"main\">首页</a></li>\r\n");
      out.write("          <!-- <li><a href=\"http://www.865171.cn\" target=\"main\">待办任务</a></li> -->\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("     <h1 class=\"type\"><a href=\"javascript:void(0)\">计划管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("        ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("          <li><a href=\"schedule/weeklist\" target=\"main\">周计划</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("     <h1 class=\"type\"><a href=\"javascript:void(0)\">公告管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("          <li><a href=\"pub/addNoticeBefore\" target=\"main\">发布公告</a></li>\r\n");
      out.write("          <li><a href=\"pub/publist\" target=\"main\">公告列表</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("     <h1 class=\"type\"><a href=\"javascript:void(0)\">计量管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("          <li><a href=\"gasuse/uselist\" target=\"main\">气量列表</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <h1 class=\"type\"><a href=\"javascript:void(0)\">用户管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t  <li><a href=\"user/pwd\" target=\"main\">修改密码</a></li>\r\n");
      out.write("         <!--  <li><a href=\"http://www.865171.cn\" target=\"main\">增加商家</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">管理商家</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">发布资讯</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">资讯管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">市场联盟</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">名片管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">商城管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">商品管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">商城留言</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">商城公告</a></li> -->\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("     <!--  <h1 class=\"type\"><a href=\"javascript:void(0)\">注册用户管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">会员管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">留言管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">回复管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">订单管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">举报管理</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">评论管理</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("        <h1 class=\"type\"><a href=\"javascript:void(0)\">其它参数管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("          <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("            <li><a href=\"http://www.865171.cn\" target=\"main\">管理设置</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">主机状态</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">攻击状态</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">登陆记录</a></li>\r\n");
      out.write("          <li><a href=\"http://www.865171.cn\" target=\"main\">运行状态</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div> -->\r\n");
      out.write("      </div>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\t\tvar contents = document.getElementsByClassName('content');\r\n");
      out.write("\t\tvar toggles = document.getElementsByClassName('type');\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar myAccordion = new fx.Accordion(\r\n");
      out.write("\t\t\ttoggles, contents, {opacity: true, duration: 400}\r\n");
      out.write("\t\t);\r\n");
      out.write("\t\tmyAccordion.showThisHideOpen(contents[0]);\r\n");
      out.write("\t</script>\r\n");
      out.write("        </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /left.jsp(174,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role=='1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("          <li><a href=\"schedule/daylist\" target=\"main\">日计划</a></li>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("          <li><a href=\"schedule/day\" target=\"main\">日计划</a></li>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /left.jsp(215,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role== '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("          <li><a href=\"user/list\" target=\"main\">用户列表 </a></li>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
