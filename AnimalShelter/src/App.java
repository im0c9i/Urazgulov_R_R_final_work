//package src;

import controllers.MenuController;
import intrefaces.DBASample;
import intrefaces.DBActions;
import intrefaces.MMSample;
import intrefaces.MenuManagable;
import views.ViewShelter;

public class App {
    public static void main(String[] args) throws Exception {

        /** Приветственное слово */
        System.out.println("Привет! Это проект Реестр животных");
        String filename = "AnimalShelter\\src\\db\\shelter.txt";
        DBActions dbActions = new DBASample(filename);
        MenuManagable menuManagable = new MMSample(dbActions);
        MenuController menuController = new MenuController(menuManagable);
        ViewShelter viewShelter = new ViewShelter(menuController);
        viewShelter.run();
    }
}
