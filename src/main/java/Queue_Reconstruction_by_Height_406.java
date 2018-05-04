import java.util.*;

/**
 * Created by zhongjianlv on 2018/2/8
 * <p>
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Queue_Reconstruction_by_Height_406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0]? (o1[1] - o2[1]):o2[0] - o1[0];
            }
        });

        List<int[]> r = new ArrayList<>();
        for(int[] temp:people){
            r.add(temp[1],temp);
        }
        return r.toArray(new int[people.length][2]);
    }


    //LinkedList time limit
    //ArrayList ok but slow
    public int[][] reconstructQueue2(int[][] people) {
        int n = people.length;
        int[][] result = new int[n][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        for(int i =0;i <n;++i)
            queue.add(people[i]);
        List<int[]> r = new ArrayList<>();
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int k = temp[1];
            int h = temp[0];
            int i = 0;
            while(k != 0){
                if(i < r.size()){
                    if(r.get(i)[0] >= h)
                        --k;
                }else{
                    break;
                }
                ++i;
            }
            while(i < r.size()){
                if(h > r.get(i)[0])
                    ++i;
                else
                    break;
            }
            r.add(i,temp);
        }
        for(int i = 0 ; i < r.size();++i){
            result[i] = r.get(i);
        }
        return result;
    }

}
