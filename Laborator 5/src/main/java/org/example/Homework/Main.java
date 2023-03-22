package org.example.Homework;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Document> documents = new ArrayList<Document>(){
            {
                add(new Document("D:\\test_json.json", 1, "doc1", "Andrei"));
                add(new Document("path2", 2, "doc2", "Mihai"));
                add(new Document("path3", 3, "doc3", "Ana"));
            }
        };

        Catalog catalog = new Catalog(documents);

        //show documents from catalogue
        Command listItems = new ListCommand(catalog);
        listItems.runCommand();

        //generate htmlReport
        String htmlReportPath = "D:\\report.html";
        Command report = new ReportCommand(catalog, htmlReportPath);
        report.runCommand();

        Command viewCommand = new ViewCommand(documents.get(0));
        viewCommand.runCommand();

        /*
        Steps to generate and execute the .jar archive:
        I created an artefact from project structure
        To the created artefact I selected the Homework.Main.class as the main class.
        To generate the .jar I built the project artifacts (Build->BuildArtifacts)
        To execute the jar archive, I wrote in the terminal: java -jar \ProgramareAvansata\Lab5\out\artifacts\Lab5_jar\Lab5.jar
         */
    }
}