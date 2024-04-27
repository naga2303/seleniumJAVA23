package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadExcel
{
    public static String[][] getExcelData()  {
        String file = "./testAsData/ExcelSheet.xlsx";
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet sh = wb.getSheetAt(0);
        int rows = sh.getLastRowNum();
        int cellNum = sh.getRow(0).getLastCellNum();
        String [][] data = new String [rows][cellNum];
        for(int i=1;i<=rows;i++){
            XSSFRow rw= sh.getRow(i);

            for(int j=0;j<rw.getLastCellNum();j++){
                XSSFCell cw= rw.getCell(j);
                DataFormatter dft = new DataFormatter();
                String values = dft.formatCellValue(cw);
                data[i-1][j]= values;
                //The reason to store the value in the string is because the value will be
                //provided as a string in the sendKeys method.
                System.out.println(values);
            }
        }
        try {
            wb.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
