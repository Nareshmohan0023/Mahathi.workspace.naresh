package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import entity.Event;
import entity.Participant;
import utils.PrepareQuery;
import utils.Queries;

public class EventManagementImpl {

	
	public static ResultSet viewAllEvents() throws SQLException,SQLServerException {
		return PrepareQuery.view(Queries.VIEW_EVENT);
	}

	public static void addEvent(Event event)throws SQLException, SQLServerException {
		PrepareQuery.update(Queries.ADD_EVENT, 
				event.getEventId(),
				event.getEventName(),
				event.getEventDesc(),
				event.getEventVenue());
	}

	public static void editEvent(String column, int id,String value) throws SQLServerException, SQLException {
		PrepareQuery.update("UPDATE EVENTS SET "+column+" = ? WHERE EVENT_ID = ?;", value,id);

	}

	public static void deleteEvent(int eId) throws SQLException,  SQLServerException {
		PrepareQuery.update(Queries.DELETE_EVENT, eId);
	}

	public static void addParticipant(Participant p) throws SQLException, SQLServerException {
		PrepareQuery.update(Queries.ADD_PARTICIPANT, p.getpId(),p.getpName(),p.getEmail(),p.getPhone(),p.getPassword());
	}

	public static void deleteParticipant(int pId) throws SQLException, SQLServerException {
		PrepareQuery.update(Queries.DELETE_PARTICIPANT, pId);
	}

	public static void editParticipant(String column, int id,String value) throws SQLServerException, SQLException {
		PrepareQuery.update("UPDATE PARTICIPANTS SET "+column+" = ? WHERE P_ID = ?;", value,id);
	}

	public static ResultSet viewRegisters() throws SQLException, SQLServerException{
		return PrepareQuery.view(Queries.VIEW_REGISTERS);
	}

	public static ResultSet viewParticipantList() throws SQLException, SQLServerException {
		return PrepareQuery.view(Queries.VIEW_PARTICIPANT);
	}
	
	public static ResultSet viewParticipantByID(String pName) throws SQLException, SQLServerException {
		return PrepareQuery.view(Queries.VIEW_PARTICIPANT_BY_ID,pName);
	}

	public static void register(int eId,int pId) throws SQLException, SQLServerException {
		Random rand = new Random();
		int rId = rand.nextInt(100000);
		PrepareQuery.update(Queries.REGISTER_FOR_EVENT,rId,eId,pId);
	}
	
	public static ResultSet getDetails() throws SQLException, SQLServerException {
		return PrepareQuery.view(Queries.DETAILS);
	}
}
