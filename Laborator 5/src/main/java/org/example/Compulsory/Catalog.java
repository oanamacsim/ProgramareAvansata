package org.example.Compulsory;

import javax.print.Doc;
import java.util.List;

public class Catalog
{
    private List<Document> documents;
    public Catalog(List<Document> documents)
    {
        this.documents = documents;
    }

    public List<Document> getDocuments()
    {
        return documents;
    }

    public void setDocuments(List<Document> documents)
    {
        this.documents = documents;
    }
}
