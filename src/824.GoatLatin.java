class Solution {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        for(char c : "aeiouAEIOU".toCharArray()) vowel.add(c);
        
        StringBuilder ans = new StringBuilder();
        String ending = "a";
        for(String word : S.split(" ")) {
            char first = word.charAt(0);
            
            if(vowel.contains(first)) {
                ans.append(word);
            } else {
                ans.append(word.substring(1, word.length()));
                ans.append(first);
            }
            ans.append("ma" + ending + " ");
            ending += "a";
        }
        
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
