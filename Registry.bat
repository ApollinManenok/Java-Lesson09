chcp 65001
if not exist bin\nul md bin
javac -d bin -sourcepath src -cp bin src\by\itacademy\lesson09\Main.java
java -classpath bin -Djava.util.logging.config.file=logging.properties by.itacademy.lesson09.Main