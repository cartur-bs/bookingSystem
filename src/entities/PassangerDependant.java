package entities;

public class PassangerDependant {
    String name;
    int birthDate;
    String cpf;
    String destination;
    String responsableName;
    int responsableBirthdate;
    String responsableCpf;

    public PassangerDependant(String name, int birthDate, String cpf, String destination, String responsableName, String responsableCpf, int responsableBirthdate) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.responsableName = responsableName;
        this.responsableBirthdate = responsableBirthdate;
        this.responsableCpf = responsableCpf;
    }
}
