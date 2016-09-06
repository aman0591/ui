FROM java:8-jre

ADD build/libs/ /app

WORKDIR /app

EXPOSE 8080
ENTRYPOINT ["java"]
CMD ["-Dgrails.env=production-no-mysql", "-jar", "streama.war"]
