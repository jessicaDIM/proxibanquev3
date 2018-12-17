package fr.formation.proxibanquev3.persistance;

/**
 * Classe contenant sous forme de constantes l'ensemble des requetes necessaires aux manipulations de la base de donnees.
 * 
 * @author Adminl
 *
 */
public class JpqlQueries {
	
	public static final String SELECT_ALL_CLIENTS = "SELECT c FROM Client c";
	public static final String SELECT_ACCOUNTS = "SELECT a from Account a";
	public static final String SELECT_ALL_CARDS = null;
	public static final String SELECT_ALL_CHECK = null;
	public static final String SELECT_CLIENT_BY_NAME="SELECT c FROM Client c WHERE c.lastname = :lastname and c.firstname=:firstname";
	

}
