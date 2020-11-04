nmote-epp - Nmote Extensible Provisioning Protocol
==================================================

Java 1.8 client and server EPP protocol implementation
See https://en.wikipedia.org/wiki/Extensible_Provisioning_Protocol

Features
--------
* Minimal dependecies (SLF4J, commons-lang, jaxb)
* Auto reconnecting


Generating Sources
------------------

nmote-epp uses JAXB to bind to and from XML EPP messages. 
Java sources representing EPP XML elements are generated by xjc source generator from XSD schema files.

Schema files were extracted from RFC docs and redacted a bit to make it work better with java. 
You can find generated java sources in a repository.

If you need to use additional XSDs or modify what's available, you'll need to generate sources with xjc. 
For example, to compile epp-1.0.xsd:

> xjc -d src-dir -npa -extension -b bindings.xml epp-1.0.xsd

-npa flag tells xjs not to override package-info.java. Existing package-info.java
contains a @XmlNs annotation customizing XML namespace prefix for EPP namespace.

-extension -b bindings.xml tells compiler to activate some vendor extensions.
Without it I couldn't get XSD to Java working correctly, so don't forget to use it.

Add to Your's Project
---------------------

If you use maven for dependency management, add following snippet to pom.xml:

```xml
	<dependencies>
		...

		<dependency>
			<groupId>com.nmote.epp</groupId>
			<artifactId>nmote-epp</artifactId>
			<version>0.7.2</version>
		</dependency>

	</dependencies>
```

Building
--------
To produce nmote-epp.jar you will need apache maven installed. Run:

> mvn clean package


Author Contact and Support
--------------------------

For further information please contact
Vjekoslav Nesek (vnesek@nmote.com)
