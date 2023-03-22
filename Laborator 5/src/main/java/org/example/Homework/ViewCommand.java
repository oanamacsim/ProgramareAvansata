package org.example.Homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command
{
    public ViewCommand(Document document)
    {
        this.document = document;
    }

    Document document;

    @Override
    public void runCommand()
    {
        Desktop desktop = Desktop.getDesktop();

        try
        {
            desktop.open(new File(document.getPath()));
        }
        catch (IOException e)
        {
            throw new CustomException("Cannot open the document.", e);
        }
        catch(IllegalArgumentException e)
        {
            throw new CustomException("Illegal Argument Exception", e);
        }
    }
}
