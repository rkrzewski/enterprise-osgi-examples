Eclipse Libra tooling
---------------------

<h3>Eclipse setup</h3>
This example is using the following tool chain:

- Eclipse IDE for Java EE Developers 3.7.1 (Indigo SR1)
- OSGi Bundle Facet 0.1.1 (part of Indigo release)
- JRebel (optional)
- Gemini Web 2.0.1 

For details, see: [here](platform/eclipse-platform.p2f) 

<h3>Project import</h3>

If you happen to have JRebel license around you can play around with it.
`rebel.xml` files and provided launch configuration are tweaked to compensate for workspace 
location in the file system, but they make an assumption that the git repo will be cloned 
to a directory named `enterprise-osgi-examples` inside the workspace directory.

After cloning the repository use `Import projects > Import existing projects` on `/libra` 
subfolder, select all three.

After the import you need to switch to correct target platform to clear the build errors:
`Window > Preferences > Plug-in development > Target platform`, Select `gemini-web-2.0.1`
Resetting the platform will cause download of a number of OSGi bundles from the network. 

<h3>Running - PDE OSGi Framework launcher</h3>

When done, open `Run Configurations` dialog and find `equinox-gemini-web` under `OSGi 
Framework` category. 

Launch it and open `http://localhost:8080/libra` in the browser.

If you have JRebel try editing the html file and java sources. Changes should be visible 
at next page refresh.

<h3>Running - Eclipse Libra / WTP server Lanucher - Equinox</h3>

Eclipse Libra provides OSGi framework launchers that integrate with WTP server infrastructure.

I've tried running my example project this way but unfortunately it dind't work well. Here's what
I did:

- Open WTP `Servers` view
- Create new Server, choose `Eclipse Libra > Equinox 3.6+ Runtime Instance` (right click in view's
  area)
- Configure runtime environment, I've used Equinox 3.8M3
- Add and Remove resources view appars, close it for now.
- Open server definition (double click the server in Servers view), navigate to `Target Platform 
  Profile` tab, Click `Add...`, select `Software Site` select Indigo site in `work with` combo, 
  uncheck `Group by category`, find and select `Equinox Core Function`. Click OK. Click `Add...` 
  again, select `Software site`, choose Gemini Web site, check `Group by category`, select the 
  category (include all bundles). Click OK. Save chages to server definition. At this point the 
  server should have same target platform as the one used by PDE / OSGi framework launcher used 
  above.
- Now, open `Add and Remove resources` for the server. view is displayed. I've noticed that there 
  is a problem with module structure displayed in this view. `pl.caltha.osgi.libra.util` module is 
  nested under `pl.caltha.osgi.libra.web`, which is correct - but it appears /twice/. Furthermore
  each of these two instances of `pl.caltha.osgi.libra.util` appear to contain two more copies of 
  the latter module. See [Screenshot](images/add_remove_problem.png). When I attempt to add 
  `pl.caltha.osgi.libra.web` to the server, there's an exception thrown while closing the dialog, 
  a blank error window appears, then a `StackOverflowError` is reported. It occurs because 
  `org.eclipse.wst.server.core.internal.Server.visitModule(Server.java:2913)` goes into infinite 
  recursion. The server cannot be started and the workbench reports further `SOEs` until the module 
  is removed.
- I've noticed another issue: when I deploy only `pl.caltha.osgi.libra.util` and start the server, 
  the server is stuck in the state `[Started, Republish]`. Clicking `Publish` button on the 
  server's toolbar causes `Export plugins` dialog to appear, but `Republish` status does not go away.

