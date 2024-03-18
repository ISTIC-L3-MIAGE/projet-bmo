# Diagramme de classes

Ce diagramme présente les entités et leurs interactions au sein de notre système.

### Classe Bookmaker

Cette classe représente l'entité considérée comme l'administrateur de notre système.

### Classe Parieur

Cette classe représente les personnes utilisant notre système afin de placer des placer sur des évènements sportifs.

### Classe Sport

Cette classe représente les évènements sportifs gérés par notre système. C'est une classe abstraite qui nous sert à créer un squelette de base pour les différents sports que notre système doit gérer, à savoir : le football, le tennis, le basket et les courses de chevaux.

### Classe Pari

Cette classe nous permet de représenter les paris placés par les parieurs dans notre système. Elle est aussi une classe abstraite qui nous permet d'avoir un squelette pour nos deux types de paris : les paris simples et les paris avancés.

### Classe Pari Simple

Cette classe est une héritière de la classe Pari et nous sert à représenter les paris basiques. C'est à dire les paris qui ne peuvent être placé qu'avant le début de l'évènement sportif concerné dans lesquels le parieur devra juste deviner l'issue du match ou l'écart final au score.

### Classe Pari Avancé

Cette classe est aussi une héritière de la classe Pari qui nous sert cette fois à représenter les paris un peu plus complexes. Ce sont les paris qui peuvent être placés même pendant un match.

### Classe Football

C'est une classe héritière de la classe Sport qui permet de représenter tous les matchs de foot.

### Classe Basket

C'est une classe héritière de la classe Sport qui permet de représenter tous les matchs de basket.

### Classe Tennis

C'est une classe héritière de la classe Sport qui permet de représenter tous les matchs de tennis.

### Classe CourseDeChevaux

C'est une classe héritière de la classe Sport qui permet de représenter toutes les courses de chevaux.

### Classe Règle

C'est classe nous sert à définir les règles d'un sport. Elle est juste un élément constitutif de la classe Sport.
