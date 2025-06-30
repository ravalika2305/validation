package com.example.stockdataEntity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "stock_data")
public class StockDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Company code cannot be empty")
    @Size(min = 3, max = 10, message = "Company code must be between 3 and 10 characters")
    private String companyCode;

    @NotNull(message = "T1 value is required")
    @Min(value = 1, message = "T1 value must be greater than 0")
    private Integer t1;

    @NotNull(message = "T2 value is required")
    @Min(value = 1, message = "T2 value must be greater than 0")
    private Integer t2;

    @NotNull(message = "T3 value is required")
    @Min(value = 1, message = "T3 value must be greater than 0")
    private Integer t3;

    @NotBlank(message = "Stock order type cannot be empty")
    @Pattern(regexp = "BUY|SELL", message = "Stock order type must be either BUY or SELL")
    private String stockOrderType;

    public StockDataEntity() {}

    public StockDataEntity(Integer id, String companyCode, Integer t1, Integer t2, Integer t3, String stockOrderType) {
        this.id = id;
        this.companyCode = companyCode;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.stockOrderType = stockOrderType;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Integer getT1() {
		return t1;
	}

	public void setT1(Integer t1) {
		this.t1 = t1;
	}

	public Integer getT2() {
		return t2;
	}

	public void setT2(Integer t2) {
		this.t2 = t2;
	}

	public Integer getT3() {
		return t3;
	}

	public void setT3(Integer t3) {
		this.t3 = t3;
	}

	public String getStockOrderType() {
		return stockOrderType;
	}

	public void setStockOrderType(String stockOrderType) {
		this.stockOrderType = stockOrderType;
	}

	@Override
	public String toString() {
		return "StockDataEntity [id=" + id + ", companyCode=" + companyCode + ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3
				+ ", stockOrderType=" + stockOrderType + "]";
	}
     
}
