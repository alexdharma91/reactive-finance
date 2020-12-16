package com.home.homewebflux.dto;

import com.home.homewebflux.model.entity.ProductType;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;

@Data
public class ApplicationDto {
    private String clientFio;
    private ProductType productType;
    private boolean sex;
    private int age;
    private Double income;
}
