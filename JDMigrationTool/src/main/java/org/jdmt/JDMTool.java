package org.jdmt;

import java.util.List;

import org.jdmt.dto.JDMaterial;
import org.jdmt.io.JDMTReader;
import org.jdmt.io.JDMTWriter;

public class JDMTool {
	
	private JDMTReader reader;
	private JDMTWriter writer;
	
	
	public JDMTool() {
		reader=new JDMTReader();
		writer=new JDMTWriter();
	}
	
	public static void main(String[] args) {
		
		//String inFilePath="C:/Users/ghost/Documents/työ/Wihuri/John Deere/TESTFILE_SMALL.V2-2019-12-30";
		//String inFilePath="C:/Users/ville.susi/Documents/Digital Development/Projects/John Deere/TESTFILE_SMALL.V2-2019-12-30";
		String inFilePath="C:/Users/ville.susi/Documents/Digital Development/Projects/John Deere/de19_dwnld_v2-2019-12-30/DE19.DWNLD.V2-2019-12-30";
		String outFilePath="C:/Users/ville.susi/Documents/Digital Development/Projects/John Deere/JD Data.xlsx";
		String dbPath="C:/Users/ville.susi/Documents/Digital Development/Projects/John Deere/JDDB.accdb";
		
		JDMTool tool=new JDMTool();
		List<JDMaterial> materials=tool.reader.readJDFile(inFilePath);
		System.out.println("JD material count: "+materials.size());
		//tool.writer.saveToExcel(materials, outFilePath);
		tool.writer.saveToAccess(materials, dbPath);
		
		materials=null;
		
	}

}
