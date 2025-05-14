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
                sh "ansible-playbook ${ANSIBLE_PLAYBOOK} -i ${ANSIBLE_INVENTORY} --become"
            }
        }

        stage('Deployment Confirmation') {
            steps {
                echo '✔️ Déploiement terminé avec succès !'
            }
        }
    }
}
