/*
For a given source string and a target string, you should output the first index(from 0) of target string in source string.
If target does not exist in source, just return -1.
If source = "source" and target = "target", return -1.
If source = "abcdabcdefg" and target = "bcd", return 1.
*/
public class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if(source==null||target==null) return -1;
        int length1=source.length(),length2=target.length();
        if(length2==0) return 0;
        if(length1<length2) return -1;
        int[] prefix=new int[length2];
        int i=0,j=1;
        while(j<length2){
            if(target.charAt(i)==target.charAt(j)){
                prefix[j++]=(i++)+1;
            }
            else{
                if(i==0) prefix[j++]=0;
                else i=prefix[i-1];
            }
        }
        i=0;j=0;
        while(i<length1&&j<length2){
            if(source.charAt(i)==target.charAt(j)){
                i++;j++;
            }
            else{
                if(j==0) i++;
                else j=prefix[j-1];
            }
        }
        return (j==length2)?(i-length2):-1;
    }
}
