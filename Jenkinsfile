pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: '173cf848-7f65-4d96-b41e-563107d32cd2', // ton vrai ID Jenkins
                    url: 'git@github.com:AhmedouBouk/hello.git'         // URL SSH, pas HTTPS !
            }
        }

        stage('Test') {
            steps {
                echo '✔️ Clonage réussi avec SSH !'
            }
        }
    }
}
