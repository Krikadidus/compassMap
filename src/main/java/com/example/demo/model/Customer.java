package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    //fields or attributes
    //variables to model, define, configure, identify ,etc ...
    // when we create an object
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    @JsonIgnore
    @OneToOne(mappedBy = "customer")
    private AssessmentView assessmentViewInCustomer;

    public Customer(String id, String firstName, String lastName, String email, String phone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // methods
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', email='%s', phone='%s', address='%s']",
                id, firstName, lastName, email, phone, address);
    }


}