package entities;

import java.sql.SQLException;

public class Passanger {
    String name;
    int birthDate;
    String cpf;
    String destination;
    PassangerDependant newDependant;

    public String getName(){
        return this.name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public String getDestination() {
        return destination;
    }

    public Passanger(String name, int birthDate, String cpf, String destination) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
    }

    public Passanger(String name, int birthDate, String cpf, String destination, PassangerDependant passangerDependant) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
        this.newDependant = passangerDependant;
    }

     public void createPerson() throws SQLException{
         System.out.println("creating person");
    }


    public void consultPerson() throws SQLException{
        System.out.println("creating person");
    }

}
