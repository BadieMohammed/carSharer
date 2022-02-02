package de.unidue.inf.is.domain;

public final class User {

    private String name;
    private String email;


    public User() {
    }


    public User(String name, String email ) {
        this.name = name;
        this.email = email;

    }
    
    
    public void setName(String Name) {
    	this.name = Name;
	}
    public void setEmail (String email) {
		this.email = email ;
	}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
}