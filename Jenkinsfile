pipeline {
    agent any

    stages {

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t myapp .'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 9090:80 myapp'
            }
        }

    }
}
