package entities;

public class PassangerDependant {
    String name;
    String birthDate;
    String cpf;
    String destination;
    String responsibleName;
    String responsibleBirthdate;
    String responsibleCpf;

    public PassangerDependant(String DepName, String DepBirthDate, String DepCpf, String destination, String responsibleName, String responsibleCpf, String responsibleBirthdate) {
        this.name = DepName;
        this.birthDate = DepBirthDate;
        this.cpf = DepCpf;
        this.responsibleName = responsibleName;
        this.responsibleBirthdate = responsibleBirthdate;
        this.responsibleCpf = responsibleCpf;
    }
}
