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

        stage('Verify Ansible') {
            steps {
                sh 'ansible --version'
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
