import java.util.Scanner;

public class Attributes {

    //12 attributes
    private int sex;
    private String gender;
    private String hairColor;
    private String eyeColor;
    private String ethnicity;
    private String race;
    private int age;
    private String height;
    private boolean seriousRelationship;
    private String favoriteFood;
    private boolean currentStudent;
    private String occupation;

    public Attributes() {
        /**
       System.out.println("\nSet your other attributes!:\n");
       setSex();
       setGender();
       setHairColor();
       setEyeColor();
       setEthnicity();
       setRace();
       setAge();
       setHeight();
       setSeriousRelationship();
       setFavoriteFood();
       setCurrentStudent();
       setOccupation();
         */
    }

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


    public void setSex(){
        System.out.print("\nEnter in sex (0 = Male, 1 = Female, 3 = Unisex):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        sex = in.nextInt();
        editAttributes();
    }

    public void setGender(){
        System.out.print("\nEnter in your gender:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        gender = in.nextLine();
        editAttributes();
    }

    public void setHairColor(){
        System.out.print("\nEnter in your hair color:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        hairColor = in.nextLine();
        editAttributes();
    }

    public void setEyeColor(){
        System.out.print("Enter in your eye color:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        eyeColor = in.nextLine();
        editAttributes();
    }

    public void setEthnicity(){
        System.out.print("\nEnter in your ethnicity:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        ethnicity = in.nextLine();
        editAttributes();
    }

    public void setRace(){
        System.out.print("\nEnter in your race:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        race = in.nextLine();
        editAttributes();
    }

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

    public void setHeight(){
        System.out.print("\nEnter in your height in feet:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        height = in.nextLine();
        editAttributes();
    }

    public void setSeriousRelationship(){
        System.out.print("\nAre you looking for a serious relationship? (1 = Yes | 0 = No):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        seriousRelationship = (in.nextInt() == 1);
        editAttributes();
    }

    public void setFavoriteFood(){
        System.out.print("\nEnter in your favorite food:" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        favoriteFood = in.nextLine();
        editAttributes();
    }

    public void setCurrentStudent(){
        System.out.print("\nAre you a current student? (1 = Yes | 0 = No):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        currentStudent = (in.nextInt() == 1);
        editAttributes();
    }

    public void setOccupation(){
        System.out.print("\nEnter in your current occupation (put \"N/A\" for no occupation):" +
                "\n > ");
        Scanner in = new Scanner(System.in);
        occupation = in.nextLine();
        editAttributes();
    }

    public String getSex() {
        if (sex == 0){return "M";}
        else if (sex == 1){return "F";}
        else {return "U";}
    }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    public String getSeriousRelationship() {
        if(seriousRelationship){return "Yes";}
        else{return "No";}
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getCurrentStudent() {
            if(currentStudent){return "Yes";}
            else{return "No";}
        }

    public String getOccupation() {
        return occupation;
    }

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
