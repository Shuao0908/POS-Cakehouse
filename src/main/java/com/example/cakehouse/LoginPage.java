package com.example.cakehouse;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static javafx.application.Application.launch;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPage extends Application{
    public static DataTesting data = new DataTesting();
    final String bgDesign = "-fx-background-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);";
    final Font font = Font.font("Times New Roman", FontWeight.BOLD,15);
    final Font font3 = Font.font("Times New Roman", FontWeight.BOLD,28);
    final Font font2 = Font.font("Times New Roman", FontWeight.BOLD,35);
    public Stage window;
    public TableView<Unit> inventoryTable = new TableView<>();
    private static TableView<Unit> orderTable = new TableView<>();
    private TableView<Receipt> customerTable = new TableView<>();
    private static TableView<Unit> cusOrderTable = new TableView<>();
    public void setFont(Label l){
        l.setFont(font);
        l.setPrefSize(210, 40);
        l.setTextFill(Color.WHITE);
        l.setAlignment(Pos.CENTER);
    }
    public void setFont2(Label l){
        l.setFont(Font.font(15));
        l.setPrefSize(155, 40);
        l.setStyle("-fx-textFill: #171717;");
        l.setAlignment(Pos.CENTER_RIGHT);
    }
    public void setFont3(Label l){
        l.setFont(Font.font(15));
        l.setPrefSize(100, 20);
        l.setStyle("-fx-textFill: #171717;");
        l.setAlignment(Pos.CENTER_LEFT);
    }
    public void setFont4(Label l){
        l.setFont(Font.font(15));
        l.setPrefSize(200, 30);
        l.setStyle("-fx-textFill: #171717;");
        l.setAlignment(Pos.CENTER_LEFT);
    }
    public void setTextField2(TextField tf){
        tf.setFont(Font.font(15));
        tf.setPrefSize(155,30);
        tf.setAlignment(Pos.CENTER_LEFT);
    }
    public void setTextField3(TextField tf){
        tf.setFont(Font.font(15));
        tf.setPrefSize(240,30);
        tf.setAlignment(Pos.CENTER_LEFT);
    }
    public void setTextField4(TextField tf){
        tf.setFont(Font.font(15));
        tf.setPrefSize(355,30);
        tf.setAlignment(Pos.CENTER_LEFT);
    }
    public void setComboBox(ComboBox<String> box){
        box.setPrefSize(155,30);
    }
    public void setComboBox2(ComboBox<String> box){
        box.setPrefSize(240,30);
    }
    public void setComboBox3(ComboBox<String> box){
        box.setPrefSize(355,30);
    }
    private void setButton(Button bt){
        bt.setFont(font);
        bt.setPrefSize(210, 40);
        bt.setCursor(Cursor.HAND);
        bt.setStyle("-fx-background-color:transparent;-fx-border-color:#ffffff;-fx-border-radius:5px;-fx-text-fill:#ffffff;");
        bt.setOnMouseEntered(e -> bt.setStyle("-fx-background-color:#ffffff;-fx-text-fill:#000000;-fx-border-radius:5px;"));
        bt.setOnMouseExited(e-> bt.setStyle("-fx-background-color:transparent; -fx-border-color:#ffffff;" +
                "-fx-border-radius:5px; -fx-text-fill:#ffffff;"));

    }
    private void setButton2(Button bt){
        bt.setFont(Font.font(15));
        bt.setPrefSize(151, 40);
        bt.setAlignment(Pos.CENTER);
        bt.setCursor(Cursor.HAND);
    }
    public static void main(String[] args) {
        launch(args);
    }
    private void identityChoice(ChoiceBox<String> i){
        i.getItems().addAll("Customer","Admin");
        i.setValue("Customer");
        i.setStyle("-fx-text-font:15px;");
        i.setPrefSize(220,28);
        i.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");
    }
    public static TextField userName1 = new TextField();
    public static TextField userName2 = new TextField();
    public PasswordField password1 = new PasswordField();
    public PasswordField password2 = new PasswordField();
    private void btLogin(Button b){
        b.setPrefSize(220,40);
        b.setFont(Font.font(15));
        b.setTextFill(Color.WHITE);
        b.setCursor(Cursor.HAND);
        b.setStyle(bgDesign+"-fx-background-radius:20px;");
        b.setOnMouseEntered(e -> b.setStyle("-fx-background-color:linear-gradient(to bottom left,#2B3449,#7B8FB3);" +
                "-fx-background-radius:20px;"));
        b.setOnMouseExited(e -> b.setStyle(bgDesign+"-fx-background-radius:20px;"));
    }
    private TextField emailAdd = new TextField();
    private void btSignUp(Button b){
        b.setFont(Font.font(15));
        b.setTextFill(Color.WHITE);
        b.setPrefSize(220,40);
        b.setStyle(bgDesign+"-fx-background-radius:20px;");
        b.setCursor(Cursor.HAND);
        b.setOnMouseEntered(e -> b.setStyle("-fx-background-color:linear-gradient(to bottom left,#2B3449,#7B8FB3);" +
                "-fx-background-radius:20px;"));
        b.setOnMouseExited(e -> b.setStyle(bgDesign+"-fx-background-radius:20px;"));
    }
    public Scene loginScene(){
        var loginBg = new GridPane();
        loginBg.setStyle(bgDesign); //DeepBlue,lightBlue#ECF2FF,,Grey
        loginBg.setMinSize(0,0);
        loginBg.setPrefSize(800,500);
        loginBg.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        loginBg.setNodeOrientation(NodeOrientation.INHERIT);

        var signInVBox = new VBox(10);
        signInVBox.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#212121");
        signInVBox.setMinSize(0,0);
        signInVBox.setPrefSize(400,500);
        signInVBox.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        signInVBox.setPadding(new Insets(100,100,100,100));
        signInVBox.setAlignment(Pos.CENTER);
        signInVBox.setNodeOrientation(NodeOrientation.INHERIT);

        var signInLabel = new Label("Sign In");
        signInLabel.setFont(Font.font("Berlin Sans FB", FontWeight.BOLD,60));
        signInLabel.setStyle("-fx-text-fill:#2B3467");

        var cbInLogin = new ChoiceBox<String>();
        identityChoice(cbInLogin);

        userName1.clear();
        userName1.setPromptText("Username");
        userName1.setFont(Font.font(15));
        userName1.setPrefSize(220,28);
        userName1.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");

        password1.clear();
        password1.setPromptText("Password");
        password1.setFont(Font.font(15));
        password1.setPrefSize(220,28);
        password1.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");

        var btLogin = new Button("Login");
        btLogin(btLogin);
        btLogin.setOnAction(e -> verifyIdentity(cbInLogin));

        Hyperlink forgotPassword = new Hyperlink("Forgot Password?");
        forgotPassword.setFont(Font.font("Microsoft Sans Serif",15));
        forgotPassword.setStyle("-fx-text-fill:#5185c5; -fx-underline:false;-fx-border-color:transparent");
        forgotPassword.setCursor(Cursor.HAND);
        forgotPassword.setOnMouseEntered(e -> forgotPassword.setStyle("-fx-underline:true;"));
        forgotPassword.setOnMouseExited(e -> forgotPassword.setStyle("-fx-text-fill:#5185c5; -fx-underline:false;-fx-border-color:transparent"));
        forgotPassword.setOnMouseClicked(e -> {window.setScene(forgotPwScene()); userName1.clear();password1.clear();});

        Hyperlink createAcc = new Hyperlink("Create a New Account?");
        createAcc.setFont(Font.font("Microsoft Sans Serif",15));
        createAcc.setStyle("-fx-text-fill:#5185c5; -fx-underline:false;-fx-border-color:transparent");
        createAcc.setCursor(Cursor.HAND);
        createAcc.setOnMouseEntered(e -> createAcc.setStyle("-fx-underline:true;"));
        createAcc.setOnMouseExited(e -> createAcc.setStyle("-fx-text-fill:#5185c5; -fx-underline:false;-fx-border-color:transparent"));
        createAcc.setOnMouseClicked(e -> {window.setScene(signUpScene()); userName1.clear();password1.clear();});

        signInVBox.getChildren().addAll(signInLabel,cbInLogin,userName1,password1,btLogin,forgotPassword,createAcc);

        loginBg.add(titleVBox(),0,0);
        loginBg.add(signInVBox,1,0);

        return new Scene(loginBg,800,500);
    }
    public Scene signUpScene(){
        var signUpBg = new GridPane();
        signUpBg.setStyle(bgDesign); //DeepBlue,lightBlue#ECF2FF,,Grey
        signUpBg.setMinSize(0,0);
        signUpBg.setPrefSize(800,500);
        signUpBg.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        signUpBg.setNodeOrientation(NodeOrientation.INHERIT);

        var signUpVBox = new VBox(10);
        signUpVBox.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#212121");
        signUpVBox.setMinSize(0,0);
        signUpVBox.setPrefSize(400,500);
        signUpVBox.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        signUpVBox.setPadding(new Insets(100,100,100,100));
        signUpVBox.setAlignment(Pos.CENTER);
        signUpVBox.setNodeOrientation(NodeOrientation.INHERIT);

        var signUpLabel = new Label("Sign Up");
        signUpLabel.setFont(Font.font("Berlin Sans FB", FontWeight.BOLD,50));
        signUpLabel.setStyle("-fx-text-fill:#2B3467");

        var cbInSignUp = new ChoiceBox<String>();
        identityChoice(cbInSignUp);
        cbInSignUp.getItems().clear();
        cbInSignUp.getItems().add("Customer");

        userName2.clear();
        userName2.setPromptText("Username");
        userName2.setFont(Font.font(15));
        userName2.setPrefSize(220,28);
        userName2.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");

        userName2.clear();
        password2.setPromptText("Password");
        password2.setFont(Font.font(15));
        password2.setPrefSize(220,28);
        password2.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");

        emailAdd.clear();
        emailAdd.setPromptText("EmailAddress");
        emailAdd.setFont(Font.font(15));
        emailAdd.setPrefSize(220,28);
        emailAdd.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");

        var btSignUp = new Button("Sign Up");
        btSignUp(btSignUp);
        btSignUp.setOnAction(e -> addNewAcc(cbInSignUp));

        Hyperlink loginAcc = new Hyperlink("Have a account already?");
        loginAcc.setFont(Font.font("Microsoft Sans Serif",15));
        loginAcc.setCursor(Cursor.HAND);
        loginAcc.setStyle("-fx-text-fill:#5185c5; -fx-underline:false;-fx-border-color:transparent");
        loginAcc.setOnMouseEntered(e -> loginAcc.setStyle("-fx-underline:true;"));
        loginAcc.setOnMouseExited(e -> loginAcc.setStyle("-fx-text-fill:#5185c5; -fx-underline:false;-fx-border-color:transparent"));
        loginAcc.setOnMouseClicked(e -> {window.setScene(loginScene());emailAdd.clear(); userName2.clear(); password2.clear();});

        signUpVBox.getChildren().addAll(signUpLabel,cbInSignUp,emailAdd,userName2,password2,btSignUp,loginAcc);
        signUpBg.add(titleVBox(),0,0);
        signUpBg.add(signUpVBox,1,0);

        return new Scene(signUpBg,800,500);
    }
    private Scene forgotPwScene(){
        var fpBg = new GridPane();
        fpBg.setStyle(bgDesign); //DeepBlue,lightBlue#ECF2FF,,Grey
        fpBg.setMinSize(0,0);
        fpBg.setPrefSize(800,500);
        fpBg.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        fpBg.setNodeOrientation(NodeOrientation.INHERIT);

        var forgotPwVBox = new VBox(10);
        forgotPwVBox.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#212121");
        forgotPwVBox.setMinSize(0,0);
        forgotPwVBox.setPrefSize(400,500);
        forgotPwVBox.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        forgotPwVBox.setPadding(new Insets(100,100,100,100));
        forgotPwVBox.setAlignment(Pos.CENTER);
        forgotPwVBox.setNodeOrientation(NodeOrientation.INHERIT);

        var forgotPwLabel = new Label("Forgot");
        forgotPwLabel.setFont(Font.font("Berlin Sans FB", FontWeight.BOLD,30));
        forgotPwLabel.setStyle("-fx-text-fill:#2B3467");

        var forgotPwLabel2 = new Label("Password");
        forgotPwLabel2.setFont(Font.font("Berlin Sans FB", FontWeight.BOLD,30));
        forgotPwLabel2.setStyle("-fx-text-fill:#2B3467");

        emailAdd.clear();
        emailAdd.setPromptText("Email Address");
        emailAdd.setFont(Font.font(15));
        emailAdd.setPrefSize(220,28);
        emailAdd.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");

        password1.clear();
        password1.setPromptText("New Password");
        password1.setFont(Font.font(15));
        password1.setPrefSize(220,28);
        password1.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");
        password2.clear();
        password2.setPromptText("New Password");
        password2.setFont(Font.font(15));
        password2.setPrefSize(220,28);
        password2.setStyle("-fx-background-color:transparent; -fx-background-radius:20px;" +
                "-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);-fx-border-radius:20px;" +
                "-fx-text-inner-color:#000;");

        var btChangePw = new Button("Change Password");
        btLogin(btChangePw);
        btChangePw.setOnAction(e -> changePassword());
        var btBack = new Button("Back");
        btLogin(btBack);
        btBack.setOnAction(e -> window.setScene(loginScene()));
        forgotPwVBox.getChildren().addAll(forgotPwLabel,forgotPwLabel2,emailAdd,password1,password2,btChangePw,btBack);

        fpBg.add(titleVBox(),0,0);
        fpBg.add(forgotPwVBox,1,0);
        return new Scene(fpBg,800,500);
    }
    private void changePassword() {
        String e = String.valueOf(emailAdd.getText());
        String pw = String.valueOf(password1.getText());
        String newPw = String.valueOf(password2.getText());

        System.out.println(e+" "+pw+" "+ " "+pw+","+newPw);

        if(emailAdd.getText().isEmpty() || password1.getText().isEmpty()
                ||password2.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();
        } else {
            String checkUser = "SELECT emailAdd FROM user WHERE emailAdd ='"+e+"'";
            connect1 = data.connectDB();
            try{
                statement1 = connect1.createStatement();
                result1 = statement1.executeQuery(checkUser);
                if (!result1.next()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(e+" haven't been registered!");
                    alert.showAndWait();

                }else {
                    if(!pw.equals(newPw)){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Passwords are not the same! Enter again!");
                        alert.showAndWait();
                        password1.clear(); password2.clear();
                    }else {
                        String updatePassword = "UPDATE user SET "
                                +" password ='"+ pw
                                +"' WHERE emailAdd = '"+e+"'";
                        prepare1 = connect1.prepareStatement(updatePassword);
                        prepare1.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Confirmation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully changed password!");
                        alert.showAndWait();

                        window.setScene(loginScene());
                    }
                }
            }catch(Exception e1){e1.printStackTrace();}
        }
    }
    private Connection connect1;
    private PreparedStatement prepare1;
    private Statement statement1;
    private ResultSet result1;
    public VBox titleVBox(){
        var titleVb= new VBox(10);
        titleVb.setMinSize(0,0);
        titleVb.setPrefSize(400,500);
        titleVb.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        titleVb.setPadding(new Insets(10,10,10,10));
        titleVb.setAlignment(Pos.CENTER);
        titleVb.setNodeOrientation(NodeOrientation.INHERIT);

        var resLabel = new Label("Shuao's\nCakehouse");
        resLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,60));
        resLabel.setTextFill(Color.WHITE);
        DropShadow ds2 = new DropShadow();
        ds2.setOffsetY(3.0F);
        ds2.setColor(Color.BLACK);
        resLabel.setEffect(ds2);

        resLabel.setOnMouseEntered(e ->{
            resLabel.setTextFill(Color.BLACK);
            resLabel.setCursor(Cursor.HAND);
            DropShadow ds1 = new DropShadow();
            ds1.setOffsetY(3.0F);
            ds1.setColor(Color.WHITE);
            resLabel.setEffect(ds1);
        });
        resLabel.setOnMouseExited(e ->{
            resLabel.setTextFill(Color.WHITE);
            resLabel.setEffect(ds2);
        });

        titleVb.getChildren().addAll(resLabel);
        return titleVb;
    }
    public void logout(){
        try{
            Alert logoutAlert = new Alert(Alert.AlertType.CONFIRMATION);
            logoutAlert.setTitle("Confirmation Message");
            logoutAlert.setHeaderText(null);
            logoutAlert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = logoutAlert.showAndWait();
            if (option.get().equals(ButtonType.OK)){
                window.setScene(loginScene());
            }
        }catch (Exception e){ e.printStackTrace();}
    }
    public void verifyIdentity(ChoiceBox<String> identityChoice){
        String u = String.valueOf(userName1.getText());
        String pw = String.valueOf(password1.getText());
        String identity = identityChoice.getValue();

        System.out.println(u+" "+pw+" "+ " "+identity);

        if(userName1.getText().isEmpty() || password1.getText().isEmpty()
                ||identityChoice.getValue().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();
        } else {
            String checkUser = "SELECT userName, password,identity FROM user WHERE userName ='"+u+"' AND password ='"+pw+"'" +
                    "AND identity ='"+identity+"'";
            connect1 = data.connectDB();
            try{
                statement1 = connect1.createStatement();
                result1 = statement1.executeQuery(checkUser);
                if (!result1.next()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid username/Wrong password");
                    alert.showAndWait();

                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();

                    if(identity.equals("Customer")){
                        window.setScene(cusScene());
                    }else if(identity.equals("Admin")){
                        window.setScene(admScene());
                    }
                }
            }catch(Exception e1){e1.printStackTrace();}
        }
    }
    public void addNewAcc(ChoiceBox<String> identityChoice){
        String u = String.valueOf(userName2.getText());
        String pw = String.valueOf(password2.getText());
        String e = String.valueOf(emailAdd.getText());
        String identity = identityChoice.getValue();

        System.out.println(u+" "+pw+" "+e+ " "+identity);

        if(userName2.getText().isEmpty() || password2.getText().isEmpty()
                || emailAdd.getText().isEmpty() ||identityChoice.getValue().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();
        } else {
            String checkEmail = "SELECT emailAdd FROM user WHERE emailAdd ='"+ e+"' OR userName = '"+u+"'";
            connect1 = data.connectDB();
            try{
                statement1 = connect1.createStatement();
                result1 = statement1.executeQuery(checkEmail);
                if (result1.next()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(emailAdd.getText() +"/"+userName2.getText()+" is already taken");
                    alert.showAndWait();
                    emailAdd.clear(); userName2.clear(); password2.clear();
                    window.setScene(signUpScene());
                }else {
                    String insertData ="INSERT INTO user(userName, password, emailAdd, identity, date) " +
                            "VALUES (?,?,?,?,?)";
                    prepare1 = connect1.prepareStatement(insertData);
                    prepare1.setString(1,userName2.getText());
                    prepare1.setString(2,password2.getText());
                    prepare1.setString(4,identityChoice.getSelectionModel().getSelectedItem());
                    prepare1.setString(3,emailAdd.getText());
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare1.setString(5,String.valueOf(sqlDate));
                    prepare1.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Registered");
                    alert.showAndWait();

                    window.setScene(loginScene());
                }
            }catch(Exception e1){e1.printStackTrace();}
        }
    }
    public void menuBar(GridPane menuPane){
        menuPane.setHgap(10);
        menuPane.setVgap(10);
        menuPane.setPadding(new Insets(10,10,10,10));
        menuPane.setStyle(bgDesign);

        var resLabel = new Label("Shuao's Cakehouse");
        setFont(resLabel);

        var welLabel = new Label();
        if(userName1 !=null){
            welLabel = new Label("Welcome, "+(userName1.getText()));
        }else{
            welLabel = new Label("Welcome, "+(userName2.getText()));
        }
        setFont(welLabel);

        var btDashBoard = new Button("DashBoard");setButton(btDashBoard);
        btDashBoard.setOnAction(e -> window.setScene(admScene()));

        var btInventory = new Button("Inventory");setButton(btInventory);
        btInventory.setOnAction(e -> window.setScene(admInventoryScene()));

        var btMenu = new Button("Menu");setButton(btMenu);
        btMenu.setOnAction(e -> window.setScene(admMenuScene()));

        var btCustomer = new Button("Customer"); setButton(btCustomer);
        btCustomer.setOnAction(e -> window.setScene(admCustomerScene()));

        var btAdmin = new Button("Admin"); setButton(btAdmin);
        btAdmin.setOnAction(e -> window.setScene(admAdminScene()));

        var btFeedback = new Button("Feedback"); setButton(btFeedback);
        btFeedback.setOnAction(e -> window.setScene(admFeedbackScene()));

        var space1 = new Pane();
        space1.setStyle("-fx-background-color: transparent;");
        space1.setPrefSize(210,220);

        var signOutPane = new HBox(10);signOutPane(signOutPane);

        menuPane.getChildren().clear();
        menuPane.add(resLabel, 0, 0);
        menuPane.add(welLabel, 0, 1);
        menuPane.add(btDashBoard, 0, 2);
        menuPane.add(btInventory,0,3);
        menuPane.add(btMenu,0,4);
        menuPane.add(btCustomer,0,5);
        menuPane.add(btAdmin,0,6);
        menuPane.add(btFeedback,0,7);
        menuPane.add(space1,0,8);
        menuPane.add(signOutPane,0,9);
    }
    public Label cusNumber = new Label();
    public Label tdIncome = new Label();
    public Label ttIncome = new Label();
    public Label numProduct= new Label();
    public AreaChart<String,Number> incomeChart;
    public BarChart<String,Number> cusChart;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void admDashboardDisplayCustomerNum(){
        String sql = "SELECT COUNT(receipt_id) FROM receipt";
        connect1 = data.connectDB();
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();
            if(result1.next()){
                cusNumber.setText(String.valueOf(result1.getInt("COUNT(receipt_id)")));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public void admDashboardDisplayTdIncome(){
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        String sql = "SELECT SUM(total) FROM receipt WHERE date = '"+date+"'";
        connect1 = data.connectDB();
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();

            if(result1.next()){
                tdIncome.setText("$ "+ df.format(result1.getDouble("SUM(total)")));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public void admDashboardDisplayNumProduct(){
        String sql = "SELECT COUNT(quantity) FROM `order`";
        connect1 = data.connectDB();
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();

            if(result1.next()){
                numProduct.setText(String.valueOf(result1.getInt("COUNT(quantity)")));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public void admDashboardDisplayTtIncome(){
        String sql = "SELECT SUM(total) FROM receipt";
        connect1 = data.connectDB();
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();

            if(result1.next()){
                ttIncome.setText("$ "+ df.format(result1.getDouble("SUM(total)")));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public void admDashboardDisplayIncomeChart(){
        if(incomeChart != null){
            incomeChart.getData().clear();
        }
        String sql ="SELECT date, SUM(total) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect1 = data.connectDB();
        XYChart.Series<String,Number> chart = new XYChart.Series<>();
        chart.setName("Year 2023");
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart.getData().add(new XYChart.Data<>(result1.getString(1),result1.getDouble(2)));
                //System.out.println(result1.getString(1)+result1.getDouble(2));
            }
            incomeChart.getData().add(chart);
        }catch(Exception e){ e.printStackTrace();}
    }
    public void admDashboardDisplayCusChart(){
        if(cusChart != null){
            cusChart.getData().clear();
        }
        String sql ="SELECT date, COUNT(receipt_id) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect1 = data.connectDB();
        XYChart.Series<String,Number> chart = new XYChart.Series<>();
        chart.setName("Year 2023");
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart.getData().add(new XYChart.Data<>(result1.getString(1), result1.getDouble(2)));
            }
            cusChart.getData().add(chart);

        }catch(Exception e){ e.printStackTrace();}
    }
    public Scene admScene(){
        var admPane = new AnchorPane();
        admPane.setPrefSize(1100, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        menuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(870,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(850,220);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var pane1in1 = new ScrollPane();
        pane1in1.setPrefSize(850,220);
        pane1in1.setStyle("-fx-background-color :transparent;");
        pane1in1.getStylesheets().add("scrollPane.css");

        var pane1in2 = new AnchorPane();
        pane1in2.setPrefSize(1020,204);

        var cusNumberBoard = new AnchorPane();
        cusNumberBoard.setPrefSize(240,185);
        cusNumberBoard.setStyle(bgDesign);
        cusNumberBoard.setTranslateX(10);
        cusNumberBoard.setTranslateY(10);

        var cusIcon = new ImageView("cusIcon3.png");
        cusIcon.setStyle("-fx-background-color:transparent;");
        cusIcon.setPreserveRatio(true);
        cusIcon.setFitHeight(70);
        cusIcon.setFitWidth(70);
        cusIcon.setTranslateX(20);
        cusIcon.setTranslateY(15);

        var cusNumLabel = new Label("Number of\nCustomer");
        cusNumLabel.setFont(font3);
        cusNumLabel.setTextFill(Color.WHITE);
        cusNumLabel.setWrapText(true);
        cusNumLabel.setTranslateX(20);
        cusNumLabel.setTranslateY(100);

        cusNumber = new Label("0");
        cusNumber.setFont(font2);
        cusNumber.setTextFill(Color.WHITE);
        cusNumber.setTranslateX(150);
        cusNumber.setTranslateY(30);
        admDashboardDisplayCustomerNum();
        cusNumberBoard.getChildren().addAll(cusIcon,cusNumLabel,cusNumber);

        var tdIncomeBoard = new AnchorPane();
        tdIncomeBoard.setPrefSize(240,185);
        tdIncomeBoard.setStyle(bgDesign);
        tdIncomeBoard.setTranslateX(270);
        tdIncomeBoard.setTranslateY(10);

        var drIcon = new ImageView("dollarIcon.png");
        drIcon.setStyle("-fx-background-color:transparent;");
        drIcon.setPreserveRatio(true);
        drIcon.setFitHeight(70);
        drIcon.setFitWidth(70);
        drIcon.setTranslateX(20);
        drIcon.setTranslateY(10);

        var tdIncomeLabel = new Label("Today's\nIncome");
        tdIncomeLabel.setFont(font3);
        tdIncomeLabel.setTextFill(Color.WHITE);
        tdIncomeLabel.setWrapText(true);
        tdIncomeLabel.setTranslateX(20);
        tdIncomeLabel.setTranslateY(100);

        tdIncome = new Label("$ 0.00");
        tdIncome.setFont(font2);
        tdIncome.setTextFill(Color.WHITE);
        tdIncome.setTranslateX(100);
        tdIncome.setTranslateY(30);
        admDashboardDisplayTdIncome();
        tdIncomeBoard.getChildren().addAll(drIcon,tdIncomeLabel,tdIncome);

        var ttIncomeBoard = new AnchorPane();
        ttIncomeBoard.setPrefSize(240,185);
        ttIncomeBoard.setStyle(bgDesign);
        ttIncomeBoard.setTranslateX(530);
        ttIncomeBoard.setTranslateY(10);

        var cashIcon = new ImageView("cashIcon.png");
        cashIcon.setStyle("-fx-background-color:transparent;");
        cashIcon.setPreserveRatio(true);
        cashIcon.setFitHeight(65);
        cashIcon.setFitWidth(65);
        cashIcon.setTranslateX(20);
        cashIcon.setTranslateY(10);

        var ttIncomeLabel = new Label("Total\nIncome");
        ttIncomeLabel.setFont(font3);
        ttIncomeLabel.setTextFill(Color.WHITE);
        ttIncomeLabel.setWrapText(true);
        ttIncomeLabel.setTranslateX(20);
        ttIncomeLabel.setTranslateY(100);

        ttIncome = new Label("$ 0.00");
        ttIncome.setFont(font2);
        ttIncome.setTextFill(Color.WHITE);
        ttIncome.setTranslateX(100);
        ttIncome.setTranslateY(30);
        admDashboardDisplayTtIncome();
        ttIncomeBoard.getChildren().addAll(cashIcon,ttIncomeLabel,ttIncome);

        var numProductBoard = new AnchorPane();
        numProductBoard.setPrefSize(240,185);
        numProductBoard.setStyle(bgDesign);
        numProductBoard.setTranslateX(790);
        numProductBoard.setTranslateY(10);

        var cakeIcon = new ImageView("cakeIcon.png");
        cakeIcon.setStyle("-fx-background-color:transparent;");
        cakeIcon.setPreserveRatio(true);
        cakeIcon.setFitHeight(70);
        cakeIcon.setFitWidth(70);
        cakeIcon.setTranslateX(20);
        cakeIcon.setTranslateY(10);

        var numProductLabel = new Label("Number of\nProduct");
        numProductLabel.setFont(font3);
        numProductLabel.setTextFill(Color.WHITE);
        numProductLabel.setWrapText(true);
        numProductLabel.setTranslateX(20);
        numProductLabel.setTranslateY(100);

        numProduct= new Label("0");
        numProduct.setFont(font2);
        numProduct.setTextFill(Color.WHITE);
        numProduct.setTranslateX(170);
        numProduct.setTranslateY(30);
        admDashboardDisplayNumProduct();
        numProductBoard.getChildren().addAll(cakeIcon,numProductLabel,numProduct);

        pane1in2.getChildren().addAll(cusNumberBoard,tdIncomeBoard,ttIncomeBoard,numProductBoard);
        pane1in1.setContent(pane1in2);
        pane1.getChildren().add(pane1in1);

        var sep1 = new Separator();
        sep1.setPrefSize(850,1);
        sep1.setTranslateX(10);
        sep1.setTranslateY(240);

        var pane2 = new AnchorPane();
        pane2.setPrefSize(850,440);
        pane2.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane2.setTranslateX(10);
        pane2.setTranslateY(250);

        var incomeData = new AnchorPane();
        incomeData.setPrefSize(410,410);
        incomeData.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        incomeData.setTranslateX(10);
        incomeData.setTranslateY(15);

        CategoryAxis xaxis = new CategoryAxis();
        NumberAxis yaxis = new NumberAxis();
        xaxis.setLabel("Date");
        yaxis.setLabel("Income");
        incomeChart = new AreaChart<>(xaxis, yaxis);
        admDashboardDisplayIncomeChart();
        incomeChart.setTitle("Income's Chart");
        incomeChart.setPrefSize(410,410);
        incomeData.getChildren().addAll(incomeChart);

        var cusData = new AnchorPane();
        cusData.setPrefSize(410,410);
        cusData.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        cusData.setTranslateX(430);
        cusData.setTranslateY(15);

        CategoryAxis xaxis2 = new CategoryAxis();
        NumberAxis yaxis2 = new NumberAxis();
        xaxis2.setLabel("Date");
        yaxis2.setLabel("Number of Order");
        cusChart = new BarChart<>(xaxis2, yaxis2);
        admDashboardDisplayCusChart();
        cusChart.setTitle("Customer's Chart");
        cusChart.setPrefSize(410,410);

        cusData.getChildren().addAll(cusChart);

        pane2.getChildren().addAll(incomeData,cusData);

        displayPane.getChildren().addAll(pane1,sep1,pane2);

        admPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(admPane, 1100, 700);
    }
    private final TextField addID = new TextField();
    private final TextField addName = new TextField();
    private final ComboBox<String> addType = new ComboBox<>();
    private final TextField addStock = new TextField();
    private final TextField addPrice = new TextField();
    private final ComboBox<String> addStatus = new ComboBox<>();
    private final ImageView addImageView = new ImageView();
    private TableColumn<Unit,String> idCol = new TableColumn<>("ID Product");
    private TableColumn<Unit,String> nameCol = new TableColumn<>("Product Name");
    private TableColumn<Unit,String> typeCol = new TableColumn<>("Type");
    private TableColumn<Unit, Integer> stockCol = new TableColumn<>("Stock");
    private TableColumn<Unit,Double> priceCol = new TableColumn<>("Price");
    private TableColumn<Unit,String> statusCol = new TableColumn<>("Status");
    private TableColumn<Unit,Date> dateCol = new TableColumn<>("Date");
    private final String[] typeList ={"Cake","Drinks"};
    public void inventoryTypeList(){
        List<String> typeL = new ArrayList<>(Arrays.asList(typeList));
        ObservableList<String> listData =FXCollections.observableArrayList(typeL);
        addType.setItems(listData);
    }
    private final String[] statusList ={"Available","Unavailable"};
    public void inventoryStatusList(){
        List<String> statusL = new ArrayList<>(Arrays.asList(statusList));
        ObservableList<String> listData =FXCollections.observableArrayList(statusL);
        addStatus.setItems(listData);
    }
    private static Connection connect2;
    private static PreparedStatement prepare2;
    private static Statement statement2;
    private static ResultSet result2;
    private ObservableList<Unit> inventoryData;
    public void inventoryShowData(){
        inventoryData = inventoryDataList();

        idCol.setMinWidth(100);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        stockCol.setMinWidth(100);
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));

        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        statusCol.setMinWidth(105);
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        dateCol.setMinWidth(110);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        inventoryTable.getColumns().clear();
        inventoryTable.getColumns().addAll(idCol,nameCol,typeCol,stockCol,priceCol,statusCol,dateCol);
        inventoryTable.setPrefSize(820,410);
        inventoryTable.getStylesheets().add("tableView_column.css");
        inventoryTable.setItems(inventoryData);
        inventoryTable.setOnMouseClicked(e -> selectInventory());
    }
    public ObservableList<Unit> inventoryDataList(){
        ObservableList<Unit> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `inventory`";
        connect2 = data.connectDB();
        try{
            prepare2 = connect2.prepareStatement(sql);
            result2 = prepare2.executeQuery();
            Unit unit;
            while(result2.next()){
                    unit = new Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        result2.getInt("stock"),
                        result2.getDouble("price"),
                        result2.getString("status"),
                        result2.getString("image"),
                        result2.getDate("date"));
                listData.add(unit);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static class Unit{
        private String id;
        private String name;
        private String user;
        private String type;
        private Integer stock;
        private Double price;
        private String status;
        private Date date;
        private String image;

        //inventory Data<Unit>
        public Unit(String i, String n, String t, Integer s, Double p,String st, String image,Date d){
            id = i; name = n; type = t;
            stock =s; price = p; status =st;
            date = d; this.image = image;
        }
        private Integer quantity;
        //productDisplay<Unit>
        public Unit(String i,String n,String t,Integer q,Double p,String image){
            id = i; name = n; type =t;price = p; quantity=q;this.image =image;
        }
        public String getId(){return id;}
        public String getName() {return name;}
        public String getType() {return type;}
        public Integer getStock() {return stock;}
        public Double getPrice() {return price;}
        public Integer getQuantity(){return quantity;}
        public String getStatus() {return status;}
        public Date getDate() {return date;}
        public String getImage(){return this.image;}
        private Spinner<Integer> addQuantity;
        private SpinnerValueFactory<Integer> spin;
        private int qty;
        public void setAddQuantity(){
            spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
            addQuantity.setValueFactory(spin);
        }
        private Button btAdd = new Button("Add");
        public AnchorPane productPane(){
            var displayPane = new AnchorPane();
            displayPane.setPrefSize(170,200);

            var vbox = new VBox(10);
            vbox.setPrefSize(170,200);
            vbox.setSpacing(10);
            vbox.setPadding(new Insets(10,10,10,10));

            var labelPane = new HBox(10);
            labelPane.setSpacing(10);

            Label n = new Label(name);
            n.setFont(Font.font("Times New Roman", FontWeight.BOLD,12));
            n.setPrefSize(120,20);
            n.setAlignment(Pos.CENTER_LEFT);

            Label p = new Label("$"+ df.format(price) +" ");
            p.setFont(Font.font("Times New Roman", FontWeight.BOLD,12));
            p.setPrefSize(60,20);
            p.setAlignment(Pos.CENTER_RIGHT);

            labelPane.getChildren().addAll(n,p);
            //labelPane.getChildren().addAll(productName,productPrice);

            var picPane = new AnchorPane();
            picPane.setPrefSize(140,140);
            picPane.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");

            String path= "file:"+getImage();
            Image image1 = new Image(path,140,130,false,true);
            ImageView i = new ImageView("file:"+getImage());
            //ImageView i = new ImageView(image1);
            //i.setPreserveRatio(true);
            i.setFitWidth(150);
            i.setFitHeight(130);
            picPane.getChildren().add(i);

            var addPane = new HBox(10);
            addPane.setSpacing(10);

            addQuantity = new Spinner<>();
            //addQuantity.setPromptText("1");
            setAddQuantity();
            addQuantity.setPrefSize(100,20);

            btAdd.setPrefSize(100,20);
            btAdd.setOnAction(e -> {setOrderID();addOrder();});

            addPane.getChildren().addAll(addQuantity,btAdd);

            vbox.getChildren().addAll(labelPane,picPane,addPane);

            displayPane.getChildren().addAll(vbox);

            return displayPane;
        }
        public void addOrder(){
            qty = addQuantity.getValue();

            String check ="";
            String checkAvailable = "SELECT status FROM inventory WHERE name ='"+name+"'";
            Connection connect = data.connectDB();
            try{
                Statement statement = connect.createStatement();
                ResultSet result = statement.executeQuery(checkAvailable);
                if(result.next()){
                    check = result.getString("status");
                }
                if(check.equals("Unavailable") || qty ==0){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error Message");
                    a.setHeaderText(null);
                    a.setContentText(name+" is UNAVAILABLE now!");
                    a.showAndWait();
                }else{
                    if(checkStock()) {
                        String insertOrder = "INSERT INTO `order`(order_id,userName,name,type, quantity, price,image,date) " +
                                "VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement prepare = connect.prepareStatement(insertOrder);
                        //CHECK for the order ID now
                        prepare.setString(1, String.valueOf(orderID));

                        //check for the userName
                        String u;
                        if (userName1.getText().isEmpty()) {
                            u = userName2.getText();
                        } else {
                            u = userName1.getText();
                        }
                        prepare.setString(2, u);
                        prepare.setString(3, getName());
                        prepare.setString(4, getType());
                        prepare.setInt(5, qty);
                        prepare.setDouble(6, (qty * getPrice()));
                        prepare.setString(7, getImage());
                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare.setString(8, String.valueOf(sqlDate));
                        System.out.println(orderID+" "+u+" "+getName()+" "+" "+qty+" "+(qty*getPrice())+" "+sqlDate);
                        prepare.executeUpdate();

                        updateStockOfInventory();

                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setTitle("Confirmation Message");
                        a.setHeaderText(null);
                        a.setContentText(getName() + " is successfully ordered!");
                        a.showAndWait();

                        orderShowData();
                        calculateTotal();
                    }else{
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error Message");
                        a.setHeaderText(null);
                        a.setContentText(name+" is UNAVAILABLE now!");
                        a.showAndWait();
                    }
                }
            }catch (Exception e){ e.printStackTrace();}
        }
        public void addCusOrder(){
            qty = addQuantity.getValue();

            String check ="";
            String checkAvailable = "SELECT status FROM inventory WHERE name ='"+name+"'";
            Connection connect = data.connectDB();
            try{
                Statement statement = connect.createStatement();
                ResultSet result = statement.executeQuery(checkAvailable);
                if(result.next()){
                    check = result.getString("status");
                }
                if(check.equals("Unavailable") || qty ==0){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error Message");
                    a.setHeaderText(null);
                    a.setContentText(name+" is UNAVAILABLE now!");
                    a.showAndWait();
                }else{
                    if(checkStock()) {
                        String insertOrder = "INSERT INTO `cus_order`(order_id,userName,name,type, quantity, price,image,date) " +
                                "VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement prepare = connect.prepareStatement(insertOrder);
                        //CHECK for the order ID now
                        prepare.setString(1, String.valueOf(orderID));

                        //check for the userName
                        String u;
                        if (userName1.getText().isEmpty()) {
                            u = userName2.getText();
                        } else {
                            u = userName1.getText();
                        }
                        prepare.setString(2, u);
                        prepare.setString(3, getName());
                        prepare.setString(4, getType());
                        prepare.setInt(5, qty);
                        prepare.setDouble(6, (qty * getPrice()));
                        prepare.setString(7, getImage());
                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare.setString(8, String.valueOf(sqlDate));
                        System.out.println(orderID+" "+u+" "+getName()+" "+" "+qty+" "+(qty*getPrice())+" "+sqlDate);
                        prepare.executeUpdate();

                        updateStockOfInventory();

                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setTitle("Confirmation Message");
                        a.setHeaderText(null);
                        a.setContentText(getName() + " is successfully ordered!");
                        a.showAndWait();

                        cusOrderShowData();
                        calculateTotalCus();
                    }else{
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error Message");
                        a.setHeaderText(null);
                        a.setContentText(name+" is UNAVAILABLE now!");
                        a.showAndWait();
                    }
                }
            }catch (Exception e){ e.printStackTrace();}
        }
        public boolean checkStock(){
            String checkID ="";
            int checkStock = 0;
            String checkType="";
            String checkStockInSQL ="SELECT id,stock,type,status,image FROM inventory WHERE name = '" +getName()+"'";
            Connection connect = data.connectDB();
            try {
                Statement statement = connect.createStatement();
                ResultSet result = statement.executeQuery(checkStockInSQL);
                if (result.next()) {
                    checkID =result.getString("id");
                    checkStock = result.getInt("stock");
                    checkType = result.getString("type");
                }
                if (checkStock <qty) {
                    if(checkStock==0){
                        String sqlUpdateStock = "UPDATE inventory SET stock='" +checkStock + "'," +
                                "name ='" + getName() + "'," +
                                "type='" + checkType + "'," +
                                "price='" + getPrice() + "'," +
                                "status='" + "Unavailable" + "' WHERE id ='"+ checkID+"'";
                        prepare2 = connect2.prepareStatement(sqlUpdateStock);
                        prepare2.executeUpdate();
                    }
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error Message");
                    a.setHeaderText(null);
                    a.setContentText(name + " is out of stock!");
                    a.showAndWait();

                    return false;
                }
            }catch (Exception e){e.printStackTrace();}
            return true;
        }
        public void updateStockOfInventory(){
            String checkID ="";
            int checkStock = 0;
            String checkType="";
            String checkStatus="";
            String checkStockInSQL ="SELECT id,stock,type,status FROM inventory WHERE name = '" +getName()+"'";
            Connection connect = data.connectDB();
            try {
                Statement statement = connect.createStatement();
                ResultSet result = statement.executeQuery(checkStockInSQL);
                if (result.next()) {
                    checkID =result.getString("id");
                    checkStock = result.getInt("stock");
                    checkType = result.getString("type");
                    checkStatus =result.getString("status");
                }
            } catch (Exception e){e.printStackTrace();}

            int updatedStock = checkStock -qty;
            try {
                String sqlUpdateStock = "UPDATE inventory SET stock='" + updatedStock + "'," +
                        "name ='" + getName() + "'," +
                        "type='" + checkType + "'," +
                        "price='" + getPrice() + "'," +
                        "status='" + checkStatus + "' WHERE id ='"+ checkID+"'";
                prepare2 = connect2.prepareStatement(sqlUpdateStock);
                prepare2.executeUpdate();

            }catch(Exception e){e.printStackTrace();}
        }
        public AnchorPane receiptOrderPane(){
            var singleOrderPane = new AnchorPane();
            singleOrderPane.setMinWidth(480);

            HBox hbox = new HBox(10);
            hbox.setSpacing(10);
            hbox.setPadding(new Insets(10,0,0,10));

            Label n = new Label(getName());
            n.setFont(Font.font("Times New Roman" , (FontWeight) null,15));
            n.setTranslateX(10);

            Label s = new Label(String.valueOf(getQuantity()));
            s.setFont(Font.font("Times New Roman" , (FontWeight) null,15));
            s.setAlignment(Pos.CENTER_RIGHT);
            s.setTranslateX(200);

            Label p = new Label(String.valueOf(getPrice()));
            p.setFont(Font.font("Times New Roman" , (FontWeight) null,15));
            p.setAlignment(Pos.CENTER_RIGHT);
            p.setTranslateX(300);

            hbox.getChildren().addAll(n,s,p);

            singleOrderPane.getChildren().add(hbox);

            return singleOrderPane;
        }
        public AnchorPane cusProductPane(){
            var displayPane = new AnchorPane();
            displayPane.setPrefSize(220,300);

            var vbox = new VBox(10);
            vbox.setPrefSize(210,300);
            vbox.setSpacing(10);
            vbox.setPadding(new Insets(10,10,10,10));

            var labelPane = new HBox(10);
            labelPane.setSpacing(10);

            Label n = new Label(name);
            n.setFont(Font.font("Times New Roman", FontWeight.BOLD,15));
            n.setPrefSize(150,20);
            n.setAlignment(Pos.CENTER_LEFT);

            Label p = new Label("$"+ df.format(price) +" ");
            p.setFont(Font.font("Times New Roman", FontWeight.BOLD,15));
            p.setPrefSize(80,20);
            p.setAlignment(Pos.CENTER_RIGHT);

            labelPane.getChildren().addAll(n,p);
            //labelPane.getChildren().addAll(productName,productPrice);

            var picPane = new AnchorPane();
            picPane.setPrefSize(170,170);
            picPane.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");

            ImageView i = new ImageView("file:"+getImage());
            i.setFitWidth(200);
            i.setFitHeight(180);
            picPane.getChildren().add(i);

            var addPane = new HBox(10);
            addPane.setSpacing(10);

            addQuantity = new Spinner<>();
            //addQuantity.setPromptText("1");
            setAddQuantity();
            addQuantity.setPrefSize(100,20);

            btAdd.setPrefSize(100,20);
            btAdd.setOnAction(e -> {setCusOrderID();addCusOrder();});

            addPane.getChildren().addAll(addQuantity,btAdd);

            vbox.getChildren().addAll(labelPane,picPane,addPane);

            displayPane.getChildren().addAll(vbox);

            return displayPane;
        }
    }
    private void signOutPane(HBox signOutPane){
        signOutPane.setAlignment(Pos.BOTTOM_LEFT);
        signOutPane.setPrefSize(210,50);
        signOutPane.setStyle("-fx-background-colour: transparent;");

        var signOutImage = new ImageView("logOutIcon.png"); //png problem
        signOutImage.setPreserveRatio(true);
        signOutImage.setFitWidth(50);
        signOutImage.setFitHeight(50);
        signOutImage.setStyle("-fx-background-radius:10px;");
        signOutImage.setCursor(Cursor.HAND);
        signOutImage.setOnMouseClicked(e -> logout()); //problem

        var signOutLabel = new Label("Sign Out");
        setFont(signOutLabel);
        signOutLabel.setAlignment(Pos.BASELINE_LEFT);
        signOutLabel.setStyle(" -fx-underline:false;-fx-border-color:transparent");
        signOutLabel.setCursor(Cursor.HAND);
        signOutLabel.setOnMouseEntered(e -> signOutLabel.setStyle("-fx-underline:true;"));
        signOutLabel.setOnMouseExited(e -> signOutLabel.setStyle("-fx-underline:false;-fx-border-color:transparent"));
        signOutLabel.setOnMouseClicked(e -> logout());

        signOutPane.getChildren().addAll(signOutImage,signOutLabel);
    }
    private Scene admInventoryScene(){ //admin Inventory Scene
        var invPane = new Pane();
        invPane.setPrefSize(1100, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        menuBar(menuPane);

        var displayPane = new Pane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(870,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(850,430);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var pane1in1 = new ScrollPane();
        pane1in1.setPrefSize(850,410);
        pane1in1.setPadding(new Insets(10,0,0,10));
        pane1in1.setStyle("-fx-background-color :transparent;");
        pane1in1.getStylesheets().add("scrollPane.css");

        inventoryShowData();
        pane1in1.setContent(inventoryTable);
        pane1.getChildren().add(pane1in1);

        var sep1 = new Separator();
        sep1.setPrefSize(850,1);
        sep1.setTranslateX(10);
        sep1.setTranslateY(450);

        var pane2 = new AnchorPane();
        pane2.setPrefSize(850,230);
        pane2.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane2.setTranslateX(10);
        pane2.setTranslateY(460);

        Label idLabel =new Label("Product ID:  ");setFont2(idLabel);setTextField2(addID);

        Label nameLabel = new Label("Product Name:  ");setFont2(nameLabel);setTextField2(addName);

        Label typeLabel = new Label("Type:  ");setFont2(typeLabel);
        setComboBox(addType);addType.setPromptText("Choose Type..");inventoryTypeList();

        Label stockLabel = new Label("Stock:  ");setFont2(stockLabel);setTextField2(addStock);
        addStock.setPromptText("0");

        Label priceLabel = new Label("Price ($):  ");setFont2(priceLabel);setTextField2(addPrice);
        addPrice.setPromptText("$0.0");

        Label statusLabel = new Label("Status:  ");setFont2(statusLabel);
        setComboBox(addStatus);addStatus.setPromptText("Choose Status..");inventoryStatusList();

        var btAdd = new Button("Add");
        setButton2(btAdd);
        btAdd.setOnAction(e -> addInventory());

        var btUpdate= new Button("Update");
        setButton2(btUpdate);
        btUpdate.setOnAction(e -> updateInventory());

        var btClear = new Button("Clear");
        setButton2(btClear);
        btClear.setOnAction(e -> clearInventory());

        var btDelete = new Button("Delete");
        setButton2(btDelete);
        btDelete.setOnAction(e -> deleteInventory());

        var addPicPane = new AnchorPane();
        addPicPane.setPrefSize(151,140);
        addPicPane.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        addPicPane.setTranslateY(20);
        addPicPane.setTranslateX(685);
        addPicPane.getChildren().add(addImageView);
        //addImageView.setPreserveRatio(true);
        addImageView.setFitHeight(140);
        addImageView.setFitWidth(151);

        var btImport = new Button("Import");
        setButton2(btImport);
        btImport.setTranslateX(685);
        btImport.setTranslateY(170);
        btImport.setOnAction(e-> importInventory());

        var pane1in2 = new GridPane();
        pane1in2.setPrefSize(800,230);
        pane1in2.setStyle("-fx-background-color:transparent");
        pane1in2.setVgap(10);
        pane1in2.setHgap(10);
        pane1in2.setTranslateY(10);
        pane1in2.setTranslateX(10);
        pane1in2.setPadding(new Insets(10,10,10,10));

        pane1in2.add(idLabel,0,0);pane1in2.add(addID,1,0);
        pane1in2.add(nameLabel,0,1);pane1in2.add(addName,1,1);
        pane1in2.add(typeLabel,0,2);pane1in2.add(addType,1,2);
        pane1in2.add(btAdd,0,3); pane1in2.add(btUpdate,1,3);

        pane1in2.add(stockLabel,2,0);pane1in2.add(addStock,3,0);
        pane1in2.add(priceLabel,2,1);pane1in2.add(addPrice,3,1);
        pane1in2.add(statusLabel,2,2); pane1in2.add(addStatus,3,2);
        pane1in2.add(btClear,2,3);pane1in2.add(btDelete,3,3);
        pane2.getChildren().addAll(pane1in2,addPicPane,btImport);

        displayPane.getChildren().addAll(pane1,sep1,pane2);
        invPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(invPane, 1100, 700);
    }
    private void deleteInventory() {
        if (addID.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the product!");
            alert.showAndWait();
        } else {
            String deleteData = "DELETE FROM inventory WHERE id ='"+addID.getText()+"'";
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE ID: "+addID.getText()+"?");
            Optional <ButtonType> option = alert.showAndWait();
            connect2 = data.connectDB();

            if(option.get().equals(ButtonType.OK)){
                try{
                    prepare2 = connect2.prepareStatement(deleteData);
                    prepare2.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted");
                    alert.showAndWait();

                    inventoryShowData();
                    clearInventory();
                }catch(Exception e){e.printStackTrace();}
            }else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        }
    }
    private void clearInventory() {
        addID.setText("");
        addName.setText("");
        addType.getSelectionModel().clearSelection();
        addStock.setText("");
        addPrice.setText("");
        addStatus.getSelectionModel().clearSelection();
        data.path ="";
        addImageView.setImage(null);
    }
    public void selectInventory(){
        Unit unit = inventoryTable.getSelectionModel().getSelectedItem();
        int num = inventoryTable.getSelectionModel().getSelectedIndex();
        if((num-1)<-1) return;
        addID.setText(unit.getId());
        addName.setText(unit.getName());
        addStock.setText(String.valueOf(unit.getStock()));
        addPrice.setText(String.valueOf(unit.getPrice()));

        data.date =String.valueOf(unit.getDate());
        data.path= "File:"+unit.getImage();
        image =new Image(data.path,140,151,false,true);
        addImageView.setImage(image);

    }
    private void updateInventory() {
        if(addID.getText().isEmpty()
                ||addName.getText().isEmpty()
                ||addType.getSelectionModel().getSelectedItem() == null
                ||addStock.getText().isEmpty()
                ||addPrice.getText().isEmpty()
                ||addStatus.getSelectionModel().getSelectedItem() == null
                ||data.path == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();
        }else{
            String path = data.path.replace("\\","\\\\").replace("File:","");
            String updateData = "UPDATE inventory SET "
                    +" name ='"+ addName.getText()
                    +"', type ='"+addType.getSelectionModel().getSelectedItem()
                    +"', stock='"+addStock.getText()
                    +"', price='" +addPrice.getText()
                    +"', status='"+addStatus.getSelectionModel().getSelectedItem()
                    +"', date='"+data.date
                    +"', image='"+path+"' WHERE id = '"+addID.getText()+"'";
            connect2 = data.connectDB();
            try{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE ID: "+addID.getText()+"?");
                Optional <ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    prepare2 = connect2.prepareStatement(updateData);
                    prepare2.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated");
                    alert.showAndWait();

                    inventoryShowData();
                    clearInventory();
                }else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
                }
            }catch(Exception e){e.printStackTrace();}
        }
    }
    private void addInventory() {
        if(addID.getText().isEmpty()
            ||addName.getText().isEmpty()
            ||addType.getSelectionModel().getSelectedItem() == null
            ||addStock.getText().isEmpty()
            ||addPrice.getText().isEmpty()
            ||addStatus.getSelectionModel().getSelectedItem() == null
            ||data.path == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();
        }else{
            String checkID = "SELECT id FROM inventory WHERE id ='"+addName.getText()+"'";
            connect2 = data.connectDB();
            try{
                statement2 = connect2.createStatement();
                result2 = statement2.executeQuery(checkID);
                if (result2.next()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(addID.getText() +" is already taken");
                    alert.showAndWait();
                }else {
                    String insertData ="INSERT INTO inventory(id, name, type, stock, price, status, date, image) " +
                            "VALUES (?,?,?,?,?,?,?,?)";
                    prepare2 = connect2.prepareStatement(insertData);
                    prepare2.setString(1,addID.getText());
                    prepare2.setString(2,addName.getText());
                    prepare2.setString(3,addType.getSelectionModel().getSelectedItem());
                    prepare2.setString(4,addStock.getText());
                    prepare2.setString(5,addPrice.getText());
                    prepare2.setString(6,addStatus.getSelectionModel().getSelectedItem());
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare2.setString(7,String.valueOf(sqlDate));
                    String path= data.path;
                    path = path.replace("\\","\\\\");
                    prepare2.setString(8,path);
                    prepare2.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added");
                    alert.showAndWait();

                    inventoryShowData();
                    clearInventory();
                }

            }catch(Exception e){e.printStackTrace();}
        }
    }
    private Image image;
    public void importInventory(){
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File","*png","*jpg"));
        File file = openFile.showOpenDialog(window.getScene().getWindow());
        if(file != null){
            data.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(),151,140,false,true);
            addImageView.setImage(image);
        }
    }
    private ObservableList<Unit> productData;
    public static ObservableList<Unit> orderData;
    public static void orderShowData(){
        orderData = orderDataList();

        orderTable.setPrefSize(260,400);
        orderTable.setStyle("-fx-background-color:transparent;-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1)");
        orderTable.setTranslateX(10);
        orderTable.setTranslateY(10);
        orderTable.getStylesheets().add("tableView_column.css");

        orderNameCol.setMinWidth(100);
        orderNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        orderQuantityCol.setMinWidth(80);
        orderQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        orderPriceCol.setMinWidth(80);
        orderPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        orderTable.getColumns().clear();
        orderTable.getColumns().addAll(orderNameCol,orderQuantityCol,orderPriceCol);
        orderTable.setItems(orderData);
        orderTable.setOnMouseClicked(e -> selectOrder());
    }
    private static int orderID ;
    public static void setOrderID(){
        String checkOrderID ="SELECT MAX(order_id) FROM `order`";
        connect2 =data.connectDB();
        try{
            statement2 = connect2.createStatement();
            result2 = statement2.executeQuery(checkOrderID);
            if(result2.next()){
                orderID =result2.getInt("MAX(order_id)");
            }

            String checkReceiptID = "SELECT MAX(order_id) FROM receipt";
            prepare2 = connect2.prepareStatement(checkReceiptID);
            result2 = prepare2.executeQuery();
            int checkReceipt =0;
            if (result2.next()){
                checkReceipt =result2.getInt("MAX(order_id)");
            }
            if (orderID == 0){
                orderID+=1;
            } else if (orderID == checkReceipt) { //CHECK whether this order is paid already or not
                orderID+=1;
            }
            //System.out.println(orderID);
        }catch(Exception e){e.printStackTrace();}
    }
    public static void setCusOrderID(){
        String checkOrderID ="SELECT MAX(order_id) FROM `cus_order`";
        connect2 =data.connectDB();
        try{
            statement2 = connect2.createStatement();
            result2 = statement2.executeQuery(checkOrderID);
            if(result2.next()){
                orderID =result2.getInt("MAX(order_id)");
            }

            String checkReceiptID = "SELECT MAX(order_id) FROM cus_receipt";
            prepare2 = connect2.prepareStatement(checkReceiptID);
            result2 = prepare2.executeQuery();
            int checkReceipt =0;
            if (result2.next()){
                checkReceipt =result2.getInt("MAX(order_id)");
            }
            if (orderID == 0){
                orderID+=1;
            } else if (orderID == checkReceipt) { //CHECK whether this order is paid already or not
                orderID+=1;
            }
            //System.out.println(orderID);
        }catch(Exception e){e.printStackTrace();}
    }
    //orderDatalist
    public static ObservableList<Unit> orderDataList(){
        setOrderID();
        ObservableList<Unit> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `order` WHERE `order_id`='"+orderID+"'";
        connect2 = data.connectDB();
        try{
            prepare2 = connect2.prepareStatement(sql);
            result2 = prepare2.executeQuery();
            Unit u1;
            while(result2.next()){
                u1 = new Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        result2.getInt("quantity"),
                        result2.getDouble("price"),
                        result2.getString("image"));
                listData.add(u1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    //displayMenuList
    public ObservableList<Unit> productDataList(){
        String sql = "SELECT * FROM `inventory`";
        connect2 = data.connectDB();
        ObservableList<Unit> listData = FXCollections.observableArrayList();
        try{
            prepare2 = connect2.prepareStatement(sql);
            result2 = prepare2.executeQuery();
            Unit u1;
            while(result2.next()){
                u1 = new Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        0,
                        result2.getDouble("price"),
                        result2.getString("image"));
                listData.add(u1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    private static TableColumn<Unit,String> orderNameCol = new TableColumn<>("Product Name");
    private static TableColumn<Unit, Integer> orderQuantityCol = new TableColumn<>("Quantity");
    private static TableColumn<Unit,Double> orderPriceCol = new TableColumn<>("Price($)");
    private ComboBox<String> addPayment = new ComboBox<>();
    private static Label total = new Label("$0.0");
    private TextField addAmount = new TextField();
    private Label charge = new Label("$0.0");
    private GridPane displayProductPane = new GridPane();
    private final String[] paymentList ={"Cash","TnG","Debit/Credit Card"};
    public void productPaymentList(){
        List<String> paymentL = new ArrayList<>(Arrays.asList(paymentList));
        ObservableList<String> listData =FXCollections.observableArrayList(paymentL);
        addPayment.setItems(listData);
        addPayment.setPromptText("Choose Payment..");
        addPayment2.setItems(listData);
        addPayment2.setPromptText("Choose Payment..");
    }
    private Button btPay = new Button("Pay");
    private Button btRemove = new Button("Remove");
    private Button btReceipt = new Button("Receipt");
    private Scene admMenuScene(){
        var mePane = new Pane();
        mePane.setPrefSize(1100, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        menuBar(menuPane);

        var displayPane = new Pane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(870,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(560,680);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var pane1in1 = new ScrollPane();
        pane1in1.setPrefSize(540,660);
        pane1in1.setTranslateX(10);
        pane1in1.setTranslateY(10);
        pane1in1.setStyle("-fx-background-color :transparent;");
        pane1in1.getStylesheets().add("scrollPane.css");

        displayProductPane.setHgap(10);
        displayProductPane.setVgap(10);
        displayProductPane.setStyle("-fx-background-color:white;");
        productDisplay();

        pane1in1.setContent(displayProductPane);
        pane1.getChildren().add(pane1in1);

        var pane2 = new AnchorPane();
        pane2.setPrefSize(280,680);
        pane2.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane2.setTranslateX(580);
        pane2.setTranslateY(10);

        orderShowData();

        var pane1in2 = new GridPane();
        pane1in2.setTranslateX(10);
        pane1in2.setTranslateY(420);
        pane1in2.setPrefSize(260,230);
        pane1in2.setVgap(10);
        pane1in2.setHgap(10);

        var totalLabel = new Label(" Total: ");
        setFont3(totalLabel);
        setFont3(total);
        calculateTotal();

        var amountLabel = new Label(" Amount: ");
        setFont3(amountLabel);
        setTextField2(addAmount);
        addAmount.setPromptText("$0.0");
        addAmount.setOnAction(e -> calculateCharge());

        var chargeLabel = new Label(" Charge: ");
        setFont3(chargeLabel);
        setFont3(charge);

        var paymentLabel = new Label(" Payment: ");
        setFont3(paymentLabel);
        productPaymentList();
        setComboBox(addPayment);
        addPayment.setOnAction(e -> getPaymentMethod());
        //addPayment.setOnMouseClicked(e -> getPaymentMethod());

        btPay.setPrefSize(260,35);
        btPay.setFont(Font.font(15));
        btPay.setTranslateX(10);
        btPay.setTranslateY(575);
        btPay.setOnAction(e -> payOrder());

        btRemove.setPrefSize(125,35);
        btRemove.setFont(Font.font(15));
        btRemove.setTranslateX(10);
        btRemove.setTranslateY(625);
        btRemove.setOnAction(e -> removeOrder());

        btReceipt.setPrefSize(125,35);
        btReceipt.setFont(Font.font(15));
        btReceipt.setTranslateX(145);
        btReceipt.setTranslateY(625);
        btReceipt.setOnAction(e -> receiptOfOrder());

        pane1in2.add(totalLabel,0,0); pane1in2.add(total,1,0);
        pane1in2.add(amountLabel,0,1); pane1in2.add(addAmount,1,1);
        pane1in2.add(chargeLabel,0,2); pane1in2.add(charge,1,2);
        pane1in2.add(paymentLabel,0,3); pane1in2.add(addPayment,1,3);

        pane2.getChildren().addAll(orderTable,pane1in2,btPay,btRemove,btReceipt);

        displayPane.getChildren().addAll(pane1,pane2);
        mePane.getChildren().addAll(menuPane,displayPane);

        return new Scene(mePane, 1100, 700);
    }
    public void productDisplay(){
        productData = productDataList();
        displayProductPane.getRowConstraints().clear();
        displayProductPane.getColumnConstraints().clear();
        int row =0;
        int col =0;
        for (Unit productDatum : productData) {
            if (col == 3) {
                col = 0;
                row += 1;
            }
            displayProductPane.add(productDatum.productPane(), col++, row); //problem
        }
    }
    private static double totalPriceOfOrder;
    private double amount;
    private double change;
    public static void calculateTotal(){
        setOrderID();
        String checkTotal = "SELECT SUM(price) FROM `order` WHERE order_id ='" +orderID+"'";
        connect2 = data.connectDB();
        try{
            prepare2 = connect2.prepareStatement(checkTotal);
            result2 = prepare2.executeQuery();

            if(result2.next()){
                totalPriceOfOrder =result2.getDouble("SUM(price)");
                total.setText("$"+ df.format(totalPriceOfOrder));
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
    public void calculateCharge(){
        calculateTotal();
        if(!addAmount.getText().isEmpty()){
            amount = Double.parseDouble(addAmount.getText().replace("$",""));
        }

        if (amount < totalPriceOfOrder) {
            addAmount.setText("$ 0.0");
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please enter the amount paid!");
            a.showAndWait();
        } else {
            change = amount - totalPriceOfOrder;
            charge.setText("$" + String.format("%.2f",change));
        }
    }
    public void getPaymentMethod() {
        calculateTotal();
        if(addPayment.getSelectionModel().isEmpty()){
            Alert alert = createAlertWithOptOut(Alert.AlertType.ERROR, "Error Message", null,
                    "Please select a payment method", ButtonType.OK);
            alert.showAndWait();
        }else if(addPayment.getSelectionModel().getSelectedItem().equals("Cash")) {
            addAmount.clear();
        }else{
            amount = totalPriceOfOrder;
            addAmount.setText("$"+amount);
        }
        calculateCharge();
    }
    public void payOrder(){
        if(totalPriceOfOrder == 0){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please choose your order first!");
            a.showAndWait();
        }else if( addPayment.getSelectionModel().getSelectedItem()==null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Invalid !_! Please select the payment method!");
            a.showAndWait();

        }else {
            calculateTotal();
            calculateCharge();
            if(amount >= totalPriceOfOrder) {
                String insertReceipt = "INSERT INTO `receipt`(`receipt_id`,`order_id`, `userName`, `total`, `paymentMethod`, `date`) " +
                        "VALUES (?,?,?,?,?,?)";
                connect2 = data.connectDB();
                try {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setTitle("Confirmation Message");
                    a.setHeaderText(null);
                    a.setContentText("Are you sure to pay now?");
                    Optional<ButtonType> option = a.showAndWait();
                    if (option.get().equals(ButtonType.OK)) {
                        setOrderID();
                        prepare2 = connect2.prepareStatement(insertReceipt);
                        prepare2.setString(1,String.valueOf(orderID));
                        prepare2.setString(2,String.valueOf(orderID));
                        String u;
                        if (userName1.getText().isEmpty()) {
                            u = userName2.getText();
                        } else {
                            u = userName1.getText();
                        }
                        prepare2.setString(3,u);
                        prepare2.setDouble(4,totalPriceOfOrder);
                        prepare2.setString(5,addPayment.getSelectionModel().getSelectedItem());

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare2.setString(6,String.valueOf(sqlDate));

                        prepare2.executeUpdate();

//                        Alert alert = createAlertWithOptOut(Alert.AlertType.CONFIRMATION, "Payment successful", null,
//                                "Do you need Receipt?", ButtonType.YES, ButtonType.NO);
//                        Optional<ButtonType> option2 = alert.showAndWait();
//                        if (option2.get().equals(ButtonType.YES)) {
//                            receiptOfOrder();
//                            Thread.sleep(5000);
//                            orderShowData();
//                            orderClearFields();
//                        }
//                        if (option2.get().equals(ButtonType.NO)){
//                            orderShowData();
//                            orderClearFields();
//                        }
                        orderShowData();
                        orderClearFields();
                    } else {
                        a = new Alert(Alert.AlertType.INFORMATION);
                        a.setTitle("Information Message");
                        a.setHeaderText(null);
                        a.setContentText("Payment Cancelled!");
                        a.showAndWait();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Alert createAlertWithOptOut(Alert.AlertType type, String title, String headerText,
                                              String message, ButtonType... buttonTypes) {
        Alert alert = new Alert(type);
        alert.getDialogPane().applyCss();
        Node graphic = alert.getDialogPane().getGraphic();
        alert.getDialogPane().getButtonTypes().clear();
        alert.getDialogPane().getButtonTypes().addAll(buttonTypes);
        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setExpandableContent(new Group());
        alert.getDialogPane().setExpanded(true);
        alert.getDialogPane().setGraphic(graphic);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        return alert;
    }
    public static void selectOrder() {
        Unit unit = orderTable.getSelectionModel().getSelectedItem();
        int num = orderTable.getSelectionModel().getSelectedIndex();
        if((num-1)<-1) return;
        data.id = Integer.parseInt(unit.getId());
        data.inventory_name = unit.getName();
        data.inventory_stock = unit.getQuantity();
        data.inventory_price = unit.getPrice();
    }
    public void removeOrder(){
        if(data.id == null ){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please select the order you want to remove!");
            a.showAndWait();
        }else{
            String deleteOrder = "DELETE FROM `order` WHERE id = '"+ data.id+"'";
            connect2 =data.connectDB();
            try{
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Confirmation Message");
                a.setHeaderText(null);
                a.setContentText("Are you sure you want to delete this order?");
                Optional<ButtonType> option = a.showAndWait();
                if(option.get().equals(ButtonType.OK)){
                    prepare2 = connect2.prepareStatement(deleteOrder);
                    prepare2.executeUpdate();

                    String checkID ="";
                    int checkStock = 0;

                    String checkStockInSQL ="SELECT id,stock FROM inventory WHERE name = '" +data.inventory_name+"'";
                    Connection connect = data.connectDB();
                    try {
                        Statement statement = connect.createStatement();
                        ResultSet result = statement.executeQuery(checkStockInSQL);
                        if (result.next()) {
                            checkID =result.getString("id");
                            checkStock = result.getInt("stock");
                        }
                    } catch (Exception e){e.printStackTrace();}

                    int updatedStock = checkStock +data.inventory_stock;
                    try {
                        String sqlUpdateStock = "UPDATE inventory SET stock='" + updatedStock + "'," +
                                "name ='" + data.inventory_name + "'," +
                                "price='" + data.inventory_price + "' WHERE id ='"+ checkID+"'";
                        prepare2 = connect2.prepareStatement(sqlUpdateStock);
                        prepare2.executeUpdate();

                    }catch(Exception e){e.printStackTrace();}
                }

                orderShowData();
            }catch(Exception e){ e.printStackTrace();}
        }
    }
    public void receiptOfOrder(){
//        if(totalPriceOfOrder ==0 || addAmount.getText().isEmpty() ||addPayment.getSelectionModel().getSelectedItem().isEmpty()){
        if(totalPriceOfOrder ==0){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please order first");
            a.showAndWait();
        }else{
            setOrderID();
            var receiptPane = new Pane();
            receiptPane.setMinSize(500,600);

            var vbox = new VBox(10);
            vbox.setMinSize(480,580);
            vbox.setSpacing(10);

            var labelPane = new HBox(10);
            labelPane.setSpacing(10);
            labelPane.setAlignment(Pos.CENTER);

            Label n = new Label("Shuao's Cakehouse");
            n.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD,30));
            n.setAlignment(Pos.CENTER);

            ImageView i = new ImageView("receiptCakeIcon.png");
            i.setPreserveRatio(true);
            i.setFitWidth(55);
            i.setFitHeight(55);

            labelPane.getChildren().addAll(i,n);

            vbox.getChildren().add(labelPane);

            var labelDatePane = new AnchorPane();
            labelDatePane.setMinWidth(480);

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("EE yyyy-MM-dd HH:mm:ss");
            Label dateLabel = new Label(formatter.format(date));
            dateLabel.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            dateLabel.setAlignment(Pos.CENTER);
            dateLabel.setTranslateX(170);

            labelDatePane.getChildren().add(dateLabel);

            var labelReceiptIDPane = new AnchorPane();
            labelReceiptIDPane.setMinWidth(480);

            Label receiptIDLabel= new Label("Receipt for Order "+orderID);
            receiptIDLabel.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD,30));
            receiptIDLabel.setAlignment(Pos.CENTER);
            receiptIDLabel.setTranslateX(100);

            labelReceiptIDPane.getChildren().add(receiptIDLabel);

            var userNameLabel = new Label();
            if(userName1.getText().isEmpty()){userNameLabel.setText("Username: "+userName2.getText());
            }else{ userNameLabel.setText("Username: "+userName1.getText());}
            userNameLabel.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            userNameLabel.setAlignment(Pos.CENTER);
            userNameLabel.setTranslateX(205);

            var sep1 = new Separator();
            sep1.setPrefSize(50,2);

            var labelOrderPane = new AnchorPane();
            labelOrderPane.setMinWidth(480);

            HBox hbox = new HBox(10);
            hbox.setSpacing(10);
            hbox.setPadding(new Insets(10,0,0,10));

            Label n2 = new Label("Product Name");
            n2.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            n2.setTranslateX(10);

            Label s = new Label("Quantity");
            s.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            s.setTranslateX(160);

            Label p = new Label("Price");
            p.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            p.setTranslateX(232);

            hbox.getChildren().addAll(n2,s,p);

            labelOrderPane.getChildren().add(hbox);

            orderData = orderDataList();
            GridPane displayReceiptPane = new GridPane();
            displayReceiptPane.getRowConstraints().clear();
            displayReceiptPane.getColumnConstraints().clear();
            displayReceiptPane.setHgap(10);
            displayReceiptPane.setVgap(10);

            int row =0;
            for (Unit orderInReceipt : orderData) {
                displayReceiptPane.add(orderInReceipt.receiptOrderPane(), 1, row);
                row++;
            }
            vbox.getChildren().addAll(labelReceiptIDPane,userNameLabel,labelDatePane,sep1,labelOrderPane,displayReceiptPane);

            var sep2 = new Separator();
            sep2.setPrefSize(50,2);

            VBox vbox3 = new VBox(10);
            vbox3.setSpacing(10);
            vbox3.setPadding(new Insets(10,0,0,10));
            vbox3.setAlignment(Pos.CENTER);

            HBox priceHbox = new HBox(10);
            priceHbox.setSpacing(10);
            priceHbox.setPadding(new Insets(10,0,0,10));

            var totalPriceLabel = new Label("Total: ");
            totalPriceLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            totalPriceLabel.setTranslateX(280);

            var totalPriceLabel2 = new Label(String.valueOf(df.format(totalPriceOfOrder)));
            totalPriceLabel2.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            totalPriceLabel2.setTranslateX(350);
            totalPriceLabel2.setAlignment(Pos.CENTER_RIGHT);

            priceHbox.getChildren().addAll(totalPriceLabel,totalPriceLabel2);

            HBox chargeHbox = new HBox(10);
            chargeHbox.setSpacing(10);
            chargeHbox.setPadding(new Insets(10,0,0,10));

            var chargeLabel = new Label("Charge: ");
            chargeLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            chargeLabel.setTranslateX(270);

            var chargeLabel2 = new Label();
            if(change == 0){
                chargeLabel2 = new Label("0.00");
            }else{
                chargeLabel2 = new Label(df.format(charge.getText()).replace("$",""));
            }
            chargeLabel2.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            chargeLabel2.setTranslateX(345);

            chargeHbox.getChildren().addAll(chargeLabel,chargeLabel2);

            HBox paymentHbox = new HBox(10);
            paymentHbox.setSpacing(10);
            paymentHbox.setPadding(new Insets(10,0,0,10));

            var paymentLabel = new Label("Payment: ");
            paymentLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            paymentLabel.setTranslateX(260);

            var paymentLabel2 = new Label();
            if(addPayment.getSelectionModel().getSelectedItem()== null){
                paymentLabel2 = new Label("--------");
            }else{
                paymentLabel2 = new Label(addPayment.getSelectionModel().getSelectedItem());
            }
            paymentLabel2.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            paymentLabel2.setTranslateX(330);

            paymentHbox.getChildren().addAll(paymentLabel,paymentLabel2);

            vbox3.getChildren().addAll(priceHbox,chargeHbox,paymentHbox);

            vbox.getChildren().addAll(sep2,vbox3);

            var sep3 = new Separator();
            sep3.setPrefSize(50,2);

            VBox vbox2 = new VBox(10);
            vbox2.setSpacing(10);
            vbox2.setPadding(new Insets(10,0,0,10));
            vbox2.setAlignment(Pos.CENTER);

            var thankLabel = new Label("Thank you for choosing our products!");
            thankLabel.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD,20));

            var phoneLabel = new Label("Phone Number: +60197189247");
            phoneLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));

            var addressLabel = new Label("10 Street N/P 10, Malaysia");
            addressLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            vbox2.getChildren().addAll(thankLabel,phoneLabel,addressLabel);

            vbox.getChildren().addAll(sep3,vbox2);

            receiptPane.getChildren().addAll(vbox);

            var scene = new Scene(receiptPane,500,700);
            Stage receiptStage = new Stage();
            receiptStage.setScene(scene);
            receiptStage.setResizable(false);
            receiptStage.setTitle("Receipt for Order "+orderID);
            receiptStage.show();
        }
    }
    public void orderClearFields(){
        totalPriceOfOrder =0;
        amount =0;
        change =0;
        total.setText("$ 0.0");
        addAmount.setText("");
        charge.setText("$ 0.0");
        addPayment.getSelectionModel().clearSelection();
        addPayment.setPromptText("Choose Payment..");
    }
    public void orderClearFields2(){
        totalPriceOfOrder2 =0;
        amount2 =0;
        change2 =0;
        total2.setText("$ 0.0");
        addAmount2.setText("");
        charge2.setText("$ 0.0");
        addPayment2.getSelectionModel().clearSelection();
        addPayment2.setPromptText("Choose Payment..");
    }
    public class Receipt{
        private Integer id;
        private String username;
        private Double totalprice;
        private String payment;
        private Date date;
        public Receipt(){ }
        public Receipt(int i, String n, double t, String p, Date d){
            id =i; username = n; totalprice =t; payment =p; date =d;
        }
        public Integer getId(){return id;}
        public String getUsername(){return username;}
        public Double getTotalprice(){return totalprice;}
        public String getPayment(){return payment; }
        public Date getDate(){return date;}
    }
    private ObservableList<Receipt> receiptData;
    public ObservableList<Receipt> receiptDataList(){
        String sql = "SELECT * FROM `receipt`";
        connect2 = data.connectDB();
        ObservableList<Receipt> listData = FXCollections.observableArrayList();
        try{
            prepare2 = connect2.prepareStatement(sql);
            result2 = prepare2.executeQuery();
            Receipt r1;
            while(result2.next()){
                r1 = new Receipt(result2.getInt("order_id"),
                        result2.getString("userName"),
                        result2.getDouble("total"),
                        result2.getString("paymentMethod"),
                        result2.getDate("date"));
                listData.add(r1);
            }
        }catch(Exception e){e.printStackTrace();}

        String sql2 = "SELECT * FROM `cus_receipt`";
        try{
            prepare2 = connect2.prepareStatement(sql2);
            result2 = prepare2.executeQuery();
            Receipt r1;
            while(result2.next()){
                r1 = new Receipt(result2.getInt("order_id"),
                        result2.getString("userName"),
                        result2.getDouble("total"),
                        result2.getString("paymentMethod"),
                        result2.getDate("date"));
                listData.add(r1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public void receiptShowData(){
        receiptData = receiptDataList();

        customerTable.setPrefSize(830,620);
        customerTable.setTranslateX(10);
        customerTable.setTranslateY(50);
        customerTable.getStylesheets().add("tableView_column.css");

        admCus_idCol.setMinWidth(150);
        admCus_idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        admCus_userNameCol.setMinWidth(150);
        admCus_userNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        admCus_totalCol.setMinWidth(150);
        admCus_totalCol.setCellValueFactory(new PropertyValueFactory<>("totalprice"));

        admCus_paymentCol.setMinWidth(190);
        admCus_paymentCol.setCellValueFactory(new PropertyValueFactory<>("payment"));

        admCus_dateCol.setMinWidth(190);
        admCus_dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        customerTable.getColumns().clear();
        customerTable.getColumns().addAll(admCus_idCol,admCus_userNameCol,admCus_totalCol,admCus_paymentCol,admCus_dateCol);
        customerTable.setItems(receiptData);
    }
    private TableColumn<Receipt,Integer> admCus_idCol = new TableColumn<>("Receipt ID");
    private TableColumn<Receipt,String> admCus_paymentCol = new TableColumn<>("Paymemt");
    private TableColumn<Receipt,Date> admCus_dateCol = new TableColumn<>("Date");
    private TableColumn<Receipt,String> admCus_userNameCol = new TableColumn<>("Username");
    private TableColumn<Receipt,Double> admCus_totalCol = new TableColumn<>("Total($)");
    public Scene admCustomerScene(){
        var admPane = new AnchorPane();
        admPane.setPrefSize(1100, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        menuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(870,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(850,680);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var cusLabel = new Label("Customer's Order");
        cusLabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,30));
        cusLabel.setTranslateY(10);
        cusLabel.setTranslateX(10);

        receiptShowData();
        pane1.getChildren().addAll(cusLabel,customerTable);

        displayPane.getChildren().addAll(pane1);
        admPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(admPane, 1100, 700);
    }
    private TextField addEmail = new TextField();
    private TextField addUserName = new TextField();
    private TextField addPassword = new TextField();
    private final String[] identityList ={"Admin","Customer"};
    private final ComboBox<String> addIdentity = new ComboBox<>();
    public void userIdentityList(){
        List<String> typeL = new ArrayList<>(Arrays.asList(identityList));
        ObservableList<String> listData =FXCollections.observableArrayList(typeL);
        addIdentity.setItems(listData);
    }
    public class User{
        private String username;
        private String password;
        private String email;
        private String identity;
        private Date date;
        public User(){ }
        public User( String n, String p,String e,String i,Date d){
             username = n; password =p; email =e;identity=i;date =d;
        }
        public String getUsername(){return username;}
        public String getPassword(){return password;}
        public String getEmail(){return email;}
        public String getIdentity(){return identity; }
        public Date getDate(){return date;}
    }
    private TableView<User> userTable = new TableView<>();
    private ObservableList<User> userData;
    public ObservableList<User> userDataList(){
        ObservableList<User> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `user`";
        connect2 = data.connectDB();
        try{
            prepare2 = connect2.prepareStatement(sql);
            result2 = prepare2.executeQuery();
            User u1;
            while(result2.next()){
                u1 = new User(result2.getString("userName"),
                        result2.getString("password"),
                        result2.getString("emailAdd"),
                        result2.getString("identity"),
                        result2.getDate("date"));
                listData.add(u1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    private TableColumn<User,String> user_nameCol = new TableColumn<>("Username");
    private TableColumn<User,String> user_passwordCol = new TableColumn<>("Password");
    private TableColumn<User,String> user_emailCol = new TableColumn<>("Email");
    private TableColumn<User,String> user_identityCol = new TableColumn<>("Identity");
    private TableColumn<User,Date> user_dateCol = new TableColumn<>("Date");
    public void userShowData(){
        userData = userDataList();

        user_nameCol.setMinWidth(131);
        user_nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        user_passwordCol.setMinWidth(210);
        user_passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

        user_emailCol .setMinWidth(210);
        user_emailCol .setCellValueFactory(new PropertyValueFactory<>("email"));

        user_identityCol.setMinWidth(132);
        user_identityCol.setCellValueFactory(new PropertyValueFactory<>("identity"));

        user_dateCol.setMinWidth(132);
        user_dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        userTable.getColumns().clear();
        userTable.getColumns().addAll(user_nameCol,user_passwordCol,user_emailCol,user_identityCol,user_dateCol);
        userTable.setPrefSize(820,380);
        userTable.setTranslateY(40);
        userTable.setTranslateX(10);
        userTable.getStylesheets().add("tableView_column.css");
        userTable.setItems(userData);
        userTable.setOnMouseClicked(e -> selectUser());
    }
    private void deleteUser() {
        if (addUserName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the user!");
            alert.showAndWait();
        } else {
            String deleteData = "DELETE FROM user WHERE userName ='"+addUserName.getText()+"'";
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE USERNAME: "+addUserName.getText()+"?");
            Optional <ButtonType> option = alert.showAndWait();
            connect2 = data.connectDB();

            if(option.get().equals(ButtonType.OK)){
                try{
                    prepare2 = connect2.prepareStatement(deleteData);
                    prepare2.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted");
                    alert.showAndWait();

                    userShowData();
                    clearUser();
                }catch(Exception e){e.printStackTrace();}
            }else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        }
    }
    private void clearUser() {
        addUserName.setText("");
        addPassword.setText("");
        addIdentity.getSelectionModel().clearSelection();
        addEmail.setText("");
    }
    public void selectUser(){
        User user = userTable.getSelectionModel().getSelectedItem();
        int num = userTable.getSelectionModel().getSelectedIndex();
        if((num-1)<-1) return;
        addUserName.setText(user.getUsername());
        addPassword.setText(user.getPassword());
        addEmail.setText(user.getEmail());
        addIdentity.setValue(user.getIdentity());
    }
    private void updateUser() {
        if(addUserName.getText().isEmpty()
                ||addEmail.getText().isEmpty()
                ||addIdentity.getSelectionModel().getSelectedItem() == null
                ||addPassword.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();
        }else{
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            String updateData = "UPDATE user SET "
                    +" userName ='"+ addUserName.getText()
                    +"', password ='"+addPassword.getText()
                    +"', emailAdd='"+addEmail.getText()
                    +"', identity='"+addIdentity.getSelectionModel().getSelectedItem()
                    +"', date='"+sqlDate+"' WHERE userName = '"+addUserName.getText()+"'";
            connect2 = data.connectDB();
            try{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE USERNAME: "+addUserName.getText()+"?");
                Optional <ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    prepare2 = connect2.prepareStatement(updateData);
                    prepare2.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated");
                    alert.showAndWait();

                    userShowData();
                    clearUser();
                }else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
                }
            }catch(Exception e){e.printStackTrace();}
        }
    }
    private void addUser() {
        if(addUserName.getText().isEmpty()
                ||addEmail.getText().isEmpty()
                ||addIdentity.getSelectionModel().getSelectedItem() == null
                ||addPassword.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();
        }else{
            String checkID = "SELECT userName FROM user WHERE userName ='"+addUserName.getText()+"'";
            connect2 = data.connectDB();
            try{
                statement2 = connect2.createStatement();
                result2 = statement2.executeQuery(checkID);
                if (result2.next()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(addUserName.getText() +" is already taken");
                    alert.showAndWait();
                }else {
                    String insertData ="INSERT INTO `user`(`userName`, `password`, `emailAdd`, `identity`, `date`) " +
                            "VALUES (?,?,?,?,?)";
                    prepare2 = connect2.prepareStatement(insertData);
                    prepare2.setString(1,addUserName.getText());
                    prepare2.setString(2,addPassword.getText());
                    prepare2.setString(3,addEmail.getText());
                    prepare2.setString(4,addIdentity.getSelectionModel().getSelectedItem());
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare2.setString(5,String.valueOf(sqlDate));
                    prepare2.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added");
                    alert.showAndWait();

                    userShowData();
                    clearUser();
                }

            }catch(Exception e){e.printStackTrace();}
        }
    }
    public Scene admAdminScene(){
        var admPane = new AnchorPane();
        admPane.setPrefSize(1100, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        menuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(870,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(850,430);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var userLabel = new Label("User Data");
        userLabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,30));
        userLabel.setTranslateY(10);
        userLabel.setTranslateX(10);

        userShowData();

        var sep1 = new Separator();
        sep1.setPrefSize(850,1);
        sep1.setTranslateX(10);
        sep1.setTranslateY(450);

        var pane2 = new AnchorPane();
        pane2.setPrefSize(850,230);
        pane2.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane2.setTranslateX(10);
        pane2.setTranslateY(460);

        Label emailLabel =new Label("Email Add:  ");setFont2(emailLabel);setTextField4(addEmail);

        Label nameLabel = new Label("User Name:  ");setFont2(nameLabel);setTextField4(addUserName);

        Label passwordLabel = new Label("Password:  ");setFont2(passwordLabel);setTextField4(addPassword);

        Label identityLabel = new Label("Identity:  ");setFont2(identityLabel);
        setComboBox3(addIdentity);addIdentity.setPromptText("Choose Identity..");userIdentityList();

        var btAdd = new Button("Add");
        setButton2(btAdd);
        btAdd.setOnAction(e -> addUser());

        var btUpdate= new Button("Update");
        setButton2(btUpdate);
        btUpdate.setOnAction(e -> updateUser());

        var btClear = new Button("Clear");
        setButton2(btClear);
        btClear.setOnAction(e -> clearUser());

        var btDelete = new Button("Delete");
        setButton2(btDelete);
        btDelete.setOnAction(e -> deleteUser());

        var pane1in2 = new GridPane();
        pane1in2.setPrefSize(800,230);
        pane1in2.setStyle("-fx-background-color:transparent");
        pane1in2.setVgap(10);
        pane1in2.setHgap(10);
        pane1in2.setTranslateY(10);
        pane1in2.setTranslateX(10);
        pane1in2.setPadding(new Insets(10,10,10,10));

        pane1in2.add(emailLabel,0,0);pane1in2.add(addEmail,1,0);
        pane1in2.add(nameLabel,0,1);pane1in2.add(addUserName,1,1);
        pane1in2.add(passwordLabel,0,2);pane1in2.add(addPassword,1,2);
        pane1in2.add(identityLabel,0,3); pane1in2.add(addIdentity,1,3);

        pane1in2.add(btAdd,2,0);
        pane1in2.add(btUpdate,2,1);
        pane1in2.add(btClear,2,2);
        pane1in2.add(btDelete,2,3);

        pane2.getChildren().addAll(pane1in2);

        pane1.getChildren().addAll(userLabel,userTable);

        displayPane.getChildren().addAll(pane1,sep1,pane2);
        admPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(admPane, 1100, 700);
    }
    public Scene admFeedbackScene(){
        var admPane = new AnchorPane();
        admPane.setPrefSize(1100, 600);

        var menuPane = new GridPane();//set prefsize and color and design
        menuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(870,800);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(850,300);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var cusLabel = new Label("Customer's Feedback");
        cusLabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,30));
        cusLabel.setTranslateY(10);
        cusLabel.setTranslateX(10);

        feedbackShowData();
        pane1.getChildren().addAll(cusLabel,surveyTable);

        var pane2 = new AnchorPane();
        pane2.setPrefSize(850,370);
        pane2.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane2.setTranslateX(10);
        pane2.setTranslateY(320);

        var wayData = new AnchorPane();
        wayData.setPrefSize(280,340);
        wayData.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        wayData.setTranslateX(10);
        wayData.setTranslateY(15);

        CategoryAxis xaxis = new CategoryAxis();
        NumberAxis yaxis = new NumberAxis();
        xaxis.setLabel("Way");
        yaxis.setLabel("Number");
        wayChart = new AreaChart<>(xaxis, yaxis);
        admFeedbackDisplayWayChart();
        wayChart.setTitle("Way's Chart");
        wayChart.setPrefSize(280,340);
        wayData.getChildren().addAll(wayChart);

        var surveyData = new AnchorPane();
        surveyData.setPrefSize(540,340);
        surveyData.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        surveyData.setTranslateX(300);
        surveyData.setTranslateY(15);

        CategoryAxis xaxis2 = new CategoryAxis();
        NumberAxis yaxis2 =new NumberAxis();
        xaxis2.setLabel("Rating");
        yaxis2.setLabel("Number");
        surveyChart = new BarChart<>(xaxis2, yaxis2);
        admFeedbackDisplaySurveyChart();
        surveyChart.setTitle("Rating Survey's Chart");
        surveyChart.setPrefSize(540,340);
        surveyData.getChildren().addAll(surveyChart);

        pane2.getChildren().addAll(wayData,surveyData);

        displayPane.getChildren().addAll(pane1,pane2);
        admPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(admPane, 1100, 700);
    }
    public AreaChart<String, Number> wayChart;
    public BarChart<String, Number> surveyChart;
    public void admFeedbackDisplayWayChart(){
        if(wayChart != null){
            wayChart.getData().clear();
        }
        String sql ="SELECT date, COUNT(way) FROM survey WHERE way ='Dine In' GROUP BY date ORDER BY TIMESTAMP(date)";
        //String sql ="SELECT way, COUNT(way) FROM survey GROUP BY way";
        connect1 = data.connectDB();
        XYChart.Series<String,Number> chart = new XYChart.Series<>();
        chart.setName("Dine In");
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart.getData().add(new XYChart.Data<>(result1.getString(1),result1.getInt(2)));
            }
            wayChart.getData().add(chart);
        }catch(Exception e){ e.printStackTrace();}

        String sql2 ="SELECT date, COUNT(way) FROM survey WHERE way ='Take Out' GROUP BY date ORDER BY TIMESTAMP(date)";
        connect1 = data.connectDB();
        XYChart.Series<String,Number> chart2 = new XYChart.Series<>();
        chart2.setName("Take Out");
        try{
            prepare1 = connect1.prepareStatement(sql2);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart2.getData().add(new XYChart.Data<>(result1.getString(1),result1.getInt(2)));
            }
            wayChart.getData().add(chart2);
        }catch(Exception e){ e.printStackTrace();}
    }
    public void admFeedbackDisplaySurveyChart(){
        if(surveyChart != null){
            surveyChart.getData().clear();
        }
        String sql ="SELECT food_quality, COUNT(food_quality) FROM survey GROUP BY food_quality";
        connect1 = data.connectDB();
        XYChart.Series<String,Number> chart = new XYChart.Series<>();
        chart.setName("Food Quality");
        try{
            prepare1 = connect1.prepareStatement(sql);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart.getData().add(new XYChart.Data<>(result1.getString(1),result1.getInt(2)));
            }
            surveyChart.getData().add(chart);
        }catch(Exception e){ e.printStackTrace();}

        String sql2 ="SELECT order_accuracy, COUNT(order_accuracy) FROM survey GROUP BY order_accuracy";
        XYChart.Series<String,Number> chart2 = new XYChart.Series<>();
        chart2.setName("Order Accuracy");
        try{
            prepare1 = connect1.prepareStatement(sql2);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart2.getData().add(new XYChart.Data<>(result1.getString(1),result1.getInt(2)));
            }
            surveyChart.getData().add(chart2);
        }catch(Exception e){ e.printStackTrace();}

        String sql3 ="SELECT cleanliness, COUNT(cleanliness) FROM survey GROUP BY cleanliness";
        XYChart.Series<String,Number> chart3 = new XYChart.Series<>();
        chart3.setName("Cleanliness");
        try{
            prepare1 = connect1.prepareStatement(sql3);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart3.getData().add(new XYChart.Data<>(result1.getString(1),result1.getInt(2)));
            }
            surveyChart.getData().add(chart3);
        }catch(Exception e){ e.printStackTrace();}

        String sql4 ="SELECT cleanliness, COUNT(service_quality) FROM survey GROUP BY service_quality";
        XYChart.Series<String,Number> chart4 = new XYChart.Series<>();
        chart4.setName("Service Quality");
        try{
            prepare1 = connect1.prepareStatement(sql4);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart4.getData().add(new XYChart.Data<>(result1.getString(1),result1.getInt(2)));
            }
            surveyChart.getData().add(chart4);
        }catch(Exception e){ e.printStackTrace();}

        String sql5 ="SELECT cleanliness, COUNT(experience) FROM survey GROUP BY experience";
        XYChart.Series<String,Number> chart5 = new XYChart.Series<>();
        chart5.setName("Service Quality");
        try{
            prepare1 = connect1.prepareStatement(sql5);
            result1 = prepare1.executeQuery();
            while(result1.next()){
                chart5.getData().add(new XYChart.Data<>(result1.getString(1),result1.getInt(2)));
            }
            surveyChart.getData().add(chart5);
        }catch(Exception e){ e.printStackTrace();}


    }
    public class Survey{
        private Integer id;
        private String username;
        private String way;
        private String food_quality;
        private String order_accuracy;
        private String cleanliness;
        private String service_quality;
        private String experience;
        private String comment;
        private Date date;
        public Survey(){ }
        public Survey(Integer i, String n, String w,String f, String o,String c, String s, String e,String com,Date d){
            id =i; username = n; way= w;food_quality =f;
            order_accuracy = o;service_quality=s;cleanliness =c;
            experience = e; comment= com; date =d;
        }
        public Integer getId(){return id;}
        public String getUsername(){return username;}
        public String getWay(){return way;}
        public String getFood_quality(){return food_quality;}
        public String getOrder_accuracy(){return order_accuracy;}
        public String getService_quality(){return service_quality;}
        public String getCleanliness(){ return  cleanliness;}
        public String getExperience(){return experience;}
        public String getComment(){return comment;}
        public Date getDate(){return date;}
    }
    private ObservableList<Survey> surveyData;
    public ObservableList<Survey> surveyDataList(){
        String sql = "SELECT * FROM `survey`";
        connect2 = data.connectDB();
        ObservableList<Survey> listData = FXCollections.observableArrayList();
        try{
            prepare2 = connect2.prepareStatement(sql);
            result2 = prepare2.executeQuery();
            Survey s1;
            while(result2.next()){
                s1 = new Survey(result2.getInt("id"),
                        result2.getString("userName"),
                        result2.getString("way"),
                        result2.getString("food_quality"),
                        result2.getString("order_accuracy"),
                        result2.getString("cleanliness"),
                        result2.getString("service_quality"),
                        result2.getString("experience"),
                        result2.getString("comment"),
                        result2.getDate("date"));
                listData.add(s1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    private TableView<Survey> surveyTable = new TableView<>();
    private TableColumn<Survey,String> surveyNameCol = new TableColumn<>("Name");
    private TableColumn<Survey,Date> surveyDateCol = new TableColumn<>("Date");
    private TableColumn<Survey,String> surveyWayCol = new TableColumn<>("Way");
    private TableColumn<Survey,String> surveyFoodQualityCol = new TableColumn<>("Food Quality");
    private TableColumn<Survey,String> surveyOrderAccuracyCol = new TableColumn<>("Order Accuracy");
    private TableColumn<Survey,String> surveyCleanlinessCol = new TableColumn<>("Cleanliness");
    private TableColumn<Survey,String> surveyServiceQualityCol = new TableColumn<>("Service Quality");
    private TableColumn<Survey,String> surveyExperienceCol = new TableColumn<>("Experience");
    private TableColumn<Survey,String> surveyCommentCol = new TableColumn<>("Comment");
    public void feedbackShowData(){
        surveyData = surveyDataList();

        surveyTable.setPrefSize(830,240);
        surveyTable.setTranslateX(10);
        surveyTable.setTranslateY(50);
        surveyTable.getStylesheets().add("tableView_column.css");

        surveyNameCol.setMinWidth(100);
        surveyNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        surveyWayCol.setMinWidth(100);
        surveyWayCol.setCellValueFactory(new PropertyValueFactory<>("way"));

        surveyFoodQualityCol.setMinWidth(100);
        surveyFoodQualityCol.setCellValueFactory(new PropertyValueFactory<>("food_quality"));

        surveyOrderAccuracyCol.setMinWidth(100);
        surveyOrderAccuracyCol.setCellValueFactory(new PropertyValueFactory<>("order_accuracy"));

        surveyCleanlinessCol.setMinWidth(100);
        surveyCleanlinessCol.setCellValueFactory(new PropertyValueFactory<>("cleanliness"));

        surveyServiceQualityCol.setMinWidth(100);
        surveyServiceQualityCol.setCellValueFactory(new PropertyValueFactory<>("service_quality"));

        surveyExperienceCol.setMinWidth(100);
        surveyExperienceCol.setCellValueFactory(new PropertyValueFactory<>("experience"));

        surveyCommentCol.setMinWidth(100);
        surveyCommentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));

        surveyDateCol.setMinWidth(100);
        surveyDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        surveyTable.getColumns().clear();
        surveyTable.getColumns().addAll(surveyNameCol,surveyWayCol,surveyFoodQualityCol,surveyOrderAccuracyCol,
                surveyCleanlinessCol,surveyServiceQualityCol,surveyExperienceCol,surveyCommentCol,surveyDateCol);
        surveyTable.setItems(surveyData);
    }
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setScene(loginScene());
        primaryStage.setResizable(false);
        primaryStage.setTitle("Shuao's CakeHouse");
        primaryStage.show();
    }
    public void cusMenuBar(GridPane  menuPane){
        menuPane.setHgap(10);
        menuPane.setVgap(10);
        menuPane.setPadding(new Insets(10,10,10,10));
        menuPane.setStyle(bgDesign);

        var resLabel = new Label("Shuao's Cakehouse");
        setFont(resLabel);

        var welLabel = new Label();
        if(userName1 !=null){
            welLabel = new Label("Welcome, "+(userName1.getText()));
        }else{
            welLabel = new Label("Welcome, "+(userName2.getText()));
        }
        setFont(welLabel);

        var btAboutUs = new Button("About Us");setButton(btAboutUs);
        btAboutUs.setOnAction(e -> window.setScene(cusScene()));

        var btMenu = new Button("Menu");setButton(btMenu);
        btMenu.setOnAction(e -> window.setScene(cusMenuScene()));

        var btCart = new Button("Cart");setButton(btCart);
        btCart.setOnAction(e -> window.setScene(cusCartScene()));

        var btOrderHistory = new Button("Order History"); setButton(btOrderHistory);
        btOrderHistory.setOnAction(e -> window.setScene(cusOrderHistoryScene()));

        var space1 = new Pane();
        space1.setStyle("-fx-background-color: transparent;");
        space1.setPrefSize(210,310);

        var signOutPane = new HBox(10);signOutPane(signOutPane);

        menuPane.getChildren().clear();
        menuPane.add(resLabel, 0, 0);
        menuPane.add(welLabel, 0, 1);
        menuPane.add(btAboutUs, 0, 2);
        menuPane.add(btMenu,0,3);
        menuPane.add(btCart,0,4);
        menuPane.add(btOrderHistory,0,5);
        menuPane.add(space1,0,6);
        menuPane.add(signOutPane,0,8);
    }
    private Scene cusScene(){
        var cusPane = new AnchorPane();
        cusPane.setPrefSize(1200, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        cusMenuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(1200,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(950,680);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var aboutUsLabel = new Label("About Us");
        aboutUsLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,30));
        aboutUsLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        aboutUsLabel.setAlignment(Pos.TOP_CENTER);
        aboutUsLabel.setTranslateX(400);

        var sep1 = new Separator();
        sep1.setPrefSize(930,1);
        sep1.setTranslateY(50);
        sep1.setTranslateX(10);

        var pane1in2 = new AnchorPane();
        pane1in2.setPrefSize(930,600);
        pane1in2.setTranslateX(10);
        pane1in2.setTranslateY(60);

        var pane1in1 = new ScrollPane();
        pane1in1.setPrefSize(930,600);
        pane1in1.setStyle("-fx-background-color :transparent;");
        pane1in1.getStylesheets().add("scrollPane.css");

        var overallPane = new Pane();
        overallPane.setPrefSize(930,900);

        var historyPane = new AnchorPane();
        historyPane.setPrefSize(930,300);
        historyPane.setStyle("-fx-background-color:white;");

        var historyLabel = new Label("History");
        historyLabel.setPrefSize(450,300);
        historyLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,65));
        historyLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        historyLabel.setAlignment(Pos.CENTER);

        var historyImagePane = new AnchorPane();
        historyImagePane.setPrefSize(450,300);
        historyImagePane.setTranslateX(450);
        historyImagePane.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);"+
                "-fx-border-radius:15px;-fx-text-alignment:CENTER;" +
                "-fx-border-width:5px;");

        var historyImageView = new ImageView("cakehouseIcon3.jpg");
        historyImageView.setFitWidth(430);
        historyImageView.setFitHeight(280);
        historyImageView.setTranslateX(10);
        historyImageView.setTranslateY(10);
        historyImageView.setOnMouseClicked(e -> historyImagePane.setVisible(false));
        historyImagePane.getChildren().addAll(historyImageView);

        var historyText = new Label();
        historyText.setPrefSize(450,300);
        historyText.setText("The journey of Shuao’s Cake House\nbegins since 2022.\nOur cake house lays the first " +
                "footprint on Gelang Patah\n which in a residence area.\n At present, we serve all range of product,\n " +
                "from cream cheese to Baseque Cheesecake,\n from coffee beans to popular western coffee. \nYou name it, "+
                "we have it!");
        historyText.setFont(Font.font("Lucida Calligraphy",(FontWeight)null,15));
        historyText.setAlignment(Pos.CENTER);
        historyText.setWrapText(true);
        historyText.setTranslateX(450);
        historyText.setStyle("-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);" +
                "-fx-border-radius:15px;-fx-text-alignment:CENTER;" +
                "-fx-border-width:5px;");
        historyText.setOnMouseClicked(e -> historyImagePane.setVisible(true));

        historyPane.getChildren().addAll(historyLabel,historyText,historyImagePane);

        var chefPane = new AnchorPane();
        chefPane.setPrefSize(930,300);
        chefPane.setStyle("-fx-background-color:white;");
        chefPane.setTranslateY(300);

        var chefLabel = new Label("About Chef");
        chefLabel.setWrapText(true);
        chefLabel.setPrefSize(450,300);
        chefLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,60));
        chefLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        chefLabel.setTranslateX(450);
        chefLabel.setAlignment(Pos.CENTER);

        var chefImagePane = new AnchorPane();
        chefImagePane.setPrefSize(450,300);
        chefImagePane.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);"+
                "-fx-border-radius:15px;-fx-text-alignment:CENTER;" +
                "-fx-border-width:5px;");

        var chefImageView = new ImageView("chefIcon2.jpg");
        chefImageView.setFitWidth(430);
        chefImageView.setFitHeight(280);
        chefImageView.setTranslateX(10);
        chefImageView.setTranslateY(10);
        chefImagePane.getChildren().addAll(chefImageView);

        var chefText = new Label();
        chefText.setPrefSize(450,300);
        chefText.setText("Chef Eejay Lau believes in putting her heart into every cakes prepared by our cake house.\n" +
                " Sometimes, she would rather take an item off the menu\n" +
                "if the ingredients are not up to her standard.");
        chefText.setFont(Font.font("Lucida Calligraphy",(FontWeight)null,15));
        chefText.setAlignment(Pos.CENTER);
        chefText.setWrapText(true);
        chefText.setStyle("-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);" +
                "-fx-border-radius:15px;-fx-text-alignment:CENTER;" +
                "-fx-border-width:5px;");
        chefImageView.setOnMouseClicked(e -> {chefImagePane.setVisible(false);chefText.setVisible(true);});
        chefText.setOnMouseClicked(e -> {chefImagePane.setVisible(true);chefText.setVisible(false);});

        chefPane.getChildren().addAll(chefLabel,chefText,chefImagePane);

        var baristaPane = new AnchorPane();
        baristaPane.setPrefSize(930,300);
        baristaPane.setStyle("-fx-background-color:white;");
        baristaPane.setTranslateY(600);

        var baristaLabel = new Label("About Barista");
        baristaLabel.setWrapText(true);
        baristaLabel.setPrefSize(450,300);
        baristaLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,52));
        baristaLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        baristaLabel.setAlignment(Pos.CENTER);

        var baristaImagePane = new AnchorPane();
        baristaImagePane.setPrefSize(450,300);
        baristaImagePane.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);"+
                "-fx-border-radius:15px;-fx-text-alignment:CENTER;" +
                "-fx-border-width:5px;");
        baristaImagePane.setTranslateX(450);

        var baristaImageView = new ImageView("baristaIcon2.jpeg");
        baristaImageView.setFitWidth(430);
        baristaImageView.setFitHeight(280);
        baristaImageView.setTranslateX(10);
        baristaImageView.setTranslateY(10);
        baristaImagePane.getChildren().addAll(baristaImageView);

        var baristaText = new Label();
        baristaText.setPrefSize(450,300);
        baristaText.setText("Barista Oliva Ong makes and serves beverages\nsuch as latte, bubble tea, espresso, and others.\n" +
                " They are responsible for producing high-quality hand-crafted beverages.");
        baristaText.setFont(Font.font("Lucida Calligraphy",(FontWeight)null,15));
        baristaText.setAlignment(Pos.CENTER);
        baristaText.setTranslateX(450);
        baristaText.setWrapText(true);
        baristaText.setStyle("-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1);" +
                "-fx-border-radius:15px;-fx-text-alignment:CENTER;" +
                "-fx-border-width:5px;");
        baristaImageView.setOnMouseClicked(e -> {baristaImagePane.setVisible(false);baristaText.setVisible(true);});
        baristaText.setOnMouseClicked(e -> {baristaImagePane.setVisible(true);baristaText.setVisible(false);});

        baristaPane.getChildren().addAll(baristaLabel,baristaText,baristaImagePane);

        overallPane.getChildren().addAll(historyPane,chefPane,baristaPane);

        pane1in1.setContent(overallPane);
        pane1in2.getChildren().addAll(pane1in1);
        pane1.getChildren().addAll(aboutUsLabel,sep1,pane1in2);
        displayPane.getChildren().addAll(pane1);
        cusPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(cusPane, 1200, 700);
    }
    public GridPane cusDisplayProductPane = new GridPane();
    private Scene cusMenuScene(){
        var cusPane = new AnchorPane();
        cusPane.setPrefSize(1200, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        cusMenuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(1200,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(950,680);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var menuLabel = new Label("Menu");
        menuLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,30));
        menuLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        menuLabel.setAlignment(Pos.TOP_CENTER);
        menuLabel.setTranslateX(400);

        var sep1 = new Separator();
        sep1.setPrefSize(930,1);
        sep1.setTranslateY(50);
        sep1.setTranslateX(10);

        var pane1in1 = new ScrollPane();
        pane1in1.setPrefSize(930,600);
        pane1in1.setTranslateX(10);
        pane1in1.setTranslateY(60);
        pane1in1.setStyle("-fx-background-color :transparent;");
        pane1in1.getStylesheets().add("scrollPane.css");

        cusDisplayProductPane.setHgap(10);
        cusDisplayProductPane.setVgap(10);
        cusDisplayProductPane.setStyle("-fx-background-color: white;");
        cusMenuPoductDisplay();

        pane1in1.setContent(cusDisplayProductPane);
        pane1.getChildren().addAll(menuLabel,sep1,pane1in1);
        displayPane.getChildren().addAll(pane1);
        cusPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(cusPane, 1200, 700);
    }
    public void cusMenuPoductDisplay(){
        productData = productDataList();
        cusDisplayProductPane.getRowConstraints().clear();
        cusDisplayProductPane.getColumnConstraints().clear();
        int row =0;
        int col =0;
        for (Unit productDatum : productData) {
            if (col == 4) {
                col = 0;
                row += 1;
            }
            cusDisplayProductPane.add(productDatum.cusProductPane(), col++, row);
        }
    }
    private Scene cusCartScene(){
        var cusPane = new AnchorPane();
        cusPane.setPrefSize(1200, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        cusMenuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(1200,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(950,680);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var cartLabel = new Label("Shopping Cart");
        cartLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,30));
        cartLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        cartLabel.setAlignment(Pos.TOP_CENTER);
        cartLabel.setTranslateX(350);

        var sep1 = new Separator();
        sep1.setPrefSize(930,1);
        sep1.setTranslateY(50);
        sep1.setTranslateX(10);

        var cartPane = new AnchorPane();
        cartPane.setPrefSize(460,600);
        cartPane.setStyle("-fx-background-color: #fff;");
        cartPane.setTranslateX(10);
        cartPane.setTranslateY(60);

        var pane1in1 = new ScrollPane();
        pane1in1.setPrefSize(460,322);
        pane1in1.setStyle("-fx-background-color :transparent;");
        pane1in1.getStylesheets().add("scrollPane.css");

        cusOrderShowData();
        pane1in1.setContent(cusOrderTable);

        var pane2in1 = new GridPane();
        pane2in1.setTranslateX(10);
        pane2in1.setTranslateY(340);
        pane2in1.setPrefSize(460,300);
        pane2in1.setVgap(10);
        pane2in1.setHgap(10);

        var totalLabel = new Label(" Total: ");
        setFont4(totalLabel);
        setFont4(total2);
        calculateTotalCus();

        var amountLabel = new Label(" Amount: ");
        setFont4(amountLabel);
        setTextField3(addAmount2);
        addAmount2.setPromptText("$0.0");
        addAmount2.setOnAction(e -> calculateCusCharge());

        var chargeLabel = new Label(" Charge: ");
        setFont4(chargeLabel);
        setFont4(charge2);

        var paymentLabel = new Label(" Payment: ");
        setFont4(paymentLabel);
        productPaymentList();
        setComboBox2(addPayment2);
        addPayment2.setOnAction(e -> getPaymentMethodCus());
        addPayment.setOnMouseClicked(e -> getPaymentMethodCus());

        btPay.setPrefSize(450,35);
        btPay.setFont(Font.font(15));
        btPay.setTranslateX(10);
        btPay.setTranslateY(510);
        btPay.setOnAction(e -> payCusOrder());

        btRemove.setPrefSize(220,35);
        btRemove.setFont(Font.font(15));
        btRemove.setTranslateX(10);
        btRemove.setTranslateY(555);
        btRemove.setOnAction(e -> removeCusOrder());

        btReceipt.setPrefSize(220,35);
        btReceipt.setFont(Font.font(15));
        btReceipt.setTranslateX(240);
        btReceipt.setTranslateY(555);
        btReceipt.setOnAction(e -> receiptOfCusOrder());

        pane2in1.add(totalLabel,0,0); pane2in1.add(total2,1,0);
        pane2in1.add(amountLabel,0,1); pane2in1.add(addAmount2,1,1);
        pane2in1.add(chargeLabel,0,2); pane2in1.add(charge2,1,2);
        pane2in1.add(paymentLabel,0,3); pane2in1.add(addPayment2,1,3);

        cartPane.getChildren().addAll(pane1in1,pane2in1,btPay,btRemove,btReceipt);

        Separator sep2 = new Separator();
        sep2.setPrefSize(1,610);
        sep2.setTranslateY(60);
        sep2.setTranslateX(480);
        sep2.setOrientation(Orientation.VERTICAL);

        var pane1in2 = new ScrollPane();
        pane1in2.setPrefSize(450,600);
        pane1in2.getStylesheets().add("scrollPane.css");
//        pane1in2.setStyle("-fx-background-color :white;");
        pane1in2.setTranslateX(490);
        pane1in2.setTranslateY(60);

        var cartPane2 = new AnchorPane();
        cartPane2.setPrefSize(360,560);
        cartPane2.setStyle("-fx-background-color: white;");
//        cartPane2.setTranslateX(490);
//        cartPane2.setTranslateY(60);

        var vb1 = new VBox(8);
        vb1.setAlignment(Pos.CENTER_LEFT);
        vb1.setPadding(new Insets(10,0,10,0));

        Label reviewLabel = new Label("Leave a review");
        reviewLabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,30));

        Text reviewText = new Text("Please let us know how was the food and service.");
        reviewText.setFont(Font.font("Times New Roman",(FontWeight)null,12));

        Separator sep3 = new Separator();
        sep3.setPrefSize(440,1);

        HBox hb1 = new HBox(10);
        hb1.setPadding(new Insets(10,10,10,10));
        hb1.setAlignment(Pos.CENTER_LEFT);

        Label q1 = new Label("Dine In / Take Out");
        q1.setFont(Font.font("Times New Roman",FontWeight.BOLD,12));

        ToggleGroup toggle1 = new ToggleGroup();

        RadioButton btDineIn = new RadioButton("Dine In");
        btDineIn.setToggleGroup(toggle1);
        btDineIn.setSelected(true);

        RadioButton btTakeOut = new RadioButton("Take Out");
        btTakeOut.setToggleGroup(toggle1);

//        System.out.println(((RadioButton)toggle1.getSelectedToggle()).getText());
        hb1.getChildren().addAll(q1,btDineIn, btTakeOut);

        ToggleGroup toggle2 = new ToggleGroup();
        VBox vb2 = createQuestion(toggle2,"Food Quality");
//        System.out.println(((RadioButton)toggle2.getSelectedToggle()).getText());

        ToggleGroup toggle3 = new ToggleGroup();
        VBox vb3 = createQuestion(toggle3,"Order Accuracy");
//        System.out.println(((RadioButton)toggle3.getSelectedToggle()).getText());

        ToggleGroup toggle4 = new ToggleGroup();
        VBox vb4 = createQuestion(toggle4,"Cleanliness");
//        System.out.println(((RadioButton)toggle4.getSelectedToggle()).getText());

        ToggleGroup toggle5 = new ToggleGroup();
        VBox vb5 = createQuestion(toggle5,"Overall Service Quality");
//        System.out.println(((RadioButton)toggle5.getSelectedToggle()).getText());

        ToggleGroup toggle6 = new ToggleGroup();
        VBox vb6 = createQuestion(toggle6,"Experience");
//        System.out.println(((RadioButton)toggle6.getSelectedToggle()).getText());

        VBox vb7 = new VBox(8);
        vb7.setPadding(new Insets(10,10,10,10));

        Label commentLabel = new Label("Any comments, questions or suggestions?");
        commentLabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,12));

        TextField commentText = new TextField();
        commentText.setFont(Font.font("Times New Roman",(FontWeight)null,12));

        vb7.getChildren().addAll(commentLabel,commentText);

        Button btSubmit = new Button("Submit");
        btSubmit.setTranslateX(150);
        btSubmit.setPrefSize(150,50);
        btSubmit.setFont(Font.font("Times New Roman",(FontWeight)null,20));
        btSubmit.setOnAction(e  -> {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Confirmation Message");
            a.setHeaderText(null);
            a.setContentText("Are you sure to submit now?");
            Optional<ButtonType> option = a.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                String insertSurvey = "INSERT INTO `survey`(`userName`, `way`, `food_quality`, `order_accuracy`, " +
                        "`cleanliness`, `service_quality`, `experience`, `comment`, `date`) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
                connect2 = data.connectDB();
                try{
                    prepare2 = connect2.prepareStatement(insertSurvey);
                    String u;
                    if (userName1.getText().isEmpty()) {
                        u = userName2.getText();
                    } else {
                        u = userName1.getText();
                    }
                    prepare2.setString(1,u);
                    prepare2.setString(2,((RadioButton)toggle1.getSelectedToggle()).getText());
                    prepare2.setString(3,((RadioButton)toggle2.getSelectedToggle()).getText());
                    prepare2.setString(4,((RadioButton)toggle3.getSelectedToggle()).getText());
                    prepare2.setString(5,((RadioButton)toggle4.getSelectedToggle()).getText());
                    prepare2.setString(6,((RadioButton)toggle5.getSelectedToggle()).getText());
                    prepare2.setString(7,((RadioButton)toggle6.getSelectedToggle()).getText());
                    prepare2.setString(8,commentText.getText());
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare2.setString(9,String.valueOf(sqlDate));

                    prepare2.executeUpdate();

                    a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Information Message");
                    a.setHeaderText(null);
                    a.setContentText("Submit Successfully!");
                    a.showAndWait();

                    window.setScene(cusCartScene());
                }catch(Exception e1){e1.printStackTrace();}
            }
        });

        vb1.getChildren().addAll(reviewLabel,reviewText,sep3,hb1,vb2,vb3,vb4,vb5,vb6,vb7,btSubmit);

        cartPane2.getChildren().addAll(vb1);
        pane1in2.setContent(cartPane2);
        pane1.getChildren().addAll(cartLabel,sep1,cartPane,sep2,pane1in2);
        displayPane.getChildren().addAll(pane1);
        cusPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(cusPane, 1200, 700);
    }
    public VBox createQuestion(ToggleGroup toggle, String question){
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER_LEFT);

        Label questionLabel = new Label(question);
        questionLabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,12));

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setAlignment(Pos.CENTER_LEFT);

        RadioButton btExcellent = new RadioButton("Excellent");
        btExcellent.setToggleGroup(toggle);
        btExcellent.setSelected(true);

        RadioButton btGood = new RadioButton("Good");
        btGood.setToggleGroup(toggle);

        RadioButton btAvg = new RadioButton("Average");
        btAvg.setToggleGroup(toggle);

        RadioButton btDissatisfied = new RadioButton("Dissatisfied");
        btDissatisfied.setToggleGroup(toggle);

//        System.out.println(((RadioButton)toggle.getSelectedToggle()).getText());
        hbox.getChildren().addAll(btExcellent, btGood,btAvg,btDissatisfied);
        vbox.getChildren().addAll(questionLabel,hbox);
        return vbox;
    }
    private static ObservableList<Unit> cusOrderData;
    private static TableColumn<Unit,String> cusOrderNameCol = new TableColumn<>("Product Name");
    private static TableColumn<Unit, Integer> cusOrderQuantityCol = new TableColumn<>("Quantity");
    private static TableColumn<Unit,Double> cusOrderPriceCol = new TableColumn<>("Price($)");
    public static ObservableList<Unit> cusOrderDataList(){
        setCusOrderID();
        ObservableList<Unit> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `cus_order` WHERE `order_id`='"+orderID+"'";
        connect2 = data.connectDB();
        try{
            prepare2 = connect2.prepareStatement(sql);
            result2 = prepare2.executeQuery();
            Unit u1;
            while(result2.next()){
                u1 = new Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        result2.getInt("quantity"),
                        result2.getDouble("price"),
                        result2.getString("image"));
                listData.add(u1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static void cusOrderShowData(){
        cusOrderData = cusOrderDataList();

        cusOrderTable.setPrefSize(450,320);
        cusOrderTable.setStyle("-fx-background-color:transparent;-fx-border-color:linear-gradient(to bottom right,#2B3467,#7B8FA1)");
        cusOrderTable.getStylesheets().add("tableView_column.css");

        cusOrderNameCol.setMinWidth(224);
        cusOrderNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        cusOrderQuantityCol.setMinWidth(108);
        cusOrderQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        cusOrderPriceCol.setMinWidth(108);
        cusOrderPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        cusOrderTable.getColumns().clear();
        cusOrderTable.getColumns().addAll(cusOrderNameCol,cusOrderQuantityCol,cusOrderPriceCol);
        cusOrderTable.setItems(cusOrderData);
        cusOrderTable.setOnMouseClicked(e -> selectCusOrder());
    }
    public static void selectCusOrder() {
        Unit unit = cusOrderTable.getSelectionModel().getSelectedItem();
        int num = cusOrderTable.getSelectionModel().getSelectedIndex();
        if((num-1)<-1) return;
        data.id = Integer.parseInt(unit.getId());
        data.inventory_name = unit.getName();
        data.inventory_stock = unit.getQuantity();
        data.inventory_price = unit.getPrice();
    }
    public static void calculateTotalCus(){
        setCusOrderID();
        String checkTotal = "SELECT SUM(price) FROM `cus_order` WHERE order_id ='" +orderID+"'";
        connect2 = data.connectDB();
        try{
            prepare2 = connect2.prepareStatement(checkTotal);
            result2 = prepare2.executeQuery();

            if(result2.next()){
                totalPriceOfOrder2 =result2.getDouble("SUM(price)");
                total2.setText("$"+ df.format(totalPriceOfOrder2));
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
    private ComboBox<String> addPayment2 = new ComboBox<>();
    private static Label total2 = new Label("$0.0");
    private TextField addAmount2 = new TextField();
    private Label charge2 = new Label("$0.0");
    private static double totalPriceOfOrder2;
    private double amount2;
    private double change2;
    public void calculateCusCharge(){
        calculateTotalCus();
        if(!addAmount2.getText().isEmpty()){
            amount2 = Double.parseDouble(addAmount2.getText().replace("$",""));
        }
        if (amount2 < (Math.round(totalPriceOfOrder2*100)/100)) {
            addAmount2.setText("$ 0.0");
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please enter the amount paid!");
            a.showAndWait();
        } else {
            change2 = (Math.round(amount2*100)/100) - (Math.round(totalPriceOfOrder2*100)/100);
            charge2.setText("$" + String.format("%.2f",change2));
        }
    }
    public void getPaymentMethodCus() {
        calculateTotalCus();
        if(addPayment2.getSelectionModel().getSelectedItem().isEmpty()){
            Alert alert = createAlertWithOptOut(Alert.AlertType.ERROR, "Error Message", null,
                    "Please select a payment method", ButtonType.OK);
            alert.showAndWait();
        }else if(addPayment2.getSelectionModel().getSelectedItem().equals("Cash")) {
            addAmount2.clear();
        }else{
            amount2 = totalPriceOfOrder2;
            addAmount2.setText("$"+df.format(amount2));
        }
        calculateCusCharge();
    }
    public void payCusOrder(){
        if(totalPriceOfOrder2 == 0){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please choose your order first!");
            a.showAndWait();
        }else if( addPayment2.getSelectionModel().getSelectedItem() == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Invalid !_! Please select the payment method!");
            a.showAndWait();

        }else {
            calculateTotalCus();
            calculateCusCharge();
            if(amount2 >= (Math.round(totalPriceOfOrder2*100)/100)) {
                String insertReceipt = "INSERT INTO `cus_receipt`(`receipt_id`,`order_id`,`userName`,`total`,`paymentMethod`,`date`) " +
                        "VALUES (?,?,?,?,?,?)";
                connect2 = data.connectDB();
                try {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setTitle("Confirmation Message");
                    a.setHeaderText(null);
                    a.setContentText("Are you sure to pay now?");
                    Optional<ButtonType> option = a.showAndWait();
                    if (option.get().equals(ButtonType.OK)) {
                        setCusOrderID();
                        prepare2 = connect2.prepareStatement(insertReceipt);
                        prepare2.setString(1,String.valueOf(orderID));
                        prepare2.setString(2,String.valueOf(orderID));
                        String u;
                        if (userName1.getText().isEmpty()) {
                            u = userName2.getText();
                        } else {
                            u = userName1.getText();
                        }
                        prepare2.setString(3,u);
                        prepare2.setDouble(4,totalPriceOfOrder2);
                        prepare2.setString(5,addPayment2.getSelectionModel().getSelectedItem());

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare2.setString(6,String.valueOf(sqlDate));

                        prepare2.executeUpdate();

//                        Alert alert = createAlertWithOptOut(Alert.AlertType.CONFIRMATION, "Payment successful", null,
//                                "Do you need Receipt?", ButtonType.YES, ButtonType.NO);
//                        Optional<ButtonType> option2 = alert.showAndWait();
//                        if (option2.get().equals(ButtonType.YES)) {
//                            receiptOfCusOrder();
//                            Thread.sleep(5000);
                        cusOrderShowData();
                        orderClearFields2();
//                        }
//                        if (option2.get().equals(ButtonType.NO)){
//                            cusOrderShowData();
//                            orderClearFields();
//                          }
                    } else {
                        a = new Alert(Alert.AlertType.INFORMATION);
                        a.setTitle("Information Message");
                        a.setHeaderText(null);
                        a.setContentText("Payment Cancelled!");
                        a.showAndWait();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void removeCusOrder(){
        if(data.id == null ){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please select the order you want to remove!");
            a.showAndWait();
        }else{
            String deleteOrder = "DELETE FROM `cus_order` WHERE id = '"+ data.id+"'";
            connect2 =data.connectDB();
            try{
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Confirmation Message");
                a.setHeaderText(null);
                a.setContentText("Are you sure you want to delete this order?");
                Optional<ButtonType> option = a.showAndWait();
                if(option.get().equals(ButtonType.OK)){
                    prepare2 = connect2.prepareStatement(deleteOrder);
                    prepare2.executeUpdate();

                    String checkID ="";
                    int checkStock = 0;
                    String checkType="";
                    String checkStatus="";
                    double checkPrice =0;
                    String checkStockInSQL ="SELECT id,stock,type,status,price FROM inventory WHERE name = '" +data.inventory_name+"'";
                    Connection connect = data.connectDB();
                    try {
                        Statement statement = connect.createStatement();
                        ResultSet result = statement.executeQuery(checkStockInSQL);
                        if (result.next()) {
                            checkID =result.getString("id");
                            checkStock = result.getInt("stock");
                            checkType = result.getString("type");
                            checkStatus =result.getString("status");
                            checkPrice =result.getDouble("price");
                        }
                    } catch (Exception e){e.printStackTrace();}

                    int updatedStock = checkStock +data.inventory_stock;
                        try {
                            String sqlUpdateStock = "UPDATE inventory SET stock='" + updatedStock + "'," +
                                    "name ='" +data.inventory_name + "'," +
                                    "type='" + checkType + "'," +
                                    "price='" + checkPrice+ "'," +
                                    "status='" + checkStatus + "' WHERE id ='"+ checkID+"'";
                            prepare2 = connect2.prepareStatement(sqlUpdateStock);
                            prepare2.executeUpdate();

                        }catch(Exception e){e.printStackTrace();}
                }
                cusOrderShowData();
                calculateTotalCus();
            }catch(Exception e){ e.printStackTrace();}
        }
    }
    public void receiptOfCusOrder(){
//        if(totalPriceOfOrder ==0 || addAmount.getText().isEmpty() ||addPayment.getSelectionModel().getSelectedItem().isEmpty()){
        if(totalPriceOfOrder2 ==0){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Message");
            a.setHeaderText(null);
            a.setContentText("Please order first");
            a.showAndWait();
        }else{
            setCusOrderID();
            var receiptPane = new Pane();
            receiptPane.setMinSize(500,600);

            var vbox = new VBox(10);
            vbox.setMinSize(480,580);
            vbox.setSpacing(10);

            var labelPane = new HBox(10);
            labelPane.setSpacing(10);
            labelPane.setAlignment(Pos.CENTER);

            Label n = new Label("Shuao's Cakehouse");
            n.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD,30));
            n.setAlignment(Pos.CENTER);

            ImageView i = new ImageView("receiptCakeIcon.png");
            i.setPreserveRatio(true);
            i.setFitWidth(55);
            i.setFitHeight(55);

            labelPane.getChildren().addAll(i,n);

            vbox.getChildren().add(labelPane);

            var labelDatePane = new AnchorPane();
            labelDatePane.setMinWidth(480);

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("EE yyyy-MM-dd HH:mm:ss");
            Label dateLabel = new Label(formatter.format(date));
            dateLabel.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            dateLabel.setAlignment(Pos.CENTER);
            dateLabel.setTranslateX(170);

            labelDatePane.getChildren().add(dateLabel);

            var labelReceiptIDPane = new AnchorPane();
            labelReceiptIDPane.setMinWidth(480);

            Label receiptIDLabel= new Label("Receipt for Order "+orderID);
            receiptIDLabel.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD,30));
            receiptIDLabel.setAlignment(Pos.CENTER);
            receiptIDLabel.setTranslateX(100);

            labelReceiptIDPane.getChildren().add(receiptIDLabel);

            var userNameLabel = new Label();
            if(userName1.getText().isEmpty()){userNameLabel.setText("Username: "+userName2.getText());
            }else{ userNameLabel.setText("Username: "+userName1.getText());}
            userNameLabel.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            userNameLabel.setAlignment(Pos.CENTER);
            userNameLabel.setTranslateX(205);

            var sep1 = new Separator();
            sep1.setPrefSize(50,2);

            var labelOrderPane = new AnchorPane();
            labelOrderPane.setMinWidth(480);

            HBox hbox = new HBox(10);
            hbox.setSpacing(10);
            hbox.setPadding(new Insets(10,0,0,10));

            Label n2 = new Label("Product Name");
            n2.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            n2.setTranslateX(10);

            Label s = new Label("Quantity");
            s.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            s.setTranslateX(160);

            Label p = new Label("Price");
            p.setFont(Font.font("Times New Roman" , FontWeight.BOLD,15));
            p.setTranslateX(232);

            hbox.getChildren().addAll(n2,s,p);

            labelOrderPane.getChildren().add(hbox);

            cusOrderData = cusOrderDataList();
            GridPane displayReceiptPane = new GridPane();
            displayReceiptPane.getRowConstraints().clear();
            displayReceiptPane.getColumnConstraints().clear();
            displayReceiptPane.setHgap(10);
            displayReceiptPane.setVgap(10);

            int row =0;
            for (Unit orderInReceipt : cusOrderData) {
                displayReceiptPane.add(orderInReceipt.receiptOrderPane(), 1, row);
                row++;
            }
            vbox.getChildren().addAll(labelReceiptIDPane,userNameLabel,labelDatePane,sep1,labelOrderPane,displayReceiptPane);

            var sep2 = new Separator();
            sep2.setPrefSize(50,2);

            VBox vbox3 = new VBox(10);
            vbox3.setSpacing(10);
            vbox3.setPadding(new Insets(10,0,0,10));
            vbox3.setAlignment(Pos.CENTER);

            HBox priceHbox = new HBox(10);
            priceHbox.setSpacing(10);
            priceHbox.setPadding(new Insets(10,0,0,10));

            var totalPriceLabel = new Label("Total: ");
            totalPriceLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            totalPriceLabel.setTranslateX(280);

            var totalPriceLabel2 = new Label(String.valueOf(df.format(totalPriceOfOrder2)));
            totalPriceLabel2.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            totalPriceLabel2.setTranslateX(350);
            totalPriceLabel2.setAlignment(Pos.CENTER_RIGHT);

            priceHbox.getChildren().addAll(totalPriceLabel,totalPriceLabel2);

            HBox chargeHbox = new HBox(10);
            chargeHbox.setSpacing(10);
            chargeHbox.setPadding(new Insets(10,0,0,10));

            var chargeLabel = new Label("Charge: ");
            chargeLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            chargeLabel.setTranslateX(270);

            var chargeLabel2 = new Label();
            if(change2 == 0){
                chargeLabel2 = new Label("0.00");
            }else{
                chargeLabel2 = new Label(df.format(Double.parseDouble(charge.getText().replace("$",""))));
            }
            chargeLabel2.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            chargeLabel2.setTranslateX(345);

            chargeHbox.getChildren().addAll(chargeLabel,chargeLabel2);

            HBox paymentHbox = new HBox(10);
            paymentHbox.setSpacing(10);
            paymentHbox.setPadding(new Insets(10,0,0,10));

            var paymentLabel = new Label("Payment: ");
            paymentLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            paymentLabel.setTranslateX(260);

            var paymentLabel2 = new Label();
            if(addPayment2.getSelectionModel().getSelectedItem()== null){
                paymentLabel2 = new Label("--------");
            }else{
                paymentLabel2 = new Label(addPayment2.getSelectionModel().getSelectedItem());
            }
            paymentLabel2.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            paymentLabel2.setTranslateX(330);

            paymentHbox.getChildren().addAll(paymentLabel,paymentLabel2);

            vbox3.getChildren().addAll(priceHbox,chargeHbox,paymentHbox);

            vbox.getChildren().addAll(sep2,vbox3);

            var sep3 = new Separator();
            sep3.setPrefSize(50,2);

            VBox vbox2 = new VBox(10);
            vbox2.setSpacing(10);
            vbox2.setPadding(new Insets(10,0,0,10));
            vbox2.setAlignment(Pos.CENTER);

            var thankLabel = new Label("Thank you for choosing our products!");
            thankLabel.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD,20));

            var phoneLabel = new Label("Phone Number: +60197189247");
            phoneLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));

            var addressLabel = new Label("10 Street N/P 10, Malaysia");
            addressLabel.setFont(Font.font("Times New Roman" , (FontWeight)null,15));
            vbox2.getChildren().addAll(thankLabel,phoneLabel,addressLabel);

            vbox.getChildren().addAll(sep3,vbox2);

            receiptPane.getChildren().addAll(vbox);

            var scene = new Scene(receiptPane,500,700);
            Stage receiptStage = new Stage();
            receiptStage.setScene(scene);
            receiptStage.setResizable(false);
            receiptStage.setTitle("Receipt for Order "+orderID);
            receiptStage.show();
        }
    }
    private Scene cusOrderHistoryScene(){
        var cusPane = new AnchorPane();
        cusPane.setPrefSize(1200, 700);

        var menuPane = new GridPane();//set prefsize and color and design
        cusMenuBar(menuPane);

        var displayPane = new AnchorPane();
        displayPane.setStyle("-fx-background-color:#ffffff");
        displayPane.setPrefSize(1200,700);
        displayPane.setTranslateX(230);

        var pane1 = new AnchorPane();
        pane1.setPrefSize(950,680);
        pane1.setStyle("-fx-background-color: #fff; -fx-background-radius:8px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5),5,0,0,0);");
        pane1.setTranslateX(10);
        pane1.setTranslateY(10);

        var orderHistoryLabel = new Label("Order History");
        orderHistoryLabel.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,30));
        orderHistoryLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        orderHistoryLabel.setAlignment(Pos.TOP_CENTER);
        orderHistoryLabel.setTranslateX(400);

        var sep1 = new Separator();
        sep1.setPrefSize(930,1);
        sep1.setTranslateY(50);
        sep1.setTranslateX(10);

        var orderHistoryLabel2 = new Label("Please the order history you want to have a look");
        orderHistoryLabel2.setFont(Font.font("Lucida Calligraphy",(FontWeight)null,18));
//        orderHistoryLabel.setStyle("-fx-text-fill:linear-gradient(to bottom right,#2B3467,#7B8FA1);");
        orderHistoryLabel2.setAlignment(Pos.TOP_CENTER);
        orderHistoryLabel2.setTranslateX(280);
        orderHistoryLabel2.setTranslateY(60);

        cusReceiptShowData();
        cusPersonalOrderShowData();

        pane1.getChildren().addAll(orderHistoryLabel,sep1,orderHistoryLabel2,personalOrderTable,cusPersonalOrderTable);
        displayPane.getChildren().addAll(pane1);
        cusPane.getChildren().addAll(menuPane,displayPane);

        return new Scene(cusPane, 1200, 700);
    }
    public ObservableList<Receipt> cusReceiptDataList(){
        connect2 = data.connectDB();
        ObservableList<Receipt> listData = FXCollections.observableArrayList();
        String u;
        if (userName1.getText().isEmpty()) {
            u = userName2.getText();
        } else {
            u = userName1.getText();
        }
        String sql2 = "SELECT * FROM `cus_receipt` WHERE userName = '"+u+"'";
        try{
            prepare2 = connect2.prepareStatement(sql2);
            result2 = prepare2.executeQuery();
            Receipt r1;
            while(result2.next()){
                r1 = new Receipt(result2.getInt("order_id"),
                        result2.getString("userName"),
                        result2.getDouble("total"),
                        result2.getString("paymentMethod"),
                        result2.getDate("date"));
                listData.add(r1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    private TableView<Receipt> personalOrderTable = new TableView<>();
    private TableColumn<Receipt,Integer> personalOrder_idCol = new TableColumn<>("Receipt ID");
    private TableColumn<Receipt,String> personalOrder_paymentCol = new TableColumn<>("Paymemt");
    private TableColumn<Receipt,Date> personalOrder_dateCol = new TableColumn<>("Date");
    private TableColumn<Receipt,Double> personalOrder_totalCol = new TableColumn<>("Total($)");
    public void cusReceiptShowData(){
        receiptData = cusReceiptDataList();

        personalOrderTable.setPrefSize(500,570);
        personalOrderTable.setTranslateX(10);
        personalOrderTable.setTranslateY(90);
        personalOrderTable.getStylesheets().add("tableView_column.css");

        personalOrder_idCol.setMinWidth(120);
        personalOrder_idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        personalOrder_totalCol.setMinWidth(120);
        personalOrder_totalCol.setCellValueFactory(new PropertyValueFactory<>("totalprice"));

        personalOrder_paymentCol.setMinWidth(150);
        personalOrder_paymentCol.setCellValueFactory(new PropertyValueFactory<>("payment"));

        personalOrder_dateCol.setMinWidth(120);
        personalOrder_dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        personalOrderTable.getColumns().clear();
        personalOrderTable.getColumns().addAll(personalOrder_idCol,personalOrder_totalCol,personalOrder_paymentCol,personalOrder_dateCol);
        personalOrderTable.setItems(receiptData);
        personalOrderTable.setOnMouseClicked(e -> selectOrderHistory());
    }
    public void selectOrderHistory() {
        Receipt receipt = personalOrderTable.getSelectionModel().getSelectedItem();
        int num = personalOrderTable.getSelectionModel().getSelectedIndex();
        if((num-1)<-1) return;
        data.id = receipt.getId();
        cusPersonalOrderShowData();
    }
    private ObservableList<Unit> cusPersonalOrderData;
    private TableView<Unit> cusPersonalOrderTable = new TableView<>();
    private TableColumn<Receipt,String> cusPersonalOrderTable_nameCol = new TableColumn<>("Name");
    private TableColumn<Receipt,Integer> cusPersonalOrderTable_quantityCol = new TableColumn<>("Quantity");
    private TableColumn<Receipt,Double> cusPersonalOrderTable_priceCol = new TableColumn<>("Price($)");
    public void cusPersonalOrderShowData(){
        cusPersonalOrderData = personalOrderDataList();

        cusPersonalOrderTable.setPrefSize(420,570);
        cusPersonalOrderTable.setTranslateX(520);
        cusPersonalOrderTable.setTranslateY(90);
        cusPersonalOrderTable.getStylesheets().add("tableView_column.css");

        cusPersonalOrderTable_nameCol.setMinWidth(160);
        cusPersonalOrderTable_nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        cusPersonalOrderTable_quantityCol.setMinWidth(100);
        cusPersonalOrderTable_quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        cusPersonalOrderTable_priceCol.setMinWidth(100);
        cusPersonalOrderTable_priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        cusPersonalOrderTable.getColumns().clear();
        cusPersonalOrderTable.getColumns().addAll(cusOrderNameCol,cusOrderQuantityCol,cusOrderPriceCol);
        cusPersonalOrderTable.setItems(cusPersonalOrderData);

    }
    public ObservableList<Unit> personalOrderDataList(){
        ObservableList<Unit> listData = FXCollections.observableArrayList();
        if(data.id != null ){
//            Alert a = new Alert(Alert.AlertType.ERROR);
//            a.setTitle("Error Message");
//            a.setHeaderText(null);
//            a.setContentText("Please select an order history!");
//            a.showAndWait();
//        } else {
            String sql = "SELECT * FROM `cus_order` WHERE `order_id`='" + data.id + "'";
            connect2 = data.connectDB();
            try {
                prepare2 = connect2.prepareStatement(sql);
                result2 = prepare2.executeQuery();
                Unit u1;
                while (result2.next()) {
                    u1 = new Unit(result2.getString("id"),
                            result2.getString("name"),
                            result2.getString("type"),
                            result2.getInt("quantity"),
                            result2.getDouble("price"),
                            result2.getString("image"));
                    listData.add(u1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listData;
    }

}
class Unit {
    private String id;
    private String name;
    private String user;
    private String type;
    private Integer stock;
    private Double price;
    private String status;
    private Date date;
    private String image;

    //inventory Data<Unit>
    public Unit(String i, String n, String t, Integer s, Double p, String st, String image, Date d) {
        id = i;
        name = n;
        type = t;
        stock = s;
        price = p;
        status = st;
        date = d;
        this.image = image;
    }

    private Integer quantity;

    //productDisplay<Unit>
    public Unit(String i, String n, String t, Integer q, Double p, String image) {
        id = i;
        name = n;
        type = t;
        price = p;
        quantity = q;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public String getImage() {
        return this.image;
    }

    private Spinner<Integer> addQuantity;
    private SpinnerValueFactory<Integer> spin;
    private int qty;
}
class Receipt{
    private int id;
    private String username;
    private double totalprice;
    private String payment;
    private Date date;
    public Receipt(){ }
    public Receipt(int i, String n, double t, String p, Date d){
        id =i; username = n; totalprice =t; payment =p; date =d;
    }
    public int getId(){return id;}
    public String getUsername(){return username;}
    public double getTotalprice(){return totalprice;}
    public String getPayment(){return payment; }
    public Date getDate(){return date;}
}
class Survey{
    private int id;
    private String username;
    private String way;
    private String food_quality;
    private String order_accuracy;
    private String cleanliness;
    private String service_quality;
    private String experience;
    private String comment;
    private Date date;
    public Survey(){ }
    public Survey(int i, String n, String w,String f, String o,String c, String s, String e,String com,Date d){
        id =i; username = n; way= w;food_quality =f;
        order_accuracy = o;service_quality=s;cleanliness =c;
        experience = e; comment= com; date =d;
    }
    public int getId(){return id;}
    public String getUsername(){return username;}
    public String getWay(){return way;}
    public String getFood_quality(){return food_quality;}
    public String getOrder_accuracy(){return order_accuracy;}
    public String getService_quality(){return service_quality;}
    public String getCleanliness(){ return  cleanliness;}
    public String getExperience(){return experience;}
    public String getComment(){return comment;}
    public Date getDate(){return date;}
}

