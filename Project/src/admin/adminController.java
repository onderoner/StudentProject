package admin;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField city;
    @FXML
    private TextField yearOnClass;
    @FXML
    private TextField langueges;
    @FXML
    private TextField lecture;
    @FXML
    private DatePicker dob;

    @FXML
    private TableView<studentData> studenttable;
    @FXML
    private TableColumn<studentData,Integer> idcolumn;
    @FXML
    private TableColumn<studentData,String> firstnamecolumn;
    @FXML
    private TableColumn<studentData,String> lastnamecolumn;
    @FXML
    private TableColumn<studentData,String> citycolumn;
    @FXML
    private TableColumn<studentData,Integer> yearOnClasscolumn;
    @FXML
    private TableColumn<studentData,String> languegescolumn;
    @FXML
    private TableColumn<studentData,String> lecturecolumn;
    @FXML
    private TableColumn<studentData,String> dobcolumn;


    private ConnectionClass dc;
    private ObservableList<studentData> data;
    private String sql="SELECT * FROM info";

    public void initialize(URL url, ResourceBundle rb){
        this.dc=new ConnectionClass();

    }
    @FXML
    private void loadStudentData(ActionEvent event)throws SQLException{
        try{
            Connection conn=ConnectionClass.getConnection();
            this.data= FXCollections.observableArrayList();

            ResultSet rs= conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new studentData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }

        }catch (SQLException e){
            System.err.println("eror"+e);
        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<studentData,Integer>("studentID"));
        this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>("name"));
        this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>("surname"));
        this.citycolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>("city"));
        this.yearOnClasscolumn.setCellValueFactory(new PropertyValueFactory<studentData,Integer>("yearOnClass"));
        this.languegescolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>("langueges"));
        this.lecturecolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>("lecture"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>("age"));

        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }
    @FXML
    private void addStudent(ActionEvent event){
        String sqlInsert = "INSERT INTO info(studentID,name,surname,city,yearOnClass,langueges,lecture,age)VALUES(?,?,?,?,?,?,?,?)";

        try{
            Connection conn = ConnectionClass.getConnection();
            PreparedStatement stnt=conn.prepareStatement(sqlInsert);
            stnt.setInt(1, Integer.parseInt(this.id.getText()));
            stnt.setString(2,this.firstname.getText());
            stnt.setString(3,this.lastname.getText());
            stnt.setString(4,this.city.getText());
            stnt.setInt(5,Integer.parseInt(this.yearOnClass.getText()));
            stnt.setString(6,this.langueges.getText());
            stnt.setString(7,this.lecture.getText());
            stnt.setString(8,this.dob.getValue().toString());

            stnt.execute();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void clearField(ActionEvent event){
        this.id.setText("");
        this.firstname.setText("");
        this.lastname.setText("");
        this.city.setText("");
        this.yearOnClass.setText("");
        this.langueges.setText("");
        this.lecture.setText("");
        this.dob.setValue(null);

    }

}
