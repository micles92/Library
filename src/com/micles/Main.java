package com.micles;

import java.util.Scanner;





/**
 * Created by Bolesław on 2015-12-28.
 */
public class Main {

    public static int menu(){
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Wyswietl uzytkownikow.");
        System.out.println("     2. Usun uzytkownikow.");
        System.out.println("     3. Dodaj uzytkownika.");
        System.out.println("     4. Wyswietl ksiazki.");
        System.out.println("     5. Usun ksiazki.");
        System.out.println("     6. Dodaj ksiazki.");
        System.out.println("     Opcje zapisu:");
        System.out.println("     7. Zapisz uzytkownikow.");
        System.out.println("     8. Zapisz ksiazki.");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }



    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Library obj = new Library(new DataBaseProcessor());

      //  obj.addBook(new Book("Inkwizytor","Piekara",2005, 39.99));
//        obj.addBook(new Book("Pan Lodowego Ogrodu","Grzedowicz",2005, 23.99));
//        obj.addBook(new Book("Wiedzmin","Sapkowski",1999, 36.00));

//        obj.addUser(new User("Katrin","kat@gmail.com",99595559));
       // obj.addUser(new User("Xoi","xoui@gmail.com",666666));




 //       System.out.println(obj);




        Scanner in = new Scanner(System.in);
        int wybor = menu();

        while(wybor!=0){
            obj.loadBook();
            obj.loadUser();
            switch(wybor){
                case 1:
                    System.out.println("Uzytkownicy:");
                    obj.viewUser();

                    break;

                case 2:
                    System.out.println("Usun uzytkownika:");

                    String mail = scanner.nextLine();
                    obj.removeUser(mail);

                    break;

                case 3:
                    System.out.println("Dodaj uzytkownika:");

                    String name = scanner.nextLine();
                    String email = scanner.nextLine();
                    int pesel = scanner.nextInt();

                    obj.addUser(new User(name,email,pesel));
                    obj.saveUser();
                    break;

                case 4:
                    System.out.println("Ksiazki:");
                    obj.viewBook();

                    break;

                case 5:
                    System.out.println("Usun ksiazke:");
                    String title = scanner.nextLine();
                    obj.removeBook(title);

                    break;

                case 6:
                    System.out.println("Dodaj ksiazke:");
                    String titl = scanner.nextLine();
                    String autor = scanner.nextLine();
                    int year = scanner.nextInt();
                    double price = scanner.nextDouble();

                    obj.addBook(new Book(titl,autor,year,price));
                    obj.saveBook();
                    break;

                case 7:
                    obj.saveUser();
                    System.out.println("Zapisano uzytkownika.");

                    break;
                case 8:
                    obj.saveUser();
                    System.out.println("Zapisano ksiazki.");

                    break;
            }



            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = menu();
        }


    }
}
