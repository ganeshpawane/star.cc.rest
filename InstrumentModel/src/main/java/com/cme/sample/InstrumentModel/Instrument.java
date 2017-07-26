package com.cme.sample.InstrumentModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Instrument {
	
		String title;
		String group;
		String symbol;	
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGroup() {
			return group;
		}
		public void setGroup(String group) {
			this.group = group;
		}
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}	
}