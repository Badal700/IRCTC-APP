package com.example.request;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class PassengerRequest {
	
	private String name;
	private String email;
	private Long phno;
	private String from;
	private String to;
	private String jdate;
	private String trainNum;

}
