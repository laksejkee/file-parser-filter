<h1> Утилита фильтрации содержимого файла </h1>

<ul> Данный проект позволяет при помощи команд использовать файлы, которые находятся 
в корневой директории. </ul>

<h1> Парметры запуска </h1>
<ul> Для запуска программы необходимо ввести в командную строку mvn clean package, чтобы jar файл загрузился в 
корневую директорию и добавился target. Далее, для запуска, введите: java -jar util.jar -s -a -p sample- in1.txt in2.txt либо иначе, 
взависимости от пожелания перечесленных параметров:  </ul>
<ul>  -p добавляет префикс, -a флаг для добавления строк в файл, 
если файлы еще не созданы, то он их сначала создаст, -f флаг полная статистика, -s флаг краткая статистика 
(Можно получить только 1 статистику. Либо -f либо -s) -o для добавления директории. 
При указании параметра -o должно быть значение, иначе будет ошибка. Если не указать -o, 
то сохраняет файлы в текущую директорию (корневую).
</ul>

```bash
 mvn clean package
```
```bash
java -jar util.jar -o files -s -a -p sample- in1.txt in2.txt
```

<h1> Особенности реализации</h1>
<ul> Версия Java: 22.0.1  </ul>
<ul> система сборки: apache-maven-3.9.10  </ul>
<ul> В данном проекте были использованы следующие стороние библиотеки </ul>
<ul>1. Lombok - для уменьшения boilerplate-кода; Версия: 1.18.38; Ссылка: 
https://projectlombok.org/ Maven: 
https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.38  
</ul>

<ul>2. Apache Commons CLI - для обработки аргументов командной строки; Версия: 1.9.0; Ссылка:
https://commons.apache.org/proper/commons-cli/ Maven: https://mvnrepository.com/artifact/commons-cli/commons-cli/1.9.0 
</ul>
<ul>3. Apache Commons Lang3 - для работы с утилитами; Версия: 3.17.0; Ссылка: 
https://commons.apache.org/proper/commons-lang/ Maven: 
https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.17.0</ul>

<ul>4. Плагин maven-assembly-plugin для внедрения зависимостей в jar файл; Версия: 3.7.1; Ссылка:
https://maven.apache.org/plugins/maven-assembly-plugin/?spm=a2ty_o01.29997173.0.0.51f7c921zlmDgy
Maven : https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-assembly-plugin/3.7.1
</ul>
<ul> 5. Плагин maven-antrun-plugin - для создания jar файла в корневой папке при maven clean package; 
Версия: 3.1.0; Ссылка: 
https://maven.apache.org/plugins/maven-antrun-plugin/?spm=a2ty_o01.29997173.0.0.51f7c921zlmDgy
Maven: https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-antrun-plugin/3.1.0</ul>



