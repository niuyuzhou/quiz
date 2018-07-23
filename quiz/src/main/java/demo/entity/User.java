package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import demo.service.UserServiceImpl;

@JsonIgnoreProperties({"id"})
public class User {
    private long id;
    private String name;
    @JsonProperty("TotalNumbers")
    private int totalNumbers;
    private UserServiceImpl usi;

    public User(long id, String name) {
        //this.id = id;
        this.name = name;
        
        if(usi == null){
        	usi = new UserServiceImpl();
        }      
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getTotalNumbers(){
    	return usi.getTotalNumbersForName(this.name);
    }
   
}
