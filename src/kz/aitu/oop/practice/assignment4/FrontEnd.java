package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.Controller.StoneController;

import java.util.InputMismatchException;
import java.util.Scanner;
interface Zhandos {
    String costString(int cost);
}

public class FrontEnd {
    private final StoneController controller;
    private final Scanner scanner;

    public FrontEnd(StoneController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("1. See all stones(by hierarchy):");
            System.out.println("2. Delete stones by ID:");
            System.out.println("3. Create new stones:");
            System.out.println("4. Total cost of the jewelry is:");
            System.out.println("5. Total weight(in carats) of the jewelry is:");
            System.out.println("0. Exit");
            System.out.println();
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: seeStones();
                    break;
                    case 2: deleteStones();
                    break;
                    case 3:createStones();
                    break;
                    case 4: jewelryCost();
                    break;
                    case 5:jewelryWeight();
                    break;
                    default: System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
    public void seeStones() {
        String response = controller.seeStones();
        System.out.println(response);
    }
    public void deleteStones() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.deleteStones(id);
        System.out.println(response);
    }
    public void createStones() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        Geneics <String, Integer> obj = new Geneics<String, Integer>("Please enter name of the stone");
        obj.print();
        String name = scanner.next();
        System.out.println("Please enter is stone precious or semi-precious");
        String value = scanner.next();
        System.out.println("Please enter cost of the stone");
        int cost = scanner.nextInt();
        System.out.println("Please enter weight(in grams)");
        int weight = scanner.nextInt();

        String response = controller.createStones(id,name,value,cost,weight);
        System.out.println(response);
    }
    public void jewelryCost(){
        int response = controller.jewelryCost();
        /*String rest = String.valueOf(response);
        Zhandos lam = (rest) -> "Cost of jewelry is:" + rest;*/
        System.out.println("Cost of jewelry is:" + response);
    }
    public void jewelryWeight(){
        int response1=controller.jewelryWeight();
        System.out.println("Weight of the jewelry is(in carats):" + response1);
    }
}
