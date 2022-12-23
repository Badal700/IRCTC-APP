package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IrctcDao;
import com.example.request.PassengerRequest;
import com.example.response.TicketResponse;

@Service
public class IrctcService {
	
	@Autowired
	private IrctcDao dao;
	
	public String bookTicket(PassengerRequest request) {
		TicketResponse response = new TicketResponse();
		response.setName(request.getName());
		response.setStatus("CONFIRMED");
		response.setCost(545.00);
		response.setFrom(request.getFrom());
		response.setTo(request.getTo());
		response.setJdate(request.getJdate());
		String pnr = UUID.randomUUID().toString();
		response.setPnr(pnr);
		
		dao.saveTicket(response);
		
		return pnr;
	}
	
	public TicketResponse getTicketByPnr(String pnr) {
		return dao.getTicketByPnr(pnr);
	}
	
	public String updateTicket(TicketResponse ticket) {
		return dao.updateTicket(ticket);
	}
	
	public String deleteTicket(String pnr) {
		return dao.deleteTicket(pnr);
	}

}
