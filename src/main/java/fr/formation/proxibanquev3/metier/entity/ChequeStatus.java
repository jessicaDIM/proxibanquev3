package fr.formation.proxibanquev3.metier.entity;
/**
 * Classe permettant de savoir si l'edition d'un chéquier va etre possible
 * @author Jessica Di Marco & Sandy Colin
 */
public class ChequeStatus {
	
	private boolean chequeIsOk;
	
	private String message;
	
	/**
	 * 
	 */
	public ChequeStatus() {
		this.chequeIsOk=true;
	}

	/**
	 * @param chequeIsOk
	 * @param message
	 */
	public ChequeStatus(boolean chequeIsOk, String message) {
		this.chequeIsOk = chequeIsOk;
		this.message = message;
	}

	/**
	 * @return the chequeIsOk
	 */
	public boolean isChequeIsOk() {
		return chequeIsOk;
	}
	

	/**
	 * @param chequeIsOk the chequeIsOk to set
	 */
	public void setChequeIsOk(boolean chequeIsOk) {
		this.chequeIsOk = chequeIsOk;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	
}
