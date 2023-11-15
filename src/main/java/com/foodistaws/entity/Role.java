package com.foodistaws.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
@Data
public class Role {
    @Id
    private String roleID;
    private String name;
    private String description;
}
