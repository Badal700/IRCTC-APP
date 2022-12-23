package com.example.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.response.TicketResponse;

@Repository
public class IrctcDao {
	
	private Map<String, TicketResponse> ticketMap = new HashMap<>();
	
	public String saveTicket(TicketResponse response) {
		ticketMap.put(response.getPnr(), response);
		return response.getPnr();
	}
	
	public String updateTicket(TicketResponse response) {
		String pnr = response.getPnr();
		ticketMap.put(pnr, response);
		return "Ticket Updated";
	}
	
	public String deleteTicket(String pnr) {
		ticketMap.remove(pnr);
		return "Ticket deleted";
	}
	
	public TicketResponse getTicketByPnr(String pnr) {
		if(ticketMap.containsKey(pnr)) {
			return ticketMap.get(pnr);
		}
		return null;
	}
	

}
