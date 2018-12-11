package com.office.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Employee extends IdHolder {
    private String name;
    private Date birth;
    @ManyToOne
    private Position position;

}
