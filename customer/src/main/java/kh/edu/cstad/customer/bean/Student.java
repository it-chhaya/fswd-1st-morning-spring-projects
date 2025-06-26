package kh.edu.cstad.customer.bean;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private String uuid;
    private String fullName;
    private Double score;

}
