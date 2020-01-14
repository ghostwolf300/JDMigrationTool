package org.jdmt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdmt.dto.JDMaterial;

public class JDMTWriter {
	
	public void writeFile(List<JDMaterial> materials, String filePath) {
		File file=new File(filePath);
		FileOutputStream fos=null;
		SXSSFWorkbook book=null;
		Sheet sheet=null;
		Row row=null;
		int rowIndex=1;
		
		try {
			
			book=new SXSSFWorkbook(-1);
			book.createSheet("JD Data");
			sheet=book.getSheet("JD Data");
			row=sheet.createRow(0);
			createHeader(row,JDMaterial.getHeaders());
			for(JDMaterial material : materials) {
				row=sheet.createRow(rowIndex);
				createDataRow(row,material);
				rowIndex++;
				if(rowIndex % 1000 == 0) {
					System.out.println(rowIndex);
					((SXSSFSheet)sheet).flushRows(1000);
				}
			}
			fos=new FileOutputStream(file);
			book.write(fos);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				book.close();
				fos.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void createHeader(Row row,String[] headers) {
		Cell cell=null;
		int colIndex=0;
		for(String hdr : headers) {
			cell=row.createCell(colIndex);
			cell.setCellValue(hdr);
			colIndex++;
		}
	}
	
	private void createDataRow(Row row,JDMaterial material) {
		Cell cell=null;
		int colIndex=0;
		Object[] fields=material.getObjectArray();
		for(Object o : fields) {
			cell=row.createCell(colIndex);
			if(o instanceof String) {
				cell.setCellValue((String)o);
			}
			else if(o instanceof Double) {
				cell.setCellValue((Double)o);
			}
			else if(o instanceof Integer) {
				cell.setCellValue((Integer)o);
			}
			colIndex++;
		}
	}
	
}
