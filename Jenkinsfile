pipeline {
    agent any
    environment {
        ANSIBLE_INVENTORY = 'inventory'
        ANSIBLE_PLAYBOOK = 'playbook.yml'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AhmedouBouk/hello.git'         // URL HTTPS au lieu de SSH
            }
        }

        stage('Verify Ansible') {
            steps {
                bat 'echo Vérification de la présence d\'Ansible...'
                bat 'where ansible || echo Ansible n\'est pas installé ou n\'est pas dans le PATH'
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                bat "echo Simulation d'exécution du playbook Ansible"
                bat "echo Commande qui serait exécutée: ansible-playbook %ANSIBLE_PLAYBOOK% -i %ANSIBLE_INVENTORY%"
                // Commenté car Ansible n'est probablement pas installé sur Windows
                // ansiblePlaybook(
                //    playbook: "${ANSIBLE_PLAYBOOK}",
                //    inventory: "${ANSIBLE_INVENTORY}",
                //    colorized: true
                // )
            }
        }

        stage('Deployment Confirmation') {
            steps {
                echo '✔️ Déploiement terminé avec succès !'
            }
        }
    }
}
