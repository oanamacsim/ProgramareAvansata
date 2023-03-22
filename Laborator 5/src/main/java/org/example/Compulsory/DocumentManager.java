package org.example.Compulsory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DocumentManager
{
    public void add(List<Document>documents, Document document)
    {
        documents.add(document);
    }

    public String toString(List<Document> documents)
    {
        return "{" +
                "documents=" + documents +
                '}';
    }

    public void save(String filePath, List<Document> documents) throws JsonProcessingException
    {
        //save catalogue as json
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(documents);

        try
        {
            FileWriter file = new FileWriter(filePath);
            file.write(jsonString);
            file.close();
        }
        catch (IOException e)
        {
            System.out.println("IOException. Error on writing file.");
            e.printStackTrace();
        }
    }

    public List<Document> load(String filePath)
    {
        List<Document> documents = null;

        try
        {
            String jsonFileLoadedAsString = new String(Files.readAllBytes(Paths.get(filePath)));

            ObjectMapper mapper = new ObjectMapper();
            Document[] objects = mapper.readValue(jsonFileLoadedAsString, Document[].class);
            documents = Arrays.asList(objects);
        }
        catch (IOException e)
        {
            System.out.println("IOException. Error on reading file.");
            e.printStackTrace();
        }

        return documents;
    }
}
