pipeline {
    agent any

    environment {
        ANSIBLE_INVENTORY = 'inventory'           // ton fichier inventaire
        ANSIBLE_PLAYBOOK = 'playbook.yml'         // ton fichier playbook
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/TON_UTILISATEUR/TON_DEPOT.git'
            }
        }

        stage('Install Ansible') {
            steps {
                sh '''
                    if ! command -v ansible > /dev/null; then
                        echo "Installation de Ansible..."
                        sudo apt-get update
                        sudo apt-get install -y ansible
                    else
                        echo "Ansible déjà installé."
                    fi
                '''
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                sh "ansible-playbook -i ${ANSIBLE_INVENTORY} ${ANSIBLE_PLAYBOOK}"
            }
        }
    }
}
