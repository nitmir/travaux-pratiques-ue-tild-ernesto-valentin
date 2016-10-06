# Master iLORD - Tests et intégration de logiciels distribués 

## Environnement de développement
Vous travaillez en binôme avec des machines disposant des logiciels Git et IntelliJ.
Vous pouvez travaillez sur vos propres machines à condition d'installer ces deux logiciels :

- Git : https://git-scm.com/downloads
- IntelliJ IDEA édition **Utimate** : https://www.jetbrains.com/idea/#chooseYourEdition

## Modalités d'évaluation

Les TPs donnent lieu à une note construite sur la base : 

- de votre assiduité et de votre attitude en TP ;
- de vos contributions sur le projet qui seront révélées par l'historique des commits sur votre projet Github.
 
## TP1 - Découverte de l'environnement de travail

### 1. Création d'un compte Github et récupération du projet "AssessedCompetencies"

- Rendez vous sur le plateforme Web [Github](https://github.com/) et créez un compte sur la plateforme.
- Rendez vous sur le devoir correspondant à nos [travaux pratiques](https://classroom.github.com/group-assignment-invitations/c40767b41493090001d29c1b93c8c4f3).
- *Clonez* le projet dans votre espace de travail en utilisant la commande *git clone https://..."*

Dans la suite du TP, le terme "M1" désigne le premier membre de votre binôme et "M2" désigne le deuxième membre du binôme. Les énoncés des 
questions préfixés par "M1:" sont à réaliser par M1 uniquement alors que les énoncés préfixés par "M2:" sont à réaliser par M2 uniquement.

- M1: Créez la branche *develop* dans votre repository local et *pushez* la branche sur Github à l'aide de la commande suivante :
*"git push -u origin develop"* . 
- M2: Récupérez la branche develop qui a été créee sur Github à l'aide de la commande suivante : *"git pull origin develop"*
- Ouvrez le projet avec IntelliJ.

### 2. Premiers pas avec Maven

- Étudiez la structure du projet ainsi que le fichier pom.xml.
- Construisez le projet et lancez les tests avec Maven.
- Lancez les tests avec IntelliJ.
- Construisez le site maven du projet et parcourez le contenu du site créé.
- Consultez le rapport de couverture du code par les tests.

### 3. Premiers avec Spring-Boot et la notion de "repository"

- Étudiez le code source du projet.
- Appuyez vous sur la doucmentation de [Spring Data JPA](http://docs.spring.io/spring-data/jpa/docs/1.11.0.M1/reference/html/) pour comprendre le code de l'application.
- Complétez l'application de telle sorte que le service *CompetenceService* permette la sauvegarde d'un objet de type Categorie (ajout de la méthode *saveCategory(Category cat)*) puis d'un objet de type Comptence (ajout de la méthode *saveCompetence(Competence comp)*).
- À l'issue de votre travail la couvertude du code par les tests doit être supérieure à 90% ; les tests doivent tester les cas de succès, les cas d'erreur, etc.

## TP2 - Mise en place de l'intégration continue

### 1. Mise en place de Travis CI

- Tâches préliminaires à exécuter par un des membres du binôme (M1): 
    - rajouter la ligne suivante dans le fichier *.gitignore* : 
        !maven-wrapper.jar
    - récupérez le fichier [*maven-wrapper.jar*](https://github.com/Master-iLORD/AssessedCompetencies/raw/master/.mvn/wrapper/maven-wrapper.jar) et déposez le
    dans le dossier *.mvn/wrapper*.
    - committez et pushez les fichiers *maven-wrapper.jar* et *.gitignore* sur votre branche courante.
- Tâche préliminaire à éxécuter par l'autre membre du binôme (M2):
    - récupérer la dernière version de la branche courante en exécuant une commande *git pull ...*
- Créez un compte sur la plateforme [Travis-CI](https://travis-ci.org/) en vous authentifiant via votre compte Github.
- En vous appuyant sur la [documentation de Travis-CI](https://docs.travis-ci.com/), faites en sorte que votre projet déclenche
l'exécution des tests de manière automatique sur Travis-CI.

### 2. Mise en place de Coveralls

- Créez un compte sur la plateforme [Coveralls](https://coveralls.io/) en vous authentifiant via votre compte Github.
- Mettez en place le [plugin maven](https://github.com/trautonen/coveralls-maven-plugin) permettant d'interfacer un projet Maven avec Coveralls.
- Modifiez votre fichier de configuration travis pour qu'en cas de succès, le rapport des tests cobertura soit envoyé sur Coveralls.
- Testez votre configuration et visitez les différents rapports Coveralls de votre projet.