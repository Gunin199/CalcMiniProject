pipeline {
   	agent any
   	environment {
   	    DockerhubCredentials = credentials("my_docker_hub_credentials")
   	}

    stages {
        stage('Git Pull') {
            steps {
                // Get code from the GitHub repository
				git url: 'https://github.com/Gunin199/CalcMiniProject.git',
				branch: 'main',
                credentialsId: 'github_secret_text'
            }
        }
        stage('Maven Build and Test') {
            steps {
                // Maven build, 'sh' specifies it is a shell command
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'sudo chmod 666 /var/run/docker.sock'
                sh 'docker build -t guninjain/my-calc-app:$BUILD_NUMBER .'
            }
        }

        stage('Publish Docker Images') {
            steps {
//                 withDockerRegistry([ credentialsId: "dockerid", url: "" ]) {
//                     sh 'docker push guninjain/my-calc-app:${BUILD_NUMBER}'
//                 }
                   sh 'echo $DockerhubCredentials_PSW | docker login -u $DockerhubCredentials_USR --password-stdin'
                   sh 'docker push guninjain/my-calc-app:${BUILD_NUMBER}'
            }
        }
    }

    //
    post {
        always {
            sh 'docker logout'
        }
    }
}