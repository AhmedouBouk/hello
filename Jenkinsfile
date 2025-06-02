pipeline {
    agent any

    environment {
        ANSIBLE_INVENTORY = 'inventory'
        ANSIBLE_PLAYBOOK = 'playbook.yml'
        ANSIBLE_HOST_KEY_CHECKING = 'False'
        SONAR_PROJECT_KEY = 'hello-project'
        SONAR_PROJECT_NAME = 'Hello Project'
        SONAR_PROJECT_VERSION = '1.0'
        SONAR_SOURCES = '.'  // adjust if needed
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AhmedouBouk/hello.git'
            }
        }

        stage('SonarQube Code Analysis') {
            environment {
                scannerHome = tool 'Sonar'  // must match Jenkins Sonar installation name
            }
            steps {
                script {
                    withSonarQubeEnv('Sonar') { // 'Sonar' must match your Jenkins SonarQube server name
                        sh """
                            ${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                            -Dsonar.projectName=${SONAR_PROJECT_NAME} \
                            -Dsonar.projectVersion=${SONAR_PROJECT_VERSION} \
                            -Dsonar.sources=${SONAR_SOURCES}
                        """
                    }
                }
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
                    ansible-playbook ${ANSIBLE_PLAYBOOK} \
                    -i ${ANSIBLE_INVENTORY} \
                    --private-key ~/.ssh/id_rsa \
                    --become
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
