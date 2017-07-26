package com.cme.sample.db.service;

import com.cme.sample.InstrumentModel.Instrument;

public interface DbService {

	public Instrument getInstrumentFromDb(String symbol);
}
