package ba.unsa.etf.rpr.Controller;

import ba.unsa.etf.rpr.DAL.OwnerDAO;
import ba.unsa.etf.rpr.Model.Owner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateVlasnikController {
    private OwnerDAO ownerDAO;
    public TextField fldEmail;
    public TextField fldPhoneNumber;
    public TextField fldLastName;
    public TextField fldFirstName;
    public TextField fldJMBG;

    @FXML
    public void initialize() throws SQLException {
        ownerDAO = OwnerDAO.getInstance();
    }

    public void createOwnerBtn(ActionEvent actionEvent) throws SQLException, IOException {
        ownerDAO.addOwner(new Owner(1, fldFirstName.getText(), fldLastName.getText(), fldJMBG.getText(), Integer.parseInt(fldPhoneNumber.getText()), fldEmail.getText()));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/objectPicking.fxml"));
        Parent root = loader.load();
        ObjectPickingController objectPickingController = loader.getController();
        objectPickingController.refreshOwnersList();
        Stage stage = (Stage) fldFirstName.getScene().getWindow();
        stage.close();
    }

    public void cancelBtn(ActionEvent actionEvent) {
        Stage stage = (Stage) fldFirstName.getScene().getWindow();
        stage.close();
    }
}
