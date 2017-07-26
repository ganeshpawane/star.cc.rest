# star.cc.rest

This example demonstrates the direct communication between two bundles.
This also shows how to publish and use a simple REST service in karaf using cxf and blueprint.

To run the example you need the http feature of karaf. The default http port is 8181 and can be configured. You also need to install the cxf feature. The base url of the cxf servlet is by default "/cxf". 
Install cxf dependancy required for rest:
	feature:repo-add cxf 3.1.5
	feature:install cxf-jaxrs http http-whiteboard

The mapping of the URI path space is :

	http://localhost:8181/cxf/instrument/(Symbol_Of_Instrument)

To start the bundle first create runnable of each project and then install it in karaf using following command

To start the karaf run:
	java -jar bin/karaf.jar

To install bundle in karaf run:
	install file:/path/to/bundle.jar

Internal dependancy of bundle:

	InstrumentModel--->(None)
	database--->InstrumentModel
	ccService-->InstrumentModel, Database
	star------->ccService


