package intrefaces;

import models.Animal;

public interface MenuManagable {
    
    public void CreateAnimal(Animal animal);

    public String[] GetClassAnimal();

    public int GetNextIdAnimal();

    public String GetAnimalType(Animal animal, String classAnimalFile);

    public Animal GetAnimalById(int findId);

    public Animal AddCommadToAnimal(Animal animal, String anyCommand);

    public void ChangeAnimal(Animal animal);
}
