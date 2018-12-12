package com.office.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.*;



@Data
@Entity
@EqualsAndHashCode(callSuper = false)

public class Position extends IdHolder {

    private String name;
    private String description;
    private double salary;
    @OneToMany(mappedBy = "position")
    @JsonIgnore
    private Set<Employee> employees;

}
