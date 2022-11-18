import java.sql.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Different operations: ");
        System.out.println("[Q to quit]");
        System.out.println("[A to add a new student]");
        System.out.println("[G to add a grade or grades]");
        System.out.println("[P to print all the GPAs]");
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose operation: ");
            String operation = scanner.next();
            if (operation.equals("Q")) {
                System.out.println("Thank you for using GCS. Bye!");
                break;
            }
            if (operation.equals("A")) {
                System.out.print("Please give the name of the student: ");
                String studentName = scanner.next();
                students.add(new Student(studentName));
            }
            if (operation.equals("G")) {
                System.out.print("Please give the name of the student: ");
                String studentNameG = scanner.next();
                System.out.print("Please add grades for the student: ['.' to end writing] ");
                ArrayList<Integer> GradesIP = new ArrayList<>();
                while (scanner.hasNextInt())
                {
                    GradesIP.add(scanner.nextInt());
                }
                sortStudents(students);
                if (findStudent(students, studentNameG) != null) {
                    findStudent(students, studentNameG).addGrade(GradesIP);
                }
                else {
                    System.out.println("You haven't added a student named " + studentNameG);
                }
                scanner.nextLine();
            }
            if (operation.equals("P")) {
                for (Student s : students){
                    System.out.println(s.getName() + ": " + s.getGrades() + " - GPA: " + s.GPA());
                }
            }
        }
    }

    static Student[] ListToArray (ArrayList<Student> studentList){
        Student[] studentArray = new Student[studentList.size()];
        for (int j = 0; j < studentList.size(); j++){
            studentArray[j] = studentList.get(j);
        }
        return studentArray;
    }

    static void ArrayToList (Student[] studentArray, ArrayList<Student> studentList) {
        for (int h = 0; h < studentArray.length; h++) {
            studentList.set(h, studentArray[h]);
        }
    }

    static void sortStudents (ArrayList<Student> studentList){
        Student[] studentArray = ListToArray(studentList);
        for (int i = 0; i < studentArray.length - 1; i++){
            int smallestIndex = i;
            for (int k = i + 1; k < studentArray.length; k++){
                if (studentArray[smallestIndex].Name.compareTo(studentArray[k].Name) > 0){
                    smallestIndex = k;
                }
            }
            if (i != smallestIndex) {
                Student temporary = studentArray[smallestIndex];
                studentArray[smallestIndex] = studentArray[i];
                studentArray[i] = temporary;
            }
        }
        ArrayToList(studentArray, studentList);
    }

    static Student findStudent (ArrayList<Student> studentList, String name){
        sortStudents(studentList);
        Student[] studentArray = ListToArray(studentList);
        int h = 0;
        for (int b = studentArray.length / 2; b >= 1; b /= 2){
            while (h + b < studentArray.length && studentArray[h + b].Name.compareTo(name) <= 0){
                h += b;
            }
        }
        if (studentArray[h].Name.equals(name)){
            return studentArray[h];
        }
        else
            return null;
    }
}
    class Student {
        public Student(String Name) {
            this.Name = Name;
            this.Grades = new ArrayList<>();
        }

        public String getName () {
            return Name;
        }

        public ArrayList<Integer> getGrades () {
            return Grades;
        }
        public void addGrade(ArrayList<Integer> gradesIP){
            for (Integer g : gradesIP){
                Grades.add(g);
            }
        }

        public double GPA() {
            double sum = 0;
            for (int s : Grades) {
                sum += s;
            }
            if (Grades.size() > 0) {
                return sum / Grades.size();
            }
            else {
                return sum / 1;
            }
        }

        public String Name;
        public ArrayList<Integer> Grades;
    }


