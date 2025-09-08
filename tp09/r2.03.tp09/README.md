#   IMPORANT : Prendre le profil java dans VSCode

Pensez à switcher de profil vers profil Java sinon rien ne marchera (pas de reconnaissance de maven, du code java, ...)

#   Commandes pour générer les javadoc :

Utiliser `mvn clean javadoc:javadoc`
*   clean : effacer tous les éléments de compilation, génération, ...
*   javadoc:javadoc : lancer le goal "javadoc" dans le plugin "javadoc:"

NB : sans le clean : les modifications de commentaires ne permettent pas de regénérer la javadoc.

Ces commandes peuvent aussi être effectuées séparément et interactivement dans l'onglet MAVEN, généralement sur la gauche de l'interface (Lifecycle > clean et Plugins > javadoc > javadoc).

La documentation est générée dans target/ (souvent target/site/apidocs).

#   Bugs classiques lorsqu'on écrit de la javadoc

Les commentaires de javadoc sont interprétés en partie comme du html. De ce fait, certains caractères peuvent géner la génération. 

C'est le cas par exemple du caractère "<" qui sera interprété comme le début d'une balise html. Il faut le remplacer dans le texte par l'entité équivalente `&lt;`.

Le risque :
*   des erreurs de génération de javadoc au lieu de warnings et des lignes rouges qui semblent indiquer des problèmes critiques.
*   mais la javadoc est en général tout de même générée.

#   Le Plugin javadoc ne démarre pas 

Il se peut que la version du plugin soit parfois incompatible avec la version de maven, selon les salles. Vous avez un message du type _"... javadoc version 3.x.y is compatible only with maven 3.t.v ..."_

Dans ce cas :
*   chercher le numéro de version actuelle du plugin maven-javadoc-plugin dans pom/xml.
*   chercher un numéro de version inférieure valide ici : https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-javadoc-plugin.
*   modifier la version dans pom.xml puis enregistrer.
*   dans l'onglet MAVEN : faire Reload (icone double flêche).