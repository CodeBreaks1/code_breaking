package bcccp.tickets.adhoc;

import java.util.List;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private IAdhocTicketFactory factory;
	private int currentTicketNo;

	
	
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		if(factory == null)
			throw new RuntimeException("factory is null");
		this.factory = factory;
	}



	@Override
	public IAdhocTicket createTicket(String carparkId) {
		if(carparkId == null || carparkId.isEmpty())
			throw new RuntimeException("CarparkID is invalid");		
		return null; // Returns a valid adhoc ticket, ==> No available IAdhocTicket property or method
	}



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
