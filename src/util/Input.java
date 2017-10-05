package util;
import java.util.Scanner;


public class Input {
    private Scanner scanner;
    private int getInt2;

    public static void main(String[] args) {
        Input input = new Input();
        System.out.println(input.getString(""));
        System.out.println(input.yesNo("Is Terrell mean?"));
        System.out.println(input.getInt(2, 10));
//          System.out.println(input.getInt);
//        System.out.println(input.getDouble(1, 20));
//        System.out.println(input.getDouble);

    }//end main

    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(String question) {
        System.out.println(question);
        String answer = scanner.nextLine();
        return answer;
    }
//
    public boolean yesNo(String answer){
        System.out.println(answer);
        answer = this.scanner.nextLine();

        if (answer.equals ("y") || answer.equals("yes")){
            return true;
        }else {
            return false;
        }
    }

    public int getInt(int min, int max){
//        System.out.println("Make selection between 0 through 5" ); //+ getInt *** Modify for Movie Application
        int intMinMax = Integer.parseInt(scanner.nextLine());

        if(intMinMax < min || intMinMax > max){
            System.out.println("Outside limit");
           intMinMax = getInt(min, max);
        }else {
//            System.out.println("You're good!"); removed for Movie Application
            return intMinMax;
        }
        return intMinMax;
    }

    public int getInt(){
        try { //risky code trying to run but could cause an error
            String userInput = scanner.nextLine(); //storing info in new String variable userInput
            return Integer.valueOf(userInput); //static method of the Integer class; takes a string and converts into integer
        }catch (NumberFormatException nfe){ //like function that take argument
            System.out.println("Invalid");
            return getInt();
        }
    }

//    public int getInt(){
//        if (this.scanner.hasNextInt()){
//            return this.scanner.nextInt();
//        }else{
//            System.out.println("Invalid");
//            scanner.nextLine();
//            return getInt();
//        }
//    }

    public double getDouble (double min, double max){
        System.out.println("Give me a double number between");
        double dIntMinMax = Double.parseDouble(scanner.nextLine());

        if(dIntMinMax < min || dIntMinMax > max) {
            System.out.println("Double outside");
            dIntMinMax = getDouble(min, max);
        }else{
            System.out.println("Double good");
            return dIntMinMax;
        }
        return dIntMinMax;
    }

    public double getDouble(){
        try {
            String userInput = scanner.nextLine(); //storing info in new String variable userInput
            return Double.valueOf(userInput);
        }catch (NumberFormatException nfe){
            System.out.println("Not a double");
            return getDouble();
        }
    }




//    public double getDouble(){
//        if (this.scanner.hasNextDouble()){
//            return this.scanner.nextDouble();
//        }else{
//            System.out.println("Not a double");
//            return getDouble();
//        }
//    }



}//end class Input
