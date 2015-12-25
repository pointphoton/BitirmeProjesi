package org.photon.bitirmeprojesi.web.jsf.lazymodel;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.photon.bitirmeprojesi.web.entity.Product;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


public class LazyProductDataModel extends LazyDataModel<Product>{
	
	private static final long serialVersionUID = -1027980125057101662L;
	private List<Product> datasource;
	
	
	public LazyProductDataModel(List<Product> datasource) {
		this.datasource=datasource;
	}
	
	@Override
	public Product getRowData(String rowKey){
		
		for (Product product : datasource) {
			   if(  String.valueOf(product.getProductId()).equals(rowKey))
                return product;
		}
		
		return null;
	}
	
	@Override
    public Object getRowKey(Product product) {
        return product.getProductId();
    }
 
	
	@Override
	public List<Product> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Product> products = new ArrayList<>();
		
		//filter
		 for(Product product : datasource) {
	            boolean match = true;
	 
	            if (filters != null) {
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    try {
	                        String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = String.valueOf(product.getClass().getField(filterProperty).get(product));
	 
	                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
	                            match = true;
	                    }
	                    else {
	                            match = false;
	                            break;
	                        }
	                    } catch(Exception e) {
	                        match = false;
	                    }
	                }
	            }
	 
	            if(match) {
	            	products.add(product);
	            }
	        }
		 
		 if(sortField != null) {
	            Collections.sort(products, new LazyProductSorter(sortField, sortOrder));
	        }
	 
	        //rowCount
	        int dataSize = products.size();
	        this.setRowCount(dataSize);
	 
	        //paginate
	        if(dataSize > pageSize) {
	            try {
	                return products.subList(first, first + pageSize);
	            }
	            catch(IndexOutOfBoundsException e) {
	                return products.subList(first, first + (dataSize % pageSize));
	            }
	        }
	        else {
	            return products;
	        }
	    }
	}