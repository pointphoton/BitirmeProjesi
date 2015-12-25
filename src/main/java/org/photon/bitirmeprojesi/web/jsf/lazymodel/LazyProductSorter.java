package org.photon.bitirmeprojesi.web.jsf.lazymodel;


import java.util.Comparator;
import org.photon.bitirmeprojesi.web.entity.Product;

import org.primefaces.model.SortOrder;



public class LazyProductSorter implements Comparator<Product>{
	
	 private String sortField;     
	    private SortOrder sortOrder;
	     
	    public LazyProductSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	@Override
	public int compare(Product product1, Product product2) {
		try {
            Object value1 = Product.class.getField(this.sortField).get(product1);
            Object value2 = Product.class.getField(this.sortField).get(product2);
 
            @SuppressWarnings({ "unchecked", "rawtypes" })
			int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }

}
}
