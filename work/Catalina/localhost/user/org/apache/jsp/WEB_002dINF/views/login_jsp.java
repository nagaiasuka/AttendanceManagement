/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-03-20 14:51:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.*;
import java.util.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/./template/footer.jsp", Long.valueOf(1679323871155L));
    _jspx_dependants.put("/WEB-INF/views/./template/header.jsp", Long.valueOf(1679323846162L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"jp\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <!-- bootstrap -->\n");
      out.write("    <link\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n");
      out.write("      crossorigin=\"anonymous\" />\n");
      out.write("    <title>Document</title>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("      body {\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .main-box {\n");
      out.write("        height: 100vh;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        padding: 0px;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("    <div class=\"main-box\">\n");
      out.write("      <header>\n");
      out.write("        <nav\n");
      out.write("          class=\"navbar navbar-primary bg-secondary fixed-top\"\n");
      out.write("          style=\"height: 10vh\">\n");
      out.write("          <span class=\"navbar-brand mb-0 h1 font-large p-2 text-white\"\n");
      out.write("            >Navbar</span\n");
      out.write("          >\n");
      out.write("        </nav>\n");
      out.write("      </header>\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("    <main>\n");
      out.write("    <div style=\"height: 10vh\"></div>\n");
      out.write("\n");
      out.write("    <div\n");
      out.write("        class=\"d-flex align-items-center justify-content-center p-1\"\n");
      out.write("        style=\"height: 85vh\">\n");
      out.write("        <div class=\"border col-7 p-3\">\n");
      out.write("        <br />\n");
      out.write("        <h2>ログイン</h2>\n");
      out.write("        <br />\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md\">\n");
      out.write("            <form>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                <label>メール：</label>\n");
      out.write("                <input\n");
      out.write("                    type=\"text\"\n");
      out.write("                    class=\"form-control\"\n");
      out.write("                    placeholder=\"yamada@mail.com\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                <label>パスワード：</label>\n");
      out.write("                <input type=\"password\" class=\"form-control\" />\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row center-block text-center p-3\">\n");
      out.write("            <div class=\"col-1\"></div>\n");
      out.write("            <div class=\"col-5\">\n");
      out.write("            <button\n");
      out.write("                type=\"button\"\n");
      out.write("                class=\"btn btn-outline-secondary btn-block\">\n");
      out.write("                閉じる\n");
      out.write("            </button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-5\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-outline-primary btn-block\">\n");
      out.write("                ログイン\n");
      out.write("            </button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br />\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    </main>\n");
      out.write("    ");
      out.write("\n");
      out.write("<footer\n");
      out.write("class=\"d-flex align-items-center justify-content-center bg-secondary fixed-bottom\"\n");
      out.write("style=\"height: 5vh\">\n");
      out.write("<small class=\"mb-0 p-2 text-white center-block\"\n");
      out.write("  >&copy; 発行年 著作権者</small\n");
      out.write(">\n");
      out.write("</footer>\n");
      out.write("<script\n");
      out.write("src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"\n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("<script\n");
      out.write("src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"\n");
      out.write("integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\"\n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("<script\n");
      out.write("src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\"\n");
      out.write("integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\"\n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
