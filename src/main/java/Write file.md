В Java есть четыре основных абстрактных класса, реализующих потоки ввода-вывода:
InputStream, OutputStream, Reader, Writer. Первые два работают с байтами,
вторые – с символами.

Для работы с файлами от этих абстрактных классов созданы соответственно классы
 FileInputStream, FileOutputStream, FileReader, FileWriter. 
Они являются адаптерами для объектов класса File к "интерфейсам" InputStream, OutputStream, Reader, Writer, т. е. к их методам.

Скажем несколько слов об адаптере как паттерне, или шаблоне, проектирования.
Класс-адаптер A наследуется от интерфейса B,
к которому приспосабливается объект другого класса – C.
Класс-адаптер A имеет поле типа класса объекта C.

Например, объект File адаптируется к потоку ввода InputStream,
т. е. все, что мы хотим получить из File,
в конечном итоге мы будем получать из InputStream. Фактически мы работаем с InputStream, через адаптер FileInputStream, 
который с одной стороны наследуется от InputStream, а с другой – имеет поле, которому присваивается объект File.

Адаптер выполняет работу по получению данных из файла и адаптации их к тому виду,
 который можно передать в методы InputStream. Класс-адаптер,
 в данном примере – FileInputStream, переопределяет методы InputStream, добавляя в них свой код.

В основной ветке сначала создается объект, для которого требуется адаптер.
Затем создается переменная класса, к которому выполняется адаптация.
Этой переменной присваивается объект класса-адаптера,
в конструктор которого передается адаптируемый объект.

File file = new File("/home/user/pic.jpg");
InputStream fIn = new FileInputStream(file);
Часто переменную определяют самим классом-адаптером:

FileInputStream fIn = new FileInputStream(file);
В конструктор можно передать строку-адрес. Объект File будет создан внутри адаптера. 
Пример побайтового копирования файла:

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputStream {
public static void main(String[] args)
throws IOException {

        FileInputStream fileIn = 
              new FileInputStream(
                  "src/file/pets.png");
        FileOutputStream fileOut = 
              new FileOutputStream(
                  "src/file/pets2.png");
 
        while (fileIn.available() > 0) {
            int oneByte = fileIn.read();
            fileOut.write(oneByte);
        }
        fileIn.close();
        fileOut.close();
    }
}
Если используются относительные адреса, они должны начинаться от корня проекта.

В конструктор FileOutputStream можно также передать второй аргумент true. В этом случае, если файл существует, данные в него будут добавляться. Перезаписи файла не произойдет.

Метод available() объекта класса FileInputStream возвращает количество непрочитанных байтов. Метод read() читает один байт и расширяет его до типа int. Кроме этого, есть другой метод read(), читающий массив байт в переменную-аргумент и возвращающий количество реально прочитанных байт. Метод write() также позволяет записывать блоками.

byte[] blockBytes = new byte[100];

while (fileIn.available() > 0) {
int qtyBytes = fileIn.read(blockBytes);
fileOut.write(blockBytes, 0, qtyBytes);
}
При чтении конца файла блок может содержать меньше прочитанных байт, чем размерность массива. Поэтому write() позволяет указывать срез массива.

У объектов FileOutputStream имеется метод flush(), который принудительно записывает находящиеся в буфере байты на диск. При вызове close() это происходит автоматически.

С помощью класса PrintStream также можно создать поток вывода в файл. PrintStream является наследником FilterOutputStream, который в свою очередь наследник OutputStream как и FileOutputStream.

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {
public static void main(String[] args)
throws FileNotFoundException {

        PrintStream fileOut = new PrintStream(
             "src/file/text.txt");
        fileOut.println(10.5);
        fileOut.printf(
              "%s - %d - %f", "hi", 10, 1.1);
        fileOut.close();
    }
}
Функция printf() предназначена для форматированного вывода.

Заметим, переменная System.out является объектом типа PrintStream.

В работе с вводом-выводом также используется другой паттерн проектирования – обертка (wrapper), он же декоратор (decorator). Декоратор расширяет функциональность объекта, а не приспосабливает объект к какому-либо стороннему интерфейсу.

Поэтому класс-обертка наследуется от того же класса или интерфейса, что и оборачиваемый объект. В классе-обертке переопределяются методы оборачиваемого объекта. В методах обертки вызываются методы оборачиваемого класса и вводится дополнительная функциональность.

В основной ветке создается объект оборачиваемого класса, который передается в конструктор обертки. Внутри класса-обертки есть поле типа декорируемого класса. Этому полю присваивается переданный объект.

BufferedInputStream – класс-обертка для InputStream (наследует через FilterInputStream). В отличие от InputStream класс BufferedInputStream позволяет предварительно читать в буфер порции байт, что уменьшает количество обращений к файлу. Существует также BufferedOutputStream.

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferStream {
public static void main(String[] args)
throws IOException {

        FileInputStream fileIn = 
          new FileInputStream("src/file/text.txt");
        BufferedInputStream bufIn = 
          new BufferedInputStream(fileIn, 100);
 
        int i;
        while((i = bufIn.read())!= -1){
            System.out.print((char)i);
        }
    }
}
Конструктор класса BufferedInputStream принимает объект InputStream или его наследника.

Хотя данные считываются блоками, метод read() извлекает их по одному. Однако в данном случае он будет извлекать их из буфера.

С помощью классов FileReader и FileWriter выполняется ввод-вывод в текстовые файлы.

FileReader reader = new FileReader(
"src/file/text.txt");
FileWriter writer = new FileWriter(
"src/file/text2.txt");

while (reader.ready()) {
int c = reader.read();
writer.write(c);
}

reader.close();
writer.close();
Метод ready() возвращает истину, если остались непрочитанные символы.

Читать и писать можно блоками. Также методу write() можно передать строку:

FileReader reader = new FileReader(
"src/file/text.txt");
FileWriter writer = new FileWriter(
"src/file/text3.txt");

char[] buff = new char[10];

while (reader.ready()) {
int qtySymbols = reader.read(buff);
writer.write(buff, 0, qtySymbols);
}

writer.write("Halo");

reader.close();
writer.close();
Рассматривая ввод данных с клавиатуры, мы уже использовали класс BufferedReader, который наследуется от Reader и позволяет читать отдельные строки методом readLine(). Его также можно использовать для построчного чтения файлов:

import java.io.*;

public class BufferedReaderTest {
public static void main(String[] args)
throws IOException {

        Reader reader = new FileReader(
                  "src/file/text.txt");
        BufferedReader buffReader = 
                  new BufferedReader(reader);
 
        while (buffReader.ready()) {
            System.out.println(
                  buffReader.readLine());
        }
 
        reader.close();
        buffReader.close();
    }
}
