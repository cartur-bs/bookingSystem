package entities;

public class PassangerDependant extends Passanger{

    Passanger passanger = new Passanger();
    String name;
    int birthDate;
    String cpf;
    String destination = passanger.getDestination();
    String responsibleName = passanger.getName();
    int responsibleBirthdate = passanger.getBirthDate();
    String responsibleCpf = passanger.getCpf();

    public PassangerDependant(String name, int birthDate, String cpf, String destination, String responsibleName, String responsibleCpf, int responsibleBirthdate) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.responsibleName = responsibleName;
        this.responsibleBirthdate = responsibleBirthdate;
        this.responsibleCpf = responsibleCpf;
    }


}
