/**
 * Created by zhongjianlv on 18-3-17.
 * <p>
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class Student_Attendance_Record_I_551 {
    public boolean checkRecord(String s) {
        int p = 0;
        int l = 0;
        for (char c : s.toCharArray()) {
            if(c == 'A') {
                ++p;
                if(p > 1) return false;
                l = 0;
            }else if(c  == 'L'){
                ++l;
                if(l > 2) return false;
            }else{
                l = 0;
            }
        }
        return true;
    }
}
