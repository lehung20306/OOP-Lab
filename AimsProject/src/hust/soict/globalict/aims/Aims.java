package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, "George Lucas", 124));
        store.addMedia(new Book("Java Programming", "Technology", 15.0f));

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: 
                    System.out.println("Goodbye!");
                    System.exit(0);
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu(Media m) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (m instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }
    
    private static void viewStore() {
        store.print();
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        System.out.println(m.toString());
                        handleMediaDetailsMenu(m);
                    } else System.out.println("Not found!");
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    Media addM = store.searchByTitle(scanner.nextLine());
                    if (addM != null) {
                        cart.addMedia(addM);
                        System.out.println("Cart size: " + cart.getItemsOrdered().size());
                    }
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    Media playM = store.searchByTitle(scanner.nextLine());
                    if (playM instanceof Playable) ((Playable) playM).play();
                    else System.out.println("Not playable.");
                    break;
                case 4: viewCart(); break;
            }
        }
    }

    private static void handleMediaDetailsMenu(Media m) {
        while (true) {
            mediaDetailsMenu(m);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice == 1) cart.addMedia(m);
            else if (choice == 2 && m instanceof Playable) ((Playable) m).play();
            else System.out.println("Invalid or Not playable.");
        }
    }

    private static void viewCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("Filter options: 1. By ID | 2. By Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (filterChoice == 1) {
                        System.out.print("Enter ID to filter: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        Media foundMedia = cart.searchById(id); 

                        if (foundMedia != null) {
                            System.out.println("Found: " + foundMedia.toString());
                        } else {
                            System.out.println("No match found for ID: " + id);
                        }
                    } else if (filterChoice == 2) {
                        System.out.print("Enter Title to filter: ");
                        String title = scanner.nextLine();

                        Media foundMedia = cart.searchByTitle(title);

                        if (foundMedia != null) {
                            System.out.println("Found: " + foundMedia.toString());
                        } else {
                            System.out.println("No match found for title: " + title);
                        }
                    }
                    break;
                case 2:
                    System.out.print("1. By Title | 2. By Cost: ");
                    if (scanner.nextInt() == 1) cart.sortByTitle();
                    else cart.sortByCost();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    Media remM = cart.searchByTitle(scanner.nextLine());
                    if (remM != null) cart.removeMedia(remM);
                    break;
                case 4:
                    System.out.print("Enter title: ");
                    Media pM = cart.searchByTitle(scanner.nextLine());
                    if (pM instanceof Playable) ((Playable) pM).play();
                    break;
                case 5:
                    System.out.println("Order created! Total: " + cart.totalCost() + " $");
                    cart.empty();
                    return;
            }
        }
    }

    private static void updateStore() {
        System.out.println("1. Add Media | 2. Remove Media");
        int c = scanner.nextInt(); scanner.nextLine();

        if (c == 1) {
            handleAddMedia();
        }
        else if (c == 2) {
            System.out.print("Enter Title to remove: ");
            Media m = store.searchByTitle(scanner.nextLine());
            if (m != null) store.removeMedia(m);
        }
    }

    private static void handleAddMedia() {
        System.out.println("Choose media type: 1. DVD | 2. Book | 3. CD");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();

        if (type == 1) {
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            store.addMedia(new DigitalVideoDisc(title, category, cost, director, length));
        } 
        else if (type == 2) {
            Book book = new Book(title, category, cost);
            
            System.out.print("Enter Number of Authors: ");
            int numAuthors = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numAuthors; i++) {
                System.out.print("Enter Author " + (i + 1) + ": ");
                book.addAuthor(scanner.nextLine());
            }
            store.addMedia(book);
        } 
        else if (type == 3) {
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Artist: ");
            String artist = scanner.nextLine();
            List<Track> tracks = new ArrayList<Track>();
            CompactDisc cd = new CompactDisc(title, category, cost, director, 0, artist, tracks);
            
            System.out.print("Enter Number of Tracks: ");
            int numTracks = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numTracks; i++) {
                System.out.print("Enter Track " + (i + 1) + " Title: ");
                String trackTitle = scanner.nextLine();
                System.out.print("Enter Track " + (i + 1) + " Length: ");
                int trackLength = scanner.nextInt();
                scanner.nextLine();
                cd.addTrack(new Track(trackTitle, trackLength));
            }
            store.addMedia(cd);
        } else {
            System.out.println("Invalid media type selected.");
        }
    }
}