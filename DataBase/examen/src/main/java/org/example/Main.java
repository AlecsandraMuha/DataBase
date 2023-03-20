package org.example;

import service.Service;
import repository.AngajatDbRepository;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        System.out.println("ok");
        System.out.println("Reading data from file");
        String username = "postgres";
        String password = "alemuha";
        String url = "jdbc:postgresql://localhost:5432/examenPractic";

        AngajatDbRepository userFileRepository = new AngajatDbRepository(url, username, password);
        Service service = new Service(userFileRepository);
        UI console = new UI(service);
        console.run();}
}