public class voctor_01 {
    public static void main(String[] args) {
        int[][] voctor =new int[11][11];
        voctor[1][2] = 1;
        voctor[2][3] = 2;
        int sum = 0;
        // 创建稀疏数组
        for(int i=0;i<voctor.length;i++){
            for (int j=0;j<voctor.length;j++) {
                if (voctor[i][j] != 0)
                    sum++;//寻找存在的点个数
            }
        }
        //sum+1：多添加一行title
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for(int i=0;i<voctor.length;i++){
            for (int j=0;j<voctor.length;j++) {
                if (voctor[i][j] != 0) {
                    if (count < sum) {
                        count++;
                        sparseArr[count][0] = i;
                        sparseArr[count][1] = i;
                        sparseArr[count][2] = voctor[i][j];
                    }
                }
            }
        }
        for(int w=0;w<sparseArr.length;w++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[w][0],sparseArr[w][1],sparseArr[w][2]);
        }
    }
}  // 二维数组转稀疏数组


