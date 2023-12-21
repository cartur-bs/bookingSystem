package entities;

import java.sql.SQLException;

public class Passenger {
    String name;
    String birthDate;
    String cpf;
    String email;
    String destination;
    String DepName;
    String DepCpf;
    String DepBirthDate;

    public String getName(){
        return this.name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDestination() {
        return destination;
    }

    public String getCpf() {
        return cpf;
    }

    //creating a new object without dependant
    public Passenger(String name, String birthDate, String cpf,String email, String destination) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
        this.email = email;
    }

    //creating a new object with dependant
    public Passenger(String name, String birthDate, String cpf, String destination, PassengerDependant passangerDependant) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
    }
    //sending the data to database
     public void createPerson() throws SQLException{
         System.out.println("creating person");
    }

    //consulting data from database
    public void consultPerson() throws SQLException{
        System.out.println("creating person");
    }

}
