![alt tag](https://s3-us-west-2.amazonaws.com/jstackui/novaui_logo.png "NovaUI logo with a stack of squares on the left.")
###### (under development)

NovaUI is a Java library to control the flow of your screens. It uses Java Swing objects to create the software interface.

#### How does it work? 

NovaUI makes it easy to integrate your panels. Instead of mapping how they connect, use a JStackUI object to create a frame that hosts all your panels. You can move forward or backwards between your panels using simples methods like next() or back().

######Keep it simples:

```
JStackUI js = new JStackUI(); 
js.next(new JPanel());
js.back();
```

![alt tag](https://s3-us-west-2.amazonaws.com/jstackui/next.gif "Cursor clicking on arrow and the panel changes from 1 through 5.")
