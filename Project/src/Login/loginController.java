package Login;

import admin.adminController;
import javafx.event.ActionEvent;
import students.StudentsController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    LoginModel loginModel= new LoginModel();


    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private TextField Password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;


    public void initialize (URL url, ResourceBundle rb){
        if(this.loginModel.isDatabaseConnected()){
            this.dbstatus.setText("Connected");

        }
        else{
            this.dbstatus.setText("Not Connected To Database");
        }
        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }
    @FXML
    public void Login (ActionEvent event){
        try{
            if (this.loginModel.isLogin(this.username.getText(),this.Password.getText(),(this.combobox.getValue()).toString())){
                Stage stage =(Stage)this.loginButton.getScene().getWindow();
                stage.close();
                switch (((option)this.combobox.getValue()).toString()){
                    case "Admin":
                        adminLogin();
                        break;
                    case "Student":

                        StudentLogin();
                        break;
                }

            }
            else {
                this.loginStatus.setText("Wrong Creditials");
            }
        }catch (Exception localException){

        }
    }




    public void StudentLogin(){
        try{
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root= (Pane)loader.load(getClass().getResource("/students/studentFXML.fxml").openStream());
            StudentsController studentController = (StudentsController) loader.getController();
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Student Dashboard");
            userStage.setResizable(false);
            userStage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void adminLogin(){
        try{
            Stage adminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane adminRoot= (Pane)adminLoader.load(getClass().getResource("/admin/adminFXML.fxml").openStream());

            adminController adminControllerr =(adminController)adminLoader.getController();
            Scene scene = new Scene(adminRoot);
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dashboard");
            adminStage.setResizable(false);
            adminStage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}