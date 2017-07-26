package com.cme.sample.cc.serviceimpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cme.sample.InstrumentModel.Instrument;
import com.cme.sample.cc.service.InstrumentService;
import com.cme.sample.db.service.DbService;
import com.cme.sample.db.service.impl.DbServiceImpl;

public class InstrumentServiceImpl implements InstrumentService{

	private static Map<String, Instrument> instrumentMap = new ConcurrentHashMap<String, Instrument>();
	/*
	public InstrumentServiceImpl(){
		instrumentMap = new HashMap<String, Instrument>();
		//Instrument instrument = loadData();
		//instrumentMap.put("PLF", instrument);
		//instrument = loadInitidalData();
		//instrumentMap.put("#NG", instrument);
	}
	
	public Instrument loadData() {
		Instrument instrument = new Instrument();
        instrument.setTitle("Platinum");
        instrument.setSymbol("PLF");
        instrument.setGroup("Metals");
        return instrument;
	}*/
	
	public void loadIntoCache(Instrument instrument){
		System.out.println("In loadIntoCache() @CCService side ");
		System.out.println("title : "+instrument.getTitle());
		System.out.println("Symbol : "+instrument.getSymbol());
		System.out.println("Group : "+instrument.getGroup());
		//System.out.println("Group : "+instrument.getGroup());
		//instrumentMap = new HashMap<String, Instrument>();
		instrumentMap.put(instrument.getSymbol(), instrument);	
	}
	
	//process get() single request
	public Instrument getInstrument(String symbol) {
		System.out.println("Requesting for contract whose symbol is : "+symbol);
		if(instrumentMap.containsKey(symbol)) {
			System.out.println("Contract is found in contract cache.. ");
			return instrumentMap.get(symbol);
		}
		else {
			DbService dbService = new DbServiceImpl();
			System.out.println("Contract is not found in contract cache");
			System.out.println("Fetching from Database...");
			Instrument instrument = dbService.getInstrumentFromDb(symbol);
			instrumentMap.put(instrument.getSymbol(), instrument);
			return instrument;
		}
	}
	
	//process get() All request
	public Instrument[] getAllInstrument() {
		System.out.println("Requesting for getAll() @ccServer side");
		System.out.println("MapSize : " +instrumentMap.size());
		return instrumentMap.values().toArray(new Instrument[]{});
	}
}
