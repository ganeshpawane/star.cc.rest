package com.cme.sample.cc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cme.sample.InstrumentModel.Instrument;

@Produces(MediaType.APPLICATION_JSON)
public interface InstrumentService {
	@GET
	@Path("/{symbol}")
	public Instrument getInstrument(@PathParam("symbol") String symbol);
	
	@GET
	@Path("/")
	public Instrument[] getAllInstrument();
	public void loadIntoCache(Instrument instrument);
}
