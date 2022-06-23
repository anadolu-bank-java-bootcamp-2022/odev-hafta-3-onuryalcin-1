package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChartService {
	
	CSVRepository cryptoDataCSVRepository;
	
	public ChartService(CSVRepository cryptoDataCSVRepository) {
		this.cryptoDataCSVRepository = cryptoDataCSVRepository;
	}
	
	public CandleStickChart createChartFromCryptoData() {
		// Bu metodu doldurmanizi bekliyoruz.

		CandleStickChart candleStickChart;
		try {
			candleStickChart = new CandleStickChart("BTC/USDT Chart");
			List<Candle> candleList = new ArrayList<>();
			candleList = cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");
			System.out.println(candleList.toString());
			candleList.forEach(item -> {
				candleStickChart.addCandle(item.getTime(), item.getOpen(), item.getHigh(), item.getLow(), item.getClose(), item.getVolume());

			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return candleStickChart;
	}
}
