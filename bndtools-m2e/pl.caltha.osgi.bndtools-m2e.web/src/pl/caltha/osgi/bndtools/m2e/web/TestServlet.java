package pl.caltha.osgi.bndtools.m2e.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.caltha.osgi.bndtools.m2e.api.Greeting;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component(provide=Servlet.class, properties= { "alias=/hello" })
public class TestServlet extends HttpServlet {
    
	private static final long serialVersionUID = -8160611306580561471L;
	
	private Greeting greetingSvc;
	
	@Reference
    public void setGreeting(Greeting greetingSvc) {
        this.greetingSvc = greetingSvc;
    }
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().append(greetingSvc.sayHello("world"));
    }
}
