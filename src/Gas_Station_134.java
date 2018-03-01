/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * Note:
 * The solution is guaranteed to be unique.
 */
public class Gas_Station_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] cha = new int[gas.length];
        for(int i = 0; i < cha.length; ++i)
            cha[i] = gas[i] - cost[i];
        int i = 0, j = cha.length-1, c = 0;
        while(i <= j){
            if(c >=0){
                c += cha[i];
                ++i;
            }else{
                c += cha[j];
                --j;
            }
        }
        if(c >=0) return (j+1)%cha.length;
        else return -1;
    }
}
