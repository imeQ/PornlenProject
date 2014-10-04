package com.pornlen.controller;

import com.pornlen.dao.EntityRepository;
import com.pornlen.domain.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@Scope("view")
@ManagedBean//only for autocompletion in xhtml. annotation not working
public class SmallNumberBean {

    @Autowired
    EntityRepository testEntityDao;

	@Max(10)
	@Min(50)
   private int smallNumber = 42;

   public int getSmallNumber() {
      return smallNumber;
   }

   public void setSmallNumber(int smallNumber) {
      this.smallNumber = smallNumber;
   }

   public void showErrors() {
	   FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "The low-priority message is displayed.");
	   FacesContext.getCurrentInstance().addMessage("smallNumberID", fm);
	   fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "This error message is oppressed, although it seems to be more important.");
	   FacesContext.getCurrentInstance().addMessage("smallNumberID", fm);

       Entity entity = new Entity();
       entity.setName("name");
       testEntityDao.save(entity);

       System.out.println("--> Error <--");
   }

}