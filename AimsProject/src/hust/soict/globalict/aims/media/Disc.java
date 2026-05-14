package hust.soict.globalict.aims.media;

public class Disc extends Media{
    private int length;
    private String director;

    public Disc(String title){
        super(title);
    }

    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }

    public Disc(String title, String category, float cost, String director){
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, float cost, String director, int length){
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

}
