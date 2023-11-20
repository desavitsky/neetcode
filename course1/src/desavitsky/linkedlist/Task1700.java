package desavitsky.linkedlist;

import java.util.ArrayDeque;

//Number of Students Unable to Eat Lunch
public class Task1700 {

    public static void main(String[] args) {
        System.out.println(countStudents2(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

    public static int countStudents2(int[] students, int[] sandwiches) {
        var zeros = 0;
        for (var st : students) {
            if (st == 0) zeros++;
        }
        var ones = students.length - zeros;
        for (var snd : sandwiches) {
            if (snd == 0 && zeros != 0) {
                zeros--;
            } else if (snd == 1 && ones != 0) {
                ones--;
            } else return zeros + ones;
        }
        return 0;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        var studentsQueue = new ArrayDeque<Integer>(students.length);
        var sandwichesQueue = new ArrayDeque<Integer>(sandwiches.length);
        for (var st : students) {
            studentsQueue.add(st);
        }
        for (var snd : sandwiches) {
            sandwichesQueue.add(snd);
        }

        var consecutiveRejects = 0;

        while (!studentsQueue.isEmpty() && (consecutiveRejects < studentsQueue.size())) {
            var student = studentsQueue.removeFirst();
            var sandwich = sandwichesQueue.peekFirst();
            if (student.equals(sandwich)) {
                sandwichesQueue.removeFirst();
                consecutiveRejects = 0;
            } else {
                studentsQueue.add(student);
                consecutiveRejects++;
            }
        }
        return studentsQueue.size();
    }
}


