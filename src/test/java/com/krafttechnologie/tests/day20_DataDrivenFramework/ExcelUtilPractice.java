package com.krafttechnologie.tests.day20_DataDrivenFramework;

import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void readExcelFile() {
        /**
         ExcelUtil dan bir object olusturacagiz
         Object iki argument alacak Bunlar: Dosyanin
         pathi ile calisma yapacagimiz sayfanin adi olacak.
         */

        ExcelUtil qaTeam2 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam2");
        System.out.println("qaTeam2.rowCount() = " + qaTeam2.rowCount()); //rowCount
        System.out.println("qaTeam2.columnCount() = " + qaTeam2.columnCount()); // columnCount

        System.out.println("qaTeam2.getColumnsNames() = " + qaTeam2.getColumnsNames());
        System.out.println("qaTeam2.getDataList().size() = " + qaTeam2.getDataList().size());
        System.out.println("qaTeam2.getDataList() = " + qaTeam2.getDataList());

        List<Map<String, String>> dataList =qaTeam2.getDataList();
        System.out.println("row = " + dataList);

        for (Map<String, String> row1: qaTeam2.getDataList()) {
            System.out.println("row1 = " + row1);
        }

        System.out.println("dataList.get(2) = " + dataList.get(2));
        System.out.println("dataList.get(2).get(\"Your Name\") = " + dataList.get(2).get("Your Name"));

        String [][] dataArray= qaTeam2.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));



    }


}
