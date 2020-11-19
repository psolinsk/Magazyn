package pl.edu.wszib.magazyn.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.database.IDataBase;
import pl.edu.wszib.magazyn.model.Item;

import java.util.Scanner;

@Component
public class GUI implements IGUI{

    Scanner scaner = new Scanner(System.in);

    @Autowired
    public IDataBase dataBase;

    @Override
    public void showMainMenu() {
        System.out.println("1. Pokaż stan magazynowy");
        System.out.println("2. Dodaj produkty");
        System.out.println("3. Usuń produkty");
        System.out.println("4. Exit");

        switch (scaner.next()){
            case "1":
                this.showAllItems();
                this.showMainMenu();
                break;
            case "2":
                this.addItems();
                this.showMainMenu();
                break;
            case "3":
                this.removeItems();
                this.showMainMenu();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Zły wybór !!");
                this.showMainMenu();
                break;
        }
    }

    private void showAllItems() {
        for(Item item: this.dataBase.getAllItems()) {
            System.out.println(item);
        }
    }

    private void addItems() {
        System.out.println("Podaj numer seryjny produktu:");
        String serialNumber = scaner.next();
        System.out.println("Podaj ilość porduktów do dodania:");
        int count = scaner.nextInt();
        if (dataBase.AddItems(serialNumber, count)) {
            System.out.println("Sukcess!");
        } else {
            System.out.println("Błąd!");
        }
    }

    private void removeItems(){
        System.out.println("Podaj numer seryjny produktu:");
        String serialNumber = scaner.next();
        System.out.println("Podaj ilość porduktów do odjęcia:");
        int count = scaner.nextInt();
        if (dataBase.RemoveItems(serialNumber, count)) {
            System.out.println("Sukcess!");
        } else {
            System.out.println("Błąd!");
        }
    }
}
