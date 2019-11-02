package io.java.startUpGProject.APIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/management")
public class UserRoleManagement {

	@RequestMapping("/users")
	public List<User> getAll(){


		List<User> users = new ArrayList<User>();
		for (int i =0;i<4;i++){
			users.add( new User("SOHAIB "+i,"FAROUKH "+i,"SohaibF"));
		}
		return users;
	}

}






class User{
	private int Id;

	public User(){

    }
	public User(String firstName, String lastName, String alias) {
	    Random generateRandom = new Random();
	    Id = generateRandom.nextInt(10000);
		FirstName = firstName;
		LastName = lastName;
		Alias = alias;
		creationDate = new Date(); // set now date
	}

	private String FirstName;
	private String LastName;
	private String Alias;
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAlias() {
		return Alias;
	}

	public void setAlias(String alias) {
		Alias = alias;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	private Date creationDate;


}
