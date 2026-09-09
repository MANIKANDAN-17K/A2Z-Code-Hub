/*
Given an array of intervals arr[][] of size n, where arr[i] = [starti, endi] represents the start and end points of the ith interval, merge all overlapping intervals and return the resulting array of non-overlapping intervals.
Note: Two intervals [a, b] and [c, d] such that a ≤ c, are considered overlapping if  c ≤ b.

Examples:

Input: arr[][] = [[1, 3], [2, 4], [6, 8], [9, 10]]
Output: [[1, 4], [6, 8], [9, 10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1, 3] and [2, 4] which on merging will become [1, 4]. Therefore we will return [[1, 4], [6, 8], [9, 10]].

Input: arr[][] = [[6, 8], [1, 9], [2, 4], [4, 7]]
Output: [[1, 9]]
Explanation: In the given intervals all the intervals overlap with the interval [1, 9]. Therefore we will return [1, 9].

Constraints:
1 ≤ n ≤ 105
0 ≤ starti ≤ endi ≤ 106

*/

class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        Arrays.sort(arr,(x,y)-> Integer.compare(x[0],y[0]));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(arr[0][0]);
        temp1.add(arr[0][1]);
        list.add(temp1);
        for(int i = 1;i<arr.length;i++){
            ArrayList<Integer> last = list.get(list.size()-1);
            int[] curr = arr[i];
            if(curr[0] <= last.get(1)){
                last.set(1,Math.max(curr[1],last.get(1)));
            }else{
                ArrayList<Integer> temp =new ArrayList<>();
                temp.add(curr[0]);
                temp.add(curr[1]);
                list.add(temp);
            }
        }
        return list;
        
    }
}
