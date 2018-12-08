package com.niit.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProfilePicture {
@Id
private String email;
@Lob
private byte[] image;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
}
