pipeline {
   agent any

   tools {
      maven "M3"
   }
    triggers {
        cron('0 8 * * *')
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'main', name: 'BRANCH', type: 'PT_BRANCH'
        string(name: 'username', defaultValue: 'standard_user', description: '')
    }

   stages {
      stage('Install Allure') {
         steps {
            sh 'curl -o allure-commandline.tgz -L https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.13.8/allure-commandline-2.13.8.tgz'
            sh 'tar -zxvf allure-commandline.tgz -C $HOME'
            sh 'ln -s $HOME/allure-2.13.8/bin/allure /usr/local/bin/allure'
         }
      }
      stage('Testing') {
         steps {
            git branch: "${params.BRANCH}", url: 'https://github.com/Tatiana-Mandrukevich/Saucedemo.git'
            sh "mvn clean -Dtest=ProductsTest -Dusername={params.username} test"
         }

         post {
            always {
               junit '**/target/surefire-reports/TEST-*.xml'
               allure([
                   includeProperties: false,
                   jdk: '',
                   properties: [],
                   reportBuildPolicy: 'ALWAYS',
                   results: [[path: 'target/allure-results']]
               ])
            }
         }
      }
   }
}