package com.view;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.jboss.seam.transaction.Transactional;
import org.metawidget.forge.navigation.MenuItem;
import org.metawidget.forge.persistence.PaginationHelper;
import org.metawidget.forge.persistence.PersistenceUtil;

import com.cdi.producer.field.ToDo;

@Transactional @Named
@RequestScoped
public class ToDoBean extends PersistenceUtil implements MenuItem
{
   private static final long serialVersionUID = 1L;
   
   private List<ToDo> list = null;
   private ToDo toDo = new ToDo();
   private long id = 0;
   private PaginationHelper<ToDo> pagination;		
   
   public Class<?> getItemType()
   {
      return ToDo.class;
   }
   
   public String getLiteralPath()
   {
      return null;
   }

   public String getLabel()
   {
      return null;
   }

   public void load()
   {
      toDo = findById(ToDo.class, id);
   }
   
   public String create()
   {
      create(toDo);
      return "view?faces-redirect=true&id=" + toDo.getId();
   }

   public String delete()
   {
      delete(toDo);
      return "list?faces-redirect=true";
   }

   public String save()
   {
      save(toDo);
      return "view?faces-redirect=true&id=" + toDo.getId();
   }

   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
      if(id>0){
			load();
	  }	
   }
   
   public ToDo getToDo()
   {
      return toDo;
   }

   public void setToDo(ToDo toDo)
   {
      this.toDo = toDo;
   }

   public List<ToDo> getList()
   {
      if(list == null)
      {
         list = getPagination().createPageDataModel();
      }
      return list;
   }

   public void setList(List<ToDo> list)
   {
      this.list = list;
   }
  
   public PaginationHelper<ToDo> getPagination() 
   {
		if (pagination == null) 
		{
			pagination = new PaginationHelper<ToDo>(10) 
			{
				@Override
				public int getItemsCount() {
					return count(ToDo.class);
				}

				@Override
				public List<ToDo> createPageDataModel() 
				{
					return new ArrayList<ToDo>(findAll(ToDo.class,
							 getPageFirstItem(), getPageSize() ));
				}
			};
		}
		return pagination;
	}

   public void setPagination(final PaginationHelper<ToDo> helper)
   {
      pagination = helper;
   }
}