package org.example.Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class LoadCommand implements Command
{
    private final Catalog catalog;
    private final String diskPath;

    public LoadCommand(Catalog cat, String diskPath)
    {
        this.catalog = cat;
        this.diskPath = diskPath;
    }

    @Override
    public void runCommand()
    {
        try
        {
            // Use Jackson's ObjectMapper to deserialize the JSON string into an ArrayList
            String jsonString = new String(Files.readAllBytes(Paths.get(diskPath)));

            ObjectMapper mapper = new ObjectMapper();
            org.example.Homework.Document[] objects = mapper.readValue(jsonString, org.example.Homework.Document[].class);

            this.catalog.setDocuments(Arrays.asList(objects));
        }
        catch (IOException e)
        {
            throw new CustomException("Cannot read from file", e);
        }
    }
}
