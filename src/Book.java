public class Book {
    private String title;
    private String writer;
    private int year;
    private int edition;
    private boolean availabilityStatus;

    public Book(String title, String writer, int year, int edition){
        this.title = title;
        this.writer = writer;
        this.year = year;
        this.edition = edition;
        this.availabilityStatus = true;
    }

    public boolean loan(){
        if(this.availabilityStatus) {
            this.availabilityStatus = false;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if(!this.availabilityStatus) {
            this.availabilityStatus = true;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public boolean getAvailability() {
        return availabilityStatus;
    }

    public String toString() {
        return "Title: " +title + "\n" +
                "Writer: " + writer + "\n" +
                "Year: " + year + "\n" +
                "Edition: " + edition + "\n" +
                "Available: " + availabilityStatus + "\n";

    }
}
