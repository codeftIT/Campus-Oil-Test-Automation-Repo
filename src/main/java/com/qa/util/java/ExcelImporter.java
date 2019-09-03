package com.qa.util.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.campusOil.qa.base.TestBase;

public class ExcelImporter extends TestBase {
	
	    public static HSSFWorkbook WBook = null;
	    public static HSSFSheet WSheet= null;

	    public static HSSFSheet DataSheet(String FilePath, String SheetName){
	        File file = new File(FilePath);
	        try {
	            FileInputStream fis = new FileInputStream(file);
	            WBook = new HSSFWorkbook(fis);
	            WSheet = WBook.getSheet(SheetName);         
	        } catch (Exception e) {         
	            e.printStackTrace();
	        }
	        return WSheet;      
	    } 
	
}
