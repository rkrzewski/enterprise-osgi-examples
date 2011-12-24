package pl.caltha.osgi.bndtools.scala.impl

import pl.caltha.osgi.bntools.scala.api.Greeting
import aQute.bnd.annotation.component.Component

@Component
class GreetingImpl extends Greeting {

  def sayHello(name: String): String = "Hello " + name

}