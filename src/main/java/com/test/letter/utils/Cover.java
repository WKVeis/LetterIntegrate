package com.test.letter.utils;
import com.test.letter.model.LetterInit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veis on 2020/12/28
 */
public class Cover {

    public List<String> coverToLetters(String value) {
        System.out.println("Please input number from 0 to 9:");
        StringBuilder arrInput = new StringBuilder("Input:arr[] ={");
        List<String> resultValue = new ArrayList<>();
        String[] arrStr = null;
        if (value.contains(",")) {
            arrStr = value.split(",");
        }else {
            arrStr = value.split("");
            if (arrStr.length > 2) {
                String msg = "Please enter the numbers 0-99 consecutively, separated by ','";
                resultValue.add(msg);
                return resultValue;
            }
        }
        List<String[]> dataList = new ArrayList<>();
        String[] arrStr2 = null;
        for (int i = 0; i < arrStr.length; i++) {
            System.out.println("the first element separated by a comma is:" + arrStr[i]);
            arrInput.append(arrStr[i]);
            if (i < arrStr.length - 1) {
                arrInput.append(",");
            }
            arrStr2 = arrStr[i].split("");
            for (int j=0;j<arrStr2.length;j++) {
                switch (arrStr2[j]) {
                    case "0":
                        break;
                    case "1":
                        break;
                    default:
                        //Get the set of letters that each number map to
                        List<String> lettersList = LetterInit.getInstance().LetterMap().get(arrStr2[j]);
                        //Put each letter in a new List
                        if (lettersList.size() > 0) {
                            String[] letterArr = (String[]) lettersList.toArray();
                            dataList.add(letterArr);
                        }
                }
            }
        }
        arrInput.append("}");
        List<String[]> resultList = ToLetters(dataList, 0, null);
        System.out.println("The input obtained is" + arrInput.toString());
        System.out.print("All matched letter combinations are:");
        if (null == resultList || resultList.isEmpty()) {
            String msg = "None match";
            resultValue.add(msg);
            return resultValue;
        }
        for (int i = 0; i < resultList.size(); i++) {
            StringBuilder builder = new StringBuilder();
            String[] letterArr = resultList.get(i);
            System.out.print("|");
            for (String s : letterArr) {
                System.out.print(s);
                builder.append(s);
            }
            resultValue.add(builder.toString());
        }
        return resultValue;
    }

    private List<String[]> ToLetters(List<String[]> list1, int index, List<String[]> list2) {
        if (index == list1.size()) {
            return list2;
        }
        List<String[]> resultList = new ArrayList<>();
        if (index == 0) {
            String[] dataArr = list1.get(0);
            for (String s : dataArr) {
                resultList.add(new String[]{s});
            }
        } else {
            String[] dataArr = list1.get(index);
            for (String[] dataArr0 : list2) {
                for (String s : dataArr) {
                    String[] arrCopy = new String[dataArr0.length + 1];
                    System.arraycopy(dataArr0, 0, arrCopy, 0, dataArr0.length);
                    arrCopy[arrCopy.length - 1] = s;
                    resultList.add(arrCopy);
                }
            }
        }
        return ToLetters(list1, ++index, resultList);
    }
}