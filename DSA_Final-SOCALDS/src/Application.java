import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Main application of the SOCALDS, contains all main methods for running the base program
 * @author Darryl Rayray & Sreyas Prabu
 */
public class Application {
    private Map<Person, Integer> compatibilityMap;
    private Queue<Person> top10Candidates;
    private ArrayList<Person> allCandidates;
    private Scanner in;
    private Person user;
    private int mode;
    private CompatibilityAlgorithm algorithm;

    /**
     * Constrcutor that sets initializes the user's profile and application data structures
     * @throws IOException
     */
    public Application() throws IOException {
        compatibilityMap = new HashMap<Person, Integer>();
        top10Candidates = new LinkedList<Person>();
        allCandidates = new ArrayList<Person>();
        algorithm = new CompatibilityBasedAlgorithm();
        readFile();
        in = new Scanner(System.in);
        System.out.println("Welcome to SOCAL DATING! Please fill out the following information!");
        user = new Person();
        mode = 0;

    }

    /**
     * The main looping method of the SOCALDS, accounts for all inputs on UserUI and AdminUI
     * @author Darryl Rayray
     */
    public void runApp(){
        if(mode ==0){
            int input = userUI();
            //profile
            if (input == 1) {
                System.out.println(user);
                runApp();
            }

            //edit profile
            else if (input == 2) {
                user.editProfile();
                runApp();
            }

            //find candidates
            else if (input == 3) {
                datingApp();
                runApp();
            }

            //exit statement
            else if (input == 4) {
                System.out.println("\nCome back soon!");
            }

            else if (input == 0123){
                mode = 1;
                int inputAdmin = adminUI();

            }

            else{
                System.out.println("\nInvalid Option\n");
                runApp();
            }
        }
        //Admin console code/UI
        else if (mode == 1){
            int input = adminUI();
            //add person
            if (input == 1) {
                addPerson();
                runApp();
            }

            //remove person
            else if (input == 2) {
                removePerson();
                runApp();
            }

            //view user's profile
            else if (input == 3) {
                System.out.println(user);
                runApp();
            }

            //return to User console
            else if (input == 4) {
                mode = 0;
                System.out.println("\nReturning to User console...");
                runApp();
            }

            //exit statement
            else if (input == 5) {
                System.out.println("\nCome back soon!");
            }

            else{
                System.out.println("\nInvalid Option\n");
                runApp();
            }

        }
    }

    /**
     * Adds a person to all possible candidates
     * @author Darryl Rayray
     */
    public void addPerson(){
        allCandidates.add(new Person());
        adminUI();
    }

    /**
     * Removes a person from list of all candidates
     * @author Darryl Rayray
     */
    public void removePerson(){
        System.out.println("\nWhat is the name of the person you wish to remove from the application?:\n");
        System.out.print(getAllCandidates());
        System.out.print("\n > ");
        int ct = 0;
        String rem = in.nextLine();
        for(Person i : allCandidates) {
            if (i.getName() == rem) {
                allCandidates.remove(i);
                ct++;
            }
        }
        System.out.println("\n" + ct + " candidates removed.");
        updateTop10Candidates();
        adminUI();
    }

    /**
     * Returns all possible candidates/users on SOCALDS
     * @return A string of all candidates
     */
    public String getAllCandidates(){
        String ret = "\n\n List of all users(candidates):";
        for(Person i : allCandidates){
            ret += i.getName() + "\n";
        }
        return ret;
    }

    /**
     * Displays UserUI
     * @author Darryl Rayray
     * @return user input/choice
     */
    public int userUI(){
        System.out.println("\n    SOCAL DATING!    \n");
        System.out.println("Options: \n");
        System.out.println(" > View Profile (1) ");
        System.out.println(" > Edit Profile (2) ");
        System.out.println(" > Find Your SOCAL Lover! (3) ");
        System.out.println(" > Exit Application (4) ");
        System.out.print("\n > ");
        return in.nextInt();
    }

    /**
     * Displays AdminUI
     * @author Darryl Rayray
     * @return admin input/choice
     */
    public int adminUI(){
        System.out.println("    SOCAL DATING! Administrator Access    \n");
        System.out.println("Options: \n");
        System.out.println(" > Add Person/Candidate (1) ");
        System.out.println(" > Remove Person/Candidate (2) ");
        System.out.println(" > View User's Profile(3) ");
        System.out.println(" > Return to User console (4) ");
        System.out.println(" > Exit Application (5) ");
        System.out.print("\n > ");
        return in.nextInt();
    }

    /**
     * Reads a file of candidates into a list of all candidates, used for demo
     * @author Darryl Rayray
     * @throws IOException
     */
    public void readFile() throws IOException{
        Scanner fr = new Scanner(new File("C:\\Users\\dm2ra\\IdeaProjects\\DSA_Final-SOCALDS\\src\\candidates.txt"));
        int rep = fr.nextInt();
        fr.nextLine();
        int ct = 0;
        while(ct < rep && fr.hasNext()){
                String name = fr.nextLine();
                String description = fr.nextLine();
                ArrayList<String> socials = new ArrayList<String>(Arrays.asList(fr.nextLine().split(" ")));
                int sex = fr.nextInt();
                fr.nextLine();
                String gender = fr.nextLine();
                String hairColor = fr.nextLine();
                String eyeColor = fr.nextLine();
                String ethnicity = fr.nextLine();
                String race = fr.nextLine();
                int age = fr.nextInt();
                fr.nextLine();
                String height = fr.nextLine();
                int seriousRelationshipInt = fr.nextInt();
                fr.nextLine();
                String favoriteFood = fr.nextLine();
                int currentStudentInt = fr.nextInt();
                fr.nextLine();
                String occupation = fr.nextLine();

                //boolean inputs
                boolean seriousRelationship = false;
                if (seriousRelationshipInt == 1) {
                    seriousRelationship = true;
                }

                boolean currentStudent = false;
                if (currentStudentInt == 1) {
                    currentStudent = true;
                }

                Person curCand = new Person(name, description, socials, sex, gender, hairColor, eyeColor, ethnicity, race, age, height, seriousRelationship, favoriteFood, currentStudent, occupation);
                allCandidates.add(curCand);
                System.out.println(name + " added to SOCALDS!");

        }
        System.out.println(getAllCandidates());
        System.out.println("\n All candidates entered \n");
    }

    /**
     * Method for the main dating algorithm
     * @author Sreyas Prabu
     */
    public void datingApp(){
        System.out.println("\nFinding your SOCAL lover...\n");

        updateCompatibilityMap();
        updateTop10Candidates();

        System.out.println("Top 10 Candidates:");
        for (Person candidate : top10Candidates) {
            System.out.println(candidate.getName() + " - Compatibility: " + compatibilityMap.get(candidate));
        }

        System.out.println("\nReturning to main menu...");
    }

    /**
     * Method that updates the top 10 candidates compatible with the user
     * @author Sreyas Prabu
     */
    public void updateTop10Candidates(){
        top10Candidates.clear();

        allCandidates.sort((p1, p2) ->
                compatibilityMap.get(p2).compareTo(compatibilityMap.get(p1))
        );

        int count = 0;
        for (Person candidate : allCandidates) {
            if (count == 10) break;
            top10Candidates.add(candidate);
            count++;
        }
    }

    /**
     * Updates the compatibility map to make sure it stays up to date
     * @author Sreyas Prabu
     */
    public void updateCompatibilityMap(){
        compatibilityMap.clear();
        for (Person candidate : allCandidates) {
            int compatibilityScore = calculateCompatibility(user, candidate);
            compatibilityMap.put(candidate, compatibilityScore);
        }
    }

    /**
     * Method that calculates how compatible the user is to another candidate
     * @author Sreyas Prabu
     * @param user The user of the SOCALDS
     * @param candidate The other candidate
     * @return compatibility score
     */
    private int calculateCompatibility(Person user, Person candidate) {
        int score = 0;
        if (user.getGender().equalsIgnoreCase(candidate.getGender())) score += 10;
        if (user.getFavoriteFood().equalsIgnoreCase(candidate.getFavoriteFood())) score += 15;
        if (user.getEthnicity().equalsIgnoreCase(candidate.getEthnicity())) score += 5;
        if (Math.abs(user.getAge() - candidate.getAge()) <= 5) score += 20;
        return score;
    }

    /**
     * Method that finds the top candidates
     * @author Sreyas Prabu
     * @param user The user of the SOCALDS
     * @param allCandidates List of all the candidates
     */
    public void findTopCandidates(Person user, List<Person> allCandidates) {
        List<Person> topCandidates = algorithm.getTopCandidates(user, allCandidates);

        System.out.println("Top 10 Candidates:");
        for (Person candidate: topCandidates) {
            System.out.println(candidate.getName());
        }
    }


}
