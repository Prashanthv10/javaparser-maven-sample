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
        stage('Detect Changes') {
            steps {
                script {

                    def status = sh(
                        script: """
                            git diff --name-only HEAD~1 HEAD | grep '^src/main/'
                        """,
                        returnStatus: true
                    )

                    if (status == 0) {
                        env.BUILDME = "yes"
                        echo "src/main changes detected"
                    } else {
                        echo "No src/main changes"
                    }
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
