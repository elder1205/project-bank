package ec.com.sofka.dto;

import jakarta.validation.constraints.*;

public class CustomerRequestDTO {

    private String idCustomer;
    @NotNull(message = "Password is required")
    @Size(min = 4, max = 25, message = "The password field must have a minimum of 4 characters and a maximum of 25 characters. ")
    private String password;

    @NotNull(message = "State is required")
    @Size(min = 4, max = 4, message = "The status field must be 4 characters long.")
    @Pattern(regexp = "true|false", message = "State must be true or false")
    private String state;

    @NotNull(message = "Name is required")
    @Size(max = 20, message = "The name field must have a maximum of 20 characters.")
    private String name;

    @NotBlank(message = "Gender cannot be empty")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private int age;

    @NotBlank(message = "Identification cannot be empty")
    @Size(min = 6, max = 20, message = "Identification must be between 6 and 20 characters")
    private String identification;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotBlank(message = "Phone cannot be empty")
    @Pattern(regexp = "\\d{10,15}", message = "Phone must be between 10 and 15 digits")
    private String phone;

    public CustomerRequestDTO() {
    }

    public CustomerRequestDTO(String password, String state, String name, String gender, int age, String identification, String address, String phone) {
        this.password = password;
        this.state = state;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
