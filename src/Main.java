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
        System.out.println("[B to find the best student]");
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose operation:  ");
            String operation = scanner.next();
            if (operation.equals("Q")) { // toimii
                System.out.println("Thank you for using GCS. Bye!");
                break;
            }
            if (operation.equals("A")) {// constructor, luo uusi oppilas-olio // toimii
                System.out.print("Please give the name of the student: ");
                String studentName = scanner.next();
                students.add(new Student(studentName));
            }
            if (operation.equals("G")) {// lisää uusi arvosana oppilas olioon // ei toimi
                System.out.print("Please give the name of the student: ");
                String studentNameG = scanner.next();
                System.out.print("Please add grades for the student: ['.' to end writing] ");
                ArrayList<Integer> GradesIP = new ArrayList<>();
                while (scanner.hasNextInt())
                {
                    GradesIP.add(scanner.nextInt());
                }
                // studentNameG.addGrade(GradesIP);
            }
            if (operation.equals("P")) { // toimii
                for (Student s : students){
                    System.out.println(s.getName() + ": " + s.getGrades() + "// GPA: " + s.GPA());
                }
            }
            if (operation.equals("B")) { // löydä paras oppilas
                System.out.print("The best student is: ");
            }
        }
    }
    static void sortStudents (ArrayList<Student> studentlist){ // järjestää oppilaat nimen mukaiseen aakkosjärjestykseen
        for (int i = 0; i < studentlist.size() - 1; i++){
            int smindex = i;
            for (int i = 0; i < studentlist.size(); i++){

            }
        }
    }

    static Student findStudent (ArrayList<Student> studentlist, String name){ // etsii oikean oppilasolion nimen perusteella binäärihaulla

    }
}
    class Student {
        public Student(String Name) {
            this.Name = Name;
            ArrayList<Integer> Grades = new ArrayList<>();
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
            int sum = 0;
            for (int s : Grades) {
                sum += s;
            }
            return sum / Grades.size();
        }

        public String Name;
        public ArrayList<Integer> Grades;
    }


