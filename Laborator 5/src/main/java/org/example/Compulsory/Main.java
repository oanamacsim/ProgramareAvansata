package org.example.Compulsory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Document document1 = new Document("path1", 1, "doc1", "Andrei");
        Document document2 = new Document("path2", 2, "doc2", "Mihai");
        Document document3 = new Document("path3", 3, "doc3", "Ana");

        List<Document> documents = new ArrayList<Document>(){
            {
                add(document1);
                add(document2);
                add(document3);
            }
        };

        Catalog catalog = new Catalog(documents);

        String jsonToSavePath = "";
        String jsonToLoadPath = "";

        DocumentManager documentManager = new DocumentManager();
        documentManager.save(jsonToSavePath, catalog.getDocuments());

        catalog.setDocuments(documentManager.load(jsonToLoadPath));

        documentManager.toString(catalog.getDocuments());
    }
}