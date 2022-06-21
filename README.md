# EPAM JavaEE project
##Database diagram
![DB](https://user-images.githubusercontent.com/40146504/174717697-5f6b973f-e85a-4371-8dec-eee52c58c0ec.png)
## Deployment
1. Clone the project https://github.com/shabal1n/java_ee
2. Download Apache Tomcat 9.0.64 https://tomcat.apache.org/download-90.cgi
3. Download Docker and pull Postgres image from Docker hub https://hub.docker.com/_/postgres
4. Run Docker container: $ docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=admin -d postgres
5. Connect to the database with (login: postgres, password: admin, host: localhost, port: 5432, database: postgres)
6. Run db script [script](EPAM_oracle_create.sql)
7. Then open a project in Intellij IDEA. You need to connect the Apache Tomcat server to run the project. Click on Run - Edit configuration. Then in the top left corner click the + and select Tomcat Server - Local.
8. The server configuration window appears, and you select the pre-installed Tomcat as Application server. On the Deployment tab remove the line in the Application context
9. You can start the project.

