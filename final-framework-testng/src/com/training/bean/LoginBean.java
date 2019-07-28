package com.training.bean;

public class LoginBean {
	private String productnametest;
	private String pricetest;
	private String statustest;
	private String modeltest;
	private String quantitytest;

	public LoginBean() {
	}

	public LoginBean(String productnametest, String pricetest,String statustest,String modeltest, String quantitytest) {
		super();
		this.setProductnametest(productnametest);
		this.setPricetest(pricetest);
		this.setStatustest(statustest);
		this.setModeltest(modeltest);
		this.setQuantitytest(quantitytest);
		
	}

	
	public String getProductnametest() {
		return productnametest;
	}

	public void setProductnametest(String productnametest) {
		this.productnametest = productnametest;
	}

	public String getPricetest() {
		return pricetest;
	}

	public void setPricetest(String pricetest) {
		this.pricetest = pricetest;
	}

	public String getStatustest() {
		return statustest;
	}

	public void setStatustest(String statustest) {
		this.statustest = statustest;
	}

	public String getModeltest() {
		return modeltest;
	}

	public void setModeltest(String modeltest) {
		this.modeltest = modeltest;
	}

	public String getQuantitytest() {
		return quantitytest;
	}

	public void setQuantitytest(String quantitytest) {
		this.quantitytest = quantitytest;
	}

	@Override
	public String toString() {
		return "LoginBean [productName =" + productnametest + ", price =" + pricetest + ", status =" +statustest +" , model ="+ modeltest +", qunatity = "+ quantitytest +" ]";
	}


}
