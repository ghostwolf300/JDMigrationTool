package org.jdmt.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.jdmt.dto.JDMaterial;
import org.jdmt.dto.PartSubstitution;

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
	
	public List<PartSubstitution> readPartSubstitutionFile(String filePath){
		List<PartSubstitution> partSubs=new ArrayList<PartSubstitution>();
		
		try(Stream<String> lines=Files.lines(Paths.get(filePath))){
			for(String line : (Iterable<String>) lines :: iterator) {
				PartSubstitution partSub=getPartSubstitution(line);
				partSubs.add(partSub);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return partSubs;
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
		material.setPackageQuantity(getNumericValueInteger(line.substring(51, 56).trim()));
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
		material.setDealerMargin(getNumericValueInteger(line.substring(231,234).trim()));
		material.setInventoryClass(String.valueOf(line.charAt(234)));
		material.setCurrencyCode(line.substring(235,238).trim());
		
		//System.out.println(material.toString());
		return material;
	}
	
	private PartSubstitution getPartSubstitution(String line) {
		PartSubstitution partSub=new PartSubstitution();
		partSub.setOldPart(line.substring(0, 13).trim());
		partSub.setSubType(line.substring(12,14).trim());
		partSub.setFactoryCode(line.substring(15, 17).trim());
		partSub.setNewPart1(line.substring(18, 30).trim());
		partSub.setQtyNewPart1(getNumericValueInteger(line.substring(31, 34).trim()));
		partSub.setNewPart2(line.substring(35, 47).trim());
		partSub.setQtyNewPart2(getNumericValueInteger(line.substring(48, 51).trim()));
		partSub.setNewPart3(line.substring(52, 64).trim());
		partSub.setQtyNewPart3(getNumericValueInteger(line.substring(65, 68).trim()));
		partSub.setNewPart4(line.substring(69, 81).trim());
		partSub.setQtyNewPart4(getNumericValueInteger(line.substring(82, 85).trim()));
		partSub.setNewPart5(line.substring(86, 98).trim());
		partSub.setQtyNewPart5(getNumericValueInteger(line.substring(99, 102).trim()));
		partSub.setNewPart6(line.substring(103, 115).trim());
		partSub.setQtyNewPart6(getNumericValueInteger(line.substring(116, 119).trim()));
		partSub.setNewPart7(line.substring(120, 132).trim());
		partSub.setQtyNewPart7(getNumericValueInteger(line.substring(133, 136).trim()));
		partSub.setTypeOfSub(String.valueOf(line.charAt(137)));
		partSub.setInterchangeable(String.valueOf(line.charAt(139)));
		return partSub;
	}
	
	private double getNumericValueDouble(String numberField) {
		double val=0.0;
		if(!numberField.isEmpty() && !numberField.equals(".")) {
			val=Double.valueOf(numberField);
		}
		return val;
	}
	
	private int getNumericValueInteger(String numberField) {
		int val=0;
		if(!numberField.isEmpty() && !numberField.equals(".")) {
			val=Integer.valueOf(numberField);
		}
		return val;
	}
	
}
