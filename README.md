# RekaKnorrExcel
1. a gepre kell java (https://jdk.java.net/java-se-ri/17)
2. le kell tolteni a mavent, kibontani, majd a bin konyvtarat, ahol mvn.cmd van, berakni a PATH ba, vagy ha
azt nem lehet, akkor ahova kibontod, azt felirni, majd ahol ez projekt van, abban a konyvtarban (a pom.xml file szintjen)

  ```C:/AholAMavenVan/bin/mvn.cmd clean install```

  a parancssorban
ha benn van a pathban, akkor csak
```mvn clean install```
   https://maven.apache.org/download.cgi
   https://maven.apache.org/guides/getting-started/windows-prerequisites.html

3. ennek hatasara a projekt target konyvtaraban letrejon egy RekaKnorrExcel.jar 
4. ezt kell futtatni 

```java -jar RekaKnorrExcel.jar```

vagy ```java -jar target/RekaKnorrExcel.jar ```vagy szoval ahol
van az ember.
5. be fogja kerni a file nevet, meg a nev illetve a datum oszlopok sorszamat, az elso oszlop 0, a masodik 1, stb
6. ezek utan kiirja egy eredmeny fileba az eredmenyt, az is excel file eredmeny.xlsx


ha nem engedik hogy futtass ilyeneket, hogy buildelj, akkor eleg egy java futtato kornyezet meg a
jar file, en le tudom buildelni, vagy te is az otthoni gepeden.
Ez esetben eleg a 

   ```java -jar RekaKnorrExcel.jar```

parancs.
ideiglenesen
beraktam a resources folderbe, de nem oda buildelodik, hanem a targetbe, szoval ha ujat csinalsz,
akkor a resources folder nem frissul
