package entities;

import dbProperties.DB;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Passenger {
    String name;
    LocalDate birthDate;
    String cpf;
    String email;
    String destination;
    LocalDateTime departDate;
    char isThereDependant;
    Connection con = DB.getConnection();

    public Passenger() throws SQLException {
    }

    public Passenger(String name, LocalDate bDateFormated, String cpf, String email, String destination, LocalDateTime departDate, char isThereDependant) throws SQLException {
        this.name = name;
        this.birthDate = bDateFormated;
        this.cpf = cpf;
        this.email = email;
        this.destination = destination;
        this.departDate = departDate;
        this.isThereDependant=isThereDependant;
    }

    //sending the data to database
     public void createPerson() throws SQLException{
         String passengerStatement = "INSERT INTO passenger(name, bDate, CPF , email, destination, departDate, dependant ) VALUES (?,?,?,?,?,?,?)";
         Date sqlBDate = Date.valueOf(birthDate);
         Timestamp sqlDepartureTimestamp = Timestamp.valueOf(departDate);
         try{
         PreparedStatement ps = con.prepareStatement(passengerStatement);
         ps.setString(1, name);
         ps.setDate(2,  sqlBDate);
         ps.setString(3, cpf);
         ps.setString(4, email);
         ps.setString(5,destination);
         ps.setTimestamp(6, sqlDepartureTimestamp);
         ps.setString(7, String.valueOf(isThereDependant));
         ps.executeUpdate();
     }catch(SQLException e){
            throw new SQLException(e);
    }}

    //consulting data from database
    public void consultPerson(String cpf) throws SQLException{
        String passengerStatement = "SELECT name, CPF, destination, dependant FROM passenger WHERE CPF =  '"+ cpf  + "';" ;
        String depStatement = "SELECT depName, depBDate, depCPF FROM passengerDependant WHERE responsibleCPF = '"+ cpf  + "'; ";
        Statement st = con.createStatement();
        ResultSet rst;

        try{
            rst = st.executeQuery(passengerStatement);
            while(rst.next()){
               System.out.println(rst.getString("name") + " | CPF: " + rst.getString("CPF") +" | Destination: "
                       + rst.getString("destination") + " | Dependant: " + rst.getString("dependant"));
           }
            //consults dependant data
                rst = st.executeQuery(depStatement);
                while(rst.next()){
                    System.out.println("Dependant's information: ");
                    System.out.println(rst.getString("depName") + " | Birth date:  " + rst.getString("depBDate") +" | CPF: "
                            + rst.getString("depCPF"));
                }
           st.close();
           rst.close();
        }catch(SQLException e){
            throw new SQLException();
        }
    }

    @Override
    public String toString() {
        return "Name= " + name + " | " +
                "cpf= " + cpf + " | " +
                "email =" + email + " | " +
                "Destination =" + destination + " | " +
                "Departure Date =" + departDate;
    }
}
