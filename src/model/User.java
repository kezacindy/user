package model;

import java.util.Date;

public class User {
    private int userId;
    private String name;
    private Date dob;
    private String email;
    private String gender;
    private String phoneNumber;
    private String province;
    private String title;
    private String district;
    private String password;

    // Getters and Setters

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
