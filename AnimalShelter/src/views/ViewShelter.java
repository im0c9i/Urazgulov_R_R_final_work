package views;


import java.time.LocalDate;
import java.util.Scanner;

import controllers.MenuController;
import models.Animal;

public class ViewShelter {

    private String classAnimalFile = "AnimalShelter\\src\\db\\classAnimal.txt";
     
    private MenuController menuController;

    public ViewShelter(MenuController menuController) {
        this.menuController = menuController;
    }

    public void run() {

        /** Текущий выбор меню пользователем. */
        CommandBaseView com = CommandBaseView.NONE;

        while (true) {
            String command = prompt("\n Доступные команды: \n"
                + "    CREATE - добавить животное в реестр \n"
                + "    GETCOM - просмотреть команды животного (по ID) \n"
                + "    NEWCOM - добавить команды животному (по ID) \n"
                + "    EXIT - выйти из программы \n\n"
                + "Введите команду: ");
            com = CommandBaseView.valueOf(command.toUpperCase());
            if (com == CommandBaseView.EXIT)
                return;
            try {
                switch (com) {
                    case CREATE:
                        Animal animal1 = getNewAnimalFromConsole();
                        menuController.CreateAnimal(animal1);
                        System.out.println("\n Животное записано в реестре");
                        break;
                    case GETCOM:
                        int findId = Integer.parseInt(prompt("\n Введите ID животного: "));
                        Animal animal2 = menuController.GetAnimalById(findId);
                        System.out.println("\n " + animal2.getClassAnimal() + 
                                            " " + animal2.getAnimalName() + 
                                            " умеет " + animal2.getAnimalCommands());
                        break;
                    case NEWCOM:
                        int findId2 = Integer.parseInt(prompt("\n Введите ID животного: "));
                        Animal animal3 = menuController.GetAnimalById(findId2);
                        Boolean exitCommand = true;
                        while (exitCommand) {
                            String anyCommand = prompt("\n Введите команду: ");
                            animal3 = menuController.AddCommadToAnimal(animal3, anyCommand);
                            if (prompt("\n Добавить ещё команду? yes/no: ").equals("no")){
                                exitCommand = false;
                            }
                        }
                        menuController.ChangeAnimal(animal3);
                        System.out.println("\n Команды записаны в реестре");

                        break;
                    case FINDID:
                        
                        break;
                    
                }
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
            }
        }
    }

    /**
     * Получение данных с одного ввода с консоли
     * @param message выводимое сообщение
     * @return String
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public Animal getNewAnimalFromConsole() {
        Animal animal = new Animal();
        /** Устанавливаем для текущей записи значения ID животного*/
        int id = menuController.GetNextIdAnimal();
        animal.setIdAnimal(id);
        
        /** Устанавливаем для текущей записи значение вида животного */
        String[] allClassAnimal = menuController.GetClassAnimal();
        System.out.println("\n Выберите класс животного:");
        for (int i = 0; i < allClassAnimal.length-1; i++) {
            System.out.println(Integer.toString(i+1) + " - " + allClassAnimal[i]);
        }
        String selectedAnimalClass = prompt(" Укажите цифру вида животного: ");
        animal.setClassAnimal(allClassAnimal[Integer.parseInt(selectedAnimalClass)-1]);
        /** Устанавливаем для текущей записи имя животного */
        animal.setAnimalName(prompt(" Введите имя животного: "));
        /** Устанавливаем для текущей записи дату рождения животного */
        LocalDate localDate = LocalDate.parse(prompt(" Введите дату рождения животного в формате ГГГГ-ММ-ДД: "));
        animal.setBirthday(localDate);
        /** Устанавливаем для текущей записи тип животного в зависимости от его вида */
        String animalType = menuController.GetAnimalType(animal, classAnimalFile);
        animal.setAnymalType(animalType);
        return animal;
    }
}
