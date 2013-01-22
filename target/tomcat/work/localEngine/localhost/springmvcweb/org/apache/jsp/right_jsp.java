package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class right_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-color: #EEF2FB;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"17\" valign=\"top\" background=\"images/mail_leftbg.gif\"><img src=\"images/left-top-right.gif\" width=\"17\" height=\"29\" /></td>\r\n");
      out.write("    <td valign=\"top\" background=\"images/content-bg.gif\"><table width=\"100%\" height=\"31\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"left_topbg\" id=\"table2\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"31\"><div class=\"titlebt\">æ¬¢è¿çé¢</div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td width=\"16\" valign=\"top\" background=\"images/mail_rightbg.gif\"><img src=\"images/nav-right-bg.gif\" width=\"16\" height=\"29\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"middle\" background=\"images/mail_leftbg.gif\">&nbsp;</td>\r\n");
      out.write("    <td valign=\"top\" bgcolor=\"#F7F8F9\"><table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td valign=\"top\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" valign=\"top\"><span class=\"left_bt\">æè°¢æ¨ä½¿ç¨ åå®¶ä¿¡æ¯ç½ ç½ç«ç®¡çç³»ç»ç¨åº</span><br>\r\n");
      out.write("              <br>\r\n");
      out.write("            <span class=\"left_txt\">&nbsp;<img src=\"images/ts.gif\" width=\"16\" height=\"16\"> æç¤ºï¼<br>\r\n");
      out.write("          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;æ¨ç°å¨ä½¿ç¨çæ¯www.865171.cnå¼åçä¸å¥ç¨äºæå»ºåå¡ä¿¡æ¯ç±»é¨æ·åç½ç«çä¸ä¸ç³»ç»ï¼å¦ææ¨æä»»ä½çé®è¯·ç¹å·¦ä¸è§£ç</span><span class=\"left_ts\">å¨çº¿å®¢æ</span><span class=\"left_txt\">è¿è¡å¨è¯¢ï¼<br>\r\n");
      out.write("          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ä¸å¤§æ ç®å®ç¾æ´åï¼ä¸ç«éä½¿ç¨æ¹å¼ï¼åè½å¼ºå¤§ï¼æä½ç®åï¼åå°æä½æå¦åæï¼åªéä¼æå­ï¼ä¼ä¸ç½ï¼å°±ä¼ç®¡çç½ç«ï¼<br>\r\n");
      out.write("           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;æ­¤ç¨åºæ¯æ¨å»ºç«å°åºçº§åå®¶ä¿¡æ¯é¨æ·çé¦éæ¹æ¡ï¼ã <br>\r\n");
      out.write("</span></td>\r\n");
      out.write("        <td width=\"7%\">&nbsp;</td>\r\n");
      out.write("        <td width=\"40%\" valign=\"top\"><table width=\"100%\" height=\"144\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"line_table\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"7%\" height=\"27\" background=\"images/news-title-bg.gif\"><img src=\"images/news-title-bg.gif\" width=\"2\" height=\"27\"></td>\r\n");
      out.write("            <td width=\"93%\" background=\"images/news-title-bg.gif\" class=\"left_bt2\">ææ°å¨æ</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"102\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("            <td height=\"102\" valign=\"top\"></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"5\" colspan=\"2\">&nbsp;</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" valign=\"top\"><!--JavaScripté¨å-->\r\n");
      out.write("              <SCRIPT language=javascript>\r\n");
      out.write("function secBoard(n)\r\n");
      out.write("{\r\n");
      out.write("for(i=0;i<secTable.cells.length;i++)\r\n");
      out.write("secTable.cells[i].className=\"sec1\";\r\n");
      out.write("secTable.cells[n].className=\"sec2\";\r\n");
      out.write("for(i=0;i<mainTable.tBodies.length;i++)\r\n");
      out.write("mainTable.tBodies[i].style.display=\"none\";\r\n");
      out.write("mainTable.tBodies[n].style.display=\"block\";\r\n");
      out.write("}\r\n");
      out.write("          </SCRIPT>\r\n");
      out.write("              <!--HTMLé¨å-->\r\n");
      out.write("              <TABLE width=72% border=0 cellPadding=0 cellSpacing=0 id=secTable>\r\n");
      out.write("                <TBODY>\r\n");
      out.write("                  <TR align=middle height=20>\r\n");
      out.write("                    <TD align=\"center\" class=sec2 onclick=secBoard(0)>éªè¯ä¿¡æ¯</TD>\r\n");
      out.write("                    <TD align=\"center\" class=sec1 onclick=secBoard(1)>ç»è®¡ä¿¡æ¯</TD>\r\n");
      out.write("                    <TD align=\"center\" class=sec1 onclick=secBoard(2)>ç³»ç»åæ°</TD>\r\n");
      out.write("                    <TD align=\"center\" class=sec1 onclick=secBoard(3)>çæè¯´æ</TD>\r\n");
      out.write("                  </TR>\r\n");
      out.write("                </TBODY>\r\n");
      out.write("              </TABLE>\r\n");
      out.write("          <TABLE class=main_tab id=mainTable cellSpacing=0\r\n");
      out.write("cellPadding=0 width=100% border=0>\r\n");
      out.write("                <!--å³äºTBODYæ è®°-->\r\n");
      out.write("                <TBODY style=\"DISPLAY: block\">\r\n");
      out.write("                  <TR>\r\n");
      out.write("                    <TD vAlign=top align=middle><TABLE width=98% height=\"133\" border=0 align=\"center\" cellPadding=0 cellSpacing=0>\r\n");
      out.write("                        <TBODY>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD width=\"4%\" height=\"28\" background=\"images/news-title-bg.gif\"></TD>\r\n");
      out.write("                            <TD height=\"25\" colspan=\"2\" background=\"images/news-title-bg.gif\" class=\"left_txt\">äº²ç±çç®¡çåï¼ <font color=\"#FFFFFF\" class=\"left_ts\"><b></b></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD width=\"42%\" height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯åç±»ä¿¡æ¯ï¼ </span>\r\n");
      out.write("                               \r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                            <TD width=\"54%\" height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯å¹¿åå¼ è´´ï¼ </span>\r\n");
      out.write("                               \r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯åå®¶å±ç¤ºï¼ </span>\r\n");
      out.write("                               \r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯ç½ä¸ååï¼ </span>\r\n");
      out.write("                               \r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯ç½ä¸åçï¼ </span>\r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯å¸åºèçï¼ </span>\r\n");
      out.write("                               \r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯å¸åºèµè®¯ï¼ </span>\r\n");
      out.write("                               \r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¨ææªéªè¯åå®¶ååï¼ </span>\r\n");
      out.write("                                <span class=\"left_ts\"> </span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                        </TBODY>\r\n");
      out.write("                    </TABLE></TD>\r\n");
      out.write("                  </TR>\r\n");
      out.write("                </TBODY>\r\n");
      out.write("                <!--å³äºcellséå-->\r\n");
      out.write("                <TBODY style=\"DISPLAY: none\">\r\n");
      out.write("                  <TR>\r\n");
      out.write("                    <TD vAlign=top align=middle><TABLE width=98% height=\"133\" border=0 align=\"center\" cellPadding=0 cellSpacing=0>\r\n");
      out.write("                        <TBODY>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD width=\"4%\" height=\"28\" background=\"images/news-title-bg.gif\"></TD>\r\n");
      out.write("                            <TD colspan=\"2\" background=\"images/news-title-bg.gif\" class=\"left_txt\">ç°æä¼åï¼å&nbsp;&nbsp; å¶ä¸­ï¼                                å&nbsp;&nbsp;&nbsp;&nbsp;å&nbsp;&nbsp;&nbsp;&nbsp;å</TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD width=\"42%\" height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æåç±»ä¿¡æ¯ï¼ </span><span class=\"left_txt\">æ¡</span></TD>\r\n");
      out.write("                            <TD width=\"54%\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æå¹¿åå¼ è´´ï¼ </span><span class=\"left_txt\">æ¡</span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æåå®¶å±ç¤ºï¼ </span><span class=\"left_txt\">ä¸ª</span></TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æç½ä¸ååï¼ </span><span class=\"left_txt\">ä¸ª</span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æç½ä¸åçï¼ </span><span class=\"left_txt\">ä¸ª</span></TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æå¸åºèçï¼ </span><span class=\"left_txt\">ä¸ª</span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æå¸åºèµè®¯ï¼ </span><span class=\"left_txt\">æ¡</span></TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ¬ç«ç°æåå®¶ååï¼ </span><span class=\"left_txt\">ä¸ª</span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                        </TBODY>\r\n");
      out.write("                    </TABLE></TD>\r\n");
      out.write("                  </TR>\r\n");
      out.write("                </TBODY>\r\n");
      out.write("                <!--å³äºtBodieséå-->\r\n");
      out.write("                <TBODY style=\"DISPLAY: none\">\r\n");
      out.write("                  <TR>\r\n");
      out.write("                    <TD vAlign=top align=middle><TABLE width=98% border=0 align=\"center\" cellPadding=0 cellSpacing=0>\r\n");
      out.write("                        <TBODY>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD width=\"4%\" height=\"25\" background=\"images/news-title-bg.gif\"></TD>\r\n");
      out.write("                            <TD height=\"25\" colspan=\"2\" background=\"images/news-title-bg.gif\" class=\"left_txt\"><span class=\"TableRow2\">æå¡å¨IP:</span>ç³»ç»çæ¬ï¼</TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD width=\"42%\" height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æå¡å¨ç±»åï¼</span></TD>\r\n");
      out.write("                            <TD width=\"54%\" height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">èæ¬è§£éå¼æï¼</span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" colspan=\"2\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">ç«ç¹ç©çè·¯å¾ï¼</span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">FSOææ¬è¯»åï¼</span><span class=\"TableRow2\"><font color=\"#FF0066\"><b><img src=\"images/X.gif\" width=\"12\" height=\"13\"></b></font><img src=\"images/g.gif\" width=\"12\" height=\"12\"></span></TD>\r\n");
      out.write("                            <TD height=\"25\" bgcolor=\"#FAFBFC\"><span class=\"left_txt\">æ°æ®åºä½¿ç¨ï¼</span><span class=\"left_ts\"><img src=\"images/X.gif\" width=\"12\" height=\"13\"><b style=\"color:blue\">\r\n");
      out.write("                              \r\n");
      out.write("                            MS SQL\r\n");
      out.write("                            \r\n");
      out.write("                              ACCESS\r\n");
      out.write("                              \r\n");
      out.write("                            </b></span></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                         \r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                        </TBODY>\r\n");
      out.write("                    </TABLE></TD>\r\n");
      out.write("                  </TR>\r\n");
      out.write("                </TBODY>\r\n");
      out.write("                <!--å³äºdisplayå±æ§-->\r\n");
      out.write("                <TBODY style=\"DISPLAY: none\">\r\n");
      out.write("                  <TR>\r\n");
      out.write("                    <TD vAlign=top align=middle><TABLE width=98% border=0 align=\"center\" cellPadding=0 cellSpacing=0>\r\n");
      out.write("                        <TBODY>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD width=\"4%\" background=\"images/news-title-bg.gif\"></TD>\r\n");
      out.write("                            <TD width=\"91%\" background=\"images/news-title-bg.gif\" class=\"left_ts\">ããç¨åºè¯´æï¼</TD>\r\n");
      out.write("                            <TD width=\"5%\" background=\"images/news-title-bg.gif\" class=\"left_txt\">&nbsp;</TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\"><span class=\"left_ts\">1ã</span>æ¬ç¨åºç±www.865171.cnå¨æ°æ¹é (QQ:215288671) </TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\">&nbsp;</TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\"><span class=\"left_ts\">2ã</span>æ¬ç¨åºä»æä¾ä½¿ç¨ï¼ä»»ä½è¿åäºèç½è§å®çè¡ä¸ºï¼èªè¡è´è´£ï¼</TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\">&nbsp;</TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\"><span class=\"left_ts\">3ã</span> æ¯æä½èçå³å¨ï¼è¯·ä¿ççæã</TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\">&nbsp;</TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\">&nbsp;</TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\"><span class=\"left_ts\">4ã</span>ç¨åºä½¿ç¨ï¼ææ¯æ¯æè¯·èç³»www.865171.cnã</TD>\r\n");
      out.write("                            <TD bgcolor=\"#FAFBFC\" class=\"left_txt\">&nbsp;</TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                          <TR>\r\n");
      out.write("                            <TD height=\"5\" colspan=\"3\"></TD>\r\n");
      out.write("                          </TR>\r\n");
      out.write("                        </TBODY>\r\n");
      out.write("                    </TABLE></TD>\r\n");
      out.write("                  </TR>\r\n");
      out.write("                </TBODY>\r\n");
      out.write("            </TABLE></td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td valign=\"top\"><table width=\"100%\" height=\"144\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"line_table\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"7%\" height=\"27\" background=\"images/news-title-bg.gif\"><img src=\"images/news-title-bg.gif\" width=\"2\" height=\"27\"></td>\r\n");
      out.write("            <td width=\"93%\" background=\"images/news-title-bg.gif\" class=\"left_bt2\">ç¨åºè¯´æ</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"102\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("            <td height=\"102\" valign=\"top\"><label></label>\r\n");
      out.write("              <label>\r\n");
      out.write("              <textarea name=\"textarea\" cols=\"48\" rows=\"8\" class=\"left_txt\">ä¸ãä¸ä¸çå°åºçº§åå®¶é¨æ·å»ºç«é¦éæ¹æ¡ï¼\r\n");
      out.write("äºãå¨ç«ä¸å·éï¼ä¸æ¬¡æ³¨åï¼ç»èº«ä½¿ç¨ï¼ä¸ä¸ªå¸å·ï¼å¨ç«éç¨ï¼\r\n");
      out.write("ä¸ãåç±»ä¿¡æ¯ãåå®¶å±ç¤ºï¼ç¾ä¸èçï¼ãç½ä¸ååãç½ä¸åçï¼ç½ä¸é»é¡µï¼ãå¹¿åå¼ è´´ãå¸åºèçãå¸åºèµè®¯ä¸å¤§æ ç®å®ç¾æ´åã\r\n");
      out.write("åãçé¢è®¾è®¡ç²¾ç¾ï¼åå°åè½å¼ºå¤§ãå»çå¼åå°æä½ï¼æ éä¸ä¸çç½ç«å¶ä½ç¥è¯ï¼åªè¦ä¼æå­ï¼å°±ä¼ç®¡çç»´æ¤ç½ç«ã</textarea>\r\n");
      out.write("              </label></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"5\" colspan=\"2\">&nbsp;</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"40\" colspan=\"4\"><table width=\"100%\" height=\"1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#CCCCCC\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"2%\">&nbsp;</td>\r\n");
      out.write("        <td width=\"51%\" class=\"left_txt\"><img src=\"images/icon-mail2.gif\" width=\"16\" height=\"11\"> å®¢æ·æå¡é®ç®±ï¼215288671@qq.com<br>\r\n");
      out.write("              <img src=\"images/icon-phone.gif\" width=\"17\" height=\"14\"> å®æ¹ç½ç«ï¼http://www.865171.cn</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td background=\"images/mail_rightbg.gif\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"bottom\" background=\"images/mail_leftbg.gif\"><img src=\"images/buttom_left2.gif\" width=\"17\" height=\"17\" /></td>\r\n");
      out.write("    <td background=\"images/buttom_bgs.gif\"><img src=\"images/buttom_bgs.gif\" width=\"17\" height=\"17\"></td>\r\n");
      out.write("    <td valign=\"bottom\" background=\"images/mail_rightbg.gif\"><img src=\"images/buttom_right2.gif\" width=\"16\" height=\"17\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
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
