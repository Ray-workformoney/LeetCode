package Array;

/**
 * @author huangrui
 * @date 2022/8/19
 */
public class BusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
           if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
               res++;
           }
        }
        return res;
    }

    public static void main(String[] args) {
        BusyStudent busyStudent = new BusyStudent();
        System.out.println(busyStudent.busyStudent(new int[] {4}, new int[] {4}, 4));
    }
}
