package com.krafttechnologie.tests.day20_DataDrivenFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] testData() {
        String[][] data = {

                {"Audi", "100", "80", "65", "55"},
                {"Honda", "112", "127", "135", "60"},
                {"Tesla", "20", "30", "25", "15"},
                {"Mazda", "70", "50", "65", "75"},
                {"Porche", "40", "43", "22", "17"},
                {"Toyota", "110", "80", "95", "155"},
                {"Volvo", "10", "20", "35", "45"},
                {"Mercedes", "20", "25", "35", "44"},
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test(String aracMarkasi, String Ocak, String Subat,
                     String Mart, String Nisan){
        /**
         * DataProvider ile aşagidaki testi irtibatlamak için 1.yol: test anotation ın yanına parantez içi data Provider yazıp
         * DataProvider method adını string bir değer gibi yazıyoruz..yada 2. yol: DataProvider anotation yanına parantez içi
         * bir name ismi veriyoruz ve aşağıdaki test anotaition yanuına parantez içi değere bu defa bu ismi veriyoruz.
         */

        System.out.println("Araç markası: "+aracMarkasi+"  Ocak Satışları-->"+Ocak+"  " +
                "Şubat Satışları-->"+Subat+"  Mart Satışları-->"+Mart+ "  Nisan Satışları-->"+Nisan);

    }
}




