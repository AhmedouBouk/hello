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
                    url: 'https://github.com/AhmedouBouk/hello.git'
            }
        }

        stage('Install Ansible') {
            steps {
                sh 'ansible --version || (sudo apt-get update && sudo apt-get install -y ansible)'
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                ansiblePlaybook(
                    playbook: "${ANSIBLE_PLAYBOOK}",
                    inventory: "${ANSIBLE_INVENTORY}",
                    become: true,
                    colorized: true
                )
            }
        }

        stage('Deployment Confirmation') {
            steps {
                echo '✔️ Déploiement terminé avec succès !'
            }
        }
    }
}
