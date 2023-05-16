package com.example.app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn;

    @FXML
    private TextField cPass;

    @FXML
    private Text errorCode;

    @FXML
    private TextField login;

    @FXML
    private TextField pass;

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

    @FXML
    void initialize(){

        btn.setOnAction(event -> {
            try {
                checkLogInInfo(login.getText(), pass.getText(), cPass.getText(), "[\\w]{1,20}");
                errorCode.setText("Login and password are correct!");
            } catch (WrongLoginException | WrongPasswordException e) {
                errorCode.setText("Incorrect login or password!");
                System.out.println(e);
            }
        });

    }



    private boolean checkLogInInfo(String login, String password, String confirmPassword, String regex)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(regex)) {
            throw new WrongLoginException("Incorrect login");
        } else if (!password.matches(regex) ||
                !confirmPassword.matches(regex) ||
                !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Incorrect password");
        }
        return true;
    }




}