package org.example.Homework;

public class ListCommand implements Command
{
    private Catalog catalog;

    public ListCommand(Catalog catalog)
    {
        this.catalog = catalog;
    }

    @Override
    public void runCommand()
    {
        System.out.println(catalog.toString());
    }
}
