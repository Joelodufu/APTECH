import java.sql.Date;

public class Module {
    //fields
    String title;
    String[] topics;
    Date duration;

    //constructor
    Module(String tile, String[] topics, Date duration) {
        this.title = tile;
        this.topics = topics;
        this.duration = duration;
    }

    //other methords
}
