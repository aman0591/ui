FROM mozart/grails:3

ADD . /app

RUN wget https://codeload.github.com/grails/grails-profile-repository/zip/master && \
    unzip master && \
    mv grails-profile-repository-master/profiles/ $GRAILS_HOME && \
    rm -rf master && \
    rm -rf grails-profile-repository-master

EXPOSE 8080
ENTRYPOINT ["grails"]
CMD ["-Dgrails.env=production-no-mysql", "run", "-verboseCompile"]
