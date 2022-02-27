package pl.sda.wheatherApplication;

import java.util.Scanner;

public class UserInterface {

    public void run() {
        System.out.println("STARTUJEMY\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Startujemy z info p pogodzie, co chcesz zrobić?");
            System.out.println("1. hehe");
            System.out.println("0. Kończymy na dziś");

            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    return;
            }
        }
    }
}
