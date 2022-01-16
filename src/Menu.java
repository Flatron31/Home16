import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class Menu {
    private static String numberConsole;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void printMenu() {
        while (true) {
            System.out.println("меню 1 захордкожено по добавлению студентов, групп, универов!!! ");
            System.out.println();
            System.out.println("Выберите операцию нажав на клавишу\n" +
                    "1 - возможность добавления\n" +
                    "2 - подсчета среднего рейтинга\n" +
                    "3 - сортировать студентов в группе по среднему рейтингу оценок\n" +
                    "4 - вывод всей информации\n" +
                    "5 - выход из приложения");
            String numberMenu = numberConsole();
            if (numberMenu.equals("1")) {
                printMenuAdd();
            } else if (numberMenu.equals("2")) {
                printMenuRatind();
            } else if (numberMenu.equals("3")) {
                System.out.println(" УВЫ ПОКА НЕ ОСИЛИЛ");
                System.out.println();
                printMenu();
            } else if (numberMenu.equals("4")) {
                printMenuInfo();
            } else if (numberMenu.equals("5")) {
                endWorkProgram();
            } else {
                System.out.println("Повторите попытку. Введите нужную операцию");
            }
        }
    }

    public static void printMenuAdd() {
        while (true) {
            System.out.println("Выберите операцию нажав на клавишу\n" +
                    "1 - добавить студента\n" +
                    "2 - добавить группу\n" +
                    "3 - добавать университет\n" +
                    "4 - вернуться в предыдущее меню");
            String numberMenu = numberConsole();
            if (numberMenu.equals("1")) {
                System.out.println("Уже все добавлено. нажмите 4 для выхода в предыд меню");
                printMenuAdd();
            } else if (numberMenu.equals("2")) {
                System.out.println("Уже все добавлено. нажмите 4 для выхода в предыд меню");
                printMenuAdd();
            } else if (numberMenu.equals("3")) {
                System.out.println("Уже все добавлено. нажмите 4 для выхода в предыд меню");
                printMenuAdd();
            } else if (numberMenu.equals("4")) {
                printMenu();
            } else {
                System.out.println("Повторите попытку. Введите нужную операцию");
            }
        }
    }

    public static void printMenuInfo() {
        while (true) {
            System.out.println("Выберите операцию нажав на клавишу\n" +
                    "1 - получить информацию о студентах\n" +
                    "2 - получить информацию о группах\n" +
                    "3 - получить информацию о университетах\n" +
                    "4 - вернуться в предыдущее меню");
            String numberMenu = numberConsole();
            if (numberMenu.equals("1")) {
                Student.printInfoStudents();
            } else if (numberMenu.equals("2")) {
                Group.printInfoGroups();
            } else if (numberMenu.equals("3")) {
                University.printInfoUniversities();
            } else if (numberMenu.equals("4")) {
                printMenu();
            } else {
                System.out.println("Повторите попытку. Введите нужную операцию");
            }
        }
    }

    public static void printMenuRatind() {
        while (true) {
            System.out.println("Выберите операцию нажав на клавишу\n" +
                    "1 - показать рейтинг студентов\n" +
                    "2 - показать рейтинг групп\n" +
                    "3 - показать рейтинг университетов\n" +
                    "4 - вернуться в предыдущее меню");
            String numberMenu = numberConsole();
            if (numberMenu.equals("1")) {
                Student.printRatingStudents();
                printMenuRatind();
            } else if (numberMenu.equals("2")) {
                Group.printRatingGroups();
                printMenuRatind();
            } else if (numberMenu.equals("3")) {
                University.printRatingUniversities();
                printMenuRatind();
            } else if (numberMenu.equals("4")) {
                printMenu();
            } else {
                System.out.println("Повторите попытку. Введите нужную операцию");
            }
        }
    }

    private static String numberConsole() {
        try {
            numberConsole = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberConsole;
    } //ввод числа в консоль

    private static void endWorkProgram() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    } // конец работы приложения




//     1 Реализовать возможность добавления студентов/групп/университетов.
//      1.1 студентов
//      1.2 групп
//      1.3 универ
   // студенты в группу универ

//    2 Реализовать возможность подсчета среднего рейтинга студента/группы/университета.
//     2.1 студентов
//      2.2 групп
//      2.3 универ

//    3 Реализовать возможность сортировки студентов в группе по среднему рейтингу.

//   4  Реализовать возможность вывода всей информации

//      5 выход из проги




}
