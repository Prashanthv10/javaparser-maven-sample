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
       /* stage('Checkout') {                   //when using pipeline script inside jenkins
            steps {
                deleteDir()
                git branch: 'master',
                //    credentialsId: 'github-creds',
                    url: 'https://github.com/r-maven-.git'
            }
        }*/

        stage('Checkout') {          //when pipeline is from scm
            steps {
                checkout scm
            }
        }
        stage('Pre check') {
          when {
            changeset "src/main/**"
        }
         steps {
           script {
            env.BUILDME = "yes"
            echo "Changes detected in src/main"
        }
    }
}
       stage('Build') {
         when { environment name: 'BUILDME', value: 'yes' }
         steps {
            echo 'Hi...changes detected now building'
           // sh 'mvn clean package'
              
                    }

    }
}
	//testing
}
