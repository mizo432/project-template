pipeline {
    agent any
    tools {
        jdk 'JDK17'
    }
    stages {
        stage ('git clone'){
            git 'https://github.com/mizo432/project-template.git'

   }

   stage( 'clean'){
       gradlew 'clean'
   }

   stage( 'build'){
       gradlew 'build'
   }

   stage('assembles reports'){
       jacoco exclusionPattern: '**/*Test*.class'
       openTasks canComputeNew: false, defaultEncoding: '', excludePattern: '', healthy: '', high: 'FIXME', ignoreCase: true, low: 'XXX', normal: 'TODO', pattern: '**/*.java', unHealthy: ''
       findbugs canComputeNew: false, defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', pattern: '**/build/reports/findbugs/*.xml', unHealthy: ''
       warnings canComputeNew: false, canResolveRelativePaths: false, consoleParsers: [[parserName: 'Java Compiler (javac)'], [parserName: 'JavaDoc Tool']], defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', messagesPattern: '', unHealthy: ''
   }

    }

}

// Gradlewコマンドを実行する
def gradlew(command) {
    if(isUnix()) {
            sh "./gradlew ${command} --stacktrace --daemon"
        } else {
            bat "./gradlew.bat ${command} --stacktrace  --daemon"
    }
}