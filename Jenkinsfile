node {
   // Mark the code checkout 'stage'....
   stage 'Checkout'

   // Get some code from a GitHub repository
   checkout scm

   // Mark the code build 'stage'....
   stage 'Compile'

   sh "mvn clean install"
   
}
