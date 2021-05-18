Etapes de la création du serpent : 
- Créer l'objet Serpent vierge
- Lui assigner les propriétés qui le définissent : 
	- Liste de positions
	- Liste de blocs
	- Taille
- Lui assigner des constructeurs 
- Lui construire des méthodes de déplacement 
	-Le corps d'un serpent entraîne sa tête
	-Gestion des déplacements autorisés :
		- Interdiction à la tête d'occuper une position existante (avant déplacement du corps)
			Sauf dans le cas ou la tête va remplacer la queue
- Création des différentes exceptions possibles