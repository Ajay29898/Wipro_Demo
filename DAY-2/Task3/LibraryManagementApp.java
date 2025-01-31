import java.util.ArrayList;
import java.util.Scanner;

class Book      // Represents a Book in the Library.
{
    String bookId;
    String title;
    String author;
    int copies;    //  Number of copies available in the library.

    // Constructor to Initializes the book attributes.
    public Book(String bookId, String title, String author, int copies) 
    {
        // You don't need this if you use different parameter names in constructor as it is same as Instance variable.
        
        this.bookId = bookId;   
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String toString() 
    {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Copies: " + copies;
    }
}

class Member      // Represents a library member.
{
    String memberId;
    String name;

    public Member(String memberId, String name) 
    {
        this.memberId = memberId;
        this.name = name;
    }

    // toString() method is used to provide a string representation of an object. When you print an object, Java calls the toString() method internally to get a human-readable description of that object.
    // This is because Java uses the default toString() implementation from the Object class, which just shows the class name and the object's memory address.

    public String toString() 
    {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}

class LibraryManagement  // Manages the library operations.
{
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addBook()    // Adds a new book to the library.
    {
        // The user is prompted to enter book details (ID, title, author, number of copies).

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Number of Copies: ");
        int copies = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // A new Book object is created and added to the books list.
        
        Book book = new Book(bookId, title, author, copies);
        books.add(book); 
        scanner.nextLine();  
        books.add(new Book(bookId, title, author, copies));

        System.out.println("Book added successfully.");
    }

    public void addMember() 
    {
        // The user is prompted to enter member details (ID and name).

        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        // A new Member object is created and added to the members list.

        Member member=new Member(memberId, name);
        members.add(member);
        System.out.println("Member added successfully.");
    }

    public void issueBook()   //The method searches the the book in books list with the given bookId
    {
        // The user provides the bookId and memberId.
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();

        for (Book book : books) 
        {
            // If the book exists and has at least one copy available, it decrements the copies and issues the book to the member.
            if (book.bookId.equals(bookId)) 
            {
                if (book.copies > 0) 
                {
                    book.copies--;
                    System.out.println("Book issued to Member ID: " + memberId);
                    return;
                } 
                else 
                {
                    System.out.println("No copies available.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook()    //The method searches the books list for the book and increments its copies
    {
        // The user provides the bookId of the book being returned.
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        for (Book book : books) 
        {
            if (book.bookId.equals(bookId)) 
            {
                book.copies++;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

   // This method iterate through the books lists and  displaying the details of each book
    public void viewBooks() 
    {
        System.out.println("Books:");
        for (Book book : books) 
        {
            System.out.println(book);
        }
    }
    //This method iterate through the members lists and displaying the details of each member.
    public void viewMembers() 
    {
        System.out.println("Members:");
        for (Member member : members) 
        {
            System.out.println(member);
        }
    }

    // Provides a  menu for interacting with the system.
    //User can choose from the following options:
    // Add Book
    // Add Member
    // Issue Book
    // Return Book
    // View Books
    // View Members
    // Exit

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Members");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> viewBooks();
                case 6 -> viewMembers();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 7);
    }
}

public class LibraryManagementApp
{
    public static void main(String[] args) 
    {
        LibraryManagement lms = new LibraryManagement();
        lms.menu();
    }
}
