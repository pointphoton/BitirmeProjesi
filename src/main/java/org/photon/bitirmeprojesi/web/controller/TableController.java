/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.web.controller;

import antlr.debug.Event;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.photon.bitirmeprojesi.ejb.CategoryFacadeLocal;
import org.photon.bitirmeprojesi.ejb.ProductFacadeLocal;
import org.photon.bitirmeprojesi.ejb.SessionFacadeLocal;
import org.photon.bitirmeprojesi.web.entity.Category;
import org.photon.bitirmeprojesi.web.entity.Product;
import org.photon.bitirmeprojesi.web.jsf.lazymodel.repository.ProductFilter;
import org.photon.bitirmeprojesi.web.jsf.lazymodel.repository.Products;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named("table")
@SessionScoped
public class TableController implements Serializable {

    @EJB(beanName = "ProductEJB")
    private ProductFacadeLocal productEJB;
    @EJB(beanName = "SessionEJB")
    private SessionFacadeLocal sessionEJB ;
      @EJB(beanName = "CategoryEJB")
   private CategoryFacadeLocal categoryEJB;
       
    private Product product;
    private LazyDataModel<Product> lazyDataModel;
    private ProductFilter filter  ;
    private Products products;
    private Product selectedProduct;
    private Category proCategory;
   private List<Category> categoryList;

    @PostConstruct
    public void init() {
        selectedProduct = new Product();
        product = new Product();
        proCategory = new Category();
         categoryList = categoryEJB.findAll();
        filter   = new ProductFilter();
      products=new Products(sessionEJB.getEntityManager());
        List<Product> results = productEJB.findAll();
             
       // lazyDataModel = new LazyProductDataModel(results);
        
      lazyDataModel=  new LazyDataModel<Product>() {
			@Override
			public List<Product> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				
				filter.setFirstRecord(first);
				filter.setQuantitiyOfRecords(pageSize);
				filter.setAscending(SortOrder.ASCENDING.equals(sortOrder));
				filter.setPropriedadeOrdenacao(sortField);
				setRowCount(products.quantityFilter(filter));
				return products.filterProducts(filter);
			}
                    	 @Override
			    public Product getRowData(String rowKey) {
                                                               
			        for(Product product : products.filterProducts(filter)) {
			            if(  String.valueOf(product.getProductId()).equals(rowKey)){
                                   			                return product;
                                    }
			        }
			 
			        return null;
			    }
			 
			    @Override
			    public Object getRowKey(Product prd) {
			        return prd.getProductId();
			    }
		};

    }

    public void onRowSelect(SelectEvent event) {
     
          FacesMessage msg = new FacesMessage("Product Selected",
                String.valueOf(((Product) event.getObject()).getProductId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
       FacesMessage msg = new FacesMessage("Product UnSelected",
             String.valueOf(((Product) event.getObject()).getProductId()));
      FacesContext.getCurrentInstance().addMessage(null, msg);
    }

     public void onRowEdit(RowEditEvent event) {
         
         Product pro = ((Product) event.getObject());
           System.out.println("pro id :"+ pro.getProductId()+"pro name: " + pro.getName()+" price:  "+pro.getCurrentPrice() +" desc: "+pro.getProDescription()+"isActive : "+
                   pro.getIsActive()+" cat  "+ pro.getCategory()) ;
         try{
         productEJB.edit(pro);
         }
         catch(Exception e){
         //logging
             onRowCancel(event);
         }
           FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(pro.getProductId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
    }
     
    public void onRowCancel(RowEditEvent event) {
          FacesMessage msg = new FacesMessage("Product Cancelled",
                String.valueOf(((Product) event.getObject()).getProductId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LazyDataModel<Product> getLazyDataModel() {
        return lazyDataModel;
    }

    public void setLazyDataModel(LazyDataModel<Product> lazyDataModel) {
        this.lazyDataModel = lazyDataModel;
    }

    public ProductFilter getFilter() {
        return filter;
    }

    public void setFilter(ProductFilter filter) {
        this.filter = filter;
    }

    public Category getProCategory() {
        return proCategory;
    }

    public void setProCategory(Category proCategory) {
        this.proCategory = proCategory;
    }
    
  
}
