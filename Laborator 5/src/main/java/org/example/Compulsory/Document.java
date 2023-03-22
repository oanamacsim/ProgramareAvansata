package org.example.Compulsory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Document
{
    private String path;
    private int id;
    private String name;
    private String author;

    public Document()
    {

    }

    public Document(String path, int id, String name, String author)
    {
        this.path = path;
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "{" +
                "path='" + path + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
