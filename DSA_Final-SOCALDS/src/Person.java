import java.lang.reflect.Array;
import java.util.*;

public class Person extends Attributes{
    //basic information
    private String name;
    private String description;
    private ArrayList<String> socials;
    private int compatibility;

    /**
     *
     */
    public Person(){
        socials = new ArrayList<String>();
        System.out.println("\nSet your base profile!:");
        editProfile();
    }

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

    public void setName(){
        System.out.print("Enter in desired First + Last name:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        editProfile();
    }

    public void setDescription(){
        System.out.print("Enter in a description about yourself:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        description = in.nextLine();
        editProfile();
    }

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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSocials() {
        String ret = "";
        for(String i : socials){
            ret += i + "\n";
        }
        return ret;
    }

    public String getAttributes(){
        return super.toString();
    }

    public String toString(){
        String ret = "";
        ret += "\n" + getName() + "'s Profile:\n";
        ret += "Description: " + getDescription() + "\n";
        ret += "Socials" + getSocials() + "\n";
        ret += getAttributes();
        return ret;
    }
}
