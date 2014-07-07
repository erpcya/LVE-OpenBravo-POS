/**
 * com.openbravo.pos.customers
 * C_CityInfo.java
 * 19/04/2014
 * 
 */
package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializerRead;
import com.openbravo.data.loader.SerializerWrite;

/**
 * @author Dixon Martinez
 * 19/04/2014
 */
public class C_CityInfo {
	private String p_C_Region_ID;
	private String p_C_City_ID;
	private String p_Name;
	private String p_AreaCode;
	private String p_Postal;
	private boolean p_IsActive;
	/**
	 * @author Dixon Martinez
	 * C_CityInfo.java
	 * 20/04/2014
	 * @param p_C_Region_ID
	 * @param p_C_City_ID
	 * @param p_Name
	 * @param p_AreaCode
	 * @param p_Postal
	 * @param p_IsActive
	 */
	public C_CityInfo(String p_C_City_ID, String p_Name,String p_C_Region_ID,  
			String p_AreaCode, String p_Postal, boolean p_IsActive) {
		super();
		this.p_C_City_ID = p_C_City_ID;
		this.p_Name = p_Name;
		this.p_C_Region_ID = p_C_Region_ID;		
		this.p_AreaCode = p_AreaCode;
		this.p_Postal = p_Postal;
		this.p_IsActive = p_IsActive;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @return the p_C_Region_ID
	 */
	public String getP_C_Region_ID() {
		return p_C_Region_ID;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @param p_C_Region_ID the p_C_Region_ID to set
	 */
	public void setP_C_Region_ID(String p_C_Region_ID) {
		this.p_C_Region_ID = p_C_Region_ID;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @return the p_C_City_ID
	 */
	public String getP_C_City_ID() {
		return p_C_City_ID;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @param p_C_City_ID the p_C_City_ID to set
	 */
	public void setP_C_City_ID(String p_C_City_ID) {
		this.p_C_City_ID = p_C_City_ID;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @return the p_Name
	 */
	public String getP_Name() {
		return p_Name;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @param p_Name the p_Name to set
	 */
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @return the p_AreaCode
	 */
	public String getP_AreaCode() {
		return p_AreaCode;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @param p_AreaCode the p_AreaCode to set
	 */
	public void setP_AreaCode(String p_AreaCode) {
		this.p_AreaCode = p_AreaCode;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @return the p_Postal
	 */
	public String getP_Postal() {
		return p_Postal;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @param p_Postal the p_Postal to set
	 */
	public void setP_Postal(String p_Postal) {
		this.p_Postal = p_Postal;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @return the p_IsActive
	 */
	public boolean isP_IsActive() {
		return p_IsActive;
	}
	/**
	 * @author Dixon Martinez
	 * 20/04/2014
	 * @param p_IsActive the p_IsActive to set
	 */
	public void setP_IsActive(boolean p_IsActive) {
		this.p_IsActive = p_IsActive;
	}
	
	public static SerializerRead getSerializerRead(){
		return 
				new SerializerRead() {
					
					@Override
					public Object readValues(DataRead dr) throws BasicException {
						return 
								new C_CityInfo(
									dr.getString(1), 
									dr.getString(2), 
									dr.getString(3), 
									dr.getString(4), 
									dr.getString(5), 
									dr.getBoolean(6)
								);
					}
				};
	}
	
	
}
