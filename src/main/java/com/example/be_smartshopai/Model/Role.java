package com.example.be_smartshopai.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Role_id;
    private int Role;// phân quyền

    public Role() {
    }

    public Role(long role_id, int role) {
        Role_id = role_id;
        Role = role;
    }

    public long getRole_id() {
        return Role_id;
    }

    public void setRole_id(long role_id) {
        Role_id = role_id;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }
}

