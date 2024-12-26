FROM eclipse-temurin:20-jdk

WORKDIR /app

COPY /app .

RUN gradle installDist

CMD ./build/install/HexletJavalin/bin/HexletJavalin