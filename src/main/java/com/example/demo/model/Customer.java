package com.example.demo.model;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name ="AssessmentView_FK")
    private AssessmentView assessmentViewInCustomer;

    // methods
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', email='%s', phone='%s', address='%s']",
                id, firstName, lastName, email, phone, address);
    }


}