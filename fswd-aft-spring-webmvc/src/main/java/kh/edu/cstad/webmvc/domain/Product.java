package kh.edu.cstad.webmvc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private String id;
    private String category;
    private Integer rate;
}
