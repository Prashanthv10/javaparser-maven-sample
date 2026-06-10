pipeline {
    agent any
     environment {
     M2_HOME = '/usr/local/maven'                  // for maven build
     PATH = "${env.M2_HOME}/bin:${env.PATH}"       // for maven build
    }
	 parameters {
        booleanParam(
            name: 'UNITTEST', 
            defaultValue: true, 
            description: 'Check this box to execute tests during this build'
        )
		booleanParam(
            name: 'CODEANALYSIS', 
            defaultValue: true, 
            description: 'Check this box to execute tests during this build'
        )
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
           // echo "Changes detected in src/main"
            echo "Changes detected in src"
        }
    }
}
		/* stage('Build Artifacts') {
		  when { 
			environment name: 'BUILDME', value: 'yes' 
		     }
		  steps {
			echo "Building Jar Component ..."
				sh "mvn clean package"
		}
		} */
		stage('Build Artifacts') {
			when { environment name: 'BUILDME', value: 'yes' }
			steps {
				script {
					if (params.UNITTEST) {
						unitstr = ""
					} else {
						unitstr = "-Dmaven.test.skip=true"
						   }
					echo "Building Maven Project ..." 
					sh "mvn clean package ${unitstr}"
				}
			}
		}
		stage('Code Coverage')
			{
			    when {
			        allOf {
			            expression { return params.CODEANALYSIS }
			            environment name: 'BUILDME', value: 'yes'
			        }
			    }
			
			    steps {
			        echo "Running Code Coverage ..."
					//dir ("./src/main")
			            sh "mvn org.jacoco:jacoco-maven-plugin:0.5.5.201112152213:prepare-agent"
			    }
			}
		stage('SonarQube Analysis') {
		 when {
			environment name: 'BUILDME', value: 'yes'
			}
			
			steps {
			withSonarQubeEnv('demosonarqube') {
			sh 'mvn sonar:sonar -Dsonar.token=sqa_4a4516de9de5a9be3767420f72b4e0336e0bc474'
			}
			      }
			} 


}
	//testing
}
