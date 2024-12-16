import java.lang.reflect.Array;
import java.util.*;

/**
 * Class that represents a candidate/user within SOCALDS, includes attributes and other descriptors
 * @author Darryl Rayray
 */
public class Person extends Attributes{
    //basic information
    private String name;
    private String description;
    private ArrayList<String> socials;
    private int compatibilityScore;

    /**
     * Constructor for Person object, sets up base profile for the user
     * @author Darryl Rayray
     */
    public Person(){
        socials = new ArrayList<String>();
        System.out.println("\nSet your base profile!:");
        editProfile();
    }

    /**
     * Constructor for reading in files, more automated way of initialization
     * @author Darryl Rayray
     * @param name name of user
     * @param description description of the user
     * @param socials social handles of the user
     * @param sex user's sex
     * @param gender user's gender
     * @param hairColor user's hair color
     * @param eyeColor user's eyeColor
     * @param ethnicity user's ethnicity
     * @param race user's race
     * @param age user's age
     * @param height user's height
     * @param seriousRelationship is user looking for a serious relationship
     * @param favoriteFood user's favorite food
     * @param currentStudent is user a current student
     * @param occupation user's occupation
     */
    public Person(String name, String description, ArrayList<String> socials, int sex, String gender, String hairColor, String eyeColor, String ethnicity, String race, int age, String height, boolean seriousRelationship, String favoriteFood, boolean currentStudent, String occupation){
        this.name = name;
        this.description = description;
        this.socials = socials;
        super.sex = sex;
        super.gender = gender;
        super.hairColor = hairColor;
        super.eyeColor = eyeColor;
        super.ethnicity = ethnicity;
        super.race = race;
        super.age = age;
        super.height = height;
        super.seriousRelationship = seriousRelationship;
        super.favoriteFood = favoriteFood;
        super.currentStudent = currentStudent;
        super.occupation = occupation;
    }

    /**
     * Displays UI for editing user's profile
     * @author Darryl Rayray
     */
    public void editProfile(){
        System.out.print("\nEdit: " +
                "\n > Name (1) " +
                "\n > Description (2) " +
                "\n > Socials (3)" +
                "\n > Other Attributes (4)" +
                "\n > Back to homepage (5)" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if(input == 1){setName();}
        else if(input == 2){setDescription();}
        else if(input == 3){setSocials();}
        else if(input == 4){super.editAttributes();}
        else{System.out.println("\nGoing back to homepage...\n");}
    }

    /**
     * sets name using user input
     * @author Darryl Rayray
     */
    public void setName(){
        System.out.print("Enter in desired First + Last name:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        editProfile();
    }

    /**
     * sets user description using user input
     * @author Darryl Rayray
     */
    public void setDescription(){
        System.out.print("Enter in a description about yourself:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        description = in.nextLine();
        editProfile();
    }

    /**
     * set user socials using user input
     * @author Darryl Rayray
     */
    public void setSocials(){
        socials.clear();
        System.out.print("Enter in 3 of your socials:\n");
        Scanner in = new Scanner(System.in);
        String input = "";
        for(int i = 0; i < 3; i++) {
            System.out.print(" > ");
            input = in.nextLine();
            socials.add(input);
        }
        editProfile();
    }

    /**
     * Sets the compatible score of the user
     * @param score score to be set to
     */
    public void setCompatScore(int score){
        compatibilityScore = score;
    }

    /**
     * Return the compatibility score
     * @return user's compatibility score
     */
    public int getCompatibilityScore(){
        return compatibilityScore;
    }

    /**
     * getter method for name
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for description
     * @return user's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * getter method for socials
     * @return user's socials
     */
    public String getSocials() {
        String ret = "";
        for(String i : socials){
            ret += i + "\n";
        }
        return ret;
    }

    /**
     * getter method for displaying user's attributes
     * @return user's attributes
     */
    public String getAttributes(){
        return super.toString();
    }

    /**
     * to string method that returns the user's details/profile
     * @return the user's details
     */
    @Override
    public String toString(){
        String ret = "";
        ret += "\n" + name + "'s Profile:\n";
        ret += "Description: " + getDescription() + "\n";
        ret += "Socials:\n" + getSocials() + "\n";
        ret += getAttributes();
        return ret;
    }
}
