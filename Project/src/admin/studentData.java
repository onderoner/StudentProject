package admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentData {
    private final IntegerProperty studentID;
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty city;
    private final IntegerProperty yearOnClass;
    private final StringProperty langueges;
    private final StringProperty lecture;
    private final StringProperty AGE;

    public studentData(Integer id,String firstname,String lastname,String city,Integer yearOnClass,String langueges,String lecture,String dob){
        this.studentID =new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(firstname);
        this.surname=new SimpleStringProperty(lastname);
        this.city=new SimpleStringProperty(city);
        this.yearOnClass=new SimpleIntegerProperty(yearOnClass);
        this.langueges=new SimpleStringProperty(langueges);
        this.lecture=new SimpleStringProperty(lecture);
        this.AGE=new SimpleStringProperty(dob);
    }

    public int getStudentID() {
        return studentID.get();
    }

    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID.set(Integer.parseInt(studentID));
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public int getYearOnClass() {
        return yearOnClass.get();
    }

    public IntegerProperty yearOnClassProperty() {
        return yearOnClass;
    }

    public void setYearOnClass(String yearOnClass) {
        this.yearOnClass.set(Integer.parseInt(yearOnClass));
    }

    public String getLangueges() {
        return langueges.get();
    }

    public StringProperty languegesProperty() {
        return langueges;
    }

    public void setLangueges(String langueges) {
        this.langueges.set(langueges);
    }

    public String getLecture() {
        return lecture.get();
    }

    public StringProperty lectureProperty() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture.set(lecture);
    }

    public String getAGE() {
        return AGE.get();
    }

    public StringProperty AGEProperty() {
        return AGE;
    }

    public void setAGE(String AGE) {
        this.AGE.set(AGE);
    }


}
