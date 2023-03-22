package org.example.Homework;

public class Document
{
    private String path;
    private int id;
    private String name;
    private String author;

    public Document(String path, int id, String name, String author)
    {
        this.path = path;
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Document()
    {
    }

    public String getPath()
    {
        return path;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    @Override
    public String toString()
    {
        return "{" +
                "url='" + path + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
