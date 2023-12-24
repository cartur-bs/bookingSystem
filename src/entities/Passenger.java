package entities;

import dbProperties.DB;

import java.sql.*;

public class Passenger {
    String name;
    String birthDate;
    String cpf;
    String email;
    String destination;
    char isThereDependant;
    Connection con = DB.getConnection();

    //creating a new object without dependant

    public Passenger() throws SQLException {
    }

    public Passenger(String name, String birthDate, String cpf, String email, String destination, char isThereDependant) throws SQLException {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
        this.email = email;
        this.isThereDependant=isThereDependant;
    }

    //sending the data to database
     public void createPerson() throws SQLException{
         String passengerStatement = "INSERT INTO passangerWithNoDependant(name, bDate, CPF , email, destination, dependant ) VALUES (?,?,?,?,?,?)";
         try{
         PreparedStatement ps = con.prepareStatement(passengerStatement);
         ps.setString(1, name);
         ps.setString(2,  birthDate);
         ps.setString(3, cpf);
         ps.setString(4, email);
         ps.setString(5,destination);
         ps.setString(6, String.valueOf(isThereDependant));
         ps.executeUpdate();
     }catch(SQLException e){
            throw new SQLException(e);
    }
    }

    //consulting data from database
    public void consultPerson(String cpf) throws SQLException{
        String passengerStatement = "SELECT name, CPF, destination, dependant FROM passangerWithNoDependant WHERE CPF = " + "'"+ cpf  +"'" +  ";";
        try{
            Statement st = con.createStatement();
            ResultSet rst = st.executeQuery(passengerStatement);

            while(rst.next()){
                String dbName = rst.getString("name");
                String dbCPF = rst.getString("CPF");
                String dbDestination = rst.getString("destination");
                String dbDependant = rst.getString("dependant");
              // System.out.println(rst.getString("name: " +  )+", CPF: " + 3 + ", destination: " + 5 + "dependant" + 6);

               System.out.println(rst.getString("name") + " | " + rst.getString("CPF") +" | "
                       + rst.getString("destination") + " | " + rst.getString("dependant"));
           }
           st.close();
           rst.close();
        }catch(SQLException e){
            throw new SQLException();
        }
    }

}
