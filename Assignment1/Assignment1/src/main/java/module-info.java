module com.example.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.assignment1 to javafx.fxml,xstream;
    exports com.example.assignment1;

}