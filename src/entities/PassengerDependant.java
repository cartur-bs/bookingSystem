package entities;

public class PassengerDependant {
    String name;
    String birthDate;
    String cpf;
    String destination;
    String responsibleName;
    String responsibleBirthdate;
    String responsibleCpf;

    public PassengerDependant(String DepName, String DepBirthDate, String DepCpf, String destination, String responsibleName, String responsibleCpf, String responsibleBirthdate) {
        this.name = DepName;
        this.birthDate = DepBirthDate;
        this.cpf = DepCpf;
        this.responsibleName = responsibleName;
        this.responsibleBirthdate = responsibleBirthdate;
        this.responsibleCpf = responsibleCpf;
    }


    public String toString() {
        return "PassengerDependant{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", cpf='" + cpf + '\'' +
                ", destination='" + destination + '\'' +
                ", responsibleName='" + responsibleName + '\'' +
                ", responsibleBirthdate='" + responsibleBirthdate + '\'' +
                ", responsibleCpf='" + responsibleCpf + '\'' +
                '}';
    }
}
