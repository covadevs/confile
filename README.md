# Confile
###### A properties file editor

Confile supports property files that follow the pattern:
```
var1=value1
var2=value2
.
.
.
varn=valuen
``` 

| Command | Description                                     |      Example     |
|:-------:|-------------------------------------------------|:----------------:|
|    /m   | show menu                                       |         -        |
|    /s   | show properties                                 |         -        |
|    /l   | load properties                                 |         -        |
|    /#   | comment property (undo if already is commented) |     /# 1 2 3     |
|    /f   | find property                                   |      /f foo      |
|    /o   | open file                                       | /o /path/to/file |
|    /x   | save file                                       |         -        |
|    /c   | clear screen                                    |         -        |
|    /q   | quit program                                    |         -        |

* _/o_ Open a file
    * _\<path\>_ path to file that wil be loaded.
* _/l_ Load properties from a file
* _/#_ Comment a property
    * You need properties previously loaded.
    * You can pass _n_ args each one separated by and empty space.
    * If a property is already commented, it'll be uncomment.
* _/s_ Show properties from a file
    * You need a previously loaded file. <br>
    You can do it by using the _/o_ command.

![GitHub Logo](/uml.jpeg)