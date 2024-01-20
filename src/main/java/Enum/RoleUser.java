package Enum;

public enum RoleUser {
    USER("user");

    private String role;

    RoleUser(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
