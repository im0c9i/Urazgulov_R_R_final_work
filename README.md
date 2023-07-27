# Итоговая контрольная работа

## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

## Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный
репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом
репозитории, использовать пул реквесты на изменения. Программа должна
запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо
разработать класс в виде конструктора.

## Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

2. Создать директорию, переместить файл туда.

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

4. Установить и удалить deb-пакет с помощью dpkg.

5. Выложить историю команд в терминале ubuntu.

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”.

8. Создать таблицы с иерархией из диаграммы в БД.

9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения.

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице.

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.

14. Написать программу, имитирующую работу реестра домашних животных.  
В программе должен быть реализован следующий функционал:  
    14.1. Завести новое животное  
    14.2. определять животное в правильный класс  
    14.3. увидеть список команд, которое выполняет животное  
    14.4. обучить животное новым командам  
    14.5. Реализовать навигацию по меню

15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля.

## Файлы (решение)

1. Итоговая контрольная работа. Задание.pdf - Текст задания (тот же, что приведен выше).

2. Decision.pdf - Решение по Linux (пункты задания с 1 по 6). 

3. Script_MySQL_Animals.sql - Решение по SQL (пункты задания с 7 по 12). Пункт 6 задания, признаться, выполнен после пунктов 7-12, потому что иерархия несложная и сама диаграмма была взята из Debeaver после реализации SQL - так проще было "рисовать".

4. Папка AnimalShelter - Решение на Java (пункты задания с 13 по 15). Если кратко, то: класс Animal наследуется от абстрактного AbstractAnimal. При наследовании добавляются параметры тип животного (Pack и Pet) и выполняемые животным команды. Сохранение данных в папке db: shelter хранит всех животных, classAniaml - типы и классы животных. Управление осуществляется из вьюшки ViewShelter (консоль) через контоллер MenuController с помощью интерфейсов MenuManagable и DBActions. Счетчик реализован путем считывания последней строки хранилища shelter и инкремента на единицу последнего ID.  
Из недостатков: 
- можно было обойтись и одним интерфейсом - вся работа осуществляется через DBActions, 
- сохранение в базу осуществлялось в формате String, в формате Animal было бы гораздо удобнее (хотя в формат sql, наверное, еще круче),
- нет технического описания кода, 
- совсем мало обработки исключений, 
- местами - использование непонятных имен переменных.
