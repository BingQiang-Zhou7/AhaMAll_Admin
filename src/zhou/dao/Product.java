package zhou.dao;

public class Product {
	String ClothingCode;
	String ClothingColor;
	String ClothingSize;
	String ClothingName;
	String ClothingOuterM;
	String ClothingInnerM;
	String ClothingPrice;
	String ClothingFlag;
	
	public Product(String clothingCode, String clothingColor, String clothingSize, String clothingName,
			String clothingOuterM, String clothingInnerM, String clothingPrice, String clothingFlag) {
		super();
		ClothingCode = clothingCode;
		ClothingColor = clothingColor;
		ClothingSize = clothingSize;
		ClothingName = clothingName;
		ClothingOuterM = clothingOuterM;
		ClothingInnerM = clothingInnerM;
		ClothingPrice = clothingPrice;
		ClothingFlag = clothingFlag;
	}
	
	public String getClothingCode() {
		return ClothingCode;
	}
	public void setClothingCode(String clothingCode) {
		ClothingCode = clothingCode;
	}
	public String getClothingColor() {
		return ClothingColor;
	}
	public void setClothingColor(String clothingColor) {
		ClothingColor = clothingColor;
	}
	public String getClothingSize() {
		return ClothingSize;
	}
	public void setClothingSize(String clothingSize) {
		ClothingSize = clothingSize;
	}
	public String getClothingName() {
		return ClothingName;
	}
	public void setClothingName(String clothingName) {
		ClothingName = clothingName;
	}
	public String getClothingOuterM() {
		return ClothingOuterM;
	}
	public void setClothingOuterM(String clothingOuterM) {
		ClothingOuterM = clothingOuterM;
	}
	public String getClothingInnerM() {
		return ClothingInnerM;
	}
	public void setClothingInnerM(String clothingInnerM) {
		ClothingInnerM = clothingInnerM;
	}
	public String getClothingPrice() {
		return ClothingPrice;
	}
	public void setClothingPrice(String clothingPrice) {
		ClothingPrice = clothingPrice;
	}
	public String getClothingFlag() {
		return ClothingFlag;
	}
	public void setClothingFlag(String clothingFlag) {
		ClothingFlag = clothingFlag;
	}
}
