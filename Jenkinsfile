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
       stage('present') {
         steps {
			sh 'pwd'
            }
	   }
       stage('Check Changes') {
          steps {
             script {

               def changed = sh(
                  script: "git diff --name-only HEAD~1 HEAD | grep '^src/main/'",
                  returnStatus: true
               )

               if (changed == 0) {
                 env.BUILDME = "yes"
            }
        }
    }
} 
       stage('test') {
         when { environment name: 'BUILDME', value: 'Yes' }
         steps {
            echo 'Hi...'
           // sh 'mvn clean package'
              
                    }

    }
}
	//testing
}
