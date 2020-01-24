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
import org.jdmt.dto.PartSubstitution;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;

public class JDMTWriter {
	
	public void saveToExcel(List<JDMaterial> materials, String filePath) {
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
	
	public void saveJDMaterialsToAccess(List<JDMaterial> materials, String dbPath) {
		Database db=null;
		Table table=null;
		int counter=0;
		try {
			db=DatabaseBuilder.open(new File(dbPath));
			table=db.getTable("tbl_jd_data");
			for(JDMaterial material : materials) {
				table.addRow(
					material.getId(),
					material.getRecordType(),
					material.getPricingCountry(),
					material.getCoreIndicator(),
					material.getSourceOfSupply(),
					material.getDescription(),
					material.getPackageQuantity(),
					material.getDealerNetPrice(),
					material.getDeereListPrice(),
					material.getCoreExchangeNetPrice(),
					material.getCoreExchangeListPrice(),
					material.getReturnCreditNetPrice(),
					material.getReturnCreditListPrice(),
					material.getReturnIndicator(),
					material.getCriticalCode(),
					material.getCompetitivePartCode(),
					material.getYearOutOfProduction(),
					material.getPricedPerIndicator(),
					material.getShippingWeight(),
					material.getLargestDimension(),
					material.getMiddleDimension(),
					material.getSmallestDimension(),
					material.getPartAccountingUnit(),
					material.getReplenishmentSource(),
					material.getPriceEffectiveDate(),
					material.getStockOrderDiscount(),
					material.getDeereSource(),
					material.getCommodityCode(),
					material.getDealerMargin(),
					material.getInventoryClass(),
					material.getCurrencyCode()
				);
				counter++;
				if(counter % 10000 == 0) {
					System.out.println("Rows inserted: "+counter);
					db.flush();
				}
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(db!=null) {
					db.close();
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void savePartSubstitutionsToAccess(List<PartSubstitution> partSubs,String dbPath) {
		Database db=null;
		Table table=null;
		int counter=0;
		try {
			db=DatabaseBuilder.open(new File(dbPath));
			table=db.getTable("tbl_part_substitution");
			for(PartSubstitution partSub : partSubs) {
				table.addRow(
					partSub.getOldPart(),
					partSub.getSubType(),
					partSub.getFactoryCode(),
					partSub.getNewPart1(),
					partSub.getQtyNewPart1(),
					partSub.getNewPart2(),
					partSub.getQtyNewPart2(),
					partSub.getNewPart3(),
					partSub.getQtyNewPart3(),
					partSub.getNewPart4(),
					partSub.getQtyNewPart4(),
					partSub.getNewPart5(),
					partSub.getQtyNewPart5(),
					partSub.getNewPart6(),
					partSub.getQtyNewPart6(),
					partSub.getNewPart7(),
					partSub.getQtyNewPart7(),
					partSub.getTypeOfSub(),
					partSub.getInterchangeable()
				);
				counter++;
				if(counter % 10000 == 0) {
					System.out.println("Rows inserted: "+counter);
					db.flush();
				}
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(db!=null) {
					db.close();
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
