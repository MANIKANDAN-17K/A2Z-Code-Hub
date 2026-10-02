/*
721. Accounts Merge


Given a list of accounts where each element accounts[i] is a list of strings, where 
the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person
if there is some common email to both accounts. Note that even if two accounts have the same name,
they may belong to different people as people could have the same name. A person can have any number 
of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of
each account is the name, and the rest of the elements are emails in sorted order.
The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]

 

Constraints:

    1 <= accounts.length <= 1000
    2 <= accounts[i].length <= 10
    1 <= accounts[i][j].length <= 30
    accounts[i][0] consists of English letters.
    accounts[i][j] (for j > 0) is a valid email.

*/

class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUparent(int x){
        if(parent[x] != x)
            parent[x]= findUparent(parent[x]);
        return parent[x];
    }
    public void findByUnion(int u,int v){
        int up = findUparent(u);
        int vp = findUparent(v);
        if(up == vp) return;
        if(size[up] < size[vp]){
            parent[vp] = up;
            size[up] += size[vp];
        }else{
            parent[up] =vp;
            size[vp] += size[up];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = accounts.size();
        DSU dsu = new DSU(accounts.size());
        for(int i = 0;i<n;i++){
            for(int j = 1;j<accounts.get(i).size();j++)
            {
                if(!map.containsKey(accounts.get(i).get(j))){
                    map.put(accounts.get(i).get(j),i);
                }else{
                    dsu.findByUnion(i,map.get(accounts.get(i).get(j)));
                }
            }
        }
        ArrayList<String>[] merge = new ArrayList[n];
        for(int i = 0;i<n;i++){
            merge[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int parent = dsu.findUparent(entry.getValue());
            merge[parent].add(key);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(merge[i].isEmpty()) continue;
            Collections.sort(merge[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String str : merge[i])
                temp.add(str);
            res.add(temp);
        }
        res.sort((a,b) -> a.get(0).compareTo(b.get(0)));
        return res;
    }
}
