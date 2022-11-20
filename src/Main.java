import java.sql.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Different operations: "); // prints the instructions for using the program to the user
        System.out.println("[Q to quit]");
        System.out.println("[A to add a new student]");
        System.out.println("[G to add a grade or grades]");
        System.out.println("[P to print all the GPAs]");
        ArrayList<Student> students = new ArrayList<>(); // creates a new arraylist to store all the students
        Scanner scanner = new Scanner(System.in); // starts the scanner to take user input
        while (true) {
            System.out.print("Choose operation: ");
            String operation = scanner.next(); // takes the wanted operation from the user as input (text)
            if (operation.equals("Q")) { // quits execution of the program
                System.out.println("Thank you for using GCS. Bye!");
                break;
            }
            if (operation.equals("A")) { // adds a new student
                System.out.print("Please give the name of the student: ");
                String studentName = scanner.next();
                students.add(new Student(studentName)); // uses a method of class Student to add new student to arraylist students
            }
            if (operation.equals("G")) { // adds grades for given student
                System.out.print("Please give the name of the student: ");
                String studentNameG = scanner.next();
                System.out.print("Please add grades for the student: ['.' to end writing] ");
                ArrayList<Integer> GradesIP = new ArrayList<>();
                while (scanner.hasNextInt())
                {
                    GradesIP.add(scanner.nextInt()); // dot is used to stop taking input because it is not a integer and the scanner.nextInt is waiting for an integer
                }
                sortStudents(students); // sorts students to a lexicographic order using function sortStudents
                if (findStudent(students, studentNameG) != null) { // tries to find the right student by name and makes sure that it is found to add grades for them
                    findStudent(students, studentNameG).addGrade(GradesIP);
                }
                else { // if there wasn't found a student with given name
                    System.out.println("You haven't added a student named " + studentNameG);
                }
                scanner.nextLine(); // takes the line being left after integers for the next loop to start normally
            }
            if (operation.equals("P")) { // prints all information about all students
                for (Student s : students){ // uses for-loop to print all information for each student
                    System.out.println(s.getName() + ": " + s.getGrades() + " - GPA: " + s.GPA());
                }
            }
        }
    }

    static Student[] ListToArray (ArrayList<Student> studentList){ // converts arraylists to arrays by copying all the objects of the list to the array, which is created and returned
        Student[] studentArray = new Student[studentList.size()]; // takes the converted list as input and gives out the created array
        for (int j = 0; j < studentList.size(); j++){
            studentArray[j] = studentList.get(j);
        }
        return studentArray;
    }

    static void ArrayToList (Student[] studentArray, ArrayList<Student> studentList) { // copies all the objects of the given array to the given list using method .set()
        for (int h = 0; h < studentArray.length; h++) { // takes array and list as input, doesn't give out anything, just modifies the list
            studentList.set(h, studentArray[h]);
        }
    }

    static void sortStudents (ArrayList<Student> studentList){ // sorts the students to lexicographic order using selection sort
        Student[] studentArray = ListToArray(studentList); // converts the given list to array
        for (int i = 0; i < studentArray.length - 1; i++){ // selection sort
            int smallestIndex = i;
            for (int k = i + 1; k < studentArray.length; k++){ // finds the smallest by lexicographic order object by name
                if (studentArray[smallestIndex].Name.compareTo(studentArray[k].Name) > 0){
                    smallestIndex = k;
                }
            }
            if (i != smallestIndex) { // swaps the smallest with an earlier object which is the first not in order
                Student temporary = studentArray[smallestIndex];
                studentArray[smallestIndex] = studentArray[i];
                studentArray[i] = temporary;
            }
        }
        ArrayToList(studentArray, studentList); // copies all the array's values to the given list
    }

    static Student findStudent (ArrayList<Student> studentList, String name){ // finds the student by name using binary search, takes the list to search from and the name to search for as parameters
        sortStudents(studentList); // sorts students into lexicographic order to use binary search
        Student[] studentArray = ListToArray(studentList); // converts list to array
        int h = 0;
        for (int b = studentArray.length / 2; b >= 1; b /= 2){ // binary search
            while (h + b < studentArray.length && studentArray[h + b].Name.compareTo(name) <= 0){
                h += b; // adds to the index halving the jumps until the given key is found or there is none
            }
        }
        if (studentArray[h].Name.equals(name)){
            return studentArray[h]; // returns the found object with the given name
        }
        else
            return null; // returns null if no matching object is found
    }
}


