import javax.swing.*;
import java.util.Arrays;

public class logisticsProject {

        //input of new package
        static void Input (int[][]argInput) {
            int number;
            int width, length, height;

            number=Integer.parseInt(JOptionPane.showInputDialog("Please enter the package number 1-75"));

            //if the number is valid, but not used yet, the data is entered
            if (number>0 && number<=argInput.length)
                if(argInput[number-1][0]==0) {
                    //assign number
                    argInput[number-1][0]=number;
                    //read data
                    width=Integer.parseInt(JOptionPane.showInputDialog("Width of package(cm)"));
                    argInput[number-1][1]=width;
                    length=Integer.parseInt(JOptionPane.showInputDialog("Length of package(cm)"));
                    argInput[number-1][2]=length;
                    height=Integer.parseInt(JOptionPane.showInputDialog("Height of package(cm)"));
                    argInput[number-1][3]=height;
                    System.out.println("The package " + number + " has the following values: " + width + "cm width, " + length + "cm length, " + height + "cm height." );
                }else {
                    System.out.println("Invalid package number");
                }
        }

        // package existing data
        static void show (int[][]argShow) {
            int number;
            number=Integer.parseInt(JOptionPane.showInputDialog("Please enter the requested package number."));
            for(int i =0; i < argShow.length; i++) {
                if (number>0 && number<=argShow.length && argShow[i][0]==number) {
                    System.out.println("The package values are: " + Arrays.toString(argShow[i]));
                    return;
                }
            }

            System.out.println("Invalid package number");
        }

        //show all package entries
        static void list (int[][]argList) {
            for (int kistenIndex = 0;kistenIndex < argList.length; kistenIndex++) {
                if(argList[kistenIndex][0] == 0) {
                    continue;
                }

                for (int detailsIndex=0;detailsIndex<argList[kistenIndex].length;detailsIndex++) {
                    System.out.println(argList[kistenIndex][detailsIndex]); }
            }
        }

        // delete package
        static void delete(int[][] argDelete) {
            int number;
            //enter package number
            do {
                number=Integer.parseInt(JOptionPane.showInputDialog("Please enter the package number you wish do delete."));
                //check if package exists
                if(number>0 && number<=argDelete.length)
                    if(argDelete[number-1][0]==number){

                        argDelete[number-1][0]=0;
                        System.out.println("The package was successfully deleted.");
                    }

                    else {
                        System.out.println("\nThe package " + number + " does not exist");
                    }
            }
            while(number<=0 || number>argDelete.length);
        }
        //Change package
        static void change(int[][]argChange) {
            int number;
            int width, length, height;
            //enter package number
            do {
                number=Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of the package you wish to change!"));

                //if package valid
                if(number>0 && number<=argChange.length)
                    if(argChange[number-1][0]!=0){

                        //read value
                        width=Integer.parseInt(JOptionPane.showInputDialog("Package width(cm)"));
                        argChange[number-1][1]=width;


                        length=Integer.parseInt(JOptionPane.showInputDialog("Package length(cm)"));
                        argChange[number-1][2]=length;


                        height=Integer.parseInt(JOptionPane.showInputDialog("Package height(cm)"));
                        argChange[number-1][3]=height;
                        System.out.println("The package values have been edited");

                    }

                    else {
                        System.out.println("\nThe package number is invalid or not assigned");
                    }
            }
            while(number<=0 || number>argChange.length);
        }

        public static void main(String[] args) {
            //union of Arrays
            int [][] warehouseManagement = new int [75][4];

            //function select
            String readFunction;
            char function;
            while (true) {
                System.out.println("You have the following options to choose from: \n");
                System.out.println("A \t Add a new package");
                System.out.println("B \t Delete a package");
                System.out.println("C \t Change a package");
                System.out.println("D \t Show a specific package");
                System.out.println("E \t Show all packages");
                System.out.println("F \t End program");
                readFunction=JOptionPane.showInputDialog("Please choose an option");
                function = readFunction.charAt(0);

                //Auswahl auswerten
                switch(function) {
                    case 'a':
                    case 'A':
                        System.out.println("\nYou have selected \"Add a new package");
                        Input(warehouseManagement);
                        break;

                    case 'b':
                    case 'B':
                        System.out.println("\nYou have selected \"Delete a package");
                        delete(warehouseManagement);
                        break;

                    case 'c':
                    case 'C':
                        System.out.println("\nYou have selected \"Change a package");
                        change(warehouseManagement);
                        break;

                    case 'd':
                    case 'D':
                        System.out.println("\nYou have selected \"Show a specific package");
                        show(warehouseManagement);
                        break;

                    case 'e':
                    case 'E':
                        System.out.println("\nYou have selected \"Show all packages");
                        list(warehouseManagement);
                        break;

                    // "F" to end the program without crash
                    case 'f':
                    case 'F':
                        return;
                }
            }
        }
    }


