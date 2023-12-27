module com.example.exam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exam to javafx.fxml;
    exports com.example.exam;

    requires org.postgresql.jdbc;
    requires java.sql;

    opens com.example.exam.Controller to javafx.fxml;
    exports com.example.exam.Controller;

    opens com.example.exam.Models to javafx.fxml;
    exports com.example.exam.Models;
}