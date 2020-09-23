package ru.mirea.ksp.example2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class MyServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(AskServlet.class, "/ask.html");
        handler.addServlet(ReplyServlet.class, "/reply.html");
        server.setHandler(handler);
        server.start();
    }
}
