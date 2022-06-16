# Projet KATYA
Projet de semestre - Gestion des équipements et des salles de projet de l'EPF  
Instructions pour lancer le site web :  
- Télécharger le code source  
- Installer Apache Maven : https://maven.apache.org/download.cgi  
- Ouvrir le projet, puis ouvrir un terminal et se placer dans l'arborescence : /Projet-Katya/ges  
- Une fois dans /ges, écrire la commande : "mvn tomcat7:run" pour lancer le serveur Apache  
- Si le tomcat s'exécute sans problème, aller dans un navigateur et se rendre à l'adresse : http://localhost:8080/ges. Vous êtes maintenant sur le site web KATYA - Ges  
- En cas d'erreur avec le tomcat, écrire la commande "mvn clean install tomcat7:run". Si l'erreur persiste, vérifier que Maven est correctement installé.

