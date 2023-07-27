package models;

import java.time.LocalDate;

public abstract class AbstractAnimal {
    /**
     * ID животного в БД
     */
    protected int idAnimal;
    protected String classAnimal;
    protected String animalName;
    protected LocalDate birthday;

    public AbstractAnimal(int idAnimal, String classAnimal, String animalName, LocalDate birthday) {
        this.idAnimal = idAnimal;
        this.classAnimal = classAnimal;
        this.animalName = animalName;
        this.birthday = birthday;
    }

    public AbstractAnimal(){
        idAnimal = 0;
        classAnimal = "none";
        animalName = "none";
        birthday = null;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public String getClassAnimal() {
        return classAnimal;
    }

    public String getAnimalName() {
        return animalName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setClassAnimal(String classAnimal) {
        this.classAnimal = classAnimal;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
        
}
