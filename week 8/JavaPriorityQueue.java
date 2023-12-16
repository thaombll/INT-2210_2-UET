
import java.util.*;

class Student {
    private int id;
    private String firstName;
    private double cgpa;

    public Student() {
    }

    public Student(int id, String firstName, double cgpa) {
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class CustomComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        int cgpaSt1 = (int) (st1.getCgpa() * 1000);
        int cgpaSt2 = (int) (st2.getCgpa() * 1000);

        if (cgpaSt1 != cgpaSt2) {
            return Integer.compare(cgpaSt2, cgpaSt1); 
        }

        String nameSt1 = st1.getFirstName();
        String nameSt2 = st2.getFirstName();
        if (!nameSt1.equals(nameSt2)) {
            return nameSt1.compareTo(nameSt2); 
        }

        return Integer.compare(st1.getId(), st2.getId()); 
    }
}

public class JavaPriorityQueue{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfQuery = Integer.parseInt(in.next());

        PriorityQueue<Student> studentList = new PriorityQueue<>(new CustomComparator());

        for (int i = 0; i < numOfQuery; ++i) {
            String operation = in.next();

            if (operation.equals("ENTER")) {
                String firstName = in.next();
                double cgpa = in.nextDouble();
                int id = in.nextInt();

                Student tmpStudent = new Student(id, firstName, cgpa);
                studentList.add(tmpStudent);
            } else {
                studentList.poll();
            }
        }
        if ( studentList.isEmpty()) System.out.println ("EMPTY");
        else
        {
            while (!studentList.isEmpty()) {
                System.out.println(studentList.poll().getFirstName());
            }
        }
        in.close();
    }
}
