package bcccp.tickets.adhoc;

import java.util.Date;


public class AdhocTicket implements IAdhocTicket {
	
	private String carparkId;
	private int ticketNo;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;

	
	
	public AdhocTicket(String carparkId, int ticketNo, String barcode) throws Exception {
		
		if(ticketNo <= 0)
			throw new RuntimeException("Invalid ticketNo");
		if(barcode.isEmpty() || barcode == null)
			throw new RuntimeException("Invalid barcode");
		if(carparkId.isEmpty() || carparkId == null)
			throw new RuntimeException("Invalid carparkId");
		
		this.carparkId = carparkId;
		this.ticketNo = ticketNo;
		this.barcode =  barcode; // "A" + ticketNo + entryDateTime; // - not clear what the requirement is
	}


	@Override
	public int getTicketNo() {
		return this.ticketNo;
	}


	@Override
	public String getBarcode() {
		return "A" + this.barcode + entryDateTime; // Should it be returned as a this.barcode or as to the requirement description?
	}


	@Override
	public String getCarparkId() {
		return this.carparkId;
	}


	@Override
	public void enter(long dateTime) throws Exception {
		if(dateTime <= 0)
			throw new RuntimeException("Invalid dateTime");
		this.entryDateTime = dateTime;
		
	}


	@Override
	public long getEntryDateTime() {
		return entryDateTime;
	}


	@Override
	public boolean isCurrent() {
		if(this.entryDateTime > 0) // need to Add exit constraint
			return true;
		else
			return false;
	}


	@Override
	public void pay(long dateTime, float charge) {
		if(dateTime <= this.entryDateTime)
			throw new RuntimeException("Invalid payment date");
		this.paidDateTime = dateTime;
		this.charge = charge;
	}


	@Override
	public long getPaidDateTime() {
		if(this.isPaid())
			return this.paidDateTime;
		else
			return 0;
	}


	@Override
	public boolean isPaid() {
		if(isCurrent())
			return true;
		else
			return false;
	}


	@Override
	public float getCharge() {
		if(this.charge > 0) // Not clear
			return this.charge;
		else
			return 0;
	}


	@Override
	public void exit(long dateTime) {
		if(this.exitDateTime <= this.paidDateTime)
			throw new RuntimeException("Invalid exitDateTime");		
	}


	@Override
	public long getExitDateTime() {
		if(hasExited())
			return this.exitDateTime;
		else
			return 0;
	}


	@Override
	public boolean hasExited() {
		if(true) // Not clear
			return true;
		else
			return false;
	}

	
	
}
