package com.gmail.ilerofv.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class Report {
    private int count;
    private BigDecimal average;
}
