package tps.banque;

import java.util.*;

import tps.banque.exception.CompteException;

/**
 * Classe représentant un compte de dépôt, qui étend la classe Compte.<BR>
 * Un compte dépôt permet de gérer des opérations de type crédit (dépôt) et débit (retrait).<BR>
 * Ce compte conserve un historique des opérations effectuées dans une liste.<BR>
 * Les opérations sont ajoutées à la liste chaque fois qu'un dépôt ou un retrait est effectué.<BR>
 * 
 * @author Evan CHAMIOT PRIEUR
 */
public class CompteDepot extends Compte {
	private ArrayList<Operation> alOperations;

	/**
     * Constructeur par défaut.<BR>
     * Crée un compte dépôt avec un numéro et un propriétaire par défaut ("Pas de numéro" et "Pas de propriétaire").
     * Initialise la liste des opérations à une nouvelle ArrayList.
     * 
     * @see Compte#Compte()
     */
	public CompteDepot() {
		this("Pas de numéro", "Pas de propriétaire");
	}

	/**
     * Constructeur paramétré.<BR>
     * Crée un compte dépôt avec un numéro et un propriétaire spécifiés.
     * Initialise la liste des opérations à une nouvelle ArrayList.
     * 
     * @param pfNumCompte Le numéro du compte.
     * @param pfNomProp Le nom du propriétaire du compte.
     * @see Compte#Compte(String, String)
     */
	public CompteDepot(String pfNumCompte, String pfNomProp) {
		super(pfNumCompte, pfNomProp);
		this.alOperations = new ArrayList<Operation>();
	}

	/**
     * Affiche les informations du compte dépôt.<BR>
     * Affiche les informations classiques du compte grâce à la méthode Compte#afficher() et les opérations effectuées.<BR>
     * Pour chaque opération, affiche le type (crédit ou débit) ainsi que le montant de l'opération.<BR>
     * 
     * @see Compte#afficher()
     */
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Les Opérations :");
		for (Operation o : this.alOperations)
			System.out.println("    - " + o.getSens() + " : " + o.getMontant());
	}

	/**
     * Effectue un retrait sur le compte dépôt.<BR>
     * Appelle la méthode Compte#retirer(double) de la classe parente pour effectuer le retrait,
     * puis ajoute l'opération dans la liste des opérations comme un débit.<BR>
     * 
     * @param pfMontant Le montant retiré sur le compte.
     * @throws CompteException Lorsque le montant est négatif.
     * @see Compte#retirer(double)
     */
	@Override
	public void retirer(double pfMontant) throws CompteException {
		super.retirer(pfMontant);
		this.alOperations.add(new Operation(SensOperation.DEBIT, pfMontant));
	}

	/**
     * Effectue un dépôt sur le compte dépôt.<BR>
     * Appelle la méthode Compte#deposer(double) de la classe parente pour effectuer le dépôt,
     * puis ajoute l'opération dans la liste des opérations comme un crédit.<BR>
     * 
     * @param pfMontant Le montant déposé sur le compte.
     * @throws CompteException Lorsque le montant est négatif.
     * @see Compte#deposer(double)
     */
	@Override
	public void deposer(double pfMontant) throws CompteException {
		super.deposer(pfMontant);
		this.alOperations.add(new Operation(SensOperation.CREDIT, pfMontant));
	}

	/**
     * Retourne la liste des opérations effectuées sur le compte sous forme d'un tableau.<BR>
     * 
     * @return Un tableau d'objets Operation représentant les opérations effectuées.
     */
	public Operation[] getOperations() {
		return this.alOperations.toArray(new Operation[0]);
	}
}
