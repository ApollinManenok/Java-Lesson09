chcp 65001
if not exist bin\nul md bin
javac -d bin -sourcepath src -cp bin src\by\itacademy\lesson09\Main.java
java -classpath bin -Djava.util.logging.config.file=logging.properties by.itacademy.lesson09.Main



Меню
Регистратура(Пациент(имя, фамилия, рождение, состояние))

Опции над регистратурой:

Добавить пациента с консоли
Добавить из файла коллекцию пациентов
Записать в локальный файл всех пациентов (перезапись)
+показать всех пациентов
+найти и показать пациента