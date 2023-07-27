package intrefaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Animal;

public class DBASample implements DBActions{

    /**
     * Путь к файлу БД
     */
    private String dbFileName = "AnimalShelter\\src\\db\\shelter.txt";

    public DBASample(String dbFileName) {
        this.dbFileName = dbFileName;
    }

    @Override
    public void CreateAnimal(Animal animal) {
        try (FileWriter wrtr = new FileWriter(dbFileName, true)) {
            wrtr.write(animalToString(animal));
            wrtr.flush();
            wrtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String animalToString(Animal animal){
        String animalString = Integer.toString(animal.getIdAnimal()) + ";"
                                + animal.getAnymalType() + ";"
                                + animal.getClassAnimal() + ";"
                                + animal.getAnimalName() + ";"
                                + animal.getBirthday() + ";" 
                                + animal.getAnimalCommands() + ";" + "\n";
        return animalString;
    }

    @Override
    public int GetNextIdAnimal() {
        File file = new File(this.dbFileName);
        String lastLine = ReadLastLine(file);
        int nextId = 0;
        if (lastLine != null) {
            String[] numbers = lastLine.split(";");            
            nextId = Integer.parseInt(numbers[0]);
            }
        return nextId+1;        
    }

    private static String ReadLastLine(File file) {
        String result = null;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            long startIdx = file.length();
            while (startIdx >= 0 && (result == null || result.length() == 0)) {
                raf.seek(startIdx);
                if (startIdx > 0) 
                    raf.readLine();
                result = raf.readLine();
                startIdx--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String GetAnimalType(Animal animal, String classAnimalFile) {
        String animalType = "";
        try {
            File file = new File(classAnimalFile);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (animalType == "") {
                if (line != null) {
                    String[] animals = line.split(";");    
                    for (int i = 1; i < animals.length; i++) {
                        if (animals[i].toUpperCase().equals(animal.getClassAnimal())) {
                            animalType = animals[0];
                        }
                    }        
                }                
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }    
        return animalType;
    }

    @Override
    public Animal GetAnimalById(int findId) {
        Animal findAnimal = null;
        try {
            File file = new File(dbFileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null && findAnimal == null) {
                String[] animalArr = line.split(";");    
                if (animalArr[0].equals(Integer.toString(findId))) {
                    findAnimal = stringToAnimal(animalArr);
                        }
                line = reader.readLine();
                }                                            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }    
        return findAnimal;
    }   

    private Animal stringToAnimal(String[] animalArr) {
        Animal animal = new Animal();
        animal.setIdAnimal(Integer.parseInt(animalArr[0]));
        animal.setAnymalType(animalArr[1]);
        animal.setClassAnimal(animalArr[2]);
        animal.setAnimalName(animalArr[3]);
        animal.setBirthday(LocalDate.parse(animalArr[4]));
        animal.setAnimalCommands(animalArr[5]);
        return animal;
    }

    @Override
    public Animal AddCommadToAnimal(Animal animal, String anyCommand) {
        String commands = animal.getAnimalCommands();
        if (commands.equals(" ")) {
            commands = anyCommand; 
        } else {
            commands += "," + anyCommand;
        }
        animal.setAnimalCommands(commands);     
        return animal;

    }

    private List<String> GetAllLines(){
        List<String> allLines = new ArrayList<>();
        List<String> shelter = new ArrayList<>();
        try {
            shelter = Files.readAllLines(Paths.get(this.dbFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : shelter) {
            if (line != null) {   
                allLines.add((line));            
            }   
        }
        return allLines;        
    }

    public void ChangeAnimal(Animal animal){
        List<String> shelter = GetAllLines();
        String newShelter = "";
        for (String line : shelter) {
            if (line != null) {
                String[] animalArr = line.split(";");
                if (animalArr[0].equals(Integer.toString(animal.getIdAnimal()))){
                    newShelter += animalToString(animal);                    
                } else {
                    newShelter += line + "\n";
                }
            }           
        }
        try (FileWriter wrtr = new FileWriter(dbFileName, false)) {
            wrtr.write(newShelter);
            wrtr.flush();
            wrtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
