![alt tag](https://s3-us-west-2.amazonaws.com/jstackui/jstackui_logo.png "JStackUI logo with a stack of squares on the left.")
###### (under development)

Library to control the flow of your screens using Java.

#### How does it work? 

JStackUI makes it easy the integration between JPanels. Instead of mapping how they connect, use a JStackUI object to create a JFrame that instantiates a starting panel and controls new ones that you may add.

```
JStackUI js = new JStackUI(); 
js.next(new JPanel());
js.back();
```

![alt tag](https://s3-us-west-2.amazonaws.com/jstackui/next.gif "Cursor clicking on arrow and the panel changes from 1 through 5.")

####Special Thanks

Logo stack icon made by [Freepik] (http://www.freepik.com) from [http://www.flaticon.com] (www.flaticon.com) is licensed by [CC 3.0 BY] (http://creativecommons.org/licenses/by/3.0/).
