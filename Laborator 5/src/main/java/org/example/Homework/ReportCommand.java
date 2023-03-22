package org.example.Homework;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

public class ReportCommand implements Command
{
    private Catalog catalog;
    private String path;

    private static final String TEMPLATE_NAME = "report_template.vm";

    public ReportCommand(Catalog catalog, String path)
    {
        this.catalog = catalog;
        this.path = path;
    }

    @Override
    public void runCommand()
    {
        Properties props = new Properties();
        props.setProperty("resource.loader", "class");
        props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        VelocityEngine engine = new VelocityEngine(props);
        Template template = engine.getTemplate(TEMPLATE_NAME);
        VelocityContext context = new VelocityContext();
        context.put("documents", catalog.getDocuments());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        try
        {
            FileWriter file = new FileWriter(path);
            file.write(writer.toString());
            file.close();
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(path));
        }
        catch (IOException e)
        {
            throw new CustomException("Cannot read or write the document.", e);
        }
        catch(IllegalArgumentException e)
        {
            throw new CustomException("Illegal Argument Exception", e);
        }
    }
}
