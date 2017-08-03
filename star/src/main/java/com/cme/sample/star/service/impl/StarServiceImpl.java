package com.cme.sample.star.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cme.sample.InstrumentModel.Instrument;
import com.cme.sample.cc.serviceimpl.InstrumentServiceImpl;

@Produces(MediaType.APPLICATION_JSON)
public class StarServiceImpl {

	Map<String, Instrument> instrumentMap;
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
	
	@GET
	@Path("/")
	public Instrument[] getAll() {
		System.out.println("Requesting for getAll() ");
		return instrumentMap.values().toArray(new Instrument[]{});
	}
	
	@POST
	@Path("/")
	public void addInstrument(Instrument instrument) {
		System.out.println("Add request received for " + instrument.getSymbol());
		instrumentMap.put(instrument.getSymbol(), instrument);
		InstrumentServiceImpl instrumentServiceImpl = new InstrumentServiceImpl();
		instrumentServiceImpl.loadIntoCache(instrument);
	}
	
	
	public Instrument getInstrumentFromMap(String symbol) {
		System.out.println("In getInstrumentFromMap() @ STAR service ");
		return instrumentMap.get(symbol);
		
	}
}
