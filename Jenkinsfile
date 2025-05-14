pipeline {
    agent any
    environment {
        ANSIBLE_INVENTORY = 'inventory'
        ANSIBLE_PLAYBOOK = 'playbook.yml'
        ANSIBLE_HOST_KEY_CHECKING = 'False'
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
                sh """
                export ANSIBLE_HOST_KEY_CHECKING=False
                ansible-playbook ${ANSIBLE_PLAYBOOK} -i ${ANSIBLE_INVENTORY} --private-key ~/.ssh/id_rsa --become
                """
            }
        }

        stage('Deployment Confirmation') {
            steps {
                echo '✔️ Déploiement terminé avec succès !'
            }
        }
    }
}
