package Lesson2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class AuthController {

    public TextField login;
    public TextField password;
    private String nick;
    private static AuthController instance;


    public void enter(ActionEvent actionEvent) throws IOException {
        boolean auth = false;
        try {
            auth = UsersSQLiteDao.getInstance().userExists(login.getText(), password.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (auth) {
            System.out.println("правильный пароль");
            Parent chat1 = FXMLLoader.load(getClass().getResource("chat.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Сетевой чат ");
            stage.setScene(new Scene(chat1));
            stage.setResizable(false);
            stage.show();
            login.getScene().getWindow().hide();
        } else {
            System.out.println("неправильный пароль");
            login.clear();
            login.setPromptText("WRONG LOGIN");
            password.clear();
            password.setPromptText("WRONG PASSWORD");
        }
    }

    public static AuthController getInstance() {
        if (instance == null) {
            instance = new AuthController();
        }
        return instance;
    }

    public void reg(ActionEvent actionEvent) throws IOException {
        Parent chat = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Регистрация ");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        login.getScene().getWindow().hide();
    }

}