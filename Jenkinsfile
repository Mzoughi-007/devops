pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...'
                git branch: 'master',
                    url: 'https://github.com/Mzoughi-007/devops.git'
            }
        }

        stage('Testing Maven') {
            steps {
                sh 'mvn -version'
            }
        }
    }
}
