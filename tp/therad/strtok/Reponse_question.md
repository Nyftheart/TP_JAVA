- La méthode strtok n'est pas thread-safe car elle utilise des variables statiques 
- Si deux threads appellent simultanément la méthode strtok avec des chaînes différentes la variable risque de faire planter ou de retourner un mauvais résultat