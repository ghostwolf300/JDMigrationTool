package org.jdmt.dto;

public class JDMaterial extends AbstractMaterial {
	
	private String recordType;
	private String pricingCountry;
	private String coreIndicator;
	private String sourceOfSupply;
	private int packageQuantity;
	private double dealerNetPrice;
	private double deereListPrice;
	private double coreExchangeNetPrice;
	private double coreExchangeListPrice;
	private double returnCreditNetPrice;
	private double returnCreditListPrice;
	private String returnIndicator;
	private String criticalCode;
	private String competitivePartCode; //Deere CommodityCode doesn't mean tariff code
	private String yearOutOfProduction;
	private String pricedPerIndicator;
	private double shippingWeight;
	private double largestDimension;
	private double middleDimension;
	private double smallestDimension;
	private String partAccountingUnit;
	private String replenishmentSource;
	private String priceEffectiveDate;
	private String stockOrderDiscount;
	private String deereSource;
	private int dealerMargin;
	private String inventoryClass;
	private String currencyCode;
	
	
	
	public JDMaterial() {
		super();
	}



	public String getRecordType() {
		return recordType;
	}



	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}



	public String getPricingCountry() {
		return pricingCountry;
	}



	public void setPricingCountry(String pricingCountry) {
		this.pricingCountry = pricingCountry;
	}



	public String getCoreIndicator() {
		return coreIndicator;
	}



	public void setCoreIndicator(String coreIndicator) {
		this.coreIndicator = coreIndicator;
	}



	public String getSourceOfSupply() {
		return sourceOfSupply;
	}



	public void setSourceOfSupply(String sourceOfSupply) {
		this.sourceOfSupply = sourceOfSupply;
	}



	public int getPackageQuantity() {
		return packageQuantity;
	}



	public void setPackageQuantity(int packageQuantity) {
		this.packageQuantity = packageQuantity;
	}



	public double getDealerNetPrice() {
		return dealerNetPrice;
	}



	public void setDealerNetPrice(double dealerNetPrice) {
		this.dealerNetPrice = dealerNetPrice;
	}



	public double getDeereListPrice() {
		return deereListPrice;
	}



	public void setDeereListPrice(double dealerListPrice) {
		this.deereListPrice = dealerListPrice;
	}



	public double getCoreExchangeNetPrice() {
		return coreExchangeNetPrice;
	}



	public void setCoreExchangeNetPrice(double coreExchangeNetPrice) {
		this.coreExchangeNetPrice = coreExchangeNetPrice;
	}



	public double getCoreExchangeListPrice() {
		return coreExchangeListPrice;
	}



	public void setCoreExchangeListPrice(double coreExchangeListPrice) {
		this.coreExchangeListPrice = coreExchangeListPrice;
	}



	public double getReturnCreditNetPrice() {
		return returnCreditNetPrice;
	}



	public void setReturnCreditNetPrice(double returnCreditNetPrice) {
		this.returnCreditNetPrice = returnCreditNetPrice;
	}



	public double getReturnCreditListPrice() {
		return returnCreditListPrice;
	}



	public void setReturnCreditListPrice(double returnCreditListPrice) {
		this.returnCreditListPrice = returnCreditListPrice;
	}



	public String getReturnIndicator() {
		return returnIndicator;
	}



	public void setReturnIndicator(String returnIndicator) {
		this.returnIndicator = returnIndicator;
	}



	public String getCriticalCode() {
		return criticalCode;
	}



	public void setCriticalCode(String criticalCode) {
		this.criticalCode = criticalCode;
	}



	public String getCompetitivePartCode() {
		return competitivePartCode;
	}



	public void setCompetitivePartCode(String competitivePartCode) {
		this.competitivePartCode = competitivePartCode;
	}



	public String getYearOutOfProduction() {
		return yearOutOfProduction;
	}



	public void setYearOutOfProduction(String yearOfProduction) {
		this.yearOutOfProduction = yearOfProduction;
	}



	public String getPricedPerIndicator() {
		return pricedPerIndicator;
	}



	public void setPricedPerIndicator(String pricedPerIndicator) {
		this.pricedPerIndicator = pricedPerIndicator;
	}



	public double getShippingWeight() {
		return shippingWeight;
	}



	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}



	public double getLargestDimension() {
		return largestDimension;
	}



	public void setLargestDimension(double largestDimension) {
		this.largestDimension = largestDimension;
	}



	public double getMiddleDimension() {
		return middleDimension;
	}



	public void setMiddleDimension(double middleDimension) {
		this.middleDimension = middleDimension;
	}



	public double getSmallestDimension() {
		return smallestDimension;
	}



	public void setSmallestDimension(double smallestDimension) {
		this.smallestDimension = smallestDimension;
	}



	public String getPartAccountingUnit() {
		return partAccountingUnit;
	}



	public void setPartAccountingUnit(String partAccountingUnit) {
		this.partAccountingUnit = partAccountingUnit;
	}



	public String getReplenishmentSource() {
		return replenishmentSource;
	}



	public void setReplenishmentSource(String replenishmentSource) {
		this.replenishmentSource = replenishmentSource;
	}



	public String getPriceEffectiveDate() {
		return priceEffectiveDate;
	}



	public void setPriceEffectiveDate(String priceEffectiveDate) {
		this.priceEffectiveDate = priceEffectiveDate;
	}



	public String getStockOrderDiscount() {
		return stockOrderDiscount;
	}



	public void setStockOrderDiscount(String stockOrderDiscount) {
		this.stockOrderDiscount = stockOrderDiscount;
	}



	public String getDeereSource() {
		return deereSource;
	}



	public void setDeereSource(String deereSource) {
		this.deereSource = deereSource;
	}



	public int getDealerMargin() {
		return dealerMargin;
	}



	public void setDealerMargin(int dealerMargin) {
		this.dealerMargin = dealerMargin;
	}



	public String getInventoryClass() {
		return inventoryClass;
	}



	public void setInventoryClass(String inventoryClass) {
		this.inventoryClass = inventoryClass;
	}



	public String getCurrencyCode() {
		return currencyCode;
	}



	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}



	@Override
	public String toString() {
		return recordType + "; " + pricingCountry + "; " + coreIndicator + "; " + sourceOfSupply + "; "
				+ packageQuantity + "; " + dealerNetPrice + "; " + deereListPrice + "; " + coreExchangeNetPrice + "; "
				+ coreExchangeListPrice + "; " + returnCreditNetPrice + "; " + returnCreditListPrice + "; "
				+ returnIndicator + "; " + criticalCode + "; " + competitivePartCode + "; " + yearOutOfProduction + "; "
				+ pricedPerIndicator + "; " + shippingWeight + "; " + largestDimension + "; " + middleDimension + "; "
				+ smallestDimension + "; " + partAccountingUnit + "; " + replenishmentSource + "; " + priceEffectiveDate
				+ "; " + stockOrderDiscount + "; " + deereSource + "; " + dealerMargin + "; " + inventoryClass + "; "
				+ currencyCode + "; " + getId() + "; " + getDescription() + "; " + getBaseUOM() + "; " + getLength()
				+ "; " + getWidth() + "; " + getHeight() + "; " + getNetWeight() + "; " + getGrossWeight() + "; "
				+ getEanCode() + "; " + getCommodityCode() + "]";
	}
	
	public Object[] getObjectArray() {
		Object[] arrObjects=new Object[] {
				super.getId(),
				this.getRecordType(),
				this.getPricingCountry(),
				this.getCoreIndicator(),
				this.getSourceOfSupply(),
				super.getDescription(),
				this.getPackageQuantity(),
				this.getDealerNetPrice(),
				this.getDeereListPrice(),
				this.getCoreExchangeNetPrice(),
				this.getCoreExchangeListPrice(),
				this.getReturnCreditNetPrice(),
				this.getReturnCreditListPrice(),
				this.getReturnIndicator(),
				this.getCriticalCode(),
				this.getCompetitivePartCode(),
				this.getYearOutOfProduction(),
				this.getPricedPerIndicator(),
				this.getShippingWeight(),
				this.getLargestDimension(),
				this.getMiddleDimension(),
				this.getSmallestDimension(),
				this.getPartAccountingUnit(),
				this.getReplenishmentSource(),
				this.getPriceEffectiveDate(),
				this.getStockOrderDiscount(),
				this.getDeereSource(),
				this.getCommodityCode(),
				this.getDealerMargin(),
				this.getInventoryClass(),
				this.getCurrencyCode()
		};
		return arrObjects;
	}
	
	public static String[] getHeaders() {
		String[] header=new String[] {
			"JDID",
			"RECORD_TYPE",
			"PRICING_COUNTRY",
			"CORE_INDICATOR",
			"SOURCE_OF_SUPPLY",
			"DESCRIPTION",
			"PACKAGE_QTY",
			"DEALER_NET_PRICE",
			"DEERE_LIST_PRICE",
			"CORE_EXCH_NET_PRICE",
			"CORE_EXCH_LIST_PRICE",
			"RETURN_CREDIT_NET_PRICE",
			"RETURN_CREDIT_LIST_PRICE",
			"RETURN_INDICATOR",
			"CRITICAL_CODE",
			"COMP_PART_CODE",
			"YEAR_OUT_OF_PROD",
			"PRICED_PER_INDICATOR",
			"SHIPPING_WEIGHT",
			"LARGEST_DIM",
			"MIDDLE_DIM",
			"SMALLEST_DIM",
			"PART_ACCT_UNIT",
			"REPLENISHMENT_SOURCE",
			"PRICE_EFFECTIVE_DATE",
			"STOCK_ORDER_DISCOUNT",
			"DEERE_SOURCE",
			"COMMODITY_CODE",
			"DEALER_MARGIN",
			"INVENTORY_CLASS",
			"CURRENCY_CODE"
		};
		return header;
	}
	
}
