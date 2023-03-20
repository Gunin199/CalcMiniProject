pipeline {
   	agent any
   	environment {
   	    DockerhubCredentials = credentials("my_docker_hub_credentials")
   	    imageName = guninjain/my-calc-app
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
                sh 'docker build -t $imageName:$BUILD_NUMBER .'
            }
        }

        stage('Publish Docker Images') {
            steps {
//                 withDockerRegistry([ credentialsId: "dockerid", url: "" ]) {
//                     sh 'docker push guninjain/my-calc-app:${BUILD_NUMBER}'
//                 }
                   sh 'echo $DockerhubCredentials_PSW | docker login -u $DockerhubCredentials_USR --password-stdin'
                   sh 'docker push ${imageName}:${BUILD_NUMBER}'
            }
        }
        stage('Stop containers of previous app versions')
        {
            steps{
                sh 'docker ps | awk '{print $1,$2 }' | grep ${imageName} | awk '{print $1}' | xargs -I {} docker stop {} '
            }
        }
        stage('Remove containers of previous app versions'){
            steps{
                sh 'docker ps -a | awk '{ print $1,$2 }' | grep ${imageName} | awk '{print $1 }' | xargs -I {} docker rm {}'
            }
        }
        stage('Remove images of previous app versions')
        {
            steps{
                sh 'docker rmi $(docker images --format "{{.Repository}}:{{.Tag}}" | grep ${imageName})'
            }
        }
        stage('Deploy using Ansible')
        {
            steps
            {
//                 ansiblePlaybook becomeUser: 'null',
//                                 colorized: true,
//                                 installation: 'Ansible',
//                                 inventory: 'inventory',
//                                 playbook: 'playbook.yml',
//                                 sudoUser: 'null',
//
                sh 'ansible-playbook playbook.yml -i inventory --extra-vars \"build_num=${BUILD_NUMBER}\"'
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