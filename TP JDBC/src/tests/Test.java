package tests;

import java.util.Date;
import java.util.Scanner;

import Entite.Client;
import Entite.Commande;
import Entite.Demande;
import Entite.Fournisseur;
import Entite.LigneCommande;
import Entite.LigneDemande;
import Entite.Produit;
import Entite.Rayon;
import Service.ClientService;
import Service.CommandeService;
import Service.DemandeService;
import Service.FournisseurService;
import Service.LigneCommandeService;
import Service.LigneDemandeService;
import Service.ProduitService;
import Service.RayonService;

public class Test {

	public static void main(String[] args) {
		ClientService cs = new ClientService();
		ProduitService ps = new ProduitService();
		CommandeService ccs = new CommandeService();
		LigneCommandeService lcs = new LigneCommandeService();
		FournisseurService fs = new FournisseurService();
		RayonService rs = new RayonService();
		DemandeService ds = new DemandeService();
		LigneDemandeService lds = new LigneDemandeService();
		Scanner sc2 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int x = 0;
		while (x < 16) {
			System.out.println("#############################--MENU--#########################\n");
			System.out.println("1)ajouter client ");
			System.out.println("2)afficher  clients ");
			System.out.println("3)supprimer client ");
			System.out.println("4)ajouter produits ");
			System.out.println("5)afficher produits ");
			System.out.println("6)supprimer produits");
			System.out.println("7)afficher toutes les commandes ");
			System.out.println("8)Faire une commande");
			System.out.println("9)faire une demande ");
			System.out.println("10)Ajouter demande");
			System.out.println("11)afficher toutes les demandes ");
			System.out.println("12)ajouter un fournisseur");
			System.out.println("13)afficher les fournisseurs");
			System.out.println("14)Supprimer Fournisseur");
			System.out.println("15)ajouter rayon ");
			System.out.println("16)quitter");
			System.out.println("donnez votre choix ");
			x = sc2.nextInt();
			switch (x) {
			case 1: {
				System.out.println("donnez le nom du client ");
				String b = sc.nextLine();
				System.out.println("donnez le phone ");
				String tel = sc.nextLine();
				System.out.println("donnez l'email ");
				String em = sc.nextLine();
				cs.create(new Client(b, tel, em));
				System.out.println("Client ajoute ");
				break;
			}
			case 2: {
				for (Client c : cs.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 3: {
				int l = 0;
				System.out.println("Donnez le nom du client ");
				String n = sc.nextLine();
				for (Client c : cs.findAll()) {
					if (c.getNom().equals(n)) {
						cs.delete(c);
						l++;
						System.out.println("client supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun client n a le nom entre ");
				}
				break;
			}
			case 4: {
				Scanner sc6=new Scanner(System.in);
				Scanner sc7=new Scanner(System.in);
				System.out.println("Donnez la designation d'un produit ");
				String des = sc6.nextLine();
				System.out.println("Donnez le prix d'achat du produit ");
				Double pr = sc7.nextDouble();
				System.out.println("Choisissez votre rayon");
				for (Rayon r : rs.findAll()) {
					System.out.println(r);
				}
				int rc = sc.nextInt();
				System.out.println("donnez la quantite du produit");
				int qu = sc.nextInt();
				ps.create(new Produit(des, pr, rs.findById(rc), qu));
				System.out.println("produit ajoute");
				break;
			}
			case 5: {
				for (Produit c : ps.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 6: {
				int l = 0;
				System.out.println("Donnez l'id du produit ");
				int n = sc.nextInt();
				for (Produit c : ps.findAll()) {
					if (c.getId() == n) {
						ps.delete(c);
						l++;
						System.out.println("le produit est supprime ");
					}
				}
				if (l == 0) {
					System.out.println("Produit inexistant ");
				}
				break;
			}
			case 7: {
				System.out.println("Voici les Commandes Faites");
				for (LigneCommande c : lcs.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 11: {
				System.out.println("Donnez l'id du produit que vous voulez");
				for (Produit c : ps.findAll()) {
					System.out.println(c);
				}

				int g = sc.nextInt();
				System.out.println("donnez l'id de votre demande");
				for (Demande dem : ds.findAll()) {
					System.out.println(dem);
				}
				int de = sc.nextInt();
				System.out.println("Donnez la quantite dont vous avez besoin");
				int qu = sc.nextInt();
				lds.create(new LigneDemande(ps.findById(g), ds.findById(de), qu));
				System.out.println("Demande faite");
				break;
			}
			case 9: {
				System.out.println("Demandes faites sont: ");
				for (LigneDemande c : lds.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 12: {
				Scanner sc3 = new Scanner(System.in);
				Scanner sc4 = new Scanner(System.in);
				System.out.println("Donnez le nom du fournisseur");
				String name = sc3.nextLine();
				System.out.println("Donnez son telephone");
				String phone = sc4.nextLine();
				fs.create(new Fournisseur(name, phone));
				System.out.println("Fournisseur ajoute");
				break;
			}
			case 13: {
				for (Fournisseur f : fs.findAll()) {
					System.out.println(f);
				}
				break;
			}
			case 10: {
				System.out.println("donnez l'id du fournisseur");
				for (Fournisseur f : fs.findAll()) {
					System.out.println(f);
				}
				int i = sc.nextInt();
				ds.create(new Demande(fs.findById(i), new Date()));
				System.out.println("Demande ajoute");
				break;
			}
			case 16: {
				System.out.println("Donnez l'id de la commande");
				for (Commande c : ccs.findAll()) {
					System.out.println(c);
				}
				int cmd = sc.nextInt();
				System.out.println("Donnez l'id du produit");
				for (Produit p : ps.findAll()) {
					System.out.println(p);
				}
				int cl = sc.nextInt();
				System.out.println("Donnez la quantite ");
				int qu = sc.nextInt();
				System.out.println("Donnez le prix de vente");
				double pr = sc2.nextDouble();
				lcs.create(new LigneCommande(qu, pr, ccs.findById(cmd), ps.findById(cl)));
				System.out.println("Commande faite");
				break;
			}
			case 14: {
				int l = 0;
				System.out.println("Donnez l'id du fournisseur \n");
				for (Fournisseur c : fs.findAll()) {
					System.out.println(c);
				}
				int n = sc.nextInt();
				for (Fournisseur c : fs.findAll()) {
					if (c.getId() == n) {
						fs.delete(c);
						l++;
						System.out.println("le fournisseur est supprime ");
					}
				}
				if (l == 0) {
					System.out.println("Aucun fournisseur n a le nom entre \n");
				}
				break;
			}
			case 15:
				Scanner sc5 = new Scanner(System.in);

				System.out.println("donnez le code du rayon");
				String cod = sc5.nextLine();
				rs.create(new Rayon(cod));
				System.out.println("rayon ajoute avec succes");
				break;

			}
		}
	}
}
