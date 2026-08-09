/*
class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != " ".charAt(0)){
                sb.append(s.charAt(i));
            }else{
                st.push(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length() > 0){
            st.push(sb.toString());
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
            if(!st.isEmpty()){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            while( i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0) break;
            int end = i;
            while( i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            String word = s.substring(i + 1, end + 1);
            if(word.length() > 0){
                sb.append(" ");
            }
            sb.append(word);
        }
        return sb.toString().trim();
    }
}
