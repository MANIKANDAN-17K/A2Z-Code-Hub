/*
An alien language uses the lowercase English alphabet, but the order of its letters is unknown. You are given an array of strings words[] that is claimed to be sorted lexicographically according to the rules of the alien language.

Determine the order of the letters in the alien alphabet. If a valid ordering exists, return a string containing all unique letters in lexicographical order according to the alien language. Otherwise, return an empty string.

If a string s1 is lexicographically smaller than a string s2, and the first position at which they differ contains letter a in s1 and letter b in s2, then a must appear before b in the alien alphabet.

Note: The driver code prints true if the returned order is valid; otherwise, it prints false.

Examples:

Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
Output: true
Explanation: A possible correct order of letters in the alien dictionary is "bdac".
The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
So, 'b' -> 'd' -> 'a' -> 'c' is a valid ordering.

Input: words[] = ["caa", "aaa", "aab"]
Output: true
Explanation: A possible correct order of letters in the alien dictionary is "cab".
The pair "caa" and "aaa" suggests 'c' appears before 'a'.
The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary. 
So, 'c' -> 'a' -> 'b' is a valid ordering.

Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: No valid ordering of letters is possible.
The pair "ab" and "ef" suggests "a" appears before "e".
The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.

Constraints:
1 ≤ words.size() * words[i].size()  ≤ 106
words[i] consists only of lowercase English letters.
*/
class Solution {
    
    public ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[26];
        for(int i = 0;i<26;i++){
            for(int nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < 26;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            for(int idx : adj.get(node)){
                indegree[idx]--;
                if(indegree[idx] == 0){
                    q.add(idx);
                }
            }
        }
        if(list.size() != 26) return new ArrayList<>();
        return list;
    }
    
    public String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<words.length;i++){
            for(char ch : words[i].toCharArray()){
                set.add(ch - 'a');
            }
        }
        for(int i = 1;i<words.length;i++){
            String s1 = words[i - 1];
            String s2 = words[i];
            int j = 0;
            int minlen = Math.min(s1.length(),s2.length());
            while(j < minlen &&s1.charAt(j) == s2.charAt(j)) j++;
            if(j == minlen){
                if(s1.length() > s2.length()) return "";
                continue;
            }
            adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
        }
        ArrayList<Integer> topo = topoSort(adj);
        if(topo.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for(int node : topo){
            if(set.contains(node)){
                sb.append((char) (node + 'a'));
            }
        }
        return sb.toString();
    }
}
