package Lesson2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
1. Добавить в сетевой чат запись локальной истории в текстовый файл на клиенте.
2. После загрузки клиента показывать ему последние 100 строк чата.
* */

public class ChatApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent auth = FXMLLoader.load(getClass().getResource("auth.fxml"));
        primaryStage.setTitle("Вход в аккаунт");
        primaryStage.setScene(new Scene(auth));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}