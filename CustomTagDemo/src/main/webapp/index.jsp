<?xml version="1.0" encoding="UTF-8"?>
<taglib xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
                            http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd"
        version="2.1">

    <tlib-version>1.0</tlib-version>
    <uri>http://example.com/mytags</uri>
    <short-name>mytags</short-name>

    <tag>
        <name>greet</name>
        <tag-class>com.example.tags.GreetTag</tag-class>
        <body-content>empty</body-content>
        <attribute>
            <name>greet_name</name>
            <required>false</required>
            <rtexprvalue>true</rtexprvalue>
        </attribute>
    </tag>
</taglib>
