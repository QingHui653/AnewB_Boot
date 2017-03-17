package com.example.component.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *	注解方式配置servlet
 * @author woshizbh
 */
@WebServlet(urlPatterns="/myServlet2/*", description="注解Servlet的说明，未经过UTF-8编码")
public class MyServlet2 extends HttpServlet{
      
       private static final long serialVersionUID = 1L;
 
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>MyServlet2 doGet()<<<<<<<<<<<");
        doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>MyServlet2 doPost()<<<<<<<<<<<");
        resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter(); 
        out.println("<html>"); 
        out.println("<head>"); 
        out.println("<title>Hello World</title>"); 
        out.println("</head>"); 
        out.println("<body>"); 
        out.println("<h1>这是：myServlet2</h1>"); 
        out.println("</body>"); 
        out.println("</html>");
    }
}