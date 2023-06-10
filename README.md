Command design pattern is used so that each signal is encapsulated within its own command object, making it easier to understand, modify and extend codebase.

Factory pattern is used to encapsulate the decision-making process of command object creation, on basis of received signal.

To add new signals, add a new implementation of SignalCommand and update the SignalCommandFactory to handle the creation of that new command.






**Note** :

This solution can lead to explosion of SignalCommand implementation classes after sometime. 

A configuration-driven approach could help here in that case, where a configuration file 
or database table can be used to store the mapping between signal numbers and its corresponding Algo library commands. 
New signals can then be added directly to the database/configuration file.
And at runtime, application class can read which Algo library commands to execute. 

BUT this will create tight coupling between Algo library and our application. Also database calls can add 
latency to our api calls, which makes this solution a bit undesirable and 
hence not implemented in here.

At the end of the day, I would prefer low latency, de-coupled, easily extensible code over "too many classes".
Would like to know your thoughts on this. Thanks.
