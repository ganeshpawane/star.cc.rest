package com.cme.sample.cc.serviceimpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cme.sample.InstrumentModel.Instrument;
import com.cme.sample.cc.service.InstrumentService;
import com.cme.sample.star.service.StarService;
import com.cme.sample.star.service.impl.StarServiceImpl;
//import com.cme.sample.db.service.DbService;
//import com.cme.sample.db.service.impl.DbServiceImpl;

@Produces(MediaType.APPLICATION_JSON)
public class InstrumentServiceImpl {

	private static Map<String, Instrument> instrumentMap = new ConcurrentHashMap<String, Instrument>();

	public void init(){
		System.out.println("CCService Bundle is started...");
	}
	
	public void stop(){
		System.out.println("Good bye CCService...");
	}

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
	@GET
	@Path("/{symbol}")
	public Instrument getInstrument(@PathParam("symbol") String symbol) {
		System.out.println("Requesting for contract whose symbol is : "+symbol);
		if(instrumentMap.containsKey(symbol)) {
			System.out.println("Contract is found in contract cache.. ");
			return instrumentMap.get(symbol);
		}
		else {
			//DbService dbService = new DbServiceImpl();
			StarServiceImpl starServiceImpl = new StarServiceImpl();
			System.out.println("Contract is not found in contract cache");
			System.out.println("Fetching from Database...");
			//Instrument instrument = dbService.getInstrumentFromDb(symbol);
			Instrument instrument = starServiceImpl.getInstrumentFromMap(symbol);
			instrumentMap.put(instrument.getSymbol(), instrument);
			return instrument;
		}
	}

	//process get() All request
	@GET
	@Path("/")
	public Instrument[] getAllInstrument() {
		System.out.println("Requesting for getAll() @ccServer side");
		System.out.println("MapSize : " +instrumentMap.size());
		return instrumentMap.values().toArray(new Instrument[]{});
	}
}
