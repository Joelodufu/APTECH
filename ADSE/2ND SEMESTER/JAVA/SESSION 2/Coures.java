import java.sql.Date;
import java.util.Currency;

public class Coures {

    //fields
    String title;
    String[] jobOpportunities;
    Date startDate;
    Date endDate;
    Currency cost;
    Module[] modules;
    
    
    //Constructors
    Coures(String title, Module[] modules, String[] jobOpportunities, Date starDate, Date endDate, Currency cost) {
        this.title = title;
        this.jobOpportunities = jobOpportunities;
        this.modules = modules;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    //other methods
    void beginCourse() {
        //begins a cours
    }

    void EndCourse() {
        //ending a course
    }
    
}