package entities;

import dbProperties.DB;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerDependant {
    PreparedStatement ps = null;
    String dependantStatement = "INSERT INTO passengerDependant(depName, depBDate, depCPF,responsibleName, responsibleEmail,responsibleCPF, responsibleBDate) VALUES(?,?,?,?,?,?,?)";

    String depName;
    String depBirthDate;
    String depCpf;
    String responsibleName;
    String responsibleBirthdate;
    String responsibleEmail;
    String responsibleCpf;

    public PassengerDependant(String DepName, String DepBirthDate,  String DepCpf, String responsibleName, String responsibleEmail, String responsibleCpf,String responsibleBirthdate) {
        this.depName = DepName;
        this.depBirthDate = DepBirthDate;
        this.depCpf = DepCpf;
        this.responsibleName = responsibleName;
        this.responsibleBirthdate = responsibleBirthdate;
        this.responsibleEmail =  responsibleEmail;
        this.responsibleCpf = responsibleCpf;
    }

    public void createDependant() throws SQLException {
        ps = DB.getConnection().prepareStatement(dependantStatement);
        ps.setString(1, depName);
        ps.setString(2,  depBirthDate);
        ps.setString(3, depCpf);
        ps.setString(4, responsibleName);
        ps.setString(5,responsibleEmail);
        ps.setString(6, responsibleCpf);
        ps.setString(7,responsibleBirthdate);

        ps.executeUpdate();
        ps.close();
    }
}
