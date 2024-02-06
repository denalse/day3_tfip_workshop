## Welcome to SDF Day 3

mvn archetype:generate -DgroupId=sg.edu.nus.iss -DartifactId=sdfworkshop3 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

commands:
- 1. mvn clean compile
- 2. mvn package
- 3. java -cp target/sdfworkshop3-1.0-SNAPSHOT.jar sg.edu.nus.iss.App