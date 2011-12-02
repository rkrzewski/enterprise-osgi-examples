package pl.caltha.osgi.m2e.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.caltha.osgi.m2e.util.Utility;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("Hello from a Servlet!\n");
		Utility util = new Utility();
		pw.append(util.hello());
		pw.close();
	}
}
