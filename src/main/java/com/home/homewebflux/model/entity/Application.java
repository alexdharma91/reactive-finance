package com.home.homewebflux.model.entity;

import com.home.homewebflux.dto.ApplicationDto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Table("application")
public class Application {

    @Id
    private Long id;
    private String clientFio;
    private boolean sex;
    private int age;
    private Double income;
    private ProductType productType;
    private LocalDateTime creationDateTime;
    private LocalDateTime processedDateTime;
    private Boolean scoringResult;

    public static Application fromDto(ApplicationDto applicationDto) {
        return new Application()
                .setAge(applicationDto.getAge())
                .setSex(applicationDto.isSex())
                .setCreationDateTime(LocalDateTime.now())
                .setIncome(applicationDto.getIncome())
                .setProductType(applicationDto.getProductType());
    }

}
