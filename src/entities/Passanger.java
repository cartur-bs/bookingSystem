package entities;

import java.sql.SQLException;

public class Passanger {
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

    public Passanger(String name, String birthDate, String cpf,String email, String destination) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
        this.email = email;
    }

    public Passanger(String name, String birthDate, String cpf, String destination, PassangerDependant passangerDependant) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
        //PassangerDependant newDependant = new PassangerDependant( DepName,  DepBirthDate,  DepCpf,  destination,  this.getName(),  this.getCpf(),  this.getBirthDate());
    }

     public void createPerson() throws SQLException{
         System.out.println("creating person");
    }


    public void consultPerson() throws SQLException{
        System.out.println("creating person");
    }

}
