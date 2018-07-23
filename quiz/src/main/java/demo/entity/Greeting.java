package demo.entity;

import demo.service.UserServiceImpl;

public class Greeting {

    private final long id;
    private final String content;
    private final String name;
    private final int totalNumbers;
    private UserServiceImpl usi;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content; 
        this.name = content;
        this.totalNumbers = 0;
        
    }

    public Greeting(String name) {
    	
        if(usi == null){
        	usi = new UserServiceImpl();
        }    	
        this.totalNumbers = getTotalNumbers(name);
        this.content = name; 
        this.id = getTotalNumbers(name);
    	this.name = name;
    }

	public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private int getTotalNumbers(String name) {    	
    	int i = 0;
    	i = usi.getTotalNumbersForName(name);
    	return i;
    }

}
