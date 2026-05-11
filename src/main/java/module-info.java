module com.tahsynapse.wordscramble {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tahsynapse.wordscramble to javafx.fxml;
    exports com.tahsynapse.wordscramble;
}