package com.tselree.collector.DAO;

public interface OmniformDAO {
	public void addOmniform(String id, String payload);
	public void updOmniform(String id, String payload);
	public String checkOmniform(String id);
}
