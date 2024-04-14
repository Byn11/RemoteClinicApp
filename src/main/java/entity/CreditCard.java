package entity;

import java.io.Serializable;
import java.util.Date;

public class CreditCard implements Serializable {
	private int id;
	private String name;
	private int creditCardNumber;
	private Date expiration;
	private int securityCode; 
	
	public CreditCard() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param creditCardNumber
	 * @param expiration
	 * @param securityCode
	 */
	public CreditCard(int id, String name, int creditCardNumber, Date expiration, int securityCode) {
		super();
		this.id = id;
		this.name = name;
		this.creditCardNumber = creditCardNumber;
		this.expiration = expiration;
		this.securityCode = securityCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}


}
