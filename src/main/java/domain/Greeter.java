package domain;

public class Greeter {
    private String name;
    private String password;

    public String input(String input) {
        String result = input + " " + name + " " + password;
        return result;
    }

    public void setName(String name) {
        System.out.println("name주입");
        this.name = name;
    }

    public void setPassword(String password) {
        System.out.println("password주입");
        this.password = password;
    }
}
