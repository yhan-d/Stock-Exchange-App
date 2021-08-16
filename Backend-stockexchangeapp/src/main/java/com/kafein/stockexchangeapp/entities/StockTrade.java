package com.kafein.stockexchangeapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="stock_trades")
@Data
public class StockTrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "stock_trade_id")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(name = "count")
    private int count;

    @Column(name = "total_price")
    private int totalPrice;

    public StockTrade() {
    }

    public StockTrade(Long id, Client client, Stock stock, int count, int totalPrice) {
        this.id = id;
        this.client = client;
        this.stock = stock;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockTrade that = (StockTrade) o;
        return  Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, stock, count, totalPrice);
    }

    @Override
    public String toString() {
        return "StockTrade{" +
                "id=" + id +
                ", client=" + client +
                ", stock=" + stock +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
