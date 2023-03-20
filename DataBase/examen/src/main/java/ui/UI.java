package ui;

import service.Service;
import domain.Angajat;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UI {
    private Service service;

    public UI(Service service) {
        this.service = service;
    }
    public void showOptions() {
        System.out.println();
        System.out.println("1. Afisare angajati");
        System.out.println("2. Cautarea angajatului 'Ionescu Paul' ");
        System.out.println("3. Filtrarea angajatilor cu postul 'programator'");
        System.out.println("4. Filtrarea angajatilor cu postul 'programator' si cu salariul mai mare decat 5000");
        System.out.println("5. Sortare angajati dupa nume si prenume alfabetic descrescator");
        System.out.println("6. Sortare angajati dupa post crescator");
        System.out.println("7. Sortare angajati dupa salariu descrescator");
        System.out.println("8. Iesire");
        System.out.println();
    }

    public void run() {
        while (true) {
            showOptions();
            int optiune;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dati optiune: ");
            optiune = scanner.nextInt();

            if (optiune == 1) {
                Set<Angajat> set = (Set<Angajat>) service.getAllService();
                set.forEach(System.out::println);
            } else if (optiune == 2) {
                List<Angajat> angajati = service.filtrareDupaNumeSiPrenume("Ionescu","Paul");
                angajati.forEach(System.out::println);
            } else if (optiune == 3) {
                List<Angajat> filtrati = service.filtrareDupaPost("programator");
                filtrati.forEach(System.out::println);
            }
            else if(optiune == 4){
                List<Angajat> filtrati = service.filtrareDupaPostSiSalariu("programator");
                filtrati.forEach(System.out::println);
            }
            else if(optiune == 5){
                List<Angajat> angajati = service.sortareDupaNumePrenume();
                angajati.forEach(x-> System.out.println(x.pctA()));
            }
            else if(optiune == 6){
                List<Angajat> angajati = service.sortareDupaPost();
                angajati.forEach(x-> System.out.println(x.pctB()));
            }
            else if(optiune == 7){
                List<Angajat> angajati = service.sortareDupaSalariu();
                angajati.forEach(x-> System.out.println(x.pctC()));
            }
            else if(optiune == 8)
                    break;
        }
    }
}