package io.wisoft.capstone;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Initialization {
  public static void main(String[] args) {
    final Logger logger = LoggerFactory.getLogger(Initialization.class);

    final ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    contextHandler.setContextPath("/");

    final ResourceConfig resourceConfig = new ResourceConfig();
    resourceConfig.packages(Initialization.class.getName());

    final Server server = new Server(8080);
    server.setHandler(contextHandler);

    final ServletHolder servletHolder = contextHandler.addServlet(ServletContainer.class, "/2018/capstone/v1/api/*");
    servletHolder.setInitOrder(1);
    servletHolder.setInitParameter("jersey.config.server.provider.packages", "io.wisoft.capstone.controller");

    try {
      logger.info("2018 Capstone server is running on port 8080.");
      server.start();
      server.join();
    } catch (final Exception e) {
      logger.error("Error : " , e);
    } finally {
      server.destroy();
    }
  }
}
