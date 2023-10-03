package utils;

import javafx.scene.control.Alert;

public class Alerts {
    public static void alertWarnig(Alert.AlertType type, String title){
        Alert alertWarning = new Alert(type);

        alertWarning.setTitle("Error");
        alertWarning.setHeaderText(null);
        alertWarning.setContentText(title);
        alertWarning.showAndWait();
    }
}
