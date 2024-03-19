package Model;

public class Client {

    private String last_name;
    private String first_name;
    private String email;
    private int age;
    private int memberLvl;

    public Client(String last_name, String first_name, String email, int age, int memberLvl) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.age = age;
        this.memberLvl = memberLvl;
    }

    public String getLastName() {return last_name;}
    public String getFirstName() {return first_name;}
    public String getEmail() {return email;}
    public int getAge() {return age;}
    public int getMemberLvl() {return memberLvl;}
}
