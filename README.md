![alt tag](https://s3-us-west-2.amazonaws.com/jstackui/novaui_logo.png "NovaUI logo. It is written Nova follow by a square with a UI written inside.")
###### (under development)

NovaUI is a new way to work with Java Swing. Although FX is available since Java 8, a lot of companies still use Swing, and a lot of people still don't know how to work with its substitute. Thinking about that we came up with an idea: reformulate Java Swing. Using NovaUI, you can manipulate components using CSS, change them easily on your frame using next() and back() methods and add already created components like search boxes or login panels. NovaUI will save you from a headache.

#### How does it work? 

NovaUI have Swing components of its own, like JNovaUI or JNovaPanel. Using these kind of components, you can easily insert CSS using the addCSS() method. Look at the example below to see how easy it is!

######Keep it simples:

```
JNovaUI jnova = new JNovaUI(); 
jnova.addCSS("width", "500px");

JNovaPanel jnovaPanel = newJNovaPanel();
jnovaPanel.addCSS("background-color", "rgb(236,236,236)");

jnova.next(jnovaPanel);
```

![alt tag](https://s3-us-west-2.amazonaws.com/jstackui/next.gif "Cursor clicking on arrow and the panel changes from 1 through 5.")

######Available CSS properties:
+ width
+ background-color

More properties are going to be added soon.
