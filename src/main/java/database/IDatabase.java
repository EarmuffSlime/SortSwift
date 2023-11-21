package database;


import java.util.ArrayList;

import adminSystem.*;

public interface IDatabase {
	public abstract ArrayList<LoginCredentials> accessDatabase();
}