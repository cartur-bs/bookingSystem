package entities;

import dbProperties.DB;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PassengerDependant {
    String depName;
    LocalDate depBirthDate;
    String depCpf;
    LocalDateTime departTime;
    String responsibleName;
    LocalDate responsibleBirthdate;
    String responsibleEmail;
    String responsibleCpf;

    public PassengerDependant(String DepName, LocalDate DepBirthDate, String DepCpf, LocalDateTime departTime, String responsibleName, String responsibleEmail, String responsibleCpf, LocalDate responsibleBirthdate) {
        this.depName = DepName;
        this.depBirthDate = DepBirthDate;
        this.depCpf = DepCpf;
        this.departTime = departTime;
        this.responsibleName = responsibleName;
        this.responsibleBirthdate = responsibleBirthdate;
        this.responsibleEmail =  responsibleEmail;
        this.responsibleCpf = responsibleCpf;
    }

    public void createDependant() throws SQLException {
        String dependantStatement = "INSERT INTO passengerDependant(depName, depBDate, depCPF,departureTime, responsibleName, responsibleEmail,responsibleCPF, responsibleBDate) VALUES(?,?,?,?,?,?,?,?)";
        Date sqlDepBDate = Date.valueOf(depBirthDate);
        Date sqlResponsibleBDate = Date.valueOf(responsibleBirthdate);
        Timestamp sqlDepartDate = Timestamp.valueOf(departTime);
        try(PreparedStatement ps = DB.getConnection().prepareStatement(dependantStatement)){
        ps.setString(1, depName);
        ps.setDate(2,  sqlDepBDate);
        ps.setString(3, depCpf);
        ps.setTimestamp(4, sqlDepartDate);
        ps.setString(5, responsibleName);
        ps.setString(6,responsibleEmail);
        ps.setString(7, responsibleCpf);
        ps.setDate(8,sqlResponsibleBDate);

        ps.executeUpdate();}
        catch (SQLException e){
            throw new SQLException();
        }
    }

    @Override
    public String toString() {
        return "Dependant Name= " + depName + " | " +
                "Dependant Birth Date= " + depBirthDate + " | " +
                " Dependant Cpf= " + depCpf +" | " ;
    }
}
