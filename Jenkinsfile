pipeline {
    agent any
     environment {
     M2_HOME = '/usr/local/maven'
     PATH = "${env.M2_HOME}/bin:${env.PATH}"
    }


    triggers {
        githubPush()
    }

    stages {
       /* stage('Checkout') {
            steps {
                deleteDir()
                git branch: 'master',
                //    credentialsId: 'github-creds',
                    url: 'https://github.com/r-maven-.git'
            }
        }*/

        stage('Checkout') {
            steps {
                checkout scm
            }
        }
       stage('Debug Changes') {
         steps {
            script {
             echo "Number of change sets: ${currentBuild.changeSets.size()}"
			}
		 }
	   }
       stage('test') {
         when { environment name: 'BUILDME', value: 'yes' }
         steps {
            echo 'Hi...'
           // sh 'mvn clean package'
              
                    }

    }
}
	//testing
}
