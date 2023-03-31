package com.example.lab6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class PositionalGame extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        //create the topSection
        BorderPane topSection = new BorderPane();

        Text numOfDotsText = new Text("Number of dots:");
        final Spinner<Integer> spinner = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10, 2);
        spinner.setValueFactory(valueFactory);
        Text lineProbabilityText = new Text("Line probability:");
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "0.25",
                        "0.5",
                        "0.75",
                        "1"
                );
        final ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setValue("0.75");
        Button createNewGameBtn = new Button("Create new game");
        HBox topContainer = new HBox();
        topContainer.setSpacing(10);
        topContainer.setPadding(new Insets(10, 0, 10, 0));
        topContainer.getChildren().add(numOfDotsText);
        topContainer.getChildren().add(spinner);
        topContainer.getChildren().add(lineProbabilityText);
        topContainer.getChildren().add(comboBox);
        topContainer.getChildren().add(createNewGameBtn);
        topContainer.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        topContainer.alignmentProperty().set(Pos.CENTER);
        topSection.setCenter(topContainer);

        //create the centerSection

        BorderPane centerSection = new BorderPane();
        centerSection.setCenter(new Canvas(400, 400));
        centerSection.setBorder(new Border(new BorderStroke(Color.rgb(200, 200, 200), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        int numOfPoints = spinner.getValue();
        drawPointsAndLines(centerSection, numOfPoints);
        createNewGameBtn.setOnAction(new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                drawPointsAndLines(centerSection, spinner.getValue());
            }
        });

        //create the bottomSection
        BorderPane bottomSection = new BorderPane();
        Button load = new Button("Load");
        Button save = new Button("Save");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        HBox bottomContainer = new HBox();
        bottomContainer.setSpacing(10);
        bottomContainer.setPadding(new Insets(10, 0, 10, 0));
        bottomContainer.getChildren().add(load);
        bottomContainer.getChildren().add(save);
        bottomContainer.getChildren().add(reset);
        bottomContainer.getChildren().add(exit);

        bottomSection.setCenter(bottomContainer);

        //create the mainframe
        BorderPane mainFrame = new BorderPane();
        mainFrame.setTop(topSection);
        mainFrame.setCenter(centerSection);
        mainFrame.setBottom(bottomSection);

        bottomContainer.alignmentProperty().set(Pos.CENTER);
        bottomContainer.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        primaryStage.setScene(new Scene(mainFrame, 800, 600));
        primaryStage.setTitle("Lab6 JavaFX");
        primaryStage.show();
    }

    private void drawPointsAndLines(BorderPane section, int numOfPoints)
    {
        // Get the canvas from the center section
        Canvas canvas = (Canvas) section.getCenter();

        // Get the width and height of the canvas
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        // Calculate the center point of the canvas
        double centerX = canvasWidth / 2;
        double centerY = canvasHeight / 2;

        // Calculate the radius of the circle
        double radius = Math.min(canvasWidth, canvasHeight) / 2.5;

        // Calculate the angle between each point
        double angleBetweenPoints = 2 * Math.PI / numOfPoints;

        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Clear the canvas
        gc.clearRect(0, 0, canvasWidth, canvasHeight);

        List<Point> points = new ArrayList<>();

        // Draw each point in a circle
        for (int i = 0; i < numOfPoints; i++)
        {
            double angle = i * angleBetweenPoints;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            gc.fillOval(x - 5, y - 5, 10, 10);
            points.add(new Point(x, y));
        }

        gc.setStroke(Color.rgb(125, 125, 125));
        for (int pointIndex1 = 0; pointIndex1 < points.size(); pointIndex1++)
        {
            for (int pointIndex2 = pointIndex1 + 1; pointIndex2 < points.size(); pointIndex2++)
            {
                if (pointIndex1 != pointIndex2)
                {
                    Point point1 = points.get(pointIndex1);
                    Point point2 = points.get(pointIndex2);
                    gc.strokeLine(point1.x, point1.y, point2.x, point2.y);
                }
            }
        }
        gc.setStroke(Color.rgb(0, 0, 0));
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}

