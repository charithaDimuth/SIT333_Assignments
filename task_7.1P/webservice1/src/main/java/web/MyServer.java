package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.DefaultServlet;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;

/**
 * HTTP server. Starts server and registers Java Servlets to URL routes.
 */
public class MyServer {

    private static int PORT = 8082;

    public void start() throws Exception {
        // HTTP server listening on port 8082.
        Server server = new Server(PORT);

        // Create the handler with sessions enabled
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");

        // ✅ Set the static resource base to your "pages" folder
        handler.setResourceBase("pages");

        // ✅ Serve login.html at /login.html
        handler.addServlet(DefaultServlet.class, "/login.html");

        // ✅ Set welcome file (optional: defaults to login.html if visiting root /)
        handler.setWelcomeFiles(new String[] { "login.html" });

        // ✅ Register existing servlets
        handler.addServlet(WelcomeServlet.class, "/");
        handler.addServlet(LoginServlet.class, "/login");
        handler.addServlet(RegistrationServlet.class, "/reg");

        // Attach handler and start server
        server.setHandler(handler);

        System.out.println("Server started!");
        server.start();
        server.join(); // Wait for server to finish
    }

    public static void main(String[] args) throws Exception {
        new MyServer().start();
    }
}