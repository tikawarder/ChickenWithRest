package com.example.chicken.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Chicken {
    long id;
    String name;
    int eggNumber;
}
