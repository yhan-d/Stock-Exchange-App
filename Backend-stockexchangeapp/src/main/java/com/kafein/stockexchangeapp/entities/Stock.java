package com.kafein.stockexchangeapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id",nullable = false)
    private Long stockId;

    @Column(name = "stock_code",nullable = false,unique = true)
    private String stockCode;

    @Column(name = "stock_name",nullable = false,unique = true)
    private String stockName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "stock", cascade = {CascadeType.ALL})
    private Set<StockTrade> stockTrades = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return stockId != null && stockId.equals(((Stock) o).stockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, stockCode, stockName);
    }


}

