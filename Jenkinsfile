pipeline {
	agent any
	
	environment{
		JENKINS_NODE_COOKIE = 'dontkillmeplease'
    }
	
	stages {
		stage('Clean our current workspace') {
            steps {
              cleanWs()
            }
        }
		stage('Reclone our github repo') {
           steps {
				script{
					try {
						sh "rm -r spring"
						echo 'Directory found, and deleted'
					} catch (all) {
						echo 'No directory exists'
					}
				}
				sh "git clone https://github.com/revature-2206-social-capstone/spring.git"
           }
        }
        stage ("Build my project") {
			steps{
				echo 'Building right now'
					sh 'mvn -f spring/social-media-spring clean package'
			}
		}
        stage('Destroy Old Server') {
            steps {
                script {
                    try {
                        // kill any running instances
                        sh 'kill $(lsof -t -i:9002)'
                    } catch (all) {
                        // if it fails that should mean a server wasn't already running
                        echo 'No server was already running'
                    }
                }
            }
        }
        stage('Start New Server!') {
            steps {
                script {
                     sh 'nohup java -jar ./spring/social-media-spring/build/libs/social-media-spring-1.0-SNAPSHOT.jar &'
                }
            }
        }
	}
}
