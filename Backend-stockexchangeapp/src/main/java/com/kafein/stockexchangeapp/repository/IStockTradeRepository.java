package com.kafein.stockexchangeapp.repository;

import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.entities.StockTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStockTradeRepository extends JpaRepository<StockTrade,Long> {
    @Query("SELECT s FROM StockTrade st\n" +
            "     JOIN st.stock s\n" +
            "     JOIN st.client c\n" +
            "      WHERE s.stockId= st.stock.stockId AND c.userId =:clientId")
    List<Stock> findByUserId(@Param("clientId")long id);



    @Query("SELECT c FROM StockTrade st\n" +
            "     INNER JOIN st.stock s\n" +
            "    INNER  JOIN st.client c\n" +
            "      WHERE c.userId = st.client.userId AND s.stockId =:stockId")
    List<Client> findByStockId(@Param("stockId")long id);

    @Query("SELECT st FROM StockTrade st WHERE st.client.userId=:clientId AND st.stock.stockId=:stockId")
    StockTrade findStockTradeByClientAndStock(long clientId, long stockId);



}
