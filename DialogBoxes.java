package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogBoxes
{
    public void messageBox(String message, String title, String buttonName)
    {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label();
        label.setText(message);

        Button button = new Button();
        button.setText(buttonName);
        button.setOnAction(e->
        {
            stage.close();
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label,button);

        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.setCl

    }

}
