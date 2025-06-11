Rapport de la vidéo Spring MVC Thylemeaf Spring Data JPA (All In One Spring MVC Thymeleaf Spring Security - Master II-BDCC) , réalisée par Mr.Mohamed Youssfi


Cette vidéo offre une démonstration pratique de la mise en œuvre d'une application Spring Boot avec Spring MVC, JPA et Thymeleaf. Ce projet représente une application web simple permettant de gérer une liste de produits.

Lien : https://www.youtube.com/watch?v=FHy7raIldgg


Introduction
Ce projet est une application web développée avec Spring Boot , intégrant la sécurité via Spring Security , et utilisant Thymeleaf comme moteur de template. L'objectif semble être la gestion d’un catalogue de produits avec des fonctionnalités CRUD (Créer, Lire, Mettre à jour, Supprimer), en distinguant les rôles utilisateurs (USER) et administrateurs (ADMIN).


Technologies utilisées :

Java 17+
Spring Boot : Pour la configuration rapide et l’auto-démarrage
Spring MVC : Pour le développement web basé sur les contrôleurs
Spring Security : Gestion de l’authentification et des autorisations
JPA / Hibernate : Persistance des données avec une base en mémoire
Thymeleaf : Moteur de templates HTML
Bootstrap 5 : Pour la mise en page et l’aspect visuel
H2 Database (en mémoire) : Base de données utilisée pour les tests

Packages Principaux

net.bousmara.bdccfsmspringmvc.sec : Configuration de la sécurité
net.bousmara.bdccfsmspringmvc.entities : Entité JPA Product
net.bousmara.bdccfsmspringmvc.repository : Interface de persistance ProductRepository
net.bousmara.bdccfsmspringmvc.web : Contrôleur ProductController
net.bousmara.bdccfsmspringmvc : Classe principale BdccFsmSpringMvcApplication

Sécurité (Spring Security)

Configuration : SecurityConfig.java
Utilisation de l’authentification en mémoire avec InMemoryUserDetailsManager
Trois utilisateurs prédéfinis :
user1, user2 → rôle USER
admin → rôles USER et ADMIN
Encodage des mots de passe via BCryptPasswordEncoder
Protection des URLs selon les rôles :
/index/** → accessible aux USER
/admin/** → réservé aux ADMIN
/public/** et /webjars/** → accessibles à tous
Page de login personnalisée : /login
Gestion personnalisée de l’accès refusé : /notAuthorized
Désactivation CSRF (pour simplifier les tests locaux)

Entité & Repository

Product.java
Entité JPA persistante avec annotation @Entity
Champs :
id : Clé primaire auto-incrémentée
name : Nom du produit (obligatoire, entre 3 et 50 caractères)
price : Prix ≥ 0
quantity : Quantité ≥ 1
Annotations de validation utilisées :
@NotEmpty, @Size, @Min
ProductRepository.java
Interface qui étend JpaRepository<Product, Long>
Permet les opérations CRUD standard sans implémentation manuelle

Vue (Thymeleaf + Bootstrap)

products.html
Template principal héritant d’une structure commune
Barre de navigation responsive avec Bootstrap
Affichage dynamique de la liste des produits
Menu utilisateur avec affichage du nom connecté et lien de déconnexion

layout1.html
Template servant comme layout pour la décoration des pages avec un navbar.
Contient des liens redirigeant vers :
Products : page des produits.
Home : Page des produits
Logout : déconnexion
username : nom de l'utilisateur connecté

newProduct.html
Formulaire permettant d’ajouter un nouveau produit
Champs :
name : Nom du produit
price : Prix
quantity : Quantité disponible
Validation côté serveur avec affichage des erreurs

notAuthorized.html
Message simple indiquant que l’utilisateur n’a pas les droits nécessaires
Utilise le layout commun pour garder la cohérence visuelle

login.html
Formulaire simple d’authentification avec champs :
username
password
Utilise Bootstrap pour un style moderne
Redirige vers /login via méthode POST

Captures d'écran : 

![image](https://github.com/user-attachments/assets/be248f52-1d6f-44ac-a077-852061b28fa3)
![image](https://github.com/user-attachments/assets/92cbf747-8cd8-47c3-8d3e-9fb6cc1cf158)
![image](https://github.com/user-attachments/assets/2da17d71-df02-4211-a964-ab287ed4df26)
![image](https://github.com/user-attachments/assets/77b5eca2-ac57-4fa2-a15a-0a27e2c2434e)
![image](https://github.com/user-attachments/assets/0d7e36c3-c6b7-4912-aae4-a36095a75cc8)
![image](https://github.com/user-attachments/assets/3d7110ad-9cb1-4721-b123-79a513e1b8c5)
![image](https://github.com/user-attachments/assets/488c0f5d-042d-4f21-a823-1631d4dfb1c3)
![image](https://github.com/user-attachments/assets/fdc24a99-6f03-47a6-aa80-3c8f173f39d2)
![image](https://github.com/user-attachments/assets/0f132d2a-070b-4cb3-af08-0d6de17dfdc6)






