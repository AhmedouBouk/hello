# Projet d'intégration Jenkins-Ansible

Ce projet démontre l'intégration entre Jenkins et Ansible pour automatiser le déploiement d'une application web simple.

## Prérequis 

- Jenkins installé et en cours d'exécution
- Ansible installé sur le serveur Jenkins ou accessible
- Un compte GitHub avec ce dépôt cloné

## Structure du projet

- `index.html`: Page web simple à déployer
- `Jenkinsfile`: Configuration du pipeline Jenkins
- `inventory`: Fichier d'inventaire Ansible définissant les serveurs cibles
- `playbook.yml`: Playbook Ansible pour déployer l'application

## Guide d'installation et de configuration

### 1. Configuration de Jenkins

1. **Installer les plugins nécessaires**:
   - Git Plugin
   - GitHub Integration Plugin
   - Ansible Plugin

   Allez dans **Manage Jenkins > Manage Plugins > Available** et recherchez ces plugins.

2. **Configurer les informations d'identification GitHub**:
   - Allez dans **Manage Jenkins > Manage Credentials**
   - Ajoutez vos identifiants SSH pour GitHub

### 2. Créer un pipeline Jenkins

1. Sur le dashboard Jenkins, cliquez sur **New Item**
2. Entrez un nom (ex: "hello-world-deployment")
3. Sélectionnez **Pipeline** et cliquez sur **OK**
4. Dans la section **Pipeline**:
   - Sélectionnez **Pipeline script from SCM**
   - Choisissez **Git** comme SCM 
   - Entrez l'URL du dépôt: `git@github.com:AhmedouBouk/hello.git`
   - Spécifiez la branche: `main` 
   - Sélectionnez vos identifiants GitHub
   - Laissez le **Script Path** à `Jenkinsfile`
5. Cliquez sur **Save**

### 3. Configuration d'Ansible

1. Vérifiez que le fichier `inventory` contient l'adresse IP correcte de votre serveur cible
2. Assurez-vous que le serveur Jenkins peut se connecter au serveur cible via SSH

### 4. Déclencher le pipeline

1. Sur le dashboard Jenkins, accédez à votre pipeline
2. Cliquez sur **Build Now**

### 5. Configuration du webhook GitHub (optionnel)

1. Dans votre dépôt GitHub, allez dans **Settings > Webhooks > Add webhook**
2. Entrez l'URL de votre serveur Jenkins: `http://your-jenkins-server/github-webhook/`
3. Sélectionnez **Just the push event**
4. Cliquez sur **Add webhook**

## Dépannage

- Si l'installation d'Ansible échoue, vérifiez que votre utilisateur Jenkins a les droits sudo 
- Si le déploiement échoue, vérifiez les logs Jenkins et Ansible pour plus de détails

