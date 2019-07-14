package com.unionsystems.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Obiora
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    private Long id;
    private String name;
    private String address;
    private Integer age;
}
