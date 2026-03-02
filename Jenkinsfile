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

        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
        

        stage('MVN SONARQUBE') {
    steps {
        sh "mvn sonar:sonar \
            -Dsonar.login=f15e2274833cd0dd6c38eff10628e23b4287f001 \
            -Dsonar.host.url=http://192.168.72.130:9000 \
            -Dsonar.qualitygate.wait=false \
            -Dsonar.tests=" 
    }
}
    }
}
