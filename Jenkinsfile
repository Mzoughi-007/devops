pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token') // Jenkins credentials ID
    }

    stages {

        stage('Checkout GIT') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/Mzoughi-007/devops.git'
            }
        }

        stage('Clean Build') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh """
                    mvn sonar:sonar \
                    -Dsonar.projectKey=devops \
                    -Dsonar.host.url=http://192.168.72.140:9000 \
                    -Dsonar.login=${SONAR_TOKEN}
                    """
                }
            }
        }
    }
}
