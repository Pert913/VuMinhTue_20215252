package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private RadioButton penButton;

    @FXML
    private ToggleGroup toolButton;
    

    private Color toolColor;

    @FXML
    void initialize() {
        penButton.setSelected(true);
        toolColor = Color.BLACK;

        toolButton.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle == penButton) {
                toolColor = Color.BLACK;
            } else if (newToggle == eraserButton) {
                toolColor = Color.WHITE;
            }
        });
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), 
                event.getY(), 4, toolColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

}
