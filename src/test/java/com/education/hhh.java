package com.education;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hhh {

    public String multiply(String num1, String num2) {
        int l = num1.length();
        int r = num2.length();
        int[] num = new int[l + r];
        for (int i = 0; i < l; i++) {
            int n1 = num1.charAt(l - 1 - i) - '0';
            int tmp = 0;
            for (int j = 0; j < r; j++) {
                int n2 = num2.charAt(r - 1 - j) - '0';
                tmp = tmp + num[i + j] + n1 * n2;
                num[i + j] = tmp % 10;
                tmp /= 10;
            }
            num[i + r] = tmp;
        }
        int i = l + r - 1;
        while (i > 0 && num[i] == 0) {
            i--;
        }
        StringBuilder result = new StringBuilder();
        while (i >= 0) {
            result.append(num[i--]);
        }
        return result.toString();
    }


//    /**
//     * java实现读取英文文章，统计其中每个单词出现的次数并输出
//     *
//     * @author halbert
//     */
//
//
//    public void count() throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("D:\\test\\english.txt"));
//        StringBuffer buffer = new StringBuffer();
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            buffer.append(line);
//        }
//        reader.close();
//        Pattern expression = Pattern.compile("[a-zA-Z]+");    //定义正则表达式匹配单词
//        String string = buffer.toString();
//        Matcher matcher = expression.matcher(string);
//        Map<String,Integer> map = new TreeMap<String,Integer>();
//        String word = "";
//        int n = 0;
//        Integer times = 0;
//        while (matcher.find()) {        //是否匹配单词
//            word = matcher.group();        //得到一个单词，树映射中的键
//            n++;
//            if (map.containsKey(word)) {    //如果该键存在，则表示单词出现过
//                times = map.get(word);        //得到单词出现的次数
//                map.put(word, times + 1);
//            } else {
//                map.put(word, 1);    //否则单词是第一次出现，直接放入map
//            }
//        }
//        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
//        Comparator<Map.Entry<String,Integer>> comparator = new Comparator<Map.Entry<String,Integer>>() {
//
//            @Override
//            public int compare (Entry <String,Integer> left, Entry < string integer = "" > right){
//            return (left.getValue()).compareTo(right.getValue());
//        }
//
//        } ;
//        Collections.sort(list, comparator);
//        System.out.println("统计分析如下：");
//        System.out.println("t 文章中单词总数" + n + "个");
//        System.out.println("具体的信息在原文件目录的result.txt文件中");
//        BufferedWriter bufw = new BufferedWriter(new FileWriter("D:\\test\\result.txt"));
//        for (Entry<string integer = "" > me :list){
//            bufw.write(me + "");
//            bufw.newLine();
//        }
//        bufw.write("english.txt中的单词总数" + n + "个");
//        bufw.newLine();
//        bufw.write("english.txt中不同单词" + map.size() + "个");
//        bufw.close();
//    }


//    public static void main(String[] args) {
//        try {
//            hhh fwc = new hhh();
//            fwc.count();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}




