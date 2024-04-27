package utils;

import net.bytebuddy.asm.MemberSubstitution;
import org.testng.annotations.DataProvider;

public class DataUtils {
    //@DataProvider(name = "test", indices = {0,1}) - with indices
    @DataProvider(parallel = true)
    //indices - here, indices refers which array index should run, below there are
    //two array size, mentioning 0 indicates the first index of the array
    //should run.
    //The name attribute is not mandatory. instead the method name can be provided.
    public String[][] getData(){
        String [][] excelData = ReadExcel.getExcelData();

   /*     String [][] data = new String[2][2];
        data[0][0] = "test";
        data[0][1]="test2";
        data[1][0]="test3";
        data[1][1]="test4";*/
        return excelData;
    }
}
