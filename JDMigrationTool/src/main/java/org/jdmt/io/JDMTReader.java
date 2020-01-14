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
		material.setDealerNetPrice(getNumericValueDouble(line.substring(56, 72).trim()));
		material.setDeereListPrice(getNumericValueDouble(line.substring(72, 88).trim()));
		material.setCoreExchangeNetPrice(getNumericValueDouble(line.substring(88, 104).trim()));
		material.setCoreExchangeListPrice(getNumericValueDouble(line.substring(104, 120).trim()));
		material.setReturnCreditNetPrice(getNumericValueDouble(line.substring(120, 136).trim()));
		material.setReturnCreditListPrice(getNumericValueDouble(line.substring(136, 152).trim()));
		material.setReturnIndicator(String.valueOf(line.charAt(152)));
		material.setCriticalCode(line.substring(153,155).trim());
		material.setCompetitivePartCode(line.substring(155,158).trim());
		material.setYearOutOfProduction(line.substring(158,162).trim());
		material.setPricedPerIndicator(String.valueOf(line.charAt(162)));
		material.setShippingWeight(getNumericValueDouble(line.substring(163, 173).trim()));
		material.setLargestDimension(getNumericValueDouble(line.substring(173, 182).trim()));
		material.setMiddleDimension(getNumericValueDouble(line.substring(182, 191).trim()));
		material.setSmallestDimension(getNumericValueDouble(line.substring(191, 200).trim()));
		material.setPartAccountingUnit(line.substring(200,204).trim());
		material.setReplenishmentSource(line.substring(204,208).trim());
		material.setPriceEffectiveDate(line.substring(208,216).trim());
		material.setStockOrderDiscount(String.valueOf(line.charAt(216)));
		material.setDeereSource(line.substring(217,221).trim());
		material.setCommodityCode(line.substring(221,231).trim());
		material.setDealerMargin(Integer.valueOf(line.substring(231,234).trim()));
		material.setInventoryClass(String.valueOf(line.charAt(234)));
		material.setCurrencyCode(line.substring(235,238).trim());
		
		//System.out.println(material.toString());
		return material;
	}
	
	private double getNumericValueDouble(String numberField) {
		double val=0.0;
		if(!numberField.equals(".")) {
			val=Double.valueOf(numberField);
		}
		return val;
	}
	
}
