package Form;

import jakarta.persistence.*;

@Entity
public class FormContent {

    private String fullName;
    @Id
    private String email;
    private String phone;
    private String gender;
    private String dob;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String qualification;
    private String examCenter;
    private String category;
    private String password;
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Lob
    @Column(name = "signature")  // Store the image as bytes
    private byte[] signature;


    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public FormContent() {
        /* No-argument constructor Need
        Required by many Java frameworks (like JSP/Servlet, Hibernate, Spring) to instantiate objects using reflection.
        Allows you to create an object first and then set values using setters. */
    }
    public FormContent(String fullName, String email, String phone, String gender,
                       String dob, String address, String city, String state,
                       String pinCode, String qualification, String examCenter,
                       String category, String password , byte[] photo , byte[] signature) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.qualification = qualification;
        this.examCenter = examCenter;
        this.category = category;
        this.password = password;
        this.photo = photo;
        this.signature = signature;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExamCenter() {
        return examCenter;
    }

    public void setExamCenter(String examCenter) {
        this.examCenter = examCenter;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FormContent{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", qualification='" + qualification + '\'' +
                ", examCenter='" + examCenter + '\'' +
                ", category='" + category + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
