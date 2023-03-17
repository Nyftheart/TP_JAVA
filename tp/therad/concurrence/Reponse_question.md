Le code crée deux threads qui modifient le champ value de l'objet test. Chaque thread assigne la valeur de son propre id à value, et vérifie si la modification a été correctement effectuée.
L'un des threads peut être interrompu par le système d'exploitation après avoir effectué l'affectation et avant que la condition de boucle ne soit vérifiée.
Le code n'est pas correctement synchronisé pour gérer la concurrence.
