package springhw.beans;

import java.util.Objects;

public class Characters {
    private String name;
    private String role;

    public Characters() {
    }

    public Characters(String role) {
        super();
        this.role = role;
    }

    // static Фабричный метод
    public static Characters getCharacters(String role) {
        return new Characters(role);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
    @Override
    public String toString() {
        return "Characters{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", hashCode=" + hashCode() +
                '}';
    }
}
