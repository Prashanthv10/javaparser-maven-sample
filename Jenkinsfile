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

       stage('pre check') {
        when {
		  anyOf {
              changeset "src/**"
		      changeset "*/*"
			}
            }
        steps {
          script {
             env.BUILDME = "Yes" // Set env variable to enable further Build Stages to reuse
    }
} 
} 
       stage('test') {
         when { environment name: 'BUILDME', value: 'Yes' }
         steps {
            echo 'Hi...'
            sh 'mvn clean package'
              
                    }

    }
}
	//testing
}
