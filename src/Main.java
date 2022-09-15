import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Book> bookList = new ArrayList<Book>();
        Book b1 = new Book("Naked Lunch", "William Burroughs", 1959, 1);
        //System.out.println(b1);
        bookList.add(b1);

        while (true) {
            menu(sc, bookList);
        }

    }

    static void menu(Scanner sc, ArrayList<Book> bookList){

        int menyChoice;
        System.out.println("1. Add a book to the library\n" +
                "2. Search for a book by name\n" +
                "3. List all available books\n" +
                "4. Return a book\n" +
                "5. Quit\n");

        menyChoice = sc.nextInt();
        sc.nextLine();
        switch (menyChoice) {
            case 1 -> {
                bookList.add(addBook(sc));
            }
            case 2 -> {
                searchBook(sc, bookList);
            }
            case 3 -> {
                listBooks(bookList);
            }
            case 4 -> {
                returnBook(sc, bookList);
            }
            case 5 -> {
                quit();
            }
        }
    }

    static Book addBook(Scanner sc) {
        System.out.println("What is the title?");
        String title = sc.nextLine();

        System.out.println("Who is the writer?");
        String writer = sc.nextLine();

        System.out.println("What year was the book printed?");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.println("Which edition is the book?");
        int edition = sc.nextInt();
        sc.nextLine();

        return new Book(title, writer, year, edition);
    }

    static void searchBook(Scanner sc, ArrayList<Book> bookList) {

        String bookTitle;
        String menuChoice;

        System.out.println("Enter book title:");
        bookTitle = sc.nextLine();

        for (Book b: bookList){
            if (b.getTitle().equals(bookTitle)){
                System.out.println(b);
                System.out.println("Do you want to check out the book? y/n");
                menuChoice = sc.nextLine();
                if(menuChoice.equals("y")) {
                    if (b.loan()){
                        System.out.println("You have borrowed the book.");
                    } else {
                        System.out.println("The book is unavailable.");
                    }
                    return;
                }
            }
            System.out.println("The book is not in the catalogue.");
            return;
        }
    }

    static void listBooks(ArrayList<Book> bookList) {
        for(Book book: bookList) {
            if (book.getAvailability()) {
                System.out.println(book);
            }
        }
    }

    static void returnBook(Scanner sc, ArrayList<Book> bookList) {
        String bookTitle;

        System.out.println("Enter the title of the book you want to return.");
        bookTitle = sc.nextLine();

        for(Book book: bookList) {
            if (book.getTitle().equals(bookTitle)) {
                if (book.returnBook()) {
                    System.out.println(book.getTitle() + " is returned.");
                    return;
                } else {
                    System.out.println("The book is not loaned!");
                    return;
                }
            }
        }
        System.out.println("The book is not in the catalogue.");

    }

    static void quit() {
        System.exit(0);
    }
}