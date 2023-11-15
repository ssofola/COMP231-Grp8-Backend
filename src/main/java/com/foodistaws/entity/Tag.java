package com.foodistaws.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tag")
@Data
public class Tag {
    private String TagID;
}
