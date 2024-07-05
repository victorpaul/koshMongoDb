package com.kosh.koshmongodb;

import com.kosh.koshmongodb.configs.AppConfig;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class KoshMongoDbApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        super.init();
        context = SpringApplication.run(AppConfig.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/main.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Parent root = fxmlLoader.load();
        stage.setTitle("JavaFX Spring Boot Application");
        stage.setScene(new Scene(root, 400, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        context.close();
        Platform.exit();
        super.stop();
    }
}
