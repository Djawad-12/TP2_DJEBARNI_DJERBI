# Réponses aux questions - TP2 : Spring MVC
'''
.
├── pom.xml
├── README.md
└── src
    └── main
        ├── java
        │   └── com
        │       └── tp
        │           ├── mvc
        │           │   ├── FormController.java
        │           │   ├── HomeController.java
        │           │   └── MessageController.java
        │           └── service
        │               └── MessageService.java
        ├── resources
        └── webapp
            ├── index.jsp
            └── WEB-INF
                ├── dispatcher-servlet.xml
                ├── views
                │   ├── form.jsp
                │   ├── home.jsp
                │   ├── result.jsp
                │   └── vue.jsp
                └── web.xml

'''

## Partie 2 : Configuration

**1. Quel est le rôle du DispatcherServlet ?**

Il reçoit toutes les requêtes HTTP et les redirige vers les bons contrôleurs.

**2. Pourquoi `/` et non `/*` ?**

On utilise `/` pour intercepter les requêtes par défaut, mais cela permet au serveur de servir quand même les fichiers statiques (images, CSS). Si on met `/*`, tout est bloqué par le servlet

## Partie 3 : Premier Contrôleur

**1. Pourquoi la JSP est-elle dans /WEB-INF ?**

C'est une mesure de sécurité. Les fichiers dans `WEB-INF` sont privés : un utilisateur ne peut pas y accéder directement en tapant l'URL dans son navigateur. Il est obligé de passer par un contrôleur

**2. Qui choisit la vue finale ?**

C'est le `ViewResolver` (configuré dans le XML). Il prend le nom "home" renvoyé par le contrôleur et trouve le fichier réel `/WEB-INF/views/home.jsp` grâce à la directory qu'on a spécifié

## Partie 8 : Questions de réflexion

**1. Quel est le rôle exact du DispatcherServlet ?**

Il reçoit la requête, trouve le bon contrôleur, récupère le modèle, et demande à la vue de s'afficher

**2. Pourquoi Spring MVC est-il basé sur Front Controller ?**

Cela permet de centraliser tout ce qui est commun (sécurité, routage) au même endroit au lieu de le répéter dans chaque servlet


**3. Où s'applique l'IoC dans Spring MVC ?**

L'IoC est utilisée quand Spring crée automatiquement nos contrôleurs et y injecte en utilisant `@Autowired` les services métier dont on a besoin

**4. Différence entre @Controller et @Service ?**

* `@Controller` sert à gérer le Web (URLs, requêtes HTTP, Vues)
* `@Service` sert à gérer la logique métier (calculs, traitements) indépendamment du Web
