package ru.mirea.ksp.example2;

import freemarker.cache.FileTemplateLoader;
import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReplyServlet extends HttpServlet {

    private Configuration freeMarker = new Configuration(Configuration.VERSION_2_3_30);

    @Override
    public void init() throws ServletException {
        freeMarker.setDefaultEncoding("UTF-8");
        try {
            freeMarker.setTemplateLoader(new FileTemplateLoader(new File(".")));
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
        freeMarker.setOutputFormat(HTMLOutputFormat.INSTANCE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("user_name");

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Template reply = freeMarker.getTemplate("reply.ftl");
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("helloUser", userName);
        try {
            reply.process(templateData, resp.getWriter());
        } catch (TemplateException ex) {
            throw new ServletException(ex);
        }
    }
}
