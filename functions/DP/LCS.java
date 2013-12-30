class LCS{
        static String LCS(String str1, String str2) {
            char[] m=str1.toCharArray();
            char[] n=str2.toCharArray();
            int[][] arr = new int[m.length + 1][n.length + 1];
            for (int i = 0; i < m.length + 1; i++) {
                arr[i][0] = 0;
            }
            for (int i = 0; i < n.length + 1; i++) {
                arr[0][i] = 0;
            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < n.length; j++) {
                    if (m[i]==n[j]) {
                        arr[i + 1][j + 1] = arr[i][j] + 1;
                    }else{
                       arr[i+1][j+1]=Math.max(arr[i+1][j],arr[i][j+1]);
                    }
                }
            }
            int mpos = m.length, npos = n.length;
            StringBuilder sb=new StringBuilder();

            while (mpos != 0 && npos != 0) {
                if (m[mpos - 1]==(n[npos - 1])) {
                    sb.insert(0,m[mpos - 1]);
                    mpos--;
                    npos--;
                } else if (arr[mpos][npos - 1] >= arr[mpos][npos]) {
                    npos--;
                } else {
                    mpos--;
                }
            }
            return sb.toString();
    }
}