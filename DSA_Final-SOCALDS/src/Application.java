import java.util.*;


public class Application {
    private Map<Person, Integer> compatibilityMap;
    private Queue<Person> top10Candidates;
    private ArrayList<Person> allCandidates;
    private Scanner in;
    private Person user;
    private int mode;

    public Application(){
        compatibilityMap = new HashMap<Person, Integer>();
        top10Candidates = new LinkedList<Person>();
        allCandidates = new ArrayList<Person>();
        in = new Scanner(System.in);
        System.out.println("Welcome to SOCAL DATING! Please fill out the following information!");
        user = new Person();
        mode = 0;
    }

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

    public void addPerson(){
        allCandidates.add(new Person());
        adminUI();
    }

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

    public String getAllCandidates(){
        String ret = "\n\n List of all users(candidates):";
        for(Person i : allCandidates){
            ret += i.getName() + "\n";
        }
        return ret;
    }

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

    public void datingApp(){

    }

    public void updateTop10Candidates(){

    }

    public void updateCompatibilityMap(){

    }


}
