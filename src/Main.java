import entities.Passanger;
import entities.PassangerDependant;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //starting the program
       try{ System.out.println("Hello, let's make your booking!");
        System.out.println("What's your name?");
        String name = sc.next();
        System.out.println("What's your birth date?");
        String bDate = sc.next();
        System.out.println("What's your cpf?");
        String CPF = sc.next();
        System.out.println("What's your email?");
        String email = sc.next();
        System.out.println("What's your destination?");
        String destination = sc.next();
        System.out.println(name + bDate + CPF + destination);
        System.out.println("Would you like to add a dependant?(Y/N)");
        char isThereDependant = sc.next().charAt(0);

        if(isThereDependant == 'N'){
            Passanger passanger = new Passanger(name, bDate, CPF, email, destination);
            System.out.println("Your booking is complete!");
        }

        if(isThereDependant == 'Y'){
            System.out.println("Let's add your dependant information!");
            System.out.println("What's your dependant name?");
            String depName = sc.next();
            System.out.println("What's your dependant birth date?");
            String depBdate = sc.next();
            System.out.println("What's your dependant cpf?");
            String depCpf = sc.next();
            PassangerDependant newDependant = new PassangerDependant( depName, depBdate,  depCpf,  destination,  name,  CPF,  bDate);
            System.out.println("Your booking and your dependant's are complete!");
        }}
       catch(InputMismatchException e){
           e.printStackTrace();
           System.out.println("Insert a valid value");
       }
       finally {
           sc.close();
       }

    }
}