pipeline {
    agent any
    stages {
        stage('Preparation') {
            // 実際の処理はstepsブロック中に定義する
            steps {
                deleteDir()
                // このJobをトリガーしてきたGithubのプロジェクトをチェックアウト
                checkout scm
                // ジョブ失敗の原因調査用にJenkinsfileとbuild.gradleは最初に保存する
                archiveArtifacts "Jenkinsfile"
                archiveArtifacts "build.gradle"
                archiveArtifacts "settings.gradle"
                // scriptブロックを使うと従来のScripted Pipelinesの記法も使える
                script {
                    // Permission deniedで怒られないために実行権限を付与する
                    if(isUnix()) {
                        sh 'chmod +x gradlew'
                    }
                }
                gradlew 'clean'
            }
        }

        stage( 'compile'){
            steps {
                gradlew 'classes testClasses'
            }
            post {
                // alwaysブロックはstepsブロックの処理が失敗しても成功しても必ず実行される
                always {
                    // JavaDoc生成時に実行するとJavaDocの警告も含まれてしまうので
                    // Javaコンパイル時の警告はコンパイル直後に収集する
                    recordIssues(enabledForFailure: true, tools: [java()])
                }
            }
        }

        stage('assembles reports'){
            steps {
                // 並列処理の場合はparallelメソッドを使う
               parallel('static analysis' : {
                   gradlew 'check -x test'
                   // dirメソッドでカレントディレクトリを指定できる
                   recordIssues enabledForFailure: true, tools: [spotBugs(pattern: '**/build/reports/spotbugs/main.xml')]
                   recordIssues enabledForFailure: true, tools: [pmdParser(pattern: '**/build/reports/pmd/main.xml')]
                   // recordIssues enabledForFailure: true, tools: [cpd(pattern: '**/build/reports/cpd/cpd.xml', reportEncoding: 'UTF-8', skipSymbolicLinks: true)]
               },
               'task-scan': {
                   recordIssues(tools: [taskScanner(highTags: 'FIXME', ignoreCase: true, includePattern: '**/src/main/java/**/*.java', lowTags: 'XXX', normalTags: 'TODO')])
               }
               )
            }
        }
       stage('test'){
            steps {
                // 並列処理の場合はparallelメソッドを使う
               parallel('medium test' : {
                   gradlew ":server-business:testMedium --args='--spring.profiles.active=mediumUnit' -x compileJava "
               }
               )
            }
        }

   }

}

// Gradlewコマンドを実行する
def gradlew(command) {
    if(isUnix()) {
            sh "./gradlew ${command} --stacktrace --daemon --warning-mode all"
    } else {
            bat "./gradlew.bat ${command} --stacktrace  --daemon --warning-mode all"
    }
}