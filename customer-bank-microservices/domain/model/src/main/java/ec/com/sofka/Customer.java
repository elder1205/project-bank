package ec.com.sofka;

public class Customer  extends Person{

    private String idCustomer;
    private String  password;
    private String state;

    public Customer() {
    }

    public Customer(String idCustomer, String password, String state) {
        this.idCustomer = idCustomer;
        this.password = password;
        this.state = state;
    }

    public Customer(String idPerson, String name, String gender, int age, String identification, String address, String phone, String idCustomer, String password, String state) {
        super(idPerson, name, gender, age, identification, address, phone);
        this.idCustomer = idCustomer;
        this.password = password;
        this.state = state;
    }

    public Customer(String idPerson, String name, String gender, int age, String identification, String address, String phone) {
        super(idPerson, name, gender, age, identification, address, phone);
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
}
