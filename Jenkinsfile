pipeline {
    agent any

    environment {
        SONAR_PROJECT_KEY = 'hello-project'
        SONAR_PROJECT_NAME = 'Hello Project'
        SONAR_PROJECT_VERSION = '1.0'
        SONAR_SOURCES = '.'  // adjust path to your source code if needed
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
                scannerHome = tool 'Sonar'  // Must match your SonarQube Scanner name in Jenkins
            }
            steps {
                script {
                    withSonarQubeEnv('Sonar') { // Must match your SonarQube Server name in Jenkins
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

        stage('Confirmation') {
            steps {
                echo '✔️ SonarQube analysis completed successfully.'
            }
        }
    }
}
