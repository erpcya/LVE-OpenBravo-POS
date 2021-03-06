/**
 * com.openbravo.pos.customers
 * C_CountryInfo.java
 * 18/04/2014
 * 
 */
package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializerRead;

/**
 * @author Dixon Martinez
 * 18/04/2014
 */
public class C_CountryInfo {
	private String p_C_Currency_ID;
	private String p_C_Country_ID;
	private String p_Name;
	private String p_Description;
	private boolean p_IsActive;
	private String p_CountryCode;
	
	/**
	 * @author Dixon Martinez
	 * C_CountryInfo.java
	 * 18/04/2014
	 * @param p_C_Currency_ID
	 * @param p_C_Country_ID
	 * @param p_Name
	 * @param p_Description
	 * @param p_IsDefault
	 * @param p_IsActive
	 */
	public C_CountryInfo(String p_C_Currency_ID, String p_C_Country_ID,
			String p_Name, String p_Description, boolean p_IsDefault,
			boolean p_IsActive) {
		super();
		this.p_C_Currency_ID = p_C_Currency_ID;
		this.p_C_Country_ID = p_C_Country_ID;
		this.p_Name = p_Name;
		this.p_Description = p_Description;
		this.p_IsActive = p_IsActive;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @return the p_C_Currency_ID
	 */
	public String getp_C_Currency_ID() {
		return p_C_Currency_ID;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @param p_C_Currency_ID the p_C_Currency_ID to set
	 */
	public void setp_C_Currency_ID(String p_C_Currency_ID) {
		this.p_C_Currency_ID = p_C_Currency_ID;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @return the p_C_Country_ID
	 */
	public String getP_C_Country_ID() {
		return p_C_Country_ID;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @param p_C_Country_ID the p_C_Country_ID to set
	 */
	public void setP_C_Country_ID(String p_C_Country_ID) {
		this.p_C_Country_ID = p_C_Country_ID;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @return the p_Name
	 */
	public String getP_Name() {
		return p_Name;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @param p_Name the p_Name to set
	 */
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @return the p_Description
	 */
	public String getP_Description() {
		return p_Description;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @param p_Description the p_Description to set
	 */
	public void setP_Description(String p_Description) {
		this.p_Description = p_Description;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @return the p_IsActive
	 */
	public boolean isP_IsActive() {
		return p_IsActive;
	}

	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @param p_IsActive the p_IsActive to set
	 */
	public void setP_IsActive(boolean p_IsActive) {
		this.p_IsActive = p_IsActive;
	}
	/**
	 * @author Dixon Martinez
	 * 18/04/2014
	 * @return
	 */
	public static SerializerRead getSerializerRead(){
		return new SerializerRead() {
			
			@Override
			public Object readValues(DataRead dr) throws BasicException {
				return 
						new C_CountryInfo(
								dr.getString(1), 
								dr.getString(2), 
								dr.getString(3), 
								dr.getString(4), 
								dr.getBoolean(5), 
								dr.getBoolean(6));
			}
		};
	}
}
