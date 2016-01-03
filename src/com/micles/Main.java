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
        System.out.println("     1. ");
        System.out.println("     2. ");
        System.out.println("     3. ");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }



    public static void main(String[] args) throws Exception {
        Library obj = new Library(new DataBaseProcessor());

//        obj.addBook(new Book("Inkwizytor","Piekara",2005, 39.99));
//        obj.addBook(new Book("Pan Lodowego Ogrodu","Grzedowicz",2005, 23.99));
//        obj.addBook(new Book("Wiedzmin","Sapkowski",1999, 36.00));

//        obj.addUser(new User("Katrin","kat@gmail.com",99595559));
//        obj.addUser(new User("Xoi","xoui@gmail.com",666666));


     //     obj.saveUser();
     //     obj.loadUser();

 //       System.out.println(obj);


        Scanner in = new Scanner(System.in);
        int wybor = menu();

        while(wybor!=0){
            switch(wybor){
                case 1:
                    System.out.println("Dodaj uzytkownika.");

                    break;

                case 2:

                    break;

                case 3:

                    break;
            }

            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = menu();
        }


    }
}
