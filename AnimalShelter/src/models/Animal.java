package models;

import java.time.LocalDate;

public class Animal extends AbstractAnimal {
    private String anymalType;
    private String animalCommands;

    public Animal(int idAnimal, String classAnimal, String animalName, LocalDate birthday) {
        super(idAnimal, classAnimal, animalName, birthday);
    }

    public Animal(int idAnimal, String classAnimal, String animalName, LocalDate birthday, String animalType, String animalCommands) {
        this(idAnimal, classAnimal, animalName, birthday);
        this.anymalType = animalType;
        this.animalCommands = animalCommands;
    }
    
    public Animal() {
        super();
        animalCommands = " ";
    }

    public String getAnymalType() {
        return anymalType;
    }

    public void setAnymalType(String anymalType) {
        this.anymalType = anymalType;
    }

    public String getAnimalCommands() {
        return animalCommands;
    }

    public void setAnimalCommands(String animalCommands) {
        this.animalCommands = animalCommands;
    }    
    
}
