package tps.banque;

import tps.banque.exception.CompteException;

/**
 * Classe représentant un compte sécurisé, qui étend la classe CompteDepot.<BR>
 * Un compte sécurisé permet de gérer un solde, des opérations (dépôts et retraits), 
 * et un découvert autorisé. Le montant retiré ne peut pas dépasser le solde du compte
 * plus le découvert autorisé.<BR>
 * 
 * @author Evan CHAMIOT PRIEUR
 * @version 1.0
 */
public class CompteSecurise extends CompteDepot {
	private double debitAutorise;

	/**
     * Constructeur par défaut.<BR>
     * Crée un compte sécurisé avec un numéro, un propriétaire et un découvert autorisé à 0.
     * 
     * @see CompteDepot#CompteDepot()
     */
	public CompteSecurise() {
		this("Pas de numéro", "Pas de propriétaire");
	}

	/**
     * Constructeur paramétré.<BR>
     * Crée un compte sécurisé avec un numéro, un propriétaire et un découvert autorisé à 0.
     * 
     * @param pfNumCompte Le numéro du compte.
     * @param pfNomProp Le nom du propriétaire du compte.
     * @see CompteDepot#CompteDepot(String, String)
     */
	public CompteSecurise(String pfNumCompte, String pfNomProp) {
		this(pfNumCompte, pfNomProp, 0);
	}

	/**
     * Constructeur paramétré.<BR>
     * Crée un compte sécurisé avec un numéro, un propriétaire et un découvert autorisé spécifiés.
     * 
     * @param pfNumCompte Le numéro du compte.
     * @param pfNomProp Le nom du propriétaire du compte.
     * @param pfDA Le montant du découvert autorisé pour ce compte.
     * @see CompteDepot#CompteDepot(String, String)
     */
	public CompteSecurise(String pfNumCompte, String pfNomProp, double pfDA) {
		super(pfNumCompte, pfNomProp);
		this.debitAutorise = pfDA;
	}

	/**
     * Affiche les informations du compte sécurisé.<BR>
     * Affiche les informations classiques du compte grâce à la méthode CompteDepot#afficher(),
     * puis affiche le montant du découvert autorisé.<BR>
     * 
     * @see CompteDepot#afficher()
     */
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Decouvert autorise : " + this.debitAutorise);
	}

	/**
     * Vérifie si un retrait est possible sur le compte.<BR>
     * Cette méthode vérifie si le solde du compte après retrait est supérieur ou égal 
     * au montant du découvert autorisé (le solde peut descendre jusqu'à ce découvert).
     * 
     * @param pfMontant Le montant du retrait demandé.
     * @return true si le retrait est possible, false sinon.
     */
	public boolean isRetraitPossible(double pfMontant) {
		return (this.soldeCompte() - pfMontant >= (-1) * this.debitAutorise);
	}

	 /**
     * Effectue un retrait sur le compte sécurisé.<BR>
     * Avant d'effectuer le retrait, cette méthode vérifie si le retrait est possible 
     * en tenant compte du découvert autorisé.<BR>
     * Si le retrait est impossible (le solde restant serait inférieur au découvert autorisé),
     * une exception CompteException est levée.
     * 
     * @param pfMontant Le montant du retrait.
     * @throws CompteException Si le retrait est impossible (montant trop élevé par rapport au solde et au découvert autorisé).
     * @see CompteDepot#retirer(double)
     */
	@Override
	public void retirer(double pfMontant) throws CompteException {
		if (!this.isRetraitPossible(pfMontant)) {
			throw new CompteException("Retrait de : "+ pfMontant
					+ " impossible sur "+this.getNumCompte());
		}
		super.retirer(pfMontant);
	}
}