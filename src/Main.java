import java.sql.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose operation: [Q to quit, A to add a student, G to add a grade or grades, P to print all the GPAs] ");
            String operation = scanner.next();
            if (operation.equals("Q")) {
                System.out.println("Thank you for using GCS. Bye!");
                break;
            }
            if (operation.equals("A")) {// constructor, luo uusi oppilas-olio
                System.out.print("Please give the name of the student: ");
                String studentName = scanner.next();
                Student student1 = new Student(studentName);
            }
            if (operation.equals("G")) {// lisää uusi arvosana oppilas olioon
                System.out.print("Please give the name of the student: ");
                String studentNameG = scanner.next();
                System.out.print("Please add grades for the student: ");
                ArrayList<Integer> GradesIP = new ArrayList<>();
                while (scanner.hasNextInt())
                {
                    GradesIP.add(scanner.nextInt());
                    for (Integer v : GradesIP){
                        System.out.println(v);
                    }
                }
                System.out.println("hip");
                for (Integer v : GradesIP){
                    System.out.println(v);
                }
            }
            if (operation.equals("P")) {
                // print all students and their GPAs
            }
        }
    }
}
    class Student {
        public Student(String Name) {
            this.Name = Name;
            ArrayList<Integer> Grades = new ArrayList<>();
        }

        public void addGrade(ArrayList<Integer> gradesIP){
            for (Integer g : gradesIP){
                Grades.add(g);
            }
        }

        public double GPA() {
            int sum = 0;
            for (int s : Grades) {
                sum += s;
            }
            return sum / Grades.size();
        }

        public String Name;
        public ArrayList<Integer> Grades;
    }


