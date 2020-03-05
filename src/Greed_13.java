import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Greed_13 {
    public static void main(String[] args) {
        //创建广播电台
        Map<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        map.put("K1",set1);
        map.put("K2",set2);
        map.put("K3",set3);
        map.put("K4",set4);
        map.put("K5",set5);
        //存放所有地区
        HashSet<String> all = new HashSet<>();
        for(String key : map.keySet()){
            HashSet<String> value = map.get(key);
            all.addAll(value);
        }
        //创建ArrayList，存放选择的电台集合（Key）
        ArrayList<String> select = new ArrayList<>();
        //定义临时集合，保存在遍历过程中覆盖电台地区的个数(不重复)
        HashSet<String> temp = new HashSet<>();
        //maxKey:存储一次遍历中电台覆盖区域的最大个数(不重复)，若不为空，则加入select中
        String maxKey = null;
        while (all.size()!=0){
            maxKey = null;//每次循环都需将maxKey置空
            for (String key:map.keySet()){
                //每次需将temp临时集合置空
                temp.clear();
                HashSet<String> hashSet = map.get(key);//key所对应的value
                temp.addAll(hashSet);
                temp.retainAll(all);//求交集，为覆盖的区域
                //贪婪算法的体现
                if (temp.size()>0 && (maxKey==null||temp.size()>map.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if (maxKey!=null){
                select.add(maxKey);
                //将maxKey对应的value从all中删除
                all.removeAll(map.get(maxKey));
            }
        }
        System.out.println(select);

    }
}
