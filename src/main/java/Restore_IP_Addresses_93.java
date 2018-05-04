import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-19.
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Restore_IP_Addresses_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        int l = s.length();
        if(l < 4 || l > 12) return result;
        for(int i = 1; i < l-2; ++i)
            for(int j = i+1; j < l - 1; ++j)
                for(int k = j+1; k < l; ++k){
                    String s1 = s.substring(0,i);
                    if(!isValid(s1)) continue;
                    String s2 = s.substring(i,j);
                    if(!isValid(s2)) continue;
                    String s3 = s.substring(j,k);
                    if(!isValid(s3)) continue;
                    String s4 = s.substring(k,l);
                    if(!isValid(s4)) continue;
                    result.add(s1+"."+s2+"."+s3+"."+s4);
                }
        return result;
    }

    private boolean isValid(String s){
        int temp = Integer.valueOf(s);
        if(temp<0 || temp> 255) return false;
        if(s.length() > 1 && s.charAt(0) == '0') return false;
        return true;
    }

    public static void main(String[] args) {
        Restore_IP_Addresses_93 restore_ip_addresses_93 = new Restore_IP_Addresses_93();
        System.out.println(restore_ip_addresses_93.isValid("01"));
    }
}
