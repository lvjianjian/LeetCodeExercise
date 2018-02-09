/**
 * Created by zhongjianlv on 2018/2/9
 * <p>
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Count_Primes_204 {

    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] record = new boolean[n];
        int count = 1;
        for(int i = 2; i * 2 < n; ++i){
            record[i * 2] = true;
        }
        for(int i = 3; i < n; ++i){
            if(record[i] == false)
                ++count;
            for(int j = 3; i*j<n; j+=2)
                record[i*j] = true;
        }
        return count;
    }


    // time limit
    public int countPrimes2(int n) {
        int count = 0;
        for(int i = 2; i < n; ++i)
            if(isPrime(i))
                count+=1;
        return count;
    }

    private boolean isPrime(int k){
        int h = (int)Math.sqrt(k);
        for(int i = 2; i <=h; ++i){
            if(k % i == 0)
                return false;
        }
        return true;
    }
}
