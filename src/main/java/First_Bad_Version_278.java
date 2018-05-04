/**
 * Created by zhongjianlv on 18-2-27.
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class First_Bad_Version_278 {

    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while(l <= h){
            int mid = l + (h -l) /2;
            if(isBadVersion(mid)){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int i){
        return true;
    }
}
