pipeline {
    agent any
    tools {
        jdk 'openjdk-11'
    }
    environment {
        GIT_SHA = sh(returnStdout: true, script: 'git rev-parse --short HEAD')
    }
    triggers {
        githubPush()
    }

    stages {
        stage('Git Sha') {
            steps {
                echo "Git - ${GIT_SHA}"
            }
        }
//         stage('Build') {
//             steps {
//                 sh './gradlew assemble'
//             }
//             post {
//                 success {
//                     archiveArtifacts(artifacts: '**/build/libs/*.jar', allowEmptyArchive: true)
//                 }
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//             post {
//                 always {
//                     junit '**/build/test-results/test/**/TEST-*.xml'
//                 }
//             }
//         }
//         stage('Container-ize and Upload to ECR') {
//             when {
//                 branch 'master'
//             }
//             environment {
//                 ECR_URL = 'https://719042170775.dkr.ecr.us-west-2.amazonaws.com/jbaumgartner/user-service'
//                 ECR_IMAGE_NAME = '719042170775.dkr.ecr.us-west-2.amazonaws.com/jbaumgartner/user-service'
//                 LOCAL_IMAGE_NAME = 'jbaumgartner/user-service'
//             }
//             steps {
//                 withDockerRegistry(credentialsId: 'ecr:us-west-2:aws_admin', url: ECR_URL) {
//                     sh './gradlew jibDockerBuild --image=${LOCAL_IMAGE_NAME}'
//                     sh 'docker tag ${LOCAL_IMAGE_NAME}:latest ${ECR_IMAGE_NAME}:latest'
//                     sh 'docker push ${ECR_IMAGE_NAME}:latest'
//                     sh 'docker tag ${LOCAL_IMAGE_NAME}:latest ${ECR_IMAGE_NAME}:${BUILD_NUMBER}'
//                     sh 'docker push ${ECR_IMAGE_NAME}:${BUILD_NUMBER}'
//                 }
//             }
//         }
//         stage('Deploy') {
//             when {
//                 branch 'master'
//             }
//             environment {
//                 AWS_DEFAULT_REGION = 'us-west-2'
//             }
//             steps {
//                 withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws_admin', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
//                     withKubeConfig([credentialsId: 'aws_eks_kubeconfig']) {
//                         sh 'envsubst < kubernetes.yaml | kubectl apply -f -'
//                     }
//                 }
//             }
//         }
    }

    post {
        cleanup {
            deleteDir()
        }
    }
}
