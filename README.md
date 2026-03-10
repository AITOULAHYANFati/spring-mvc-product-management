# 🛍️ Spring MVC Product Management

Application web de gestion des produits développée avec Spring Boot, Spring Data JPA, Thymeleaf et Spring Security.

---

## 📋 Table des matières

- [Objectif](#objectif)
- [Technologies utilisées](#technologies-utilisées)
- [Structure du projet](#structure-du-projet)
- [Lancer le projet](#lancer-le-projet)
- [Sécurité](#sécurité)
- [Captures d'écran](#captures-décran)

---

## 🎯 Objectif

Ce TP a pour but de créer une application Web JEE basée sur :
- **Spring MVC** pour la couche web
- **Spring Data JPA / Hibernate** pour la persistance
- **Thymeleaf** pour les vues
- **Spring Security** pour la sécurisation


## ✅ Étapes réalisées

1. ✅ Création du projet Spring Boot avec les dépendances :
   - Spring Web
   - Spring Data JPA
   - H2 Database
   - Thymeleaf
   - Lombok
   - Spring Security
   - Spring Validation

2. ✅ Création de l'entité JPA `Product`
3. ✅ Création de l'interface `ProductRepository` basée sur Spring Data
4. ✅ Test de la couche DAO avec `CommandLineRunner`
5. ✅ Configuration personnalisée de Spring Security
6. ✅ Création du contrôleur Spring MVC et des vues Thymeleaf :
   - Affichage de la liste des produits
   - Suppression d'un produit
   - Page template avec Thymeleaf Layout et Bootstrap 5
   - Formulaire d'ajout avec validation
7. ✅ Sécurisation avec Spring Security (rôles USER et ADMIN)

---

## 🛠️ Technologies utilisées

| Technologie       | Rôle                            |
|-------------------|---------------------------------|
| Spring Boot       | Framework principal             |
| Spring MVC        | Couche Web                      |
| Spring Data JPA   | Accès aux données               |
| Hibernate         | ORM                             |
| H2 Database       | Base de données en mémoire      |
| Thymeleaf         | Moteur de templates             |
| Bootstrap 5       | Interface utilisateur           |
| Spring Security   | Authentification & autorisation |
| Lombok            | Réduction du code boilerplate   |
| Spring Validation | Validation des formulaires      |

---

## 📁 Structure du projet
```
src/
├── main/
│   ├── java/org/example/springmvcproductmanagement/
│   │   ├── entites/
│   │   │   └── Product.java
│   │   ├── repository/
│   │   │   └── ProductRepository.java
│   │   ├── sec/
│   │   │   └── SecurityConfig.java
│   │   ├── web/
│   │   │   └── ProductController.java
│   │   └── SpringMvcProductManagementApplication.java
│   └── resources/
│       └── templates/
│           ├── layout1.html
│           ├── products.html
│           ├── new-product.html
│           └── notAuthorized.html
```

---

## 🚀 Lancer le projet

### Prérequis
- Java 17+
- Maven 3.8+

## 🔐 Sécurité

### Comptes disponibles

| Utilisateur | Mot de passe | Rôle        |
|-------------|--------------|-------------|
| `user1`     | `123`        | USER        |
| `user2`     | `123`        | USER        |
| `admin`     | `123`        | USER, ADMIN |

### Contrôle d'accès

| URL            | Rôle requis   |
|----------------|---------------|
| `/user/**`     | USER          |
| `/admin/**`    | ADMIN         |
| `/public/**`   | Tout le monde |

> 🔒 Les mots de passe sont encodés avec **BCrypt**


