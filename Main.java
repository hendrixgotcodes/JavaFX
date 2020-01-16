package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent> {

    Button btn = new Button();
    Label lbl = new Label();
    Button decBtn;
    Button incBtn;
    Label countLbl;
    int counter;
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        btn.setText("Click me");
        btn.setOnAction(e ->
        {
            if (lbl.getText().equalsIgnoreCase(""))
            {
                lbl.setText("Hello World");
            }
            else
            {
                lbl.setText("");
            }
        });
        Button switchbtn = new Button();
        switchbtn.setText("Next Page");
        lbl.setText("");
        BorderPane bp = new BorderPane();
        bp.setTop(lbl);
        bp.setRight(btn);
        bp.setLeft(switchbtn);
        Scene scene = new Scene(bp, 300, 200);




        countLbl = new Label();
        counter = 0;
        countLbl.setText(String.valueOf(counter));
        decBtn = new Button();
        decBtn.setText("Decrease");
        decBtn.setOnAction(this);

        incBtn = new Button();
        incBtn.setText("Increase");
        incBtn.setOnAction(this);

        DialogBoxes mb = new DialogBoxes();

        Button switchBtn1 = new Button();
        switchBtn1.setText("Previous page");
        switchBtn1.setOnAction(e->
        {
            //primaryStage.setScene(scene);
            mb.confirmationBox("Hello","Greetings","Confirm","Cancel");

        });

        BorderPane bp1 = new BorderPane();
        bp1.setTop(countLbl);

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(incBtn,decBtn,switchBtn1);
        hBox.setAlignment(Pos.CENTER);

        bp1.setBottom(hBox);

        Scene countScene = new Scene(bp1, 300, 200);

        switchbtn.setOnAction(e ->
        {
            primaryStage.setScene(countScene);
        });

        primaryStage.setOnCloseRequest(e->
        {
            e.consume();
            close_button();
        });
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(decBtn))
        {
            counter--;
            countLbl.setText(String.valueOf(counter));
        }
        else if (actionEvent.getSource().equals(incBtn))
        {
            counter++;
            countLbl.setText(String.valueOf(counter));
        }
    }
    private void close_button()
    {
        boolean reallyQuit = false;
        DialogBoxes dialogBoxes = new DialogBoxes();
        reallyQuit = dialogBoxes.confirmationBox("Do you really want to quit ?","Confirmation","Yes","No");
        if (reallyQuit)
        {
            stage.close();
        }

    }
}
