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
		
		String inFilePath="C:/Users/ghost/Documents/työ/Wihuri/John Deere/TESTFILE_SMALL.V2-2019-12-30";
		String outFilePath="";
		
		JDMTool tool=new JDMTool();
		List<JDMaterial> materials=tool.reader.readJDFile(inFilePath);
		tool.writer.writeFile(materials, outFilePath);

	}

}
