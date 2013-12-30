import java.util.Arrays;

class Permutation{
    static void perm(String st,StringBuffer out){
        char[]arr=st.toString().toCharArray();
        Arrays.sort(arr);
        perm(new StringBuilder(new String(arr)),new StringBuilder(),out);
    }
    
    static void perm(StringBuilder st,StringBuilder per,StringBuffer sb){
        if(st.length()==0){
            sb.append(per).append("\n");
        }
        for(int i=0;i<st.length();i++){
            char c=st.charAt(i);
            perm(new StringBuilder(st).deleteCharAt(i),new StringBuilder(per).append(c),sb);
        }
    }
}