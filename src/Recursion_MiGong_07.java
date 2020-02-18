//TODO:未完成
public class Recursion_MiGong_07 {
    public static void main(String[] args) {
        //创建迷宫
        int [][] map = new int [8][7];
        for (int i =0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i =0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
    }


    //确定迷宫出口map[6][5]
    //i：指定开始查找的位置
    //map：地图
    //j：指定位置
    //当数值为2时表示通路，数值为1表示死路，数值为0表示此路没有走过，数值3表示此路走过，但是不通
    //走迷宫时需要确定一个策略 上->右->下->左
    public static boolean setWay(int map[][], int i, int j){
        if (map[6][5] == 2){
            return true;
        }else
        return true;
    }
}
