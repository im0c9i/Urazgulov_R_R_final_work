package intrefaces;

import java.util.stream.Stream;

import models.Animal;
import models.ClassAnimal;

/**
 * MMSample
 */
public class MMSample implements MenuManagable {
    private DBActions dbActions;

    public MMSample(DBActions dbActions) {
        this.dbActions = dbActions;
    }

    @Override
    public void CreateAnimal(Animal animal) {            
        dbActions.CreateAnimal(animal);
    }

    @Override
    public String[] GetClassAnimal() {
        String[] valuesClassAnimal = Stream.of(ClassAnimal.values()).map(ClassAnimal::name).toArray(String[]::new);
        return valuesClassAnimal;
    }

    @Override
    public int GetNextIdAnimal() {
        return dbActions.GetNextIdAnimal();        
    }

    @Override
    public String GetAnimalType(Animal animal, String classAnimalFile) {
        return dbActions.GetAnimalType(animal, classAnimalFile);
    }

    @Override
    public Animal GetAnimalById(int findId) {
        return dbActions.GetAnimalById(findId);
    }

    @Override
    public Animal AddCommadToAnimal(Animal animal, String anyCommand) {
        return dbActions.AddCommadToAnimal(animal, anyCommand);
    }

    @Override
    public void ChangeAnimal(Animal animal) {
        dbActions.ChangeAnimal(animal);
    }

}