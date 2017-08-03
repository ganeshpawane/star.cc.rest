package com.cme.sample.star.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cme.sample.InstrumentModel.Instrument;

@Produces(MediaType.APPLICATION_JSON)
public interface StarService {
	@POST
	@Path("/")
	public void addInstrument(Instrument instrument);
	
	@GET
	@Path("/")
	public Instrument[] getAll();
	
	public Instrument getInstrumentFromMap(String symbol);
}
