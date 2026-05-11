package com.tahsynapse.wordscramble;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class Controller {
    // Buttons defined in FXML (fx:id)
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;

    // Slot labels defined in FXML (fx:id)
    @FXML private Label slot1;
    @FXML private Label slot2;
    @FXML private Label slot3;
    @FXML private Label slot4;
    @FXML private Label slot5;
    @FXML private Label slot6;
    @FXML private Label slot7;

    // index of next slot to fill (1-based for clarity)
    private int currentSlot = 1;
    // minimal hard-coded target word matching letters in the FXML
    private static final String TARGET = "ORANGES";

    // initialize is called by FXMLLoader after fields are injected
    @FXML
    private void initialize() {
        currentSlot = 1;
        // ensure slots show dash initially
        slot1.setText("-");
        slot2.setText("-");
        slot3.setText("-");
        slot4.setText("-");
        slot5.setText("-");
        slot6.setText("-");
        slot7.setText("-");
        // enable all buttons
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        // add a style class to each button so hover styling is applied via CSS
        btn1.getStyleClass().add("letter-button");
        btn2.getStyleClass().add("letter-button");
        btn3.getStyleClass().add("letter-button");
        btn4.getStyleClass().add("letter-button");
        btn5.getStyleClass().add("letter-button");
        btn6.getStyleClass().add("letter-button");
        btn7.getStyleClass().add("letter-button");
        // prevent buttons from holding initial focus (so first button won't show blue focus border)
        btn1.setFocusTraversable(false);
        btn2.setFocusTraversable(false);
        btn3.setFocusTraversable(false);
        btn4.setFocusTraversable(false);
        btn5.setFocusTraversable(false);
        btn6.setFocusTraversable(false);
        btn7.setFocusTraversable(false);
    }

    // FXML uses onAction="#handleLetterClick" so this method name must match
    @FXML
    protected void handleLetterClick(ActionEvent event) {
        if (!(event.getSource() instanceof Button)) return;
        Button src = (Button) event.getSource();
        String letter = src.getText();

        // put letter into next available slot
        switch (currentSlot) {
            case 1 -> slot1.setText(letter);
            case 2 -> slot2.setText(letter);
            case 3 -> slot3.setText(letter);
            case 4 -> slot4.setText(letter);
            case 5 -> slot5.setText(letter);
            case 6 -> slot6.setText(letter);
            case 7 -> slot7.setText(letter);
            default -> {
                // all slots filled; do nothing (could add reset logic)
                return;
            }
        }

        // disable the button so it can't be used again
        src.setDisable(true);
        currentSlot++;

        // if all slots are filled, check the assembled word
        if (currentSlot > 7) {
            StringBuilder sb = new StringBuilder();
            sb.append(slot1.getText())
              .append(slot2.getText())
              .append(slot3.getText())
              .append(slot4.getText())
              .append(slot5.getText())
              .append(slot6.getText())
              .append(slot7.getText());
            String assembled = sb.toString().toUpperCase();
            if (assembled.equals(TARGET)) {
                // mark slots green on success
                slot1.setStyle("-fx-background-color: lightgreen;");
                slot2.setStyle("-fx-background-color: lightgreen;");
                slot3.setStyle("-fx-background-color: lightgreen;");
                slot4.setStyle("-fx-background-color: lightgreen;");
                slot5.setStyle("-fx-background-color: lightgreen;");
                slot6.setStyle("-fx-background-color: lightgreen;");
                slot7.setStyle("-fx-background-color: lightgreen;");
            } else {
                // wrong: reset slots and re-enable buttons for another try
                slot1.setText("-");
                slot2.setText("-");
                slot3.setText("-");
                slot4.setText("-");
                slot5.setText("-");
                slot6.setText("-");
                slot7.setText("-");
                // re-enable buttons
                btn1.setDisable(false);
                btn2.setDisable(false);
                btn3.setDisable(false);
                btn4.setDisable(false);
                btn5.setDisable(false);
                btn6.setDisable(false);
                btn7.setDisable(false);
                currentSlot = 1;
            }
        }
    }

    // keep the originally-named handler if other code calls it; delegate to new method
    @FXML
    protected void handleLetterClicked(ActionEvent event) {
        handleLetterClick(event);
    }
}
