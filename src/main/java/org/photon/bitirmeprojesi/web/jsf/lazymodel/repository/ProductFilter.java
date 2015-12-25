package org.photon.bitirmeprojesi.web.jsf.lazymodel.repository;

import java.io.Serializable;

public class ProductFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private int firstRecord;
	private int quantitiyOfRecords;
	private String propriedadeOrdenacao;
	private boolean ascending;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int getFirstRecord() {
        return firstRecord;
    }

    public void setFirstRecord(int firstRecord) {
        this.firstRecord = firstRecord;
    }

    public int getQuantitiyOfRecords() {
        return quantitiyOfRecords;
    }

    public void setQuantitiyOfRecords(int quantitiyOfRecords) {
        this.quantitiyOfRecords = quantitiyOfRecords;
    }

    public String getPropriedadeOrdenacao() {
        return propriedadeOrdenacao;
    }

    public void setPropriedadeOrdenacao(String propriedadeOrdenacao) {
        this.propriedadeOrdenacao = propriedadeOrdenacao;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }


}


