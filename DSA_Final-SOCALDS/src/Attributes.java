import java.util.Scanner;

/**
 * Attributes class for the person class
 * @author Darryl Rayray
 */
public class Attributes {

    //12 attributes
    int sex;
    String gender;
    String hairColor;
    String eyeColor;
    String ethnicity;
    String race;
    int age;
    String height;
    boolean seriousRelationship;
    String favoriteFood;
    boolean currentStudent;
    String occupation;


    /**
     * Method that displays the UI and allows the user to edit their displayed attributes
     * @author Darryl Rayray
     */
    public void editAttributes(){
        System.out.print("\nEdit: " +
                "\n > Sex (1) " +
                "\n > Gender (2) " +
                "\n > Hair Color (3)" +
                "\n > Eye Color (4)" +
                "\n > Ethnicity (5)" +
                "\n > Race (6)" +
                "\n > Age (7)" +
                "\n > Height (8)" +
                "\n > Looking for a serious relationship (9)" +
                "\n > Favorite Food (10)" +
                "\n > Currently in college/other form of education (11)" +
                "\n > Occupation (12)" +
                "\n > Back to homepage (13)" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if(input == 1){setSex();}
        else if(input == 2){setGender();}
        else if(input == 3){setHairColor();}
        else if(input == 4){setEyeColor();}
        else if(input == 5){setEthnicity();}
        else if(input == 6){setRace();}
        else if(input == 7){setAge();}
        else if(input == 8){setHeight();}
        else if(input == 9){setSeriousRelationship();}
        else if(input == 10){setFavoriteFood();}
        else if(input == 11){setCurrentStudent();}
        else if(input == 12){setOccupation();}
        else{System.out.println("\nGoing back to homepage...\n\n");}
    }

    /**
     * setter method for sex with user input
     * @author Darryl Rayray
     */
    public void setSex(){
        System.out.print("\nEnter in sex (0 = Male, 1 = Female, 3 = Unisex):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        sex = in.nextInt();
        editAttributes();
    }

    /**
     * setter method for gender with user input
     * @author Darryl Rayray
     */
    public void setGender(){
        System.out.print("\nEnter in your gender:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        gender = in.nextLine();
        editAttributes();
    }

    /**
     * setter method for hair color with user input
     * @author Darryl Rayray
     */
    public void setHairColor(){
        System.out.print("\nEnter in your hair color:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        hairColor = in.nextLine();
        editAttributes();
    }

    /**
     * setter method for eye color with user input
     * @author Darryl Rayray
     */
    public void setEyeColor(){
        System.out.print("Enter in your eye color:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        eyeColor = in.nextLine();
        editAttributes();
    }

    /**
     * setter method for ethnicity with user input
     * @author Darryl Rayray
     */
    public void setEthnicity(){
        System.out.print("\nEnter in your ethnicity:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        ethnicity = in.nextLine();
        editAttributes();
    }

    /**
     * setter method for race with user input
     * @author Darryl Rayray
     */
    public void setRace(){
        System.out.print("\nEnter in your race:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        race = in.nextLine();
        editAttributes();
    }

    /**
     * setter method for age with user input
     * @author Darryl Rayray
     */
    public void setAge(){
        System.out.print("\nEnter in your age:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if(input < 18){
            System.out.println("\n Users can only be 18+ \n");
            setAge();
        }
        editAttributes();
    }

    /**
     * setter method for height with user input
     * @author Darryl Rayray
     */
    public void setHeight(){
        System.out.print("\nEnter in your height in feet:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        height = in.nextLine();
        editAttributes();
    }

    /**
     * setter method for serious relationship with user input
     * @author Darryl Rayray
     */
    public void setSeriousRelationship(){
        System.out.print("\nAre you looking for a serious relationship? (1 = Yes | 0 = No):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        seriousRelationship = (in.nextInt() == 1);
        editAttributes();
    }

    /**
     * setter method for favorite food with user input
     * @author Darryl Rayray
     */
    public void setFavoriteFood(){
        System.out.print("\nEnter in your favorite food:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        favoriteFood = in.nextLine();
        editAttributes();
    }

    /**
     * setter method for current student with user input
     * @author Darryl Rayray
     */
    public void setCurrentStudent(){
        System.out.print("\nAre you a current student? (1 = Yes | 0 = No):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        currentStudent = (in.nextInt() == 1);
        editAttributes();
    }

    /**
     * setter method for occupation with user input
     * @author Darryl Rayray
     */
    public void setOccupation(){
        System.out.print("\nEnter in your current occupation (put \"N/A\" for no occupation):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        occupation = in.nextLine();
        editAttributes();
    }

    /**
     * getter method for sex
     * @author Darryl Rayray
     */
    public String getSex() {
        if (sex == 0){return "M";}
        else if (sex == 1){return "F";}
        else {return "U";}
    }

    /**
     * getter method for gender
     * @author Darryl Rayray
     */
    public String getGender() {
        return gender;
    }

    /**
     * getter method for hair color
     * @author Darryl Rayray
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * getter method for eye color
     * @author Darryl Rayray
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * getter method for ethnicity
     * @author Darryl Rayray
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * getter method for race
     * @author Darryl Rayray
     */
    public String getRace() {
        return race;
    }

    /**
     * getter method for age
     * @author Darryl Rayray
     */
    public int getAge() {
        return age;
    }

    /**
     * getter method for height
     * @author Darryl Rayray
     */
    public String getHeight() {
        return height;
    }

    /**
     * getter method for serious relationship
     * @author Darryl Rayray
     */
    public String getSeriousRelationship() {
        if(seriousRelationship){return "Yes";}
        else{return "No";}
    }

    /**
     * getter method for favorite food
     * @author Darryl Rayray
     */
    public String getFavoriteFood() {
        return favoriteFood;
    }

    /**
     * getter method for current student
     * @author Darryl Rayray
     */
    public String getCurrentStudent() {
            if(currentStudent){return "Yes";}
            else{return "No";}
        }

    /**
     * getter method for occupation
     * @author Darryl Rayray
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * to string method for attributes
     * @return user's attributes
     */
    @Override
    public String toString() {
        String ret = "";
        ret += "Sex: " + getSex() + "\n";
        ret += "Gender: " + gender + "\n";
        ret += "Hair Color: " + hairColor + "\n";
        ret += "Eye Color: " + eyeColor + "\n";
        ret += "Ethnicity: " + ethnicity + "\n";
        ret += "Race: " + race + "\n";
        ret += "Age: " + age + "\n";
        ret += "Height: " + height + "\n";
        ret += "Looking for a serious relationship: " + getSeriousRelationship() + "\n";
        ret += "Favorite Food: " + favoriteFood + "\n";
        ret += "Is a current student: " + getCurrentStudent() + "\n";
        ret += "Occupation: " + getOccupation() + "\n";
        return ret;
    }
}
