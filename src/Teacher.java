public class Teacher {
    private int teacherId;
    private String name;
    private String phone;
    private String dataOfBirth;
    private String email;
    private String address;

    //contructor
    public Teacher(int teacherId, String name, String phone, String dataOfBirth, String email, String address) {
        this.teacherId = teacherId;
        this.name = name;
        this.phone = phone;
        this.dataOfBirth = dataOfBirth;
        this.email = email;
        this.address = address;
    }

    // get set
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return teacherId+ ", Name "+ name+ ", Phone "+ phone+
                ", Email "+ email+ ", Address "+ address+".";
    }
}
