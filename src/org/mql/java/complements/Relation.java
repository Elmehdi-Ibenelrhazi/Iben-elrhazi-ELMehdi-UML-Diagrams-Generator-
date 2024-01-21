package org.mql.java.complements;

public class Relation {
	public String type;
	public String source;
	public String destination;

	public Relation() {
		
		
	}
	
	

	public Relation(String type, String source, String destination) {
		super();
		this.type = type;
		this.source = source;
		this.destination = destination;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
