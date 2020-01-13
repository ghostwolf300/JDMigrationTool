package org.jdmt.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.jdmt.dto.JDMaterial;

public class JDMTReader {
	
	public List<JDMaterial> readJDFile(String filePath){
		
		List<JDMaterial> materials=new ArrayList<JDMaterial>();
		
		try(Stream<String> lines=Files.lines(Paths.get(filePath))){
			for(String line : (Iterable<String>) lines :: iterator) {
				JDMaterial material=getJDMaterial(line);
				materials.add(material);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return materials;
	}
	
	private JDMaterial getJDMaterial(String line) {
		//note: substring (start index - last char index+1)
		JDMaterial material=new JDMaterial();
		material.setId(line.substring(0, 18).trim());
		material.setRecordType(String.valueOf(line.charAt(18)));
		material.setPricingCountry(line.substring(19, 21).trim());
		material.setCoreIndicator(String.valueOf(line.charAt(21)));
		material.setSourceOfSupply(line.substring(22,24).trim());
		material.setDescription(line.substring(24, 51).trim());
		material.setPackageQuantity(Integer.valueOf(line.substring(51, 56)));
		material.setDealerNetPrice(Double.valueOf(line.substring(56, 72)));
		
		System.out.println(material.getId()+"\t"+material.getRecordType()+"\t"+material.getDescription()+"\t"+material.getSourceOfSupply()+"\t"+material.getDealerNetPrice());
		return null;
	}
	
}
