package pl.caltha.osgi.bndtools.scala.web

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import javax.servlet.Servlet
import javax.servlet.http.HttpServlet
import pl.caltha.osgi.bntools.scala.api.Greeting
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest

@Component(provide = Array(classOf[Servlet]), properties = Array("alias=/"))
class GreetingServlet extends HttpServlet {

	var greetingService: Greeting = null
	
	@Reference
	def setGreeting(greeting: Greeting) = {
	  greetingService = greeting
	}
	
	override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
	  resp.getWriter().append(greetingService.sayHello("world")) 
	}
}