FROM frekele/gradle:2.13-jdk8

ADD . /app

WORKDIR /app
RUN gradle assemble
WORKDIR /app/build/libs

EXPOSE 8080
ENTRYPOINT ["java"]
CMD ["-Dgrails.env=production-no-mysql", "-jar", "streama.war"]
