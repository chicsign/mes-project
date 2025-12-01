package main.java.com.example.mes.lot;

public class LotDto {
	    private String lotId;
	    private String lotStatus;
	    private String lotCode;
	    private String productName;
	    
		public LotDto(String lotId, String lotStatus, String lotCode, String productName) {
			this.lotId = lotId;
			this.lotStatus = lotStatus;
			this.lotCode = lotCode;
			this.productName = productName;
		}
		
		@Override
		public String toString() {
		    return "" +
		            "LOT아이디:'" + lotId + '\'' +
		            ",  LOT상태:'" + lotStatus + '\'' +
		            ",  LOT코드:'" + lotCode + '\'' +
		            ",  제품명:'" + productName + '\'' +
		            '}';
		}
		
		
		public String getLotId() {
			return lotId;
		}
		public void setLotId(String lotId) {
			this.lotId = lotId;
		}
		public String getLotStatus() {
			return lotStatus;
		}
		public void setLotStatus(String lotStatus) {
			this.lotStatus = lotStatus;
		}
		public String getLotCode() {
			return lotCode;
		}
		public void setLotCode(String lotCode) {
			this.lotCode = lotCode;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
	    
	    
		
	    
}
