pipeline {
   agent any

   tools {
      maven "M3"
      allure "Allure"
   }
    triggers {
        cron('0 8 * * *')
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'main', name: 'BRANCH', type: 'PT_BRANCH'
        string(name: 'username', defaultValue: 'standard_user', description: '')
    }

   stages {
      stage('Testing') {
         steps {
            git branch: "${params.BRANCH}", url: 'https://github.com/Tatiana-Mandrukevich/Saucedemo.git'
            sh "mvn clean -Dtest=ProductsTest -Dusername=${params.username} test"
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