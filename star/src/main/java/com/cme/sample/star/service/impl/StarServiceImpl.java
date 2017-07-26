package com.cme.sample.star.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.cme.sample.InstrumentModel.Instrument;
import com.cme.sample.cc.service.InstrumentService;
import com.cme.sample.cc.serviceimpl.InstrumentServiceImpl;
import com.cme.sample.star.service.StarService;


public class StarServiceImpl implements StarService{

	/*Map<String, Instrument> instrumentMap;
	public StarServiceImpl()
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
	
	public Instrument[] getAll() {
		System.out.println("Requesting for getAll() ");
		return instrumentMap.values().toArray(new Instrument[]{});
	}*/
	public void addInstrument(Instrument instrument) {
		System.out.println("Add request received for " + instrument.getSymbol());
		//instrumentMap.put(instrument.getSymbol(), instrument);
		//Logic to push instrument in CC Service
		InstrumentService instrumentService = new InstrumentServiceImpl();
		instrumentService.loadIntoCache(instrument);
	}
	/*public Instrument getInstrumentFromMap(String symbol) {
		System.out.println("In getInstrumentFromMap() @ STAR service ");
		return instrumentMap.get(symbol);
		
	}*/
}
