package TU_Java.Exam2;

public class Regex {
    private static int nextId = 0;
    private int id;
    private String pattern;
    private String description;
    private int rating;

    public Regex(String pattern, String description) {
        this.id = nextId;
        this.pattern = pattern;
        this.description = description;
        this.rating = 0;
        IdCountAdd();
    }
    private static void IdCountAdd(){
        nextId++;
    }

    public String getPattern() {
        return pattern;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Regex{" +
                "id=" + id +
                ", pattern='" + pattern + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
