package pl.caltha.osgi.bndtools.scala.cmd

import java.io.PrintStream
import org.apache.felix.shell.Command
import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import pl.caltha.osgi.bntools.scala.api.Greeting
import scala.reflect.BeanProperty

@Component
class GreetingCommand extends Command {

  var greetingService: Greeting = null
  
  @Reference 
  def setGreetingService(g: Greeting): Unit = { greetingService = g }

  def getName() = "greet"

  def getShortDescription() = "Display a greeting"

  def getUsage() = "greet <name>"

  def execute(line: String, out: PrintStream, err: PrintStream): Unit = {
    line.split("\\s+") match {
      case Array(_, name) => println(greetingService.sayHello(name))
      case _ =>
    }
  }
}