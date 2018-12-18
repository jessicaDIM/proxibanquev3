Le lien vers le projet GitHub est :
	https://github.com/jessicaDIM/proxibanquev3.git
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	Procédure d'installation
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Vérifier que Java est installé sur le système.
-> Si ce n'est pas le cas, aller sur ce site: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Dans le cadre Java SE Development Kit 8u191, accepter la licence et télécharger le lien correspondant à votre système d'exploitation

2. Vérifier que Apache Tomcat 8.5 est installé sur le système
-> Si ce n'est pas le cas, aller sur ce site : https://tomcat.apache.org/download-80.cgi
Télécharger dans l'onglet 8.5.35, au niveau de Core et choissisez le lien selon votre système d'exploitation

3. Dans la base de données MySql Workbench, faire un Data_import (Server -> Data import -> Cocher Import form Self-contained file (et aller chercher les fichiers .sql dans votre ordinateur) -> Start Import)
des fichiers BDD_Structurev3.sql (Structure de la base de données) et BDD_Datav3.sql (données des tables créées)
(Le schéma de la base de données est proxibanquev2)

4. Démarrer le serveur d'application Tomcat en cliquant sur le fichier "bin\startup.bat"

5. Glisser le livrable (fichier avec extension *.war) dans répertoire Webapps du dossier d'installation de Tomcat

6. Une fois l'application déployée, un dossier au nom du fichier war est visible dans le répertoire Webapps.

7. Démarrer le navigateur, rentrer l'adresse suivante <http://localhost:8080/proxibanquev3/>
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	Test applicatif
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Pour tester l'application, il vous suffit de suivre les explications suivantes:
	----------------------------------
	0. Situation de départ : vous êtes un client de la banque Proxibanque et vous naviguez sur leur Système d'Information.
	----------------------------------
	1. L'écran d'accueil de ProxibanqueSI s'affiche. Vous y trouvez un champ à remplir avec vos Prénom et Nom. Vous trouvez également un bouton "Valider" pour valider votre action.
	
		Pour l'exemple, veuillez remplir les champs avec les prénom et nom suivants : Jean Peuplu.
		Cliquez ensuite sur valider.
		
	----------------------------------	
	2. Vous êtes alors redirigé vers votre tableau de bord. Vous y trouvez la liste de vos comptes ainsi que 4 boutons :
						1. Demander un chéquier
						2. Effectuer un virement
						3. Effectuer un retrait ou une demande de carte
						4. Retour à l'écran d'accueil.
						
		Cliquez sur le bouton comportant l'action désirée.
		
		
		Si vous avez cliqué sur le bouton 1. "Demander un chéquier", veuillez reprendre au point 3.
		Si vous avez cliqué sur le bouton 2. "Effectuer un virement", veuillez reprendre au point 4.
		Si vous avez cliqué sur le bouton 3. "Effectuer un retrait ou une demande de carte", veuillez reprendre au point 5.
		Si vous avez cliqué sur le bouton 4. "Retour à l'écran d'acceuil", vous pouvez retourner au point 1.
	----------------------------------	
	3. Vous avez choisi l'action : "Demander un chéquier" dans votre tableau de bord.
	
		////////////////
		
		Si vous souhaitez sortir de la page, cliquez sur le bouton "Retour à l'écran d'accueil".
		Vous êtes alors redirigé vers l'écran d'accueil (cf point 1.).
	----------------------------------	
	4. Vous avez choisi l'action : "Effectuer un virement" dans votre tableau de bord.
		
		Vous êtes redirigé vers une nouvelle page nommée : "Transfert pour Jean Peuplu".
		
		Vous trouvez un premier tableau sur la gauche de l'écran. Ce tableau vous permet de choisir vote compte à débiter grâce aux boutons radios.
		Vous trouvez un deuxième tableau sur la droite de l'écran. Ce tableau vous permet de choisir vote compte à créditer grâce aux boutons radios.

		///////////////////////////////---------------------------------------/////////////////////
		Cliquer ensuite sur Valider pour effectuer le virement. 
		Si le client a bien deux comptes au minimum et que le virement ne provoque pas de découvert sur le compte émetteur, le virement est réaliser. 
		
		Si vous souhaitez sortir de la page, cliquez sur le bouton "Retour à l'écran d'accueil".
		Vous êtes alors redirigé vers l'écran d'accueil (cf point 1.).
		----------------------------------	
	5. Vous avez choisi l'action : "Effectuer un retrait ou une demande de carte" dans votre tableau de bord.
		Vous êtes redirigé vers une nouvelle page dans laquelle vous trouvez un récapitulatif des informations bancaires du client : ID, N° du compte, Solde et le type de compte (colonne "Compte Epargne?").
		Dans la colonne "Compte Epargne?", vous trouverez les informations "TRUE" ou "FALSE":
			- "TRUE" indique que le compte de cette ligne est un compte d'Epargne.
			- "FALSE" indique que le compte de cette ligne est un compte Courant.
		
		Si vous souhaitez sortir de la page, cliquez sur le bouton "Retour à l'écran d'accueil".
		Vous êtes alors redirigé vers l'écran d'accueil (cf point 1.).