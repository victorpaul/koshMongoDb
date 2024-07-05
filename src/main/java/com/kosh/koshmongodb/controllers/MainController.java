package com.kosh.koshmongodb.controllers;

import com.kosh.koshmongodb.services.DBClient;
import com.kosh.koshmongodb.services.HelloService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    final HelloService helloService;
    final DBClient dbClient;

    @FXML
    private Label helloLabel;

    public MainController(HelloService helloService, DBClient dbClient) {
        this.helloService = helloService;
        this.dbClient = dbClient;
    }

    @FXML
    public void initialize() {
        helloLabel.setText(helloService.getGreeting());

        dbClient.connect();

    }
}
