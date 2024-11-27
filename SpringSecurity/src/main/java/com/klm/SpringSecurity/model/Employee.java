package com.klm.SpringSecurity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Emp_Details_Crud")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private  String name;
        private String email;
        private long phone;
        private String created_by;
        private Date created_on;

}
