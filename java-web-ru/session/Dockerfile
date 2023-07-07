FROM gradle:7.4.0-jdk17

WORKDIR /session

COPY . .

RUN gradle installDist

CMD ./build/install/session/bin/session
