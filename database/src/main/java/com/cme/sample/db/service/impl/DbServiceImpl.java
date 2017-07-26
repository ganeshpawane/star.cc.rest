package com.cme.sample.db.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.cme.sample.InstrumentModel.Instrument;
import com.cme.sample.db.service.DbService;

public class DbServiceImpl implements DbService{
	Map<String, Instrument> instrumentMap;
	public DbServiceImpl()
	{
		instrumentMap = new HashMap<String, Instrument>();
		Instrument instrument = loadInitidalData();
		instrumentMap.put("PLF", instrument);
		instrument = loadInitidalData1();
		instrumentMap.put("NG", instrument);
	}
	public Instrument loadInitidalData()
	{
		Instrument instrument = new Instrument();
        instrument.setTitle("Platinum");
        instrument.setSymbol("PLF");
        instrument.setGroup("Metals");
        return instrument;
	}
	public Instrument loadInitidalData1()
	{
		Instrument instrument = new Instrument();
        instrument.setTitle("Natural Gas");
        instrument.setSymbol("NG");
        instrument.setGroup("Energy");
        return instrument;
	}
	public Instrument getInstrumentFromDb(String symbol) {
		System.out.println("In getInstrumentFromDb() @ DB service ");
		return instrumentMap.get(symbol);
	}
}
