pipeline {
    agent any

    environment {
        SONAR_PROJECT_KEY = 'hello-project'
        SONAR_PROJECT_NAME = 'Hello Project'
        SONAR_PROJECT_VERSION = '1.0'
        SONAR_SOURCES = '.'  // Chemin vers le code source, adapte si besoin
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
                scannerHome = tool 'sonar'  // Nom exact du scanner dans Jenkins (Global Tool Configuration)
            }
            steps {
                script {
                    withSonarQubeEnv('sonar') { // Nom exact du serveur Sonar dans Jenkins (Configure System)
                        sh """
                            ${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                            -Dsonar.projectName="${SONAR_PROJECT_NAME}" \
                            -Dsonar.projectVersion=${SONAR_PROJECT_VERSION} \
                            -Dsonar.sources=${SONAR_SOURCES}
                        """
                    }
                }
            }
        }

        stage('Confirmation') {
            steps {
                echo '✔️ SonarQube analysis completed successfully.'
            }
        }
    }
}
