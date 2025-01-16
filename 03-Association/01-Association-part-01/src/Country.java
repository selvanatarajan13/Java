import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private List<SportPerson> sportPersons;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSportPersons(List<SportPerson> sportPersons) {
        this.sportPersons = sportPersons;
    }

    public List<String> getSportPersons() {
        List<SportPerson> listOfSportsPersons = this.sportPersons;
        List<String> names = new ArrayList<String>();

        for (SportPerson sportPerson : listOfSportsPersons) {
            names.add(sportPerson.getName());
        }

        return names;
    }
}
