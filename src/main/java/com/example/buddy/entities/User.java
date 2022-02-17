package com.example.buddy.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "createDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "bank_account")
    private Compte compte;

    @OneToMany
    private List<Transaction> transactions;

    @ManyToMany
    @JoinTable(name = "connection", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "freind_id"))
    private List<User> freinds = new ArrayList<User>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User(String firstName, String lastName, String email, String password, BigDecimal balance, Date createDate,
            List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.createDate = createDate;
        this.roles = roles;
        this.createDate = new Date();

    }

    public User(String firstName, String email, String password) {
        super();
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.createDate = new Date();
    }

}
