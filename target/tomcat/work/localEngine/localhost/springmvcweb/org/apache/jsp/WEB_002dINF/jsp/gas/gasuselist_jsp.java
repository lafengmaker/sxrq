package org.apache.jsp.WEB_002dINF.jsp.gas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class gasuselist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsf_005fform_0026_005fmodelAttribute_005fid_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsf_005fselect_0026_005fpath_005fitems_005fitemValue_005fitemLabel_005fdisabled_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsf_005fform_0026_005fmodelAttribute_005fid_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsf_005fselect_0026_005fpath_005fitems_005fitemValue_005fitemLabel_005fdisabled_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsf_005fform_0026_005fmodelAttribute_005fid_005faction.release();
    _005fjspx_005ftagPool_005fsf_005fselect_0026_005fpath_005fitems_005fitemValue_005fitemLabel_005fdisabled_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
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
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE link PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"");
      out.print(path );
      out.write("/images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(path );
      out.write("/css/popflow.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-color: #EEF2FB;\r\n");
      out.write("}\r\n");
      out.write(".bordertd{\r\n");
      out.write("\tbackground-color:#FDFEFE;\r\n");
      out.write("\tborder-right: 1px #CCCCCC solid;\r\n");
      out.write("\tborder-bottom: 1px #CCCCCC solid;\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"");
      out.print(path );
      out.write("/js/datepicker/WdatePicker.js\"></script>\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"");
      out.print(path );
      out.write("/js/jquery-1.7.2.js\"></script>\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"");
      out.print(path );
      out.write("/js/flow.js\"></script>\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"");
      out.print(path );
      out.write("/js/iframe.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function addgasuse(id){\r\n");
      out.write("\tdocument.getElementById(\"adduserfrm\").src=\"");
      out.print(path );
      out.write("/gasuse/gasaddbefore\";\r\n");
      out.write("\tpopupDiv('adduser',200);\r\n");
      out.write("}\r\n");
      out.write("function del(id){\r\n");
      out.write("\tvar dd=confirm(\"确认删除此用户?\");\r\n");
      out.write("\tif(dd){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\ttype : \"post\",\r\n");
      out.write("\turl : \"del\",\r\n");
      out.write("\tdataType : \"text\",\r\n");
      out.write("\tdata : \"id=\"+id,\r\n");
      out.write("\tsuccess : function(msg){\r\n");
      out.write("\t\talert('删除成功');\r\n");
      out.write("\t\t$(\"#currentPage\").val(1);\r\n");
      out.write("  \t\t$(\"#user\").submit();\r\n");
      out.write("\t},\r\n");
      out.write("\terror : function(msg){\r\n");
      out.write("\t\talert(\"删除失败\");\r\n");
      out.write("\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function refresh(){\r\n");
      out.write("\t$(\"#currentPage\").val(1);\r\n");
      out.write("\t$(\"#userfrom\").submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"17\" valign=\"top\" background=\"");
      out.print(path );
      out.write("/images/mail_leftbg.gif\"><img src=\"");
      out.print(path );
      out.write("/images/left-top-right.gif\" width=\"17\" height=\"29\" /></td>\r\n");
      out.write("    <td valign=\"top\" background=\"");
      out.print(path );
      out.write("/images/content-bg.gif\"><table width=\"100%\" height=\"31\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"left_topbg\" id=\"table2\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"31\"><div class=\"titlebt\" onclick=\"\">气量列表</div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td width=\"16\" valign=\"top\" background=\"");
      out.print(path );
      out.write("/images/mail_rightbg.gif\"><img src=\"");
      out.print(path );
      out.write("/images/nav-right-bg.gif\" width=\"16\" height=\"29\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"middle\" background=\"");
      out.print(path );
      out.write("/images/mail_leftbg.gif\">&nbsp;</td>\r\n");
      out.write("    <td valign=\"top\" bgcolor=\"#F7F8F9\"><table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("    \r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td valign=\"top\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"4\" valign=\"top\">&nbsp;\r\n");
      out.write("        ");
      //  sf:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_sf_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fsf_005fform_0026_005fmodelAttribute_005fid_005faction.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_sf_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_sf_005fform_005f0.setParent(null);
      // /WEB-INF/jsp/gas/gasuselist.jsp(89,8) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sf_005fform_005f0.setId("userfrom");
      // /WEB-INF/jsp/gas/gasuselist.jsp(89,8) name = modelAttribute type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sf_005fform_005f0.setModelAttribute("search");
      // /WEB-INF/jsp/gas/gasuselist.jsp(89,8) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sf_005fform_005f0.setAction("uselist");
      int[] _jspx_push_body_count_sf_005fform_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_sf_005fform_005f0 = _jspx_th_sf_005fform_005f0.doStartTag();
        if (_jspx_eval_sf_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("        <input name=\"currpage\" type=\"hidden\" id=\"currentPage\"  >\r\n");
            out.write("        <table width=\"100%\" height=\"144\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"line_table\">\r\n");
            out.write("          <tr>\r\n");
            out.write("            <td height=\"27\" class=\"bordertd\" colspan=\"7\" background=\"");
            out.print(path );
            out.write("/images/news-title-bg.gif\"><img src=\"");
            out.print(path );
            out.write("/images/news-title-bg.gif\" width=\"2\" height=\"27\"></td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("            <td height=\"14\" align=\"center\" class=\"bordertd\" colspan=\"7\" >开始时间: <input id=\"sdate\" type=\"text\" onfocus=\"WdatePicker({maxDate:'#F{$dp.$D(\\'enddate\\')}'})\"  class=\"Wdate\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${search.d1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\"  name=\"d1\"/>结束时间:<input id=\"enddate\" name=\"d2\" class=\"Wdate\" onfocus=\"WdatePicker({minDate:'#F{$dp.$D(\\'sdate\\')}'})\" type=\"text\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${search.d2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\">用户：");
            if (_jspx_meth_sf_005fselect_005f0(_jspx_th_sf_005fform_005f0, _jspx_page_context, _jspx_push_body_count_sf_005fform_005f0))
              return;
            out.write("   <input type=\"submit\" value=\"搜索\"> </td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("            <td height=\"14\" align=\"center\"  class=\"bordertd\" valign=\"bottom\">序号</td>\r\n");
            out.write("            <td height=\"14\" align=\"center\"  class=\"bordertd\" valign=\"bottom\">用户</td>\r\n");
            out.write("            <td height=\"14\" align=\"center\"\t class=\"bordertd\" valign=\"bottom\">日期</td>\r\n");
            out.write("            <td height=\"14\" align=\"center\"\t class=\"bordertd\" valign=\"bottom\">用气量</td>\r\n");
            out.write("            <td height=\"14\" align=\"center\" class=\"bordertd\" valign=\"bottom\">备注</td>\r\n");
            out.write("            <td height=\"14\" align=\"center\" class=\"bordertd\" valign=\"bottom\"></td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          ");
            if (_jspx_meth_c_005fforEach_005f0(_jspx_th_sf_005fform_005f0, _jspx_page_context, _jspx_push_body_count_sf_005fform_005f0))
              return;
            out.write("\r\n");
            out.write("          <tr>\r\n");
            out.write("           <td height=\"15\" colspan=\"5\">&nbsp;&nbsp;\r\n");
            out.write("           ");
            if (_jspx_meth_c_005fif_005f0(_jspx_th_sf_005fform_005f0, _jspx_page_context, _jspx_push_body_count_sf_005fform_005f0))
              return;
            out.write("\r\n");
            out.write("           </td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("            <td height=\"5\" colspan=\"5\">&nbsp;</td>\r\n");
            out.write("          </tr>\r\n");
            out.write("        </table>\r\n");
            out.write("        ");
            int evalDoAfterBody = _jspx_th_sf_005fform_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_sf_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_sf_005fform_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sf_005fform_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sf_005fform_005f0.doFinally();
        _005fjspx_005ftagPool_005fsf_005fform_0026_005fmodelAttribute_005fid_005faction.reuse(_jspx_th_sf_005fform_005f0);
      }
      out.write("\r\n");
      out.write("         <div align=\"right\" class=\"pageinclude\"> \r\n");
      out.write("         \t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/fenye.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t\t  \t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t  \t\tfunction getPageViewUrl(currentPage){\r\n");
      out.write("\t\t\t\t\t\t  \t\t$(\"#currentPage\").val(currentPage);\r\n");
      out.write("\t\t\t\t\t\t  \t\t$(\"#userfrom\").submit();\r\n");
      out.write("\t\t\t\t\t\t  \t}\r\n");
      out.write("\t\t\t\t\t  \t</script>\r\n");
      out.write("\t\t</div> \r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"40\" colspan=\"4\"><table width=\"100%\" height=\"1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#CCCCCC\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td background=\"");
      out.print(path );
      out.write("/images/mail_rightbg.gif\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"bottom\" background=\"");
      out.print(path );
      out.write("/images/mail_leftbg.gif\"><img src=\"");
      out.print(path );
      out.write("/images/buttom_left2.gif\" width=\"17\" height=\"17\" /></td>\r\n");
      out.write("    <td background=\"");
      out.print(path );
      out.write("/images/buttom_bgs.gif\"><img src=\"");
      out.print(path );
      out.write("/images/buttom_bgs.gif\" width=\"17\" height=\"17\"></td>\r\n");
      out.write("    <td valign=\"bottom\" background=\"");
      out.print(path );
      out.write("/images/mail_rightbg.gif\"><img src=\"");
      out.print(path );
      out.write("/images/buttom_right2.gif\" width=\"16\" height=\"17\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<div id='adduser' style=\"width: 700px;height: 400px;\" class=\"pop-box\">\r\n");
      out.write("\t\t\t<div class='tit'>\r\n");
      out.write("\t\t\t\t<span class=\"tittext\"></span><img src=\"");
      out.print(path );
      out.write("/images/pic22.gif\"  class=\"shutbut\" onclick=\"hideDiv('adduser')\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"pop-box-body\">\r\n");
      out.write("\t\t\t\t<div id=\"cusinfoslist\"  style=\"width: 100%;\" class=\"div\">\r\n");
      out.write("\t\t\t\t\t<iframe name=\"adduserfrm\" id=\"adduserfrm\"  height=\"400px\" class=\"divif1\"  frameborder=0  width=\"100%\"></iframe>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_sf_005fselect_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:select
    org.springframework.web.servlet.tags.form.SelectTag _jspx_th_sf_005fselect_005f0 = (org.springframework.web.servlet.tags.form.SelectTag) _005fjspx_005ftagPool_005fsf_005fselect_0026_005fpath_005fitems_005fitemValue_005fitemLabel_005fdisabled_005fnobody.get(org.springframework.web.servlet.tags.form.SelectTag.class);
    _jspx_th_sf_005fselect_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sf_005fselect_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_005fform_005f0);
    // /WEB-INF/jsp/gas/gasuselist.jsp(96,358) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sf_005fselect_005f0.setPath("userid");
    // /WEB-INF/jsp/gas/gasuselist.jsp(96,358) name = disabled type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sf_005fselect_005f0.setDisabled((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usedisable}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/gas/gasuselist.jsp(96,358) name = items type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sf_005fselect_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/gas/gasuselist.jsp(96,358) name = itemLabel type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sf_005fselect_005f0.setItemLabel("name");
    // /WEB-INF/jsp/gas/gasuselist.jsp(96,358) name = itemValue type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sf_005fselect_005f0.setItemValue("id");
    int[] _jspx_push_body_count_sf_005fselect_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_005fselect_005f0 = _jspx_th_sf_005fselect_005f0.doStartTag();
      if (_jspx_th_sf_005fselect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_005fselect_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_005fselect_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_005fselect_005f0.doFinally();
      _005fjspx_005ftagPool_005fsf_005fselect_0026_005fpath_005fitems_005fitemValue_005fitemLabel_005fdisabled_005fnobody.reuse(_jspx_th_sf_005fselect_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_005fform_005f0);
    // /WEB-INF/jsp/gas/gasuselist.jsp(106,10) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/gas/gasuselist.jsp(106,10) '${pageView.records}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageView.records}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/gas/gasuselist.jsp(106,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("us");
    // /WEB-INF/jsp/gas/gasuselist.jsp(106,10) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("status");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("          <tr>\r\n");
          out.write("            <td height=\"20\" align=\"center\" class=\"bordertd\" valign=\"bottom\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index+1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td height=\"20\" align=\"center\" class=\"bordertd\" valign=\"bottom\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${us.buser.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td height=\"20\" align=\"center\" class=\"bordertd\" valign=\"bottom\"> ");
          if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write(" </td>\r\n");
          out.write("            <td height=\"20\" align=\"center\" class=\"bordertd\" valign=\"bottom\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${us.gasvol}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td height=\"20\" align=\"center\" class=\"bordertd\" valign=\"bottom\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${us.description}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td height=\"20\" align=\"center\" class=\"bordertd\" valign=\"bottom\"></td>\r\n");
          out.write("          </tr>\r\n");
          out.write("          ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsp/gas/gasuselist.jsp(110,77) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${us.addtime}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/gas/gasuselist.jsp(110,77) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy-MM-dd hh:mm:ss");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_005fform_005f0);
    // /WEB-INF/jsp/gas/gasuselist.jsp(118,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role=='1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("           <span class=\"sec1\" onclick=\"addgasuse()\"> &nbsp;&nbsp;新增气量记录&nbsp;&nbsp;</span>\r\n");
        out.write("           ");
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
