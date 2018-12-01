package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private double number1=0;
    private double number2=0;
    private String operator ="";
    boolean firstOperation=true;
    @FXML
    private TextField output;
   @FXML
   private TextField textfield1;
   boolean firstResult=true;
   boolean firstPoint=true;
  @FXML

   void numberClicked(ActionEvent event) {
       String number;
       if (firstResult) {
           number = ((Button) event.getSource()).getText();
           textfield1.appendText(number);
           output.setText(output.getText() + number);
       } else {
           output.setText("");
           number = ((Button) event.getSource()).getText();
           textfield1.appendText(number);
           output.setText(output.getText() + number);
           firstResult = true;
       }
   }
   @FXML
   void operatorClicked(ActionEvent event) {
       String value = ((Button) event.getSource()).getText();
       firstPoint = true;
       if (!value.equals("=")) {
           textfield1.appendText(value);
           if (firstOperation) {
               operator = value;
               try{number1 = Double.parseDouble(output.getText());}
               catch(java.lang.NumberFormatException e){
                   number1 =(-0);
               }
               output.setText("");
               firstOperation = false;

           } else {
               try{output.setText(String.valueOf(Model.calculate(number1, Double.parseDouble(output.getText()), operator)));}
               catch(java.lang.NumberFormatException e){
                   resetClicked();
               }
               operator = value;
               try{number1 = Double.parseDouble(output.getText());}
               catch(java.lang.NumberFormatException e){
                   resetClicked();
               }
               firstResult = false;

           }
       } else {
           try{output.setText(String.valueOf(Model.calculate(number1, Double.parseDouble(output.getText()), operator)));}
           catch(java.lang.NumberFormatException e){
               resetClicked();
           }
           operator="";
           textfield1.setText("");
       }
   }

    @FXML
    void pointClicked(){
      if (firstPoint){
          output.appendText(".");
          firstPoint=false;
          textfield1.appendText(".");
      }
    }
    @FXML
    void resetClicked(){
        operator ="";
        number1=0;
        output.setText("");
        firstOperation=true;
        textfield1.setText("");
        firstPoint=true;
    }
}
