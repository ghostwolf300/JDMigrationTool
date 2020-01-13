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
		JDMaterial material=new JDMaterial();
		System.out.println(line);
		return null;
	}
	
}
