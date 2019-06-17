FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=muzixDb
ENV MYSQL_USER=app_root
ENV MYSQL_PASSWORD=root123
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/muzixDb
ADD ./target/accountmanager-1.0.jar usr/src/accountmanager-1.0.jar
RUN ["chmod","+x","usr/src/accountmanager-1.0.jar"]
ENTRYPOINT ["java","-Xmx200m","-jar","usr/src/accountmanager-1.0.jar"]
CMD ["-start"]
