# Local dev environment
- Java 17
  - Rememer about defining JAVA_HOME and adding it to PATH
- Maven 3.9.9
  - https://maven.apache.org/install.html
- Node v22.14.0
  - https://nodejs.org/en/download
- Git
  - CRLF as end of line `core.autocrlf=true` in git config (installer should ask you about this)
  
# Run project
- Run maven -> lifecycle -> compile from your IDE
  - It will download required Java dependencies defined in pom.xml
  - Run Spring backend by running `main` method in `IapApplication`
- Go to ./frontend/iap folder and run `npm install`
  - It will download required Node dependencies defined in package.json
  - In the same folder run `ng serve` command
- Go to localhost:4200 in your browser
- Server endpoints can be accessed at localhost:8080