package entities;

public class PassangerDependant {
    String name;
    int birthDate;
    String cpf;
    String destination;
    String responsibleName;
    int responsibleBirthdate;
    String responsibleCpf;

    public PassangerDependant(String name, int birthDate, String cpf, String destination, String responsibleName, String responsibleCpf, int responsibleBirthdate) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.responsibleName = responsibleName;
        this.responsibleBirthdate = responsibleBirthdate;
        this.responsibleCpf = responsibleCpf;
    }
}
