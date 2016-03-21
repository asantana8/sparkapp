node {
   // Mark the code checkout 'stage'....
   stage 'Checkout'

   // Get some code from a GitHub repository
   checkout scm

   // Mark the code build 'stage'....
   stage 'Compilar'
   sh "mvn clean verify"
   
   stage 'Auditoria'
   input 'Código dentro dos padrões'
   
   stage 'Gerar Dist'
   sh "mvn install -Prelease"
   
   stage 'Homologação'
   input 'Homologado com sucesso?'
   
   stage 'Teste Manual'
   input 'Testado com sucesso?'
   
   stage 'Sonar'
   sh "mvn sonar:sonar -Psonar"

}
