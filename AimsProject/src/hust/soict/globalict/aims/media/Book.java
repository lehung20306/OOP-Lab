package hust.soict.globalict.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Author " + authorName + " has been added");
        }
        else{
            System.out.println("Author " + authorName + " is already in the list");
        }
    }

    public void removeAuthor(String authorName){
        if(!authors.contains(authorName)){
            System.out.println("Author " + authorName + " does not exist in the list");
        }
        else{
            authors.remove(authorName);
            System.out.println("Author " + authorName + " has been removed");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + 
            " - " + getAuthors() + ": " + getCost() + " $";
    }
}
