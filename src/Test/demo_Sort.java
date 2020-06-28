package Test;

import java.util.Arrays;

public class demo_Sort {
    public static void main(String[] args) {
        int[] s = {8,4,5,7,1,3,6,2};
        int[] temp = new int[s.length];
//        maopao(s);
//        insert_data(s);
//        select_data(s);
//        xier(s);
//        Quick_2(s,0,s.length-1);
        Merge_data_up(s,0,s.length-1,temp);
        System.out.println(Arrays.toString(s));
//        Radix(s);
    }

    //冒泡排序
    public static void maopao(int[] s){
        for(int i=0;i<s.length;i++) {
            boolean flag=true;
            int temp=0;
            for (int j = 0; j < s.length - 1 - i; j++) {
                if (s[j] > s[j + 1]) {
                    temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println(Arrays.toString(s));
        }
    }

    //插入排序
    public static void insert_data(int[] s){
        for (int i=1;i<s.length;i++){
            int temp = 0;
            for (int j=0;j<i;j++){
                if (s[j]>s[i]){
                    temp = s[j];
                    s[j] = s[i];
                    s[i] = temp;
                }
            }
            System.out.println(Arrays.toString(s));
        }
    }

    //选择排序
    public static void select_data(int[] s){
        int temp = 0;
        for (int i=0;i<s.length-1;i++){
            int top = s[i];
            for (int j=i+1;j<s.length;j++){
                if (s[i]>s[j]){
                    s[i] = s[j];
                    temp = j;
                }
            }
            s[temp] = top;
            System.out.println(Arrays.toString(s));
        }
    }

    //希尔排序(移动法进行希尔排序)
    public static void xier(int[] s){
       for (int top=s.length/2;top>0;top/=2){
          for (int i = top;i<s.length;i++){
              int j = i;
              int temp = s[j];
              while ((j-top)>=0 && temp<s[j-top]){
                  s[j] = s[j-top];
                  j-=top;
              }
              s[j] = temp;
          }
          System.out.println(Arrays.toString(s));
       }
    }

    //快速排序
    public static void Quick_2(int[] s, int left, int right){
        int l=left;
        int r=right;
        int temp = 0;
        int median = s[(l+r)/2];
        while (l<r){
            while (s[l]<median){
                l++;
            }
            while (s[r]>median){
                r--;
            }
            if (l>=r){
                break;
            }
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            if (s[l]==median){
                r--;
            }
            if (s[r] == median){
                l++;
            }

        }
        if (l==r){
            l = l+1;
            r = r-1;
        }
        System.out.println(Arrays.toString(s));
        if (left<r){
            Quick_2(s,left,r);
        }
        if (right>l){
            Quick_2(s,l,right);
        }
    }


    //归并排序--合并
    public static void Merge_He(int[] s, int left, int right, int median, int[] temp){
        int i = left;
        int j = median+1;
        int t = 0;
        while (i<=median && j<=right){
            if (s[i]<=s[j]){
                temp[t++] = s[i++];
            }else if (s[i]>=s[j]){
                temp[t++] = s[j++];
            }
        }
        //若有一方还有数据，直接加入temp中
        while (i<=median) {
            temp[t++] = s[i++];
        }
        while (j<=right) {
            temp[t++] = s[j++];
        }

        /*
            copy temp -->  s
            并不是每一次都需要拷贝
         */
        t = 0;
        int tempLeft = left;
        while (tempLeft<=right){
            s[tempLeft++] = temp[t++];
        }
    }

    //归并 ---划分
    public static void Merge_data_up(int[] s,int left, int right, int[] temp){
        if (left<right){
            int median = (left+right)/2;
            //向左递归进行划分
            Merge_data_up(s,left,median,temp);
            //向右递归进行划分
            Merge_data_up(s,median+1,right,temp);
            //合并
            Merge_He(s,left,right, median,temp);
        }
    }


    public static void Radix(int[] s){
        int[][] box = new int[10][s.length];
        int[] temp = new int[10];
        for(int t=1;t<Arrays.stream(s).max().getAsInt();t*=10){
            for(int i=0;i<s.length;i++){
                int top = s[i]/t%10;
                box[top][temp[top]++] = s[i];
            }
        }
        int index = 0;
        for (int k = 0; k<temp.length;k++){
            if (temp[k]!=0){
                for (int m=0;m<temp[k];m++){
                    s[index++] = box[k][m];
                    box[k][m] = 0;
                }
                temp[k] = 0;
            }
            System.out.println(Arrays.toString(s));
        }
    }
}
