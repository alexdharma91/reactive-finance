package com.home.homewebflux.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.util.annotation.NonNull;

@Data
@Accessors(chain = true)
@Table("cards")
public class Card {
    @Id
    private Long id;

    private String clientFio;
    private String embossingName;
    private Integer yearExpiration;

    @NonNull
    private Integer monthExpiration;
}
