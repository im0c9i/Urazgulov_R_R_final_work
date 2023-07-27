package controllers;

import intrefaces.MenuManagable;
import models.Animal;

public class MenuController {
    private MenuManagable menuManagable;
    
    public MenuController(MenuManagable menuManagable) {
        this.menuManagable = menuManagable;
    }  
    
    public void CreateAnimal(Animal animal){
        menuManagable.CreateAnimal(animal);
    }

    public int GetNextIdAnimal() {
        return menuManagable.GetNextIdAnimal();
    }

    public String[] GetClassAnimal(){
        return menuManagable.GetClassAnimal();
    }
    
    public String GetAnimalType(Animal animal, String classAnimalFile){
        return menuManagable.GetAnimalType(animal, classAnimalFile);
    }

    public Animal GetAnimalById(int findId) {
        return menuManagable.GetAnimalById(findId);
    }

    public Animal AddCommadToAnimal(Animal animal, String anyCommand) {
        return menuManagable.AddCommadToAnimal(animal, anyCommand);        
    }

    public void ChangeAnimal(Animal animal) {
        menuManagable.ChangeAnimal(animal);
    }
    

}
